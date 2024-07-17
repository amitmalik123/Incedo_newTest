@Regression       @FAACT
Feature: WFI Regression- FAACT
		
@C123154
Scenario Outline: C123154_BAW_Transfer details section_Standalone B_Transfer type =1 in DocType table
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button
When Select work item type "Transfer In Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item "Transfer In Request" with "percentage" allocation in destination
Then Validate transfer details added on shell page
Then Validate notes history section "Funding account" 


Examples: 
		|SheetName    |RowNumber|
		|FAACT        |2        |	
	
		
@C123149
Scenario Outline: C123149_BAW_Transfer details section_Add new funding account_Standalone B
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button
When Select work item type "Transfer In Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
When Update internal status "In Process"
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item "Transfer In Request" with "percentage" allocation in destination  
Then Validate transfer details added on shell page
And Fetch b number from shell process page   
And Fetch advisor aplid from shell process page
Then Validate notes history section "Funding account" 
When Click on save exit button
Given User login to ewm and impersonate to "Agent"
When Navigate to tracking center page
And User search item by b number
Then Validate transfer details added on item details page

Examples: 
		|SheetName    |RowNumber|
		|FAACT        |3        |			

		
@C123150
Scenario Outline: C123150_BAW_Transfer details section_Add new funding account_Child B
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
And User clicks on "New Account Application" b number open button
#When Switch to respective tab with title "Shell Process"
And Click on "select" button under account number association
Then Validate added account number and account name
And Click on save exit button
When Switch to respective tab with title "NAA Coach"
When User add new work item "New Account Transfer In"
And User click on save and refresh button
When Validate new created work item "New Account Transfer In" and open the work item and switch to "Shell Process" page
When Click on add button under account number association
Then Validate added account number and account name
And Click on save exit button
When Switch to respective tab with title "NAA Coach"
When User select CIP value "Exception Granted" and save client
Then User validate "P" letter display under acc
When User does the activate account
Then User validate "A" letter display under acc
#Then Validate transfer firm details section
And User clicks on "New Account Transfer In" b number open button
When Switch to respective tab with title "Shell Process"
And Click on update transfer button
And enter transfer details for work item "Transfer In Request" with "percentage" allocation in destination
Then Validate transfer details added on shell page

Examples: 
		|SheetName    |RowNumber|
		|FAACT        |4        |	
		
		
@C123151
Scenario Outline: C123151_BAW_Transfer details section_Update existing funding account
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button
When Select work item type "Transfer In Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item "Transfer In Request" with "percentage" allocation in destination 
Then Validate transfer details added on shell page
Then Validate notes history section "Funding account" 


Examples: 
		|SheetName    |RowNumber|
		|FAACT        |5        |	