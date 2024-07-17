@Regression     @ENAX
Feature: WFI Regression- ENAX

@C81178
Scenario Outline: C81178_BAW_CreateNewClient_HRCSubmit_Disp_WFI
Given User login to the application "<SheetName>" , <RowNumber>
When User is on Account Wizard tab and click on go button for New Client creation
And User navigates to client profile page and enter required information
Then User clicks on next button on client profile page
When User navigates to Construct portfolio page and enter required information
Then User clicks on next button on construct portfolio page
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
Then User validates N number adopted under parent

Examples: 
		|SheetName    |RowNumber|
		|ENAX         |2        |
		
		
@C123962
Scenario Outline: C123962_BAW_ParentBundle_Accounts Association_Disp_WFI
Given User login to the application "<SheetName>" , <RowNumber>
When User is on Account Wizard tab and click on go button for New Client creation
And User navigates to client profile page and enter required information
Then User clicks on next button on client profile page
When User navigates to Construct portfolio page and enter required information
Then User clicks on next button on construct portfolio page
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
When User select CIP value "Exception Granted" and save client
And User clicks on "New Account Application" b number open button
#When Switch to respective tab with title "Shell Process"
And Click on "select" button under account number association
Then Validate added account number and account name
And Click on save exit button
When Switch to respective tab with title "NAA Coach"
Then Validate added account number and name
Then User does the activate account

Examples: 
		|SheetName    |RowNumber|
		|ENAX         |3        |
		
		
@C123593
Scenario Outline: C123593_BAW_ParentBundle_Ancora Non-GNW_Disp_WFI
Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
When User is on Account Wizard tab and click on go button for New Client creation
And User navigates to client profile page and enter required information
Then User clicks on next button on client profile page
When User navigates to Construct portfolio page and enter required information
Then User clicks on next button on construct portfolio page
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
When User navigates to view documents page and click on procees to submit button
Then User navigates to submit page and clicks on submit button
When User impersonate to an "Broker Dealer" and navigates to account approval page
Then User selects the client fullname and clicks on approval request
When User impersonate to an "Agent" and navigates to account approval page
When Navigate to tracking center page
And User search item number
Then Validate first note "Account(s) approved by Broker Dealer"

Examples: 
		|SheetName    |RowNumber|
		|ENAX         |4        |
	
	
@C81179
Scenario Outline: C81179_BAW_ParentBundle_BDRejected/Resubmit/Approve_Disp_WFI
Given User login to the application "<SheetName>" , <RowNumber>
When User is on Account Wizard tab and click on go button for New Client creation
And User navigates to client profile page and enter required information
Then User clicks on next button on client profile page
When User navigates to Construct portfolio page and enter required information
Then User clicks on next button on construct portfolio page
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
When User does the esignature with "in person" method
And User click on initial button
When User answer in person questions
And User check the checkbox and sign the document
Given User login to the application
When User impersonate to an "Broker Dealer" and navigates to account approval page
And User selects the client fullname and reject request
Then User validate reject message "Paperwork is rejected"
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
When Switch to respective tab with title "Assetmark"
When User impersonate to an "Agent" and navigates to account approval page
When Navigate to tracking center page
When User submit the request again after reject
Then User validate successful submission text "These accounts have been successfully submitted online to your BD/OSJ for approval"
When User impersonate to an "Broker Dealer" and navigates to account approval page
Then User selects the client fullname and clicks on approval request
When Switch to respective tab with title "Process Portal"
And Click on "Dashboard" tab
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "NAA Coach" page
Then User validate "status changed to approved by BD" alert message
And User clicks on "New Account Application" b number open button
#When Switch to respective tab with title "Shell Process"
And Click on "select" button under account number association
Then Validate added account number and account name
And Click on save exit button
When Switch to respective tab with title "NAA Coach"
Then User validate "P" letter display under acc
When User does the activate account
Then User validate "A" letter display under acc

Examples: 
		|SheetName    |RowNumber|
		|ENAX         |5        |
		
		
