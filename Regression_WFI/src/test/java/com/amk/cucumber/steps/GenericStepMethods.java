package com.amk.cucumber.steps;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.amk.cucumber.driver.DriverManager;
import com.amk.cucumber.driver.DriverManagerFactory;
import com.amk.cucumber.pages.AccountApprovalPage;
import com.amk.cucumber.pages.AccountListPage;
import com.amk.cucumber.pages.AccountSetupPage;
import com.amk.cucumber.pages.AccountUpdateUtilityPage;
import com.amk.cucumber.pages.AccountWizardPage;
import com.amk.cucumber.pages.BawDashboardPage;
import com.amk.cucumber.pages.BawHomePage;
import com.amk.cucumber.pages.BawLoginPage;
import com.amk.cucumber.pages.BulkReassignPage;
import com.amk.cucumber.pages.CheckContributionsPage;
import com.amk.cucumber.pages.ClientListPage;
import com.amk.cucumber.pages.ClientProfilePage;
import com.amk.cucumber.pages.ConstructPortfolioPage;
import com.amk.cucumber.pages.CreateDocumentsPage;
import com.amk.cucumber.pages.CreateOAPage;
import com.amk.cucumber.pages.DocuSignPage;
import com.amk.cucumber.pages.FeesPage;
import com.amk.cucumber.pages.FundingMethodPage;
import com.amk.cucumber.pages.HoldingsSummaryPage;
import com.amk.cucumber.pages.HomePage;
import com.amk.cucumber.pages.IRAWithdrawalRequestPage;
import com.amk.cucumber.pages.InvestmentChangePage;
import com.amk.cucumber.pages.ItemDetailsPage;
import com.amk.cucumber.pages.JournalUtilityPage;
import com.amk.cucumber.pages.LoginPage;
import com.amk.cucumber.pages.LookUpPage;
import com.amk.cucumber.pages.NAACoachPage;
import com.amk.cucumber.pages.OWBHomePage;
import com.amk.cucumber.pages.OneTimeDistributionPage;
import com.amk.cucumber.pages.OptOutListPage;
import com.amk.cucumber.pages.PortfolioDetailsPage;
import com.amk.cucumber.pages.ReviewAllAccountsPage;
import com.amk.cucumber.pages.SearchWorkItemPage;
import com.amk.cucumber.pages.SetQCSelectionPage;
import com.amk.cucumber.pages.ShellProcessPage;
import com.amk.cucumber.pages.SubmitPage;
import com.amk.cucumber.pages.TaxHarvestRequestPage;
import com.amk.cucumber.pages.TaxManagementServices;
import com.amk.cucumber.pages.TrackingCenterPage;
import com.amk.cucumber.pages.TransferAttributesPage;
import com.amk.cucumber.pages.ViewDocumentsPage;
import com.amk.cucumber.utility.ConfigReader;
import com.amk.cucumber.utility.DBUtil;
import com.amk.cucumber.utility.DateUtil;
import com.amk.cucumber.utility.ExcelReader;
import com.amk.cucumber.utility.ExcelUtility;
import com.amk.cucumber.utility.PDFReader;
import com.amk.cucumber.utility.RestApiUtility;
import com.amk.cucumber.utility.SeleniumCore;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.browserstack.local.Local;

import io.restassured.response.Response;

public class GenericStepMethods {
	
