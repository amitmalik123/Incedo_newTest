package com.amk.cucumber.pages;

import org.openqa.selenium.By;

import com.amk.cucumber.instantiator.Instantiator;
import com.amk.cucumber.utility.CommonMethods;
import com.amk.cucumber.utility.SeleniumCore;

public class ClientListPage extends CommonMethods implements Instantiator<ClientListPage> {

	// Static Data
	private static final String PAGE_NAME = "CLIENT LIST PAGE (Clients tab)";

	// Navigation
	private final By clientListTab = By.xpath("//span[text()='Client List']/parent::li");
	private final By clientListGrid = By.xpath("//*[@id='gbox_ClientListGrid']");
	private final By goBtn = By.xpath("//button[@id='searchbutton']");

	// Body

	@Override
	public ClientListPage getInstance() {
		return new ClientListPage(seleniumCore);
	}

	public ClientListPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	public ClientListPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		waitForSpinnerToBeDisappear();
		waitForAllLoadingImagesToBeDisappear();
		if (pageVerification) {
			boolean isGrid = seleniumCore.isElementVisible(clientListGrid, 20, 1);
			boolean isClientListTab = isElementHasClass(clientListTab, "selected");
			boolean isGOBtnClickable = seleniumCore.isElementVisible(goBtn, 5, 1);

			if (isClientListTab && isGrid && isGOBtnClickable) {
				logger.info(PAGE_NAME + " verification" + SEPARATOR + PAGE_NAME + " verification is PASSED");
			} else {
				logger.warn(PAGE_NAME + " verification" + SEPARATOR + PAGE_NAME + " verification is FAILED");
			}
		}
	}

}
