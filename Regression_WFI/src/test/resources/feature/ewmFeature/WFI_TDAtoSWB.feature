@Regression    @TDAtoSWB
Feature: WFI Regression- TDA to SWB  	
		
		
#@C196238
#Scenario Outline: C196238_[eWM] NAW - Schwab - Account Features
#Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
#When User should click on clients tab and navigate to account list page
#And User is on the accountlist tab and search with the accountNo
#And User should click on searched account and navigate to account wizard page
#When User is on Account Wizard tab and click on go button for New Client creation
#And User navigates to client profile page and enter required information
#Then User clicks on next button on client profile page
#When User navigates to Construct portfolio page and enter required information
#Then User clicks on next button on construct portfolio page
#When User navigates to fee page and enter require data
#Then User navigates to portfolio details page and click on Account setup button
#When User navigates to account holder tab and enter require information
#Then User clicks on account information button
#When User navigate to Account information tab and click on tax management services button
#Then User navigate to Account features tab and click on funding method button
#When User navigates to funding tab and enter funding method
#Then User click on online access document delivery button
#Then User navigates to review all accounts tab and click on create documents button
#Then User click on create documents button
#When User clicks on Separate Documents and select Accounts Establishment option
#
#Examples: 
#		|SheetName    |RowNumber|
#		|TDAtoSWB      |2        |
		

@C196239
Scenario Outline: C196239_[BAW] Withdrawal - TDA - Shell coach - Submit To Custodian/Bank
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button
When Select work item type "Withdrawal Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
And Fetch b number from shell process page
And Click on add document, upload "pdfFilePath" document and validate
When Switch to respective tab with title "Shell Process"
#Then Validate "first" uploaded document
Then Check doc visibility and click on submit to bank button
 

Examples: 
		|SheetName    |RowNumber|
		|TDAtoSWB      |3        |	

		
@C69188
Scenario Outline: C69188_[eWM] OAM - Schwab (Custodian Code = TDA) Transfer Activity Kits
Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
When User should click on clients tab and navigate to account list page
And User is on the accountlist tab and search with the accountNo
And User should click on searched account and navigate to account wizard page
And Select request and type in Account Management
When User clicks on complete and print button		
Then User navigates to docu sign page and clicks on Continue & Finish button
And Fetch the tracking id and click on close button
Then Validate description text as "Account Transfer Authorization"
When User clicks on view button
Then Validate view documents popup
#And Validate uploaded document "Account Transfer Authorization" on view documents popup
When User should delete PDF displayed as "eSigPDFDownload"
And User download pdf document
Then User verify "eSigPDFDownload" file is downloaded and "Transfer Your Account to Schwab" content is present
When User should delete PDF displayed as "eSigPDFDownload"

Examples: 
		|SheetName    |RowNumber|
		|TDAtoSWB      |4        |	


@C196266
Scenario Outline: C196266_[eWM] ICT - No Partial for New Destination Investment - Only Retain New Account
#Given User login to the application "<SheetName>" , <RowNumber>
Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
When User should click on clients tab and navigate to account list page
And User is on the accountlist tab and search with the accountNo
And User should click on searched account and navigate to account wizard page
And Click on client management option "Change Investments"
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix
Then Establish DB connection and update "model change" in citrix
And Click on account number and navigate to investment selection tab
Then Validate Account Number On Destination Investment Tab
When Select new investment on destination investment tab
Then Validate New Investment Modal
When Search and Select Investment Solution on destination investment tab 1
Then User validate partial label visibility
When Select "100 percentage" amount in destination investment tab
When Click on next button
Then User validate new account number option visibility
Then Validate the "Account Number" tab
And Validate "suitability" tab and navigate to account features tab
Then Validate the "Account Features" tab
Then Validate the "Fees" tab
Then Validate the "Summary" tab
When User clicks on complete and print button
Then User navigates to docu sign page and clicks on Continue & Finish button
And Fetch the tracking id and click on close button
And User upload the PDF file
Then User verify the tracking Id starts with B

Examples: 
		|SheetName    |RowNumber|
		|TDAtoSWB      |5        |	


@C208360
Scenario Outline: C208360_[WFI Duplicate Accts] - Create/Edit OA Updates - Shell coach - Managed Account - TDA terminated
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button
When Select work item type "Account Maintenance"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
When Select account from select account popup
And Select individual owner and click run now
When Update internal status "In Process"
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix
And click on Update OA button
And User manage to select account results "error" msg
Then "Cancel" added journal
And Select action type "Cancel" 
And enter action value "submit"                
Then Validate added OA details on create OA page "submit"

Examples: 
		|SheetName    |RowNumber|
		|TDAtoSWB        |6       |	


@C208361
Scenario Outline: C208361_[WFI Duplicate Accts] - Create/Edit OA Updates - Shell coach - Managed Account - GNW
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button
When Select work item type "Account Maintenance"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
When Select account from select account popup
And Select individual owner and click run now
When Update internal status "In Process"
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix
And click on Update OA button
And User manage to select account results "no error" msg
Then "Cancel" added journal
And Select action type "Cancel" 
And enter action value "submit"                
Then Validate added OA details on create OA page "submit"

Examples: 
		|SheetName    |RowNumber|
		|TDAtoSWB        |7       |	

