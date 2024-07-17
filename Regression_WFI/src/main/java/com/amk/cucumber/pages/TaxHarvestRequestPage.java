package com.amk.cucumber.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.amk.cucumber.utility.BasePage;
import com.amk.cucumber.utility.SeleniumCore;



public class TaxHarvestRequestPage extends BasePage {
	private final By lossesCheckBox = By.xpath("//div[text()='Losses']//preceding-sibling::span"); 
	private final By outOfMarket = By.xpath("//div[@class='sc-jeGTLq jqDnZt' and contains(text(),'Out of the Market')] //preceding-sibling::span");
	private final By inTheMarket = By
			.xpath("//div[@class='sc-jeGTLq iEWHDX' and contains(text(),'In the Market')] //preceding-sibling::span");
	private final By gainsCheckBox = By.xpath("//div[text()='Gains']//preceding-sibling::span");
	private final By selectTradeListOption = By.xpath("//div[text()='Select Trade List']//preceding-sibling::span");
	private final By selectMaxLossesOption = By.xpath("//div[text()='Max Loss Available']//preceding-sibling::span");
	private final By addSpecificAmountOption = By.xpath("(//div[@class='sc-idOiZg dlulYZ']//descendant::span)[1]");
	private final By selectMaxGainOption = By.xpath("//div[text()='Max Gain Available']//preceding-sibling::span");
	private final By addingAmount = By.xpath("//input[@placeholder='Enter dollar amount (Min. $100)']");
	private final By firstCheckBoxofEligibleTrading = By
			.xpath("(//div[contains(@class,'scroll')]//descendant::div//span)[1]");
	private final By commonCheckBoxofEligibleTrading = By
			.xpath("(//div[contains(@class,'scroll')]//descendant::div//span)");
	private final By CheckBoxForAllSecurityTypes = By
			.xpath("//div[text()='Security Type']/following-sibling::div/div/span");
	private final By acceptDisclosures = By.xpath("//div[contains(text(),'read')]//preceding-sibling::span");
	private final By continueBtn = By.xpath("//button[text()='CONTINUE']");
	private final By securitiesData = By.xpath("//div[@class='sc-cTkxnA fZLxjX']//div[2]");
	private final By securityTypeList = By
			.xpath("//div[@name='openTradeList']//div[contains(@class,'scroll')]//div[5]");

	public TaxHarvestRequestPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	private static final String PAGE_NAME = "TAX HARVEST REQUEST PAGE";