	protected static HomePage homePage;
	protected static AccountWizardPage accountWizardPage;
	protected static LookUpPage lookUpPage;
	protected static BawHomePage bawHomePage;
	protected static BawDashboardPage bawDashboardPage;
	protected static FeesPage feesPage;	
	protected static InvestmentChangePage investmentChangePage;
	protected static DocuSignPage docuSignPage;
	protected static TaxManagementServices taxManagementServices;
	protected static TrackingCenterPage trackingCenterPage;	
	protected static ItemDetailsPage itemDetailsPage;
	protected static ShellProcessPage shellProcessPage;
	protected static SearchWorkItemPage searchWorkItemPage;
	protected static BulkReassignPage bulkReassignPage;
	protected static AccountUpdateUtilityPage accountUpdateUtilityPage;
	protected static SetQCSelectionPage setQCSelectionPage;
	protected static OptOutListPage optOutListPage;	
	protected static CreateOAPage createOAPage;
	protected static JournalUtilityPage journalUtilityPage;
	protected static TransferAttributesPage transferAttributesPage;
	protected static ClientProfilePage clientProfilePage;
	protected static ConstructPortfolioPage constructPortfolioPage;
	protected static PortfolioDetailsPage portfolioDetailsPage;
	protected static AccountSetupPage accountSetupPage;
	protected static FundingMethodPage fundingMethodPage;
	protected static ReviewAllAccountsPage reviewAllAccountsPage;
	protected static CreateDocumentsPage createDocumentsPage;
	protected static ViewDocumentsPage viewDocumentsPage;
	protected static SubmitPage submitPage;
	protected static AccountApprovalPage accountApprovalPage;
	protected static NAACoachPage naaCoachPage;
	protected static TaxHarvestRequestPage taxHarvestRequest;
	protected static AccountListPage accountListPage;
	protected static ClientListPage clientListPage;
	protected static HoldingsSummaryPage holdingsSummaryPage;
	protected static IRAWithdrawalRequestPage iRAWithdrawalRequestPage;
	protected static CheckContributionsPage checkContributionsPage;
	protected static OneTimeDistributionPage oneTimeDistributionPage;
	protected static OWBHomePage  owbHomePage;	
	public static PDFReader pdf;
	
	protected static String dTrackingId;
	protected static String bTrackingId;
	protected static String bawPageWindow;
	protected static String createOaWindow;
	protected static String shellPageWindow;
	protected static String clientRegistrationType;
	protected static String fullname;
	protected static String bNumber="B099172101";
	protected static String transferFirmName;
	protected static String numberHRC;
	protected static String parentBNumber;
	protected boolean valueFor_TLHR = false;
	protected static boolean residualDistribution;
	protected  String parentWindow;
	protected static Map<String, String> addAccountInfo;
	protected static String advisorAPLID;
	protected static List<String[]> values;
	protected static String [] firstRow;
	protected static String [] secondRow;
	protected static String taxManagementId;
	protected static String retainAccountNumber;
	protected static String firmName;
	protected static List<String> transferInstructions;
	protected static String fundingAccountNumber;
	protected static String transferTrackingNumber;
	protected static String accountTransferId;
	
	protected static RestApiUtility restApiUtilityPage = new RestApiUtility();
	public static Response response;
 
	private static final String STEP_NAME = "Login To Application";

	protected ConfigReader configReader = new ConfigReader();
	protected Logger logger = Logger.getLogger(GenericStepMethods.class);
	protected static SeleniumCore seleniumCore;
	protected static Local bsLocal;
	protected DriverManager driverManager;
	public static WebDriver driver;
	public static HashMap<String, String> clientData;
	private BawLoginPage bawLoginPage;
	private DBUtil dbUtil;	

	public String excelPath = "./Data/Test11_data.xlsx";
	protected static ExcelUtility excel;
	public static String sheetName;
	public static int rowNo;


	// Setup the BaseTest
	public void setup() {
		driverManager = DriverManagerFactory.getDriverManager(configReader);
		SeleniumCore.setMaxWaitTime(configReader.get_Max_Wait_Time());
		SeleniumCore.setPollTime(configReader.get_Poll_Time());		
		
		if(configReader.get_ExecutionType().contains("REMOTE")) {
			bsLocal = new Local();			
			HashMap<String, String> bsLocalArgs = new HashMap<String, String>();			  
			bsLocalArgs.put("key", configReader.get_REMOTE_ACCESS_KEY());				
			try {
				bsLocal.start(bsLocalArgs);	
				logger.info("Is browserStack server running: "+ bsLocal.isRunning());			
			} catch (Exception e1) {				
				e1.printStackTrace();
			}
		}
		
		driver = driverManager.getWebDriver();
		seleniumCore = new SeleniumCore(driver, this.logger);		
	}

	public static void customLogger(String log, String value) {
		if (value.isEmpty())
			ExtentCucumberAdapter.addTestStepLog(" . . . . " + log);

		else
			ExtentCucumberAdapter.addTestStepLog(" . . . . " + log + " : " + value);
	}

