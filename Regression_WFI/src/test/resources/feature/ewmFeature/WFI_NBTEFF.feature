@Regression      @NBTEFF
Feature: WFI Regression- NBTEFF
		
@C123372
Scenario Outline: C123372_eWM_Create new paperwork_Recall_Reject_Approved by BD
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
Then User validate successful submission text "These accounts have been successfully submitted online to your BD/OSJ for approval" 
When Navigate to tracking center page
And User recall the item
Then User validate the recalled message "paperwork has been recalled"
When User submit the request after recall or reject
Then User validate successful submission text "These accounts have been successfully submitted online to your BD/OSJ for approval" 
When User impersonate to an "Broker Dealer" and navigates to account approval page
And User selects the client fullname and reject request
Then User validate reject message "Paperwork is rejected"
When User impersonate to an "Agent" and navigates to account approval page
When Navigate to tracking center page
When User submit the request after recall or reject
Then User validate successful submission text "These accounts have been successfully submitted online to your BD/OSJ for approval"
When User impersonate to an "Broker Dealer" and navigates to account approval page
Then User selects the client fullname and clicks on approval request
When User impersonate to an "Agent" and navigates to account approval page
When Navigate to tracking center page
And User search item number
Then Validate first note "Account(s) approved by Broker Dealer"

Examples: 
		|SheetName    |RowNumber|
		|NBTEFF       |2        |
	
		
		
@C83223
Scenario Outline: C83223_eWM_Create paperwork_Cancel Item
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
When User navigates to view documents page and click on procees to submit button
Then User navigates to submit page and clicks on submit button
Then User validate successful submission text "These accounts have been successfully submitted online to your BD/OSJ for approval" 
When Navigate to tracking center page
And User search item number
And User clicks on cancel button
Then Validate item status "Request Canceled"

Examples: 
		|SheetName    |RowNumber|
		|NBTEFF       |3        |
		
		
@C83220
Scenario Outline: C83220_eWM_Create new paperwork after recall
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
When User navigates to view documents page and click on procees to submit button
Then User navigates to submit page and clicks on submit button
Then User validate successful submission text "These accounts have been successfully submitted online to your BD/OSJ for approval" 
When Navigate to tracking center page
And User recall the item
Then User validate the recalled message "paperwork has been recalled"
When User submit the request after recall or reject
Then User validate successful submission text "These accounts have been successfully submitted online to your BD/OSJ for approval" 

Examples: 
		|SheetName    |RowNumber|
		|NBTEFF       |4        |
		
		
@C123373
Scenario Outline: C123373_eWM_Create paperwork_Approved by AD
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
When User impersonate to an "Advisor" and navigates to account approval page
Then User selects the client fullname and clicks on approval request
When User impersonate to an "Agent" and navigates to account approval page
When Navigate to tracking center page
And User search item number
Then Validate first note "Account(s) approved by Broker Dealer"

Examples: 
		|SheetName    |RowNumber|
		|NBTEFF       |5        |
		
		
@C123374
Scenario Outline: C123374_eWM_Create paperwork_Approved by OSJ
Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
Given Establish DB connection and update "osj account approval" to 1
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
When User impersonate to an "Premier Business Builder" and navigates to account approval page
Then User selects the client fullname and clicks on approval request
When User impersonate to an "Agent" and navigates to account approval page
When Navigate to tracking center page
And User search item number
Then Validate first note "Account(s) approved by Broker Dealer"
Given Establish DB connection and update "osj account approval" to 0

Examples: 
		|SheetName    |RowNumber|
		|NBTEFF       |6        |
	