package com.amk.cucumber.constants;

public class Constants {
	
	public static final String BLANK = "";

	public static final String USER_NAME = "UserName";
	public static final String USER_PASSWORD = "Password";
	public static final String CLIENT_NAME = "ClientName";
	public static final String ACCOUNT_NUMBER = "AccountNumber";
	public static final String ACCOUNT_NUMBER2 = "AccountNumber2";
	public static final String ACCOUNT_NUMBER3 = "AccountNumber3";
	public static final String ACCOUNT_NUMBER4 = "AccountNumber4";
	public static final String REQUEST_KEY = "Request";
	public static final String TYPE_KEY = "Type";
	public static final String DELIVERY_DATA = "DeliveryData";
	public static final String PDF_FILE_PATH = "pdfFilePath";
	public static final String TIF_FILE_PATH = "tifFilePath";
	public static final String INDIVIDUAL_User = "IndiUser";
	public static final String INVESTMENT_NAME = "InvestmentName";
	public static final String INVESTMENT_SOLUTION_NAME1 = "InvestmentSolutionName1";
	public static final String AMOUNT_KEY = "Amount";
	public static final String INVESTMENT_SOLUTION_NAME2 = "InvestmentSolutionName2";
	public static final String SUITABILITY_CLIENT_RISK_TOLERANCE = "suitabilityClientRiskTolerance";
	public static final String SUITABILITY_CLIENT_ISVESTMENT_HORIZON = "suitabilityClientInvestmentHorizon";
	public static final String SUITABILITY_CLIENT_NET_WORTH = "suitabilityClientNetWorth";
	public static final String TRANSFER_REQUEST = "TransferRequest";	
	public static final String QUERY_KEY = "Query";
	public static final String COLUMN_NAME = "columnName";
	public static final String HOST_NAME = "hostName";
	public static final String DB_USER_NAME = "DBusername";
	public static final String DB_PASSWORD = "Dbpassword";
	public static final String database_Name = "dbName";
	public static final String Program_ID = "ProgramID";
	public static final String Withdrawal_Method = "WithdrawalMethod";
	public static final String Delivery_Method = "DeliveryMethod";
	public static final String CLIENT_TYPE = "ClientType";
	public static final String FIDUCIARY_ROLE = "FiduciaryRole";
	public static final String RISK_TOLERANCE = "RiskTolerance";
	public static final String INVESTMENT_HORIZON = "InvestmentHorizon";
	public static final String TOTAL_NET_WORTH = "TotalNetworth";	
	public static final String RISK_RETURN_PROFILE = "RiskReturnProfile";
	public static final String REGISTRATION_TYPE = "RegistrationType";
	public static final String CUSTODIAN_KEY = "Custodian";	
	public static final String CLIENT_ACCOUNT_TYPE = "ClientAccountType";
	public static final String INVESTMENT_SOLUTION = "InvestmentSolution";
	public static final String CLIENT_FEE = "ClientFee";
	public static final String ACCOUNTHOLDER_FIRST_NAME = "AccountHolderLastName";
	public static final String ACCOUNTHOLDER_MIDDLE_NAME = "AccountHolderMiddleName";
	public static final String ACCOUNTHOLDER_LAST_NAME = "AccountHolderLastName";
	public static final String ACCOUNTHOLDER_BIRTH_DATE = "AccountHolderBirthDate";
	public static final String ACCOUNTHOLDER_SSN = "AccountHolderSSN";
	public static final String ACCOUNTHOLDER_NAME = "AccountHolderName";
	public static final String ACCOUNTHOLDER_PHONE = "AccountHolderPhone";
	public static final String ACCOUNTHOLDER_EMAIL = "AccountHolderEmail";
	public static final String ACCOUNTHOLDER_ADDRESSLINE1 = "AccountHolderAddressLine1";
	public static final String ACCOUNTHOLDER_CITY = "AccountHolderCity";
	public static final String ACCOUNTHOLDER_STATE = "AccountHolderState";
	public static final String ACCOUNTHOLDER_ZIP = "AccountHolderZip";
	public static final String ACCOUNT_NAME_KEY = "AccountName";
	public static final String FUNDING_METHOD = "FundingMethod";		
	public static final String EXISTING_BANK_ACCOUNT = "ExistingBankAccount";
	public static final String MODEL_NAME = "Model";
	
	//endpoint
	public static final String deleteResidual = "https://test.api.assetmark.com/Custodialaccountservicing/PeriodicAccountWithdrawals/DeletePeriodicWithdrawalInstructions";
	public static final String CreateJournalEntry = "https://test.api.assetmark.com/CustodialAccountServicing/MoneyMovement/CreateJournalEntry";
	public static final String CreateShareEntry = "https://test.api.assetmark.com/Custodialaccountservicing/SecurityMovement/CreateShareEntry";
	public static final String CloseAccountTransferRequest = "https://test.api.assetmark.com/Custodialaccountservicing/AccountTransfers/CloseAccountTransferRequest";
	public static final String GetAccountTransferRequests = "https://test.api.assetmark.com/Custodialaccountservicing/AccountTransfers/GetAccountTransferRequests";
	public static final String GetPeriodicWithdrawalInstructionsByAccount = "https://test.api.assetmark.com/Custodialaccountservicing/PeriodicAccountWithdrawals/GetPeriodicWithdrawalInstructionsByAccount";
	public static final String GetAccountDetail = "https://test.api.assetmark.com/Custodialaccountservicing/Accounts/GetAccountDetail";
	public static final String openAccount = "https://test.api.assetmark.com/Custodialaccountservicing/Accounts/UpdateAccount";
}
