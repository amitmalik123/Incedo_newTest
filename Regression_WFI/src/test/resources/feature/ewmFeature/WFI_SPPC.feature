@Regression    @SPPC
Feature: WFI Regression- SPPC

Background:
Given Establish DB connection and execute the query to check citrix job status		
		
@C124136
Scenario Outline: C124136_BAW_Create a new client with Savos account_Activate Account_Savos form Included
Given User login to the application "<SheetName>" , <RowNumber>
When User is on Account Wizard tab and click on go button for New Client creation
And User navigates to client profile page and enter required information
Then User clicks on next button on client profile page
When User navigates to Construct portfolio page and enter required information
Then User selects savos investment and click next button on construct portfolio page
When User navigates to fee page and enter require data
Then User navigates to portfolio details page and click on Account setup button
When User navigates to account holder tab and enter require information
Then User clicks on account information button
When User navigate to Account information tab and click on account feature button
Then User navigate to Account features tab and click on funding method button
When User navigates to funding tab and enter funding method
Then User click on online access document delivery button
When User navigates to online access document delivery tab and click on review all accounts button
Then User navigates to review all accounts tab and click on create documents button
Then User click on create documents button
When User clicks on Separate Documents and select Accounts Establishment option
Given User should login to BAW application and click on the dashboard "viaeWM"
When Click on Open New WorkIteam button
When Select work item type "New Account Application"
Then Select custodian type "GNW"
And Select individual owner and click run now
When Fetch b number from shell process page
When User enter hrc number and click on submit
And Click on "Search Work Item" tab
And Enter external id and click on search button
And Fetch parent b number
And Click on "Dashboard" tab
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "NAA Coach" page
When User select CIP value "Not Required/Duplicate" and save client
And User clicks on "New Account Application" b number open button
#When Switch to respective tab with title "Shell Process"
And Click on "select" button under account number association
Then Validate added account number and account name
And Click on save exit button
When Switch to respective tab with title "NAA Coach"
Then User validate "P" letter display under acc and beta
When User does the activate account
Then User validate "A" letter display under acc and beta
And User expand registration section
Then Validate model in investment section is non editable

Examples: 
		|SheetName    |RowNumber|
		|SPPC	        |2        |
	

@C124137
Scenario Outline: C124137_NAW_Create ICT with Savos as a destination account_Savos form NOT Included
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Click on client management option "Change Investments"
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix
Then Establish DB connection and update "model change" in citrix
And Click on account number and navigate to investment selection tab
Then Validate Account Number On Destination Investment Tab
When Select new investment on destination investment tab
Then Validate New Investment Modal
When Search and Select Investment Solution on destination investment tab 1
When Select "100 percentage" amount in destination investment tab
When Click on next button
And User enter savos investment information "excluded" transition on investment change page
When Click on next button
Then Validate the "Account Number" tab
And Validate "suitability" tab and navigate to account features tab
Then Validate the "Account Features" tab
Then Validate the "Fees" tab
Then Validate the "Summary" tab
When User clicks on complete and print button
Then User navigates to docu sign page and clicks on Continue & Finish button
And Fetch the tracking id and click on close button
And User upload the PDF file
And User verify the tracking Id starts with B
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Shell Process" page
Then Validate "ICT Activation" alert

Examples: 
		|SheetName    |RowNumber|
		|SPPC         |3        |
		
		
@C124138
Scenario Outline: C124138_NAW_Create ICT with Savos as a destination account_Savos form Included
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Click on client management option "Change Investments"
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix
Then Establish DB connection and update "model change" in citrix
And Click on account number and navigate to investment selection tab
Then Validate Account Number On Destination Investment Tab
When Select new investment on destination investment tab
Then Validate New Investment Modal
When Search and Select Investment Solution on destination investment tab 1
When Select "100 percentage" amount in destination investment tab
When Click on next button
And User enter savos investment information "included" transition on investment change page
When Click on next button
Then Validate the "Account Number" tab
And Validate "suitability" tab and navigate to account features tab
Then Validate the "Account Features" tab
Then Validate the "Fees" tab
Then Validate the "Summary" tab
When User clicks on complete and print button
Then User navigates to docu sign page and clicks on Continue & Finish button
And Fetch the tracking id and click on close button
And User upload the PDF file
And User verify the tracking Id starts with B
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Shell Process" page
Then Validate "ICT Activation" alert

Examples: 
		|SheetName    |RowNumber|
		|SPPC         |3        |
		