	public static void emptyLogger(String log) {
		ExtentCucumberAdapter.addTestStepLog(" ~ " + log);
	}

	public void setup(String excelPath, String sheet, int row) {
		excel = new ExcelUtility(excelPath);
		sheetName = getSheetName(sheet);
		rowNo = getRowNo(row);	
	}
	
	public Map<String, String> getIndividualRowDataFromSheet(String sheetName, int rowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = null;
		if(configReader.get_Application_URL().contains("test12")) {
			 testData = reader.getData("./Data/Test12_data.xlsx", sheetName);	
		} else if(configReader.get_Application_URL().contains("test11")) {
			 testData = reader.getData("./Data/Test11_data.xlsx", sheetName);	
		} else if(configReader.get_Application_URL().contains("test10")) {
			 testData = reader.getData("./Data/Test10_data.xlsx", sheetName);	
		}			
		return testData.get(rowNumber-2);
	}

	public String getSheetName(String sheetName) {
		return sheetName;
	}

	public int getRowNo(int rowNo) {
		return rowNo;
	}

	public String readData(String colName) {
		return excel.getXLValue(sheetName, colName, rowNo);
	}

	public HomePage loginToApplication(String url, String username, String password) {
		return openUrl(url).login(username, password, STEP_NAME);
	}

	private LoginPage openUrl(String url) {
		seleniumCore.get(url, STEP_NAME, "Launching Application URL. " + url);
		customLogger("Launching Application URL ", url);

		return new LoginPage(seleniumCore);
	}
	
	public HomePage loginToApplicationAssetMark() {
		final String url = configReader.get_Application_URL();
		final String username = configReader.get_Application_Username();
		final String password = configReader.get_Application_Password();
		
		return loginToApplication(url, username, password);
	}
	
	public HomePage loginToApplicationAssetMark(String username, String password) {
		final String url = configReader.get_Application_URL();
		
		return loginToApplication(url, username, password);
	}
	
	public BawHomePage loginToApplicationBusinessAutomationWorkflow(String directviaeWM) {
		String stepName = "Login To Application";
		switch (directviaeWM) {
		case "viaeWM":
			seleniumCore.getInNewTab(configReader.get_BawApplication_URL(), stepName,
					"Launching Application URL. " + configReader.get_BawApplication_URL());
			break;
		case "directBAW":
			seleniumCore.get(configReader.get_BawApplication_URL(), stepName,
					"Launching Application URL. " + configReader.get_BawApplication_URL());
			break;
		default:
			logger.info("applicaion has been launched ");
		}
		customLogger("Launching Application URL. ", configReader.get_BawApplication_URL());
		bawLoginPage = new BawLoginPage(seleniumCore);

		logger.info("launch the browser " + " open the BAW application");
		return bawLoginPage.login(configReader.get_BawApplication_Username(),
				configReader.get_BawApplication_Password(), stepName);
	}
	
	public void openBancorpApplication() {
		String bawURL= configReader.get_BawApplication_URL();
		if(bawURL.contains("fpkt11bawps1")) {
			seleniumCore.getInNewTab("file://fpkt11gss1a/Bancorp/NewApplications/", "launching bancorp application", "");
			customLogger("launching bancorp application ", bawURL);
		} else if (bawURL.contains("fpkt12bawps1")) {
			seleniumCore.getInNewTab("file://fpkt12gss1/Bancorp/NewApplications/", "launching bancorp application", "");
			customLogger("Launching Application URL. ", bawURL);
		} else {
			logger.info("applicaion has been launched ");
		}
	}
	
	public void validateFilesInBancorp() {		
		DateUtil dateUtil = new DateUtil(); 
		System.out.println(dateUtil.date());
		String text= seleniumCore.findElement(By.xpath("//tbody[@id='tbody']")).getText();		
		Assert.assertTrue("file date is not matching", text.contains(dateUtil.date()));	
		logger.info("file is found");
		customLogger("file is found", "");
	}
	
	public void loginByBawQcUser(String userName, String password) {
		seleniumCore.get(configReader.get_BawApplication_URL(), "","");
		 bawLoginPage.login(userName, password, "Login To Application via BAW QC User");
		customLogger("Login To Application via BAW QC User", "");
	}
	
