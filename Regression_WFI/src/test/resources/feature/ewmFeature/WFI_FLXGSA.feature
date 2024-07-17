@Regression    @FLXGSA
Feature: WFI Regression- FLXGSA

Background:
#Given Establish DB connection and execute the query to check citrix job status

@C181997    
Scenario Outline: C81997_ Custom Allocation Tool
Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Click on client management option "Change Investments"
And Click on account number and navigate to investment selection tab
Then Validate Account Number On Destination Investment Tab
When Select new investment on destination investment tab
Then Validate New Investment Modal
When Search and Select Investment Solution on destination investment tab 1
Then User validate custom allocation button

Examples: 
		|SheetName    |RowNumber|
		|FLXGSA       |2        |		
		

		
		
		
		
		
		
		
		
		
		
		