	public TaxHarvestRequestPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			if (seleniumCore.doesUrlContainText("TaxHarvest", 10, 1)) {
				logger.info(PAGE_NAME + " verification" + SEPARATOR + PAGE_NAME + " verification is PASSED");
				customLogger(" verification is PASSED ", "");
			} else {
				customLogger(" verification is FAILED ", "");
				throw new RuntimeException(PAGE_NAME + " verification is FAILED");
			}
		}
	}

	public DocuSignPage chooseOptionsForTaxLossGain() {
		this.seleniumCore.waitForElementToBeVisible(lossesCheckBox);
		this.seleniumCore.click(lossesCheckBox, PAGE_NAME, "Clicking gainloss check box");
		customLogger("Clicking gainloss check box", "");

		this.seleniumCore.waitForElementToBeVisible(selectTradeListOption);
		this.seleniumCore.click(selectTradeListOption, PAGE_NAME, "Clicking on realize option");
		customLogger("Clicking on realize option", "");

		this.seleniumCore.waitForElementToBeVisible(firstCheckBoxofEligibleTrading);
		this.seleniumCore.click(firstCheckBoxofEligibleTrading, PAGE_NAME,
				"Clicking on first eligible trading option check box");
		customLogger("Clicking on first eligible trading option check box", "");
		this.seleniumCore.waitForElementToBeVisible(acceptDisclosures);
		this.seleniumCore.click(acceptDisclosures, PAGE_NAME, "Clicking check box on accept disclosures");
		customLogger("Clicking check box on accept disclosures", "");
		this.seleniumCore.click(continueBtn, PAGE_NAME, "Clicking on continue button");
		customLogger("Clicking on continue button", "");
		return new DocuSignPage(seleniumCore);

	}

	public void optingHarvestType(String harvestoption) {
		if (harvestoption.equals("Looses")) {
			this.seleniumCore.waitForElementToBeVisible(lossesCheckBox);
			this.seleniumCore.click(lossesCheckBox, PAGE_NAME, "Clicking gainloss check box");
			customLogger("Clicking gainloss check box", "");
		} else {
			this.seleniumCore.waitForElementToBeVisible(gainsCheckBox);
			this.seleniumCore.click(gainsCheckBox, PAGE_NAME, "Clicking gainloss check box");
			customLogger("Clicking gainloss check box", "");
		}
	}

	public boolean validateCashOptionsExcludedFromSecurityType(String cashOption) {
		boolean cashOptions = true;
		List<WebElement> securityTypesList = this.seleniumCore.findElements(securityTypeList);
		for (WebElement securityType : securityTypesList) {
			cashOptions = securityType.getText().contains(cashOption);
			this.logger.info("Validating cash option with security Type -" + securityType + ":" + cashOption);
			if (cashOptions) {
				this.logger.info("Cash Options are not excluded from security type : " + cashOption);
				break;
			}
		}
		return cashOptions;
	}

	public void verifyCusipDisplayed(String Net_Amount, String Wizard, String Cusip) {

		boolean secVal = false;
		int netAmount = Integer.parseInt(Net_Amount);
		logger.info("the net amount value is :: : " + netAmount);
		customLogger("the net amount value is :: : " + netAmount, "");

		logger.info("The value of Cusip is : : " + Cusip + " -- The length of Cusip is :: " + Cusip.length());
		if (Cusip.length() < 9) {
			for (int i = Cusip.length(); i < 9; i++) {
				Cusip = "0" + Cusip;
				logger.info("Adjusted value of Cusip is : :" + Cusip);
			}
		} else {
			logger.info("cusip value is original ");
		}
		if (netAmount > 0) {
			logger.info("The value is in posiitive range .");
			customLogger("The value is in posiitive range .", "");

			this.seleniumCore.waitForElementToBeVisible(gainsCheckBox);
			this.seleniumCore.click(gainsCheckBox, PAGE_NAME, "Clicking Gain check box");
			customLogger("Clicking Gain check box", "");

			this.seleniumCore.waitForElementToBeVisible(selectTradeListOption);
			this.seleniumCore.click(selectTradeListOption, PAGE_NAME, "Clicking on selectTradeListOption option");
			customLogger("Clicking on selectTradeListOption option", "");
			waitForUILoading(1000);
			List<WebElement> ele = this.seleniumCore.findElements(securitiesData); // SecuritiesList
			logger.info("ele  SIZE is :: :: ::" + ele.size());

			if (netAmount > 100) {
				logger.info("the net amount value is > 100 :: : " + netAmount);
				logger.info("according to the value it should Display in Gain");
				customLogger("the net amount value is :: : " + netAmount + "> 100 ", "");
				for (WebElement security : ele) {
					logger.info("- -- - - - ---------------");
					logger.info("the ele text is : :" + security.getText());
					logger.info("the value to check is : :" + Cusip);
					secVal = security.getText().contains(Cusip);
					if (secVal) {
						logger.info("The Cusip - " + Cusip + " - is displyed in the Security ::" + security.getText());
						customLogger("The Cusip - " + Cusip + " - is displyed in the Security ::" + security.getText(),
								"");
						break;
					}
				}
				if (!secVal) {
					logger.info("The Cusip - " + Cusip + " - is NOT Displyed in the Securities ");
					customLogger("The Cusip - " + Cusip + " - is NOT Displyed in the Securities ", "");
					Assert.assertTrue("Cusip value is not displayed as desired ", secVal);
				}

			} else {
				logger.info("according to the value it should NOT Display in Gain");
				customLogger("according to the value it should NOT Display in Gain", "");
			}
		} else {
			logger.info("The value is in negitive range .");
			customLogger("The value is in negitive range .", "");

			this.seleniumCore.waitForElementToBeVisible(lossesCheckBox);
			this.seleniumCore.click(lossesCheckBox, PAGE_NAME, "Clicking Loss check box");
			customLogger("Clicking Loss check box", "");

			this.seleniumCore.waitForElementToBeVisible(selectTradeListOption);
			this.seleniumCore.click(selectTradeListOption, PAGE_NAME, "Clicking on selectTradeListOption option");
			customLogger("Clicking on selectTradeListOption option", "");
			waitForUILoading(1000);
			List<WebElement> ele = this.seleniumCore.findElements(securitiesData); // SecuritiesList
			logger.info("ele  SIZE is :: :: ::" + ele.size());

			if (netAmount < -100) {
				logger.info("according to the value it should Display in Loss");
				customLogger("the net amount value is :: : " + netAmount + "< -100 ", "");
				for (WebElement security : ele) {
					logger.info("- -- - - - ---------------");
					logger.info("the ele text is : :" + security.getText());
					logger.info("the value to check is : :" + Cusip);
					secVal = security.getText().contains(Cusip);
					if (secVal) {
						logger.info("The Cusip - " + Cusip + " - is displyed in the Security ::" + security.getText());
						customLogger("The Cusip - " + Cusip + " - is displyed in the Security ::" + security.getText(),
								"");
						break;
					}
				}
				if (!secVal) {
					logger.info("The Cusip - " + Cusip + " - is NOT Displyed in the Securities ");
					customLogger("The Cusip - " + Cusip + " - is NOT Displyed in the Securities ", "");
					Assert.assertTrue("Cusip value is not displayed as desired ", secVal);
				}
			} else {
				logger.info("according to the value it should NOT Display in Loss");
				customLogger("according to the value it should NOT Display in Loss", "");
			}
		}
	}

	public void choosingHarvestAmountType(String optionToRealize) {
		switch (optionToRealize) {
		case "SelectTradeList":
			this.seleniumCore.waitForElementToBeVisible(selectTradeListOption);
			this.seleniumCore.click(selectTradeListOption, PAGE_NAME, "Clicking on selectTradeListOption option");
			customLogger("Clicking on selectTradeListOption option", "");

			this.seleniumCore.waitForElementToBeVisible(firstCheckBoxofEligibleTrading);
			this.seleniumCore.click(firstCheckBoxofEligibleTrading, PAGE_NAME,
					"Clicking on first eligible trading option check box");
			customLogger("Clicking on first eligible trading option check box", "");
			break;
		case "Select_Securities":
			this.seleniumCore.waitForElementToBeVisible(selectTradeListOption); // SelectTradeList_ALL
			this.seleniumCore.click(selectTradeListOption, PAGE_NAME, "Clicking on selectTradeListOption option");
			customLogger("Clicking on selectTradeListOption option", "");

			this.seleniumCore.waitForElementToBeVisible(commonCheckBoxofEligibleTrading);
			List<WebElement> ele = this.seleniumCore.findElements(commonCheckBoxofEligibleTrading);

			for (int i = 0; i < 3; i++) {
				ele.get(i).click();
				logger.info("Clicking on random eligible trading option check box");
			}
			customLogger("Clicking on random eligible trading option check box", "");
			break;
		case "SelectTradeList_ALL":
			this.seleniumCore.waitForElementToBeVisible(selectTradeListOption);
			this.seleniumCore.click(selectTradeListOption, PAGE_NAME, "Clicking on selectTradeListOption option");
			customLogger("Clicking on selectTradeListOption option", "");

			this.seleniumCore.waitForElementToBeVisible(CheckBoxForAllSecurityTypes);
			this.seleniumCore.click(CheckBoxForAllSecurityTypes, PAGE_NAME,
					"Selecting all eligible trading option check box");
			customLogger("Selected all eligible trading option check box", "");
			break;
		case "MaxGainAvailable":
			this.seleniumCore.waitForElementToBeVisible(selectMaxGainOption);
			this.seleniumCore.click(selectMaxGainOption, PAGE_NAME, "Clicking on MaxGainAvailable option");
			customLogger("Clicking on MaxGainAvailable option", "");
			break;
		case "MaxLossesAvailable":
			this.seleniumCore.waitForElementToBeVisible(selectMaxLossesOption);
			this.seleniumCore.click(selectMaxLossesOption, PAGE_NAME, "Clicking on selectMaxLossesOption option");
			customLogger("Clicking on selectMaxLossesOption option", "");
			break;
		default:
			logger.info("Went into default ****");
		}
	}

	public void choosingProceedsToBeInvested(String optionToRealize) {
		switch (optionToRealize) {
		case "InTheMarket":
			this.seleniumCore.waitForElementToBeClickable(inTheMarket);
			this.seleniumCore.click(inTheMarket, PAGE_NAME, "Clicking on inTheMarket option");
			customLogger("Clicking on inTheMarket option", "");
			break;
		case "OutOfMarket":
			this.seleniumCore.waitForElementToBeClickable(outOfMarket);
			this.seleniumCore.click(outOfMarket, PAGE_NAME, "Clicking on outOfMarket option");
			customLogger("Clicking on outOfMarket option", "");
			break;
		default:
			logger.info("Went into defualt ****");
		}
	}

	public void choosingHarvestAmountTypeAndAddingSpecificAmount(String optionToRealize, String customvalue) {
		switch (optionToRealize) {
		case "AddSpecificAmount":
			this.seleniumCore.waitForElementToBeVisible(addSpecificAmountOption);
			this.seleniumCore.click(addSpecificAmountOption, PAGE_NAME, "Clicking on addSpecificAmount option");
			logger.info("using direct sendkeys .. ");
			this.seleniumCore.findElement(addingAmount).sendKeys(customvalue);
			customLogger("Clicking on addSpecificAmount option", "");
			break;
		default:
			logger.info("Went into defualt ****");
		}
	}

	public DocuSignPage acceptingDisclosure() {
		this.seleniumCore.waitForElementToBeVisible(acceptDisclosures);
		this.seleniumCore.click(acceptDisclosures, PAGE_NAME, "Clicking check box on accept disclosures");
		customLogger("Clicking check box on accept disclosures", "");
		this.seleniumCore.click(continueBtn, PAGE_NAME, "Clicking on continue button");
		customLogger("Clicking on continue button", "");
		return new DocuSignPage(seleniumCore);
	}

	public DocuSignPage chooseOptionsForTaxLossGain(String harvestoption, String optionToRealize, String customvalue) {
		if (harvestoption.equals("Loss")) {
			this.seleniumCore.waitForElementToBeVisible(lossesCheckBox);
			this.seleniumCore.click(lossesCheckBox, PAGE_NAME, "Clicking gainloss check box");
			customLogger("Clicking gainloss check box", "");
		} else {
			this.seleniumCore.waitForElementToBeVisible(gainsCheckBox);
			this.seleniumCore.click(gainsCheckBox, PAGE_NAME, "Clicking gainloss check box");
			customLogger("Clicking gainloss check box", "");
		}

		switch (optionToRealize) {
		case "SelectTradeList":
			this.seleniumCore.waitForElementToBeVisible(selectTradeListOption);
			this.seleniumCore.click(selectTradeListOption, PAGE_NAME, "Clicking on selectTradeListOption option");
			customLogger("Clicking on selectTradeListOption option", "");

			this.seleniumCore.waitForElementToBeVisible(firstCheckBoxofEligibleTrading);
			this.seleniumCore.click(firstCheckBoxofEligibleTrading, PAGE_NAME,
					"Clicking on first eligible trading option check box");
			customLogger("Clicking on first eligible trading option check box", "");
			break;
		case "Select_Securities":
			this.seleniumCore.waitForElementToBeVisible(selectTradeListOption); // SelectTradeList_ALL
			this.seleniumCore.click(selectTradeListOption, PAGE_NAME, "Clicking on selectTradeListOption option");
			customLogger("Clicking on selectTradeListOption option", "");

			this.seleniumCore.waitForElementToBeVisible(commonCheckBoxofEligibleTrading);
			List<WebElement> ele = this.seleniumCore.findElements(commonCheckBoxofEligibleTrading);

			for (int i = 0; i < 3; i++) {
				ele.get(i).click();
				logger.info("Clicking on random eligible trading option check box");
			}
			customLogger("Clicking on random eligible trading option check box", "");
			break;
		case "Select_Securities_All":
			this.seleniumCore.waitForElementToBeVisible(selectTradeListOption); // SelectTradeList_ALL
			this.seleniumCore.click(selectTradeListOption, PAGE_NAME, "Clicking on selectTradeListOption option");
			customLogger("Clicking on selectTradeListOption option", "");

			this.seleniumCore.waitForElementToBeVisible(CheckBoxForAllSecurityTypes);
			this.seleniumCore.click(commonCheckBoxofEligibleTrading, PAGE_NAME,
					"Clicking on first eligible trading option check box"); // CheckBoxForAllSecurityTypes
			customLogger("Clicking on random eligible trading option check box", "");
			break;
		case "Maximum_Gain":
			this.seleniumCore.waitForElementToBeVisible(selectMaxGainOption); // MaxGainAvailable
			this.seleniumCore.click(selectMaxGainOption, PAGE_NAME, "Clicking on MaxGainAvailable option");
			customLogger("Clicking on MaxGainAvailable option", "");
			break;
		case "Maximum_Loss":
			this.seleniumCore.waitForElementToBeVisible(selectMaxLossesOption); // MaxLossesAvailable
			this.seleniumCore.click(selectMaxLossesOption, PAGE_NAME, "Clicking on selectMaxLossesOption option");
			customLogger("Clicking on selectMaxLossesOption option", "");
			break;
		case "AddSpecificAmount":
			this.seleniumCore.waitForElementToBeVisible(addSpecificAmountOption);
			this.seleniumCore.click(addSpecificAmountOption, PAGE_NAME, "Clicking on addSpecificAmount option");
			logger.info("using direct sendkeys .. ");
			// uncomment this after run
			// this.seleniumCore.findElement(addingAmount).sendKeys(customvalue);
			customLogger("Clicking on addSpecificAmount option", "");
			break;
		default:
			logger.info("Went into defualt ****");
		}

		if (customvalue.equals("OutOfMarket")) {
			this.seleniumCore.waitForElementToBeVisible(outOfMarket);
			this.seleniumCore.click(outOfMarket, PAGE_NAME, "Clicking outOfMarket check box");
			customLogger("Clicking outOfMarket check box", "");
		} else if (customvalue.equals("NotApplicable")) {
			logger.info("Not Applicable for Proceed to be invested");
			customLogger("Not Applicable for Proceed to be invested", "");
		} else {
			WebElement ele = this.seleniumCore.findElement(inTheMarket);
			if (ele.isSelected()) {
				logger.info("in the market selected by default");
				customLogger("in the market selected by default", "");
			} else {
				this.seleniumCore.waitForElementToBeVisible(inTheMarket);
				this.seleniumCore.click(inTheMarket, PAGE_NAME, "Clicking inTheMarket check box");
				customLogger("Clicking inTheMarket check box", "");
			}
		}
		this.seleniumCore.waitForElementToBeVisible(acceptDisclosures);
		this.seleniumCore.click(acceptDisclosures, PAGE_NAME, "Clicking check box on accept disclosures");
		customLogger("Clicking check box on accept disclosures", "");
		this.seleniumCore.click(continueBtn, PAGE_NAME, "Clicking on continue button");
		customLogger("Clicking on continue button", "");
		return new DocuSignPage(seleniumCore);
	}

}
