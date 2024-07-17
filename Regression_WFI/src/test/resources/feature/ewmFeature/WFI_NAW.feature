@Regression       @NAW
Feature: WFI Regression- NAW

@C72057
Scenario Outline: C72057_NAW_Agent_NewAccount_ExistingClient_WFI
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the accountWizard tab and Search and open a client
Then User Adds a new Registration
When User navigates to Construct portfolio page and enter required information
Then User clicks on next button on construct portfolio page
When User navigates to fee page and enter require data
Then User navigates to portfolio details page and click on Account setup button
When Navigate to Account information page and select existing client
Then User clicks on account information button
When Navigate to Account information page and enter ssn info
Then User navigate to Account information tab and click on account feature button
Then User navigate to Account features tab and click on funding method button
When User navigates to funding tab and enter funding method
Then User click on online access document delivery button
When User navigates to online access document delivery tab and click on review all accounts button
Then User navigates to review all accounts tab and click on create documents button
Then User click on create documents button
When User perform actions on view documents page and fetch require data
When User clicks on Separate Documents and select Accounts Establishment option

Examples: 
		|SheetName    |RowNumber|
		|NAW          |3        |
		
	