@C81177
Scenario Outline: C81177_BAW_AssetMarkTrust_DAF_AccessActivation_Disp_WFI
Given User login to the application "<SheetName>" , <RowNumber>
When User is on Account Wizard tab and click on go button for New Client creation
And User navigates to client profile page and enter required information
Then User clicks on next button on client profile page
When User navigates to Construct portfolio page and enter required information
Then User clicks on next button on construct portfolio page
When User navigates to fee page and enter require data
Then User navigates to portfolio details page and click on Account setup button
When User navigates to account holder tab and enter require information
Then User clicks on account information button
#And User navigate to donor succession plan and enter required info
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

Examples: 
		|SheetName    |RowNumber|
		|ENAX         |6        |
		

@C160985
Scenario Outline: C160985_BAW_ParentBundle_New account with contribution + all remaining
Given User login to the application "<SheetName>" , <RowNumber>
When User is on Account Wizard tab and click on go button for New Client creation
And User navigates to client profile page and enter required information
Then User clicks on next button on client profile page
When User navigates to Construct portfolio page and enter required information
Then User clicks on next button on construct portfolio page
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
#When User select CIP value "Not Required/Duplicate" and save client
#And User clicks on "New Account Application" b number open button
#When Switch to respective tab with title "Shell Process"
#And Click on "select" button under account number association
#Then Validate added account number and account name
#And Click on save exit button
#When Switch to respective tab with title "NAA Coach"
#Then User validate "P" letter display under acc and beta
When User add new work item "New Account Contribution by ACH"
Then Validate updated work item to "New Account Bundle with Contribution"
Then Validate new created work item "New Account Contribution by ACH" and open the work item and switch to "Shell Process" page
#And User clicks on "New Account Contribution by ACH" b number open button
#When Switch to respective tab with title "Shell Process"
#And Click on "add" button under account number association
#Then Validate added account number and account name
#And Click on save exit button
#When Switch to respective tab with title "NAA Coach"
#When User does the activate account
#Then User validate "A" letter display under acc and beta

Examples: 
		|SheetName    |RowNumber|
		|ENAX         |7        |
		
		
@C160431
Scenario Outline: C160431_BAW_Check access and beta activation_gnw registration_esign_manual submission_Traditional IRA
Given User login to the application "<SheetName>" , <RowNumber>
When User is on Account Wizard tab and click on go button for New Client creation
And User navigates to client profile page and enter required information
Then User clicks on next button on client profile page
When User navigates to Construct portfolio page and enter required information
Then User clicks on next button on construct portfolio page
When User navigates to fee page and enter require data
Then User navigates to portfolio details page and click on Account setup button
When User navigates to account holder tab and enter require information
And User navigate through beneficiaries tabs
Then User clicks on account information button
When User navigate to Account information tab and click on account feature button
Then User navigate to Account features tab and click on funding method button
When User navigates to funding tab and enter funding method
Then User click on online access document delivery button
When User navigates to online access document delivery tab and click on review all accounts button
Then User navigates to review all accounts tab and click on create documents button
Then User click on create documents button
When User clicks on Separate Documents and select Accounts Establishment option
When User does the esignature with "in person" method
#And User click on initial button
When User answer in person questions
And User check the checkbox and sign the document
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

Examples: 
		|SheetName    |RowNumber|
		|ENAX         |8        |
		
		
@C160432
Scenario Outline: C160432_BAW_Check access activation_individual registration_PRS custodian_HRC submission
Given User login to the application "<SheetName>" , <RowNumber>
When User is on Account Wizard tab and click on go button for New Client creation
And User navigates to client profile page and enter required information
Then User clicks on next button on client profile page
When User navigates to Construct portfolio page and enter required information
Then User clicks on next button on construct portfolio page
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
When User does the esignature with "in person" method
And User click on initial button
When User answer in person questions
And User check the checkbox and sign the document
Given User login to the application
When User impersonate to an "Broker Dealer" and navigates to account approval page
Then User selects the client fullname and clicks on approval request
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
And User clicks on "New Account Application" b number open button
And Click on "select" button under account number association
Then Validate added account number and account name
And Click on save exit button
When Switch to respective tab with title "NAA Coach"
Then User validate "P" letter display under acc
When User does the activate account
Then User validate "A" letter display under acc

Examples: 
		|SheetName    |RowNumber|
		|ENAX         |9		     |
		