	public void setUpAzureDBConnection(String hostName, String DbUserName,String DbPassword, String DbName) {
		dbUtil = new DBUtil(seleniumCore);				
		dbUtil.setupAzureDBConnection(hostName, DbUserName, DbPassword, DbName);		
	}
	
	public void setupDBConnection(String db) {
		dbUtil = new DBUtil(seleniumCore);			
		dbUtil.setupDBConnection(db);
	}
	
	public String dataBaseValueVerification(String query, String columnName) {
		logger.info("the query is  ************   " + query);		
		customLogger("The Query is : :", query);
		String Status_value = dbUtil.executeQueryAndGetFirstValue(query, columnName);
		customLogger("DB query successfully executed", "");
		customLogger("Result From DB is ::", Status_value);
		logger.info("Result From DB is "+ Status_value);
		return Status_value;
	}
	
	public List<String[]> fetchDBValueVerification(String query) {
		logger.info("the query is  ************   " + query);		
		customLogger("The Query is : :", query);
		List<String[]> statusValue = dbUtil.executeSelectQueryAndGetStringList(query);
		customLogger("DB query successfully executed", "");		
		logger.info("DB query successfully executed ");	
		
		return statusValue;
	}
	
	public void dataBaseUpdateValue(String query) throws SQLException {
		logger.info("the query is  ************   " + query);		
		customLogger("The Query is : :", query);
		dbUtil.executeUpdateQuery(query);
		customLogger("DB query successfully executed", "");		
	}
	
	public BawHomePage loginBawQcUser() {
		return bawLoginPage.login(configReader.get_BawApplication_Username(),
				configReader.get_BawApplication_Password(), "");
	}
	
	public void loginOWBApplication() {
		seleniumCore.get(configReader.get_OcwApplication_URL(), "","");
		owbHomePage= new OWBHomePage(seleniumCore); 
		owbHomePage.clickLoginButton("", "click login button");		
		owbHomePage.loginOWB();
		customLogger("Login To OCW Application ", "");
	}
	
	public boolean checkVisibilityOfCloseButton_THR() {
		boolean check;
		WebElement ele = seleniumCore.findElement(By.xpath("//button[contains(text(),'CLOSE')]")); // By.xpath("//button[contains(text(),'CLOSE')]")
		check = ele.isDisplayed();
		return check;
	}
	
	public String dataBaseValueVerification(String dTrackingID) {
		String query =  "SELECT TOP (1000) [TaxHarvestID] " + "      ,[OriginalExternalId] "
				+ "      ,[CurrentExternalId] " + "      ,[AgentAPLID] " + "      ,[HouseholdId] "
				+ "      ,[AccountId] " + "      ,[AccountNumber] " + "      ,[ModelAPLID] " + "      ,[SleeveAPLID] "
				+ "      ,[SMI_IsThirdPartyIMA] " + "      ,[ProceedsInvested] " + "      ,[HarvestType] "
				+ "      ,[HarvestAmountType] " + "      ,[HarvestAmount] " + "      ,[SalesProceedAmount] "
				+ "      ,[CreatedBy] " + "      ,[CreatedDate] " + "      ,[ModifiedBy] " + "      ,[ModifiedDate] "
				+ "      ,[ApprovedBy] " + "      ,[ApprovedDate] " + "      ,[Status] "
				+ "  FROM [TaxHarvest].[dbo].[TaxHarvest] " + "  where OriginalExternalId = '" + dTrackingID + "'"; 
		
		logger.info("the query is  ************   " + query);
		customLogger("The Query is : :", query);
		String Status_value = dbUtil.executeQueryAndGetFirstValue(query, "Status");
		customLogger("DB query successfully executed", "");// Status
		customLogger("Result From DB is ::", Status_value);
		return Status_value;
	}
	
