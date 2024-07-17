package com.amk.cucumber.steps;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.amk.cucumber.constants.Constants;
import com.amk.cucumber.utility.PDFReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonSteps extends GenericStepMethods {

	@Given("User should login to the application and impersonate into an agent {string} , {int}")
	public void user_should_login_to_the_application_and_impersonate_into_an_agent(String sheetName, int RowNo)
			throws InvalidFormatException, IOException {
		emptyLogger(" \n ");
		clientData = (HashMap<String, String>) getIndividualRowDataFromSheet(sheetName, RowNo);
		String UserId = clientData.get(Constants.USER_NAME);		
		homePage = loginToApplicationAssetMark();
		customLogger("Login as an Admin", "Successfully Logged in to eWM as Admin");
		lookUpPage = homePage.clickSwitchID("SwitchID", "Clicking on switchID");		
		logger.info("UserId is " + UserId);
		lookUpPage.enterLookupUserIDAndclickFind(UserId, "Lookup User",
				"Entering user id: "+ UserId +" and click on find button");
		lookUpPage.clickSSOUserID(UserId, "Switch Agent ", "Clicking on SSO User ID");
		// lookUpPage.ChooseRole();
		customLogger("Impersonate as an Agent ", "Successfully switched to agent: " + UserId);
		accountWizardPage = homePage.clickAccountWizardTab();
		emptyLogger(" \n ");
	}

	@When("User impersonate to an {string} and navigates to account approval page")
	public void User_impersonate_to_an_advisor_and_navigates_to_account_approval_page(String role) {
		emptyLogger(" \n ");
		lookUpPage = homePage.clickSwitchID("SwitchID", "Clicking on switchID");
		customLogger("Clicking on switchID", "");
		lookUpPage.enterLookupUserIDAndclickFind(clientData.get(Constants.USER_NAME), "Lookup User",
				"Entering Lookup User ID and Clicking Find Button");			
		lookUpPage.clickSSOUser(role, "Switch to user ", "Clicking on SSO User ID");
		lookUpPage.ChooseAdvisorRole();	
		if(!role.equals("Agent")) {
		accountApprovalPage = homePage.clickAccountApprovalTab();
		}
		customLogger("click on Account Approval Tab ", "User is navigated to Account Approval Page as Advisor");
		emptyLogger(" \n ");
	}
	
	@Given("User login to ewm and impersonate to {string}")
	public void User_login_to_ewm(String role) {
		emptyLogger(" \n ");
		homePage = loginToApplicationAssetMark();
		lookUpPage = homePage.clickSwitchID("SwitchID", "Clicking on switchID");
		customLogger("Clicking on switchID", "");
		lookUpPage.enterLookupUserIDAndclickFind(advisorAPLID, "Lookup User",
				"Entering Lookup User ID and Clicking Find Button");		
		lookUpPage.clickSSOUser(role, "Switch to user ", "Clicking on SSO User ID");
	//	lookUpPage.ChooseAdvisorRole();	
		accountWizardPage = homePage.clickAccountWizardTab();
		customLogger("user login to ewm and impersonate to the agent fetched from baw ", advisorAPLID);
		emptyLogger(" \n ");
	}

	@Given("User login to the application {string} , {int}")
	public void user_should_login_to_the_application(String sheetName, Integer rowNo)
			throws InvalidFormatException, IOException, SQLException {
		emptyLogger(" \n ");	
		clientData = (HashMap<String, String>) getIndividualRowDataFromSheet(sheetName, rowNo);
		if(clientData.get(Constants.USER_NAME) != null) 			
			redirect(clientData.get(Constants.USER_NAME));		
		homePage = loginToApplicationAssetMark(clientData.get(Constants.USER_NAME), clientData.get(Constants.USER_PASSWORD));
		accountWizardPage = homePage.clickAccountWizardTab();
		emptyLogger(" \n ");
	}
	
	@Given("User login to the application")
	public void user_should_login_to_the_application()
			throws InvalidFormatException, IOException {
		emptyLogger(" \n ");			
		homePage = loginToApplicationAssetMark();		
		emptyLogger(" \n ");
	}

	@When("User is on the account wizard tab and search the client")
	public void user_is_on_the_accountlist_tab_and_search_with_account_no() {
		emptyLogger(" \n ");
		String clientName = clientData.get(Constants.CLIENT_NAME);
		accountWizardPage.findClient(clientName, "Enter client name in Search box field");
		accountWizardPage.clickClient(clientName, "search client name: ", "click on searched client name");
		customLogger("Search the client: ", clientName);
		emptyLogger(" \n ");
	}

	@Given("^User should login to BAW application and click on the dashboard \"(.*)\"$")
	public void user_should_login_to_baw_application_and_click_dashboard(String directviaeWM) {
		emptyLogger(" \n ");
		bawHomePage = loginToApplicationBusinessAutomationWorkflow(directviaeWM);
		bawDashboardPage = bawHomePage.moveToDashboard();
		emptyLogger(" \n ");
	}
	
	@Given("Launcing bancorp application")
	public void launcing_bancorp_application() {
		emptyLogger(" \n ");
		openBancorpApplication();		
		emptyLogger(" \n ");
	}
	
	@Then("Validate file in bancorp")
	public void validate_file_in_bancorp() {
		emptyLogger(" \n ");
		validateFilesInBancorp();
		emptyLogger(" \n ");
	}

	@When("User clicks on dashboard tab")
	public void user_click_on_dashboard_tab() {
		emptyLogger(" \n ");
		seleniumCore.getDriver().switchTo().defaultContent();
		bawHomePage.moveToDashboard();
		emptyLogger(" \n ");
	}
	
	@Given("User should login to OWB application and go to homepage")
	public void user_should_login_to_OWB_application_and_go_to_homepage() {
		emptyLogger(" \n ");
		loginOWBApplication();		
		emptyLogger(" \n ");
	}

	@Then("Establish DB connection and execute query to fetch data")
	public void establish_db_connection_and_execute_query_to_verify_approval_status() {
		emptyLogger(" \n ");
		String query = clientData.get(Constants.QUERY_KEY);
		String column = clientData.get(Constants.COLUMN_NAME);
		setupDBConnection("ewm");	
		if (bNumber == null) {
			bNumber = dataBaseValueVerification(query, column);
		} else {
			transferFirmName = dataBaseValueVerification(query + "'" + bNumber + "'", column);
		}
		emptyLogger(" \n ");
	}
	
	@Then("Establish BPM DB connection and execute the query and fetch column {string} data")
	public void establish_bpm_db_connection_and_execute_query_to_verify_approval_status(String column) {
		emptyLogger(" \n ");	
		String query="";
		setupDBConnection("bpm");		
		switch(column){
			case "BNUMBER":
				    query = ""
						+ "select * from BPM_PS_Archive.dbo.WD_Master_BKP where STATUS_ID=2 and app_id = 'shell'";
				bNumber = dataBaseValueVerification(query, column);	
				break;
			case "taxManagementId":
			    query = ""
			    		+ "select TaxManagementID, * From [TrackingCenter].dbo.[Envelope] EI "
			    		+ "join TrackingCenter..Item i on EI.ItemID = i.ItemID "
			    		+ "where ExternalID = '"+ dTrackingId +"'";
			    taxManagementId = dataBaseValueVerification(query, column);	
			break;	
			default:
				logger.info("user has too run the query");
		}		
		emptyLogger(" \n ");
	}
	
	@Then("Establish EWM DB connection and execute the query and fetch column {string} data")
	public void establish_ewm_db_connection_and_execute_query_to_verify_approval_status(String column) {
		emptyLogger(" \n ");	
		String query="";
		setupDBConnection("ewm");		
		switch(column){			
			case "AccountNo":
					query = ""
							+ "select top 1 a.APLID, a.AccountNo, pl.JournalModelType, c.FamilyName, a.Custodian "
							+ "from [AM_Billing].[dbo].[Account] a "
							+ "join [AM_Billing].[dbo].[tblClient] as c on c.FamilyID = a.FamilyID "
							+ "join [AM_Billing].[dbo].[tblAgents] ag on ag.RecID = c.AgentRecID "
							+ "join am.dbo.users u on u.UserID= ag.APLID "
							+ "LEFT JOIN Platform.dbo.GetAgreements() CSA on C.AgreementID = CSA.ID "
							+ "inner join [CRM].[dbo].[Agent] crma on ag.APLID=crma.APLID "
							+ "join platform.dbo.Model pl on a.ModelName = pl.aplid and a.custodian=pl.custodian_id "
							+ "inner join [AM_Billing].[dbo].[V_MarketValue] MV on mv.userid=a.APLID "
							+ "where a.TerminationDate is null "
							+ "and a.AccountNo is not null "
							+ "and pl.isActive=1 "
							+ "and u.paperworkapproval=2 "
							+ "and a.custodian in ('GNW') "
							+ "and ag.APLID in ('ag5848')";
					
				 	advisorAPLID = dataBaseValueVerification(query, column);	
				break;
			case "APLID":
				query = ""					
								+ "SELECT top 1 a.RepID,a.FamilyID,a.AccountNo,a.APLID,rtl.[Description] as \"Reg Type Name\",m.IsThirdPartyIMA,m.SettlementDays, "
								+ "m.AllowSameDay,m.program_id,a.accounttype,av.value,m.IsGeneralSecurities,crm.[Channel] as \"Agent Channel\", "
								+ "ag.[APLID] as \"Agent APLID\",a.[FamilyID] as \"Client APLID\",c.[FamilyName] as \"Client Name\",a.[APLID] as \"Account APLID\", "
								+ "a.[AccountNo] as \"Account Number\", "
								+ "RTRIM(LTRIM(ISNULL(a.[AccountName1],'') + ' ' + ISNULL(a.[AccountName2],''))) as \"Account Name\", "
								+ "CONVERT(DATE, a.[Date]) as \"Open Date\", "
								+ "a.[FAAuthorization] as \"FAA\", "
								+ "a.[Custodian], "
								+ "rtl.[Description] as \"Reg Type Name\", "
								+ "a.[ModelName] as \"Model APLID\", "
								+ "m.[Program_ID] as \"Program ID\", "
								+ "a.*, "
								+ "cad.* "
								+ "FROM [AM_Billing].[dbo].[Account] a WITH(NOLOCK) "
								+ "LEFT OUTER JOIN [ADS].[dbo].[Account] adsa WITH(NOLOCK) ON a.[WebID] = adsa.[Account_ID] "
								+ "LEFT OUTER JOIN [AM_Billing].[dbo].[tblFundingAccounts] f WITH(NOLOCK) ON a.[FunAccNum] = f.[ID] "
								+ "LEFT OUTER JOIN [AM_Billing].[dbo].[tblClient] c WITH(NOLOCK) ON a.[FamilyID] = c.[FamilyID] "
								+ "left outer join ads.dbo.client_address cad on cad.client_id = a.familyid "
								+ "LEFT OUTER JOIN [AM_Billing].[dbo].[tblAgents] ag WITH(NOLOCK) ON c.[AgentRecID] = ag.[RecID] "
								+ "LEFT OUTER JOIN [crm].[dbo].[agent] crm WITH(NOLOCK) ON ag.[aplid] = crm.[aplid] "
								+ "LEFT OUTER JOIN [AM_Billing].[dbo].[tblAdvisors] ad WITH(NOLOCK) ON ag.[advisorRecID] = ad.[RecID] "
								+ "LEFT OUTER JOIN [AM_Billing].[dbo].[tblBDs] bd WITH(NOLOCK) ON ad.[BDRecID] = bd.[RecID] "
								+ "LEFT OUTER JOIN [Platform].[dbo].[Model] m WITH(NOLOCK) ON a.[ModelName] = m.[APLID] and a.[Custodian] = m.[Custodian_ID] "
								+ "LEFT OUTER JOIN [Platform].[dbo].[Agreement] r WITH(NOLOCK) ON c.[AgreementID] = r.[ID] "
								+ "LEFT OUTER JOIN [AM_Billing].[dbo].[V_MarketValue] av WITH(NOLOCK) ON a.[APLID] = av.[userid] "
								+ "LEFT OUTER JOIN [AM_Billing].[dbo].[V_MarketValue] ac WITH(NOLOCK) ON a.[FamilyID] = ac.[userid] "
								+ "LEFT OUTER JOIN (SELECT cv.* FROM [ADS].[dbo].[CodeValue] cv with(nolock) where cv.[Code_ID] = 180) rtl on a.[AccountType] = rtl.[CodeValInt] "
								+ "left outer join am.dbo.users u on crm.aplid = u.userid "
								+ "WHERE "
								+ "a.[TerminationDate] IS NULL "
								+ "ORDER BY [Agent APLID]";	
				
			 	advisorAPLID = dataBaseValueVerification(query, column);	
			break;	
			default:
				logger.info("user has too run the query");
		}		
		emptyLogger(" \n ");
	}

	@Then("Establish connection with azure db and execute query to fetch data")
	public void establish_connection_with_azure_db_and_execute_query_to_verify_approval_status() {
		emptyLogger(" \n ");		
		String hostName = clientData.get(Constants.HOST_NAME);
		String DbUserName = clientData.get(Constants.DB_USER_NAME);
		String DbPassword = clientData.get(Constants.DB_PASSWORD);
		String DbName = clientData.get(Constants.database_Name);
		
		setUpAzureDBConnection(hostName, DbUserName, DbPassword,DbName);		
		emptyLogger(" \n ");
	}
	
	@Then("Validate external id status as {string}")
	public void validateTransferstatus(String status) {
		emptyLogger(" \n ");
		String query = clientData.get(Constants.QUERY_KEY);
		String column = clientData.get(Constants.COLUMN_NAME);
		transferFirmName = dataBaseValueVerification(query + "'" + bNumber + "'", column);
		validateTransferStatus(status);
		emptyLogger(" \n ");
	}
	
	@Then("User fetch account transfer id from transfer db")
	public void fetchConfirmationNumber() {
		emptyLogger(" \n ");
		String query = clientData.get(Constants.QUERY_KEY);
		String column = clientData.get(Constants.COLUMN_NAME);
		accountTransferId = dataBaseValueVerification(query + "'" + transferTrackingNumber + "'", column);		
		emptyLogger(" \n ");
	}

	@When("Baw qc user login using username {string} and password {string}")
	public void baw_qc_user_login_using_username_and_password(String userName, String password) {
		emptyLogger(" \n ");
		loginByBawQcUser(userName, password);
		bawDashboardPage = bawHomePage.moveToDashboard();
		emptyLogger(" \n ");
	}

	@When("User closes windows except current window")
	public void user_close_the_current_window() {
		emptyLogger(" \n ");		
		String currentWindowHandle = driver.getWindowHandle();		
		Set<String> windowHandles = driver.getWindowHandles();		
		for (String window : windowHandles) {	 
		    driver.switchTo().window(window);				
		    if (!window.equals(currentWindowHandle)) {		        
		        driver.close();
		    }
		}	
		driver.switchTo().window(currentWindowHandle);
		emptyLogger(" \n ");
	}
	
	@When("User should click on clients tab and navigate to account list page")
	public void navigateToAccountListPage() {
		emptyLogger(" \n ");
		homePage.clickClientsTab();
		accountListPage  = homePage.clickAccountListTab();
		emptyLogger(" \n ");
	}
	
	@Given("Establish DB connection and execute the query to check citrix job status")
	public void establish_db_connection_and_execute_query_to_check_citrix_job_status() throws SQLException {
		emptyLogger(" \n ");		
		if(configReader.get_Application_URL().contains("https://test")) {	
			setupDBConnection("ewm");			
			String query=  "UPDATE [AM_Billing].[dbo].[tblScanHours] \r\n"
					+ "SET ScanStartDT = CONVERT(datetime, CONVERT(VARCHAR(10), GETDATE(), 23)+' 00:01:00.000', 121), ScanEndDT = CONVERT(datetime, CONVERT(VARCHAR(10), GETDATE(), 23)+' 23:59:00.000', 121),  \r\n"
					+ "ScanCutoffDT = CONVERT(datetime, '2022-08-10 09:10:00.000', 121), ModifiedDT = GETDATE(), ModifiedBy = 'QAUser'\r\n"
					+ "";
			
		dataBaseUpdateValue(query);	
		}
		emptyLogger(" \n ");
	}
	
	
	public void redirect(String userName) throws SQLException {
		emptyLogger(" \n ");		
		if(configReader.get_Application_URL().contains("https://test")) {	
			setupDBConnection("ewm");			
			String varname1= "";			
			 varname1 = ""
					+ "UPDATE t1 "
					+ "SET t1.Value = 'D20' "
					+ "FROM [AM].[dbo].[user_preference] AS t1 "		
					+ "JOIN [AM].[dbo].[User_SSODetails] AS t2 ON t1.SSOGUIDID = t2.SSOGUIDID "
					+ "where t2.UserID = '"+userName+"' and  t1.[key] = 'dashboard30HomeButtonDefaultValue' ";	
			
		dataBaseUpdateValue(varname1);	
		}
		emptyLogger(" \n ");
	}
	
	@Given("User update residual distribution audit table in azure db")
	public void updateResidualDistibutions() throws SQLException {
		emptyLogger(" \n ");				
		String accountNumber = clientData.get(Constants.ACCOUNT_NUMBER);
		if(configReader.get_Application_URL().contains("https://test")) {					
			String varname1= "";			
				 varname1 = ""
						+ "UPDATE a "
						+ "set status = '1' "
						+ "from [dbo].[ResidualDistributionAudit] a "						
						+ "where AccountNumber = '"+accountNumber+"' and  status not in ('1')";			
		dataBaseUpdateValue(varname1);	
		}
		emptyLogger(" \n ");
	}
	
	@Given("User update residual distribution table in azure db")
	public void updateResidualDistibutionsTable() throws SQLException {
		emptyLogger(" \n ");				
		String accountNumber = clientData.get(Constants.ACCOUNT_NUMBER);
		if(configReader.get_Application_URL().contains("https://test")) {					
			String varname1 = ""
					+ "UPDATE A SET A.Status = 5, A.IsCurrent = 0, A.AuditEnd = GETDATE() "
					+ "OUTPUT INSERTED.[ResidualDistribution_ID], 'BAW.TestUser2', GETDATE(), GETDATE(), 0, 'D', 5, "
					+ "INSERTED.CreatedBy, INSERTED.CreatedDateTime, INSERTED.ExternalId, INSERTED.Custodian, INSERTED.AccountNumber, "
					+ "INSERTED.DeliveryMethodType, INSERTED.Memo, INSERTED.DistributionCodeId, INSERTED.InstructionNumber, INSERTED.DistributionScheduledBy "
					+ ", INSERTED.DistributionScheduledDateTime, INSERTED.DistributionInitiatedBy, INSERTED.DistributionInitiatedDateTime "
					+ ", INSERTED.DistributionInitiatedToCustodianBy, INSERTED.DistributionInitiatedToCustodianDateTime "
					+ "INTO dbo.ResidualDistributionAudit ( "
					+ "[ResidualDistribution_ID], [AuditUser], [AuditStart], [AuditEnd], [IsCurrent], [Operation], [Status] "
					+ " , CreatedBy, CreatedDateTime, ExternalId, Custodian, AccountNumber, DeliveryMethodType, Memo, DistributionCodeId "
					+ ", InstructionNumber, DistributionScheduledBy, DistributionScheduledDateTime, DistributionInitiatedBy "
					+ ", DistributionInitiatedDateTime, DistributionInitiatedToCustodianBy, DistributionInitiatedToCustodianDateTime) "
					+ "FROM dbo.ResidualDistributionAudit A "						
					+ "where A.AccountNumber = '"+accountNumber+"' and  A.IsCurrent = 1";			
		dataBaseUpdateValue(varname1);	
		}
		emptyLogger(" \n ");
	}
	
	@Then("Establish DB connection and update {string} in citrix")
	public void establish_db_connection_and_update_request_in_citrix(String option) throws SQLException {
		emptyLogger(" \n ");		
		String accountNumber = clientData.get(Constants.ACCOUNT_NUMBER);
		String model = clientData.get(Constants.MODEL_NAME);
		setupDBConnection("ewm");		
		String varname1= "";
		switch(option){
		case "request status":
			 varname1 = ""
					+ "UPDATE M set M.status=4 "
					+ "from [AM_Billing].[dbo].[tblModelChanges] as M "
					+ "join [AM_Billing].[dbo].[Account] as A "
					+ "ON M.ClientID = A.Id "
					+ "where AccountNo = '"+accountNumber+"'   and  status not in ('4')";			
			 break;
		case "completionDate":
			 varname1 = ""
					+ "UPDATE M set M.CompleteDate = '2024-03-04 02:02:00' "
					+ "from [AM_Billing].[dbo].[tblModelChanges] as M "
					+ "join [AM_Billing].[dbo].[Account] as A "
					+ "ON M.ClientID = A.Id "
					+ "where AccountNo = '"+accountNumber+"'   and  CompleteDate is null";			
			 break;	 
		case "model change":
			 varname1 = ""
					+ "UPDATE A set A.ModelName= '"+model+"' "
					+ "  FROM [AM_Billing].[dbo].[Account] as A "					
					+ "  where AccountNo= '"+accountNumber+"'";				 
			 break;	 
		case "tms id":
			 varname1 = ""
					+ "UPDATE A set A.TaxManagementID = NULL "
					+ "  FROM [AM_Billing].[dbo].[Account] as A "					
					+ "  where AccountNo = '"+accountNumber+"'";				 
			 break;	 
		}				
		dataBaseUpdateValue(varname1);		
		emptyLogger(" \n ");
	}	
	
	@Then("Establish bpm db connection and update {string} in citrix")
	public void establish_bpm_db_connection_and_update_request_in_citrix(String option) throws SQLException {
		emptyLogger(" \n ");		
		String accountNumber = clientData.get(Constants.ACCOUNT_NUMBER);
		setupDBConnection("bpm");		
		String varname1= "";
		switch(option){
		case "request status":
			 varname1 = ""
					+ "UPDATE M set M.status=4 "
					+ "from [AM_Billing].[dbo].[tblModelChanges] as M "
					+ "join [AM_Billing].[dbo].[Account] as A "
					+ "ON M.ClientID = A.Id "
					+ "where AccountNo = '"+accountNumber+"'   and  status not in ('4')";			
			 break;
		default:
			logger.info("request does not find");		}				
		dataBaseUpdateValue(varname1);		
		emptyLogger(" \n ");
	}
	
	@Then("Establish DB connection and update {string} to {int}")
	public void establish_db_connection_and_update_the_parameter(String option, int value) throws SQLException {
		emptyLogger(" \n ");		
		String userName = clientData.get(Constants.CLIENT_NAME);		
		setupDBConnection("ewm");			
		String varname1= "";
		switch(option){
		case "osj account approval":
				varname1 = ""
					+ "update crm..agent "
					+ "set allowosjaccountapproval = "+value+" "
					+ "where aplid = '"+userName+"'";
				break;
		default:
			logger.info("parameter has been approved");
			break;
		}				
		dataBaseUpdateValue(varname1);		
		emptyLogger(" \n ");
	}
	
	@Then("Establish EWM DB connection and execute the query")
	public void establish_ewm_db_connection_and_execute_query_to_verify_approval_status() {
		emptyLogger(" \n ");			
		setupDBConnection("ewm");		
				String    query = ""
						+ "SELECT top 2 c.[FamilyName] as \"Client Name\",a.[APLID] as \"Account APLID\",a.[AccountNo] as \"Account Number\" \r\n"					
						+ "FROM [AM_Billing].[dbo].[Account] a WITH(NOLOCK)\r\n"
						+ "LEFT OUTER JOIN [ADS].[dbo].[Account] adsa WITH(NOLOCK) ON a.[WebID] = adsa.[Account_ID]\r\n"
						+ "LEFT OUTER JOIN [AM_Billing].[dbo].[tblFundingAccounts] f WITH(NOLOCK) ON a.[FunAccNum] = f.[ID]\r\n"
						+ "LEFT OUTER JOIN [AM_Billing].[dbo].[tblClient] c WITH(NOLOCK) ON a.[FamilyID] = c.[FamilyID]\r\n"
						+ "left outer join ads.dbo.client_address cad on c.familyid = cad.client_id\r\n"
						+ "LEFT OUTER JOIN [AM_Billing].[dbo].[tblAgents] ag WITH(NOLOCK) ON c.[AgentRecID] = ag.[RecID]\r\n"
						+ "LEFT OUTER JOIN [crm].[dbo].[agent] crm WITH(NOLOCK) ON ag.[aplid] = crm.[aplid]\r\n"
						+ "LEFT OUTER JOIN [AM_Billing].[dbo].[tblAdvisors] ad WITH(NOLOCK) ON ag.[advisorRecID] = ad.[RecID]\r\n"
						+ "LEFT OUTER JOIN [AM_Billing].[dbo].[tblBDs] bd WITH(NOLOCK) ON ad.[BDRecID] = bd.[RecID]\r\n"
						+ "LEFT OUTER JOIN [Platform].[dbo].[Model] m WITH(NOLOCK) ON a.[ModelName] = m.[APLID] and a.[Custodian] = m.[Custodian_ID]\r\n"
						+ "LEFT OUTER JOIN [Platform].[dbo].[Agreement] r WITH(NOLOCK) ON c.[AgreementID] = r.[ID]\r\n"
						+ "LEFT OUTER JOIN [AM_Billing].[dbo].[V_MarketValue] av WITH(NOLOCK) ON a.[APLID] = av.[userid]\r\n"
						+ "LEFT OUTER JOIN [AM_Billing].[dbo].[V_MarketValue] ac WITH(NOLOCK) ON a.[FamilyID] = ac.[userid]\r\n"
						+ "LEFT OUTER JOIN (SELECT cv.* FROM [ADS].[dbo].[CodeValue] cv with(nolock) where cv.[Code_ID] = 180) rtl on a.[AccountType] = rtl.[CodeValInt]\r\n"
						+ "left outer join am.dbo.users u on crm.aplid = u.userid\r\n"
						+ "where a.TerminationDate is null\r\n"
						+ "and a.Custodian = 'gnw'  \r\n"
						+ "";
		 values =	fetchDBValueVerification(query);		
		emptyLogger(" \n ");
	}
	
	@When("User wait for {int} min")
	public void user_wait_for_a_min(int min) {		
		int waitTime= min * 60000;
		seleniumCore.waitForUILoading(waitTime);
	}
	
	@Then("User verify {string} file is downloaded and {string} content is present")
	public void verifyPDFIsDisplayed(String pdfName, String text) {
		emptyLogger(" \n ");
		validatePdfContent(pdfName, text);
		emptyLogger(" \n ");
	}
	
	@Then("User should delete PDF displayed as {string}")
	public void deleteDownloadedPDF(String pdfName) throws Exception {
		emptyLogger(" \n ");
		deletePDFFile(pdfName);
		emptyLogger(" \n ");
	}
}