	public void validatingTLHapprovalFromDB(String valeFromDB, String bTrackingId) throws InterruptedException {
		boolean check = false;
		if (valeFromDB.contains("Ready")) {
			try {
				Assert.assertEquals("ReadyForTrading", valeFromDB);
			} catch (Exception e) {
				for (int i = 0; i <= 1; i++) {
					String valueFromDB = dataBaseValueVerification(bTrackingId);
					try {
						Assert.assertEquals("ReadyForTrading", valueFromDB);
						check = true;
						break;
					} catch (Exception exp) {
						logger.info("Value from DB was not as Expected for " + i + " time, Retrying ~~.");
						customLogger("Value from DB was not as Expected for " + i + " time, Retrying ~~.", "");
						waitForUILoading(1000);
					}
				}
				if (!check) {
					logger.info("The value is not matching with DB .");
					customLogger("The value is not matching with DB .", "");
				}
			}
		} else if (valeFromDB.contains("Submit")) {

			try {
				Assert.assertEquals("SubmittedForTrading", valeFromDB);
			} catch (Exception e) {
				for (int i = 0; i <= 1; i++) {
					String valueFromDB = dataBaseValueVerification(bTrackingId);
					try {
						Assert.assertEquals("SubmittedForTrading", valueFromDB);
						check = true;
						break;
					} catch (Exception exp) {
						logger.info("Value from DB was not as Expected for " + i + " time, Retrying ~~.");
						customLogger("Value from DB was not as Expected for " + i + " time, Retrying ~~.", "");
						waitForUILoading(1000);
					}
				}
				if (!check) {
					logger.info("The value is not matching with DB .");
					customLogger("The value is not matching with DB .", "");
				}
			}

		} else {

			try {
				Assert.assertEquals("SkipTradingForHNW", valeFromDB);
			} catch (Exception e) {
				for (int i = 0; i <= 1; i++) {
					String valueFromDB = dataBaseValueVerification(bTrackingId);
					try {
						Assert.assertEquals("SkipTradingForHNW", valueFromDB);
						check = true;
						break;
					} catch (Exception exp) {
						logger.info("Value from DB was not as Expected for " + i + " time, Retrying ~~.");
						customLogger("Value from DB was not as Expected for " + i + " time, Retrying ~~.", "");
						waitForUILoading(1000);
					}
				}
				if (!check) {
					logger.info("The value is not matching with DB .");
					customLogger("The value is not matching with DB .", "");
				}
			}

		}
	}
	
	 public void waitForUILoading(int delay) {
	        try {
	            Thread.sleep(delay);
	        } catch (InterruptedException e) {
	            logger.info("Fail waiting UI :"+ e.getMessage());
	        }
	    }  
	 
	 public void validateTransferStatus(String stat) {
		 Assert.assertEquals("", transferFirmName, stat);
		 logger.info("transfer audit status is: " + stat);
			customLogger("transfer audit status is ", stat);
	 }
	 
	 public void validatePdfContent(String pdfName, String text) {
		 File file = new File(System.getProperty("user.dir") + File.separator + "Downloads" + File.separator + pdfName + ".pdf");
			int intAttemps = 0;
			while (!file.exists() && intAttemps < 10) {
				seleniumCore.waitForUILoading(1000);
				intAttemps = intAttemps + 1;
			}
			if (file.exists()) {
				Assert.assertTrue("PDF should be displayed", file.exists());
				pdf = new PDFReader(file);
				if(pdfName.toLowerCase().contains("toain")) {
					Assert.assertFalse(text+ " is not present in the file", pdf.isTextFound(text));		
				}else {
				Assert.assertTrue(text+ " is not present in the file", pdf.isTextFound(text));	
				}
				logger.info(text+ " is present in pdf file");
				customLogger(text, " is present in pdf file");
			}
	 }
	 
	 public void deletePDFFile(String pdfName) {
		 File file = new File(System.getProperty("user.dir") + File.separator + "Downloads" + File.separator + pdfName + ".pdf");
			if (file.exists()) {			
				file.delete();
				logger.info("downloaded file has been deleted");
				customLogger("downloaded file has been deleted", "");
			}
	 }
	 
	 public static  List<String> GetBankAccountAttributesFromBeta(){
	    	List<String> object = new ArrayList<String>();
	    	for(int i=0; i<2 ;i++) {
	    		object.add("getAccountCustomAttributesResponse.fieldList["+i+"].value");
	    	}
	    	return object;
	    }
	
}	
