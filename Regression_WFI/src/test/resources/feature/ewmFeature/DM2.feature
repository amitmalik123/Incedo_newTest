@1234
Feature: WFI Regression- DM2

Background:
Given Establish DB connection and execute the query to check citrix job status
		
@B1
Scenario Outline: ISC Modal Change B
Given User login to the application "<SheetName>" , <RowNumber>
When User should click on clients tab and navigate to account list page
And User is on the accountlist tab and search with the accountNo
And User should click on searched account and navigate to account wizard page
And Click on client management option "Change Investments"
And Click on account number and navigate to investment selection tab
Then Validate Account Number On Destination Investment Tab
When Select new investment on destination investment tab
Then Validate New Investment Modal
When Select Solution Type
When Select Investment Solution on destination investment tab
When Select "100 percentage" amount in destination investment tab
When Click on next button
Then Validate the "Account Number" tab
And Validate "Suitability" tab and navigate to account features tab
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
When Update internal status "In Process-Auto close Pending Settlement"
Then Validate "ICT Activation" alert
When User close the D tracking id
Then Click on save exit button

Examples: 
		|SheetName    |RowNumber|
		|DM2          |2        |	
	
		
		
		
@A1
Scenario Outline: ISC Modal Change A
Given User login to the application "<SheetName>" , <RowNumber>
When User should click on clients tab and navigate to account list page
And User is on the accountlist tab and search with the accountNo
And User should click on searched account and navigate to account wizard page
And Click on client management option "Change Investments"
And Click on account number and navigate to investment selection tab
Then Validate Account Number On Destination Investment Tab
When Select new investment on destination investment tab
Then Validate New Investment Modal
When Select Solution Type
When Select Investment Solution on destination investment tab
When Select "100 percentage" amount in destination investment tab
When Click on next button
Then Validate the "Account Number" tab
And Validate "Suitability" tab and navigate to account features tab
Then Validate the "Account Features" tab
Then Validate the "Fees" tab
Then Validate the "Summary" tab
When User clicks on complete and submit button and click on complete button on client signature button
Then User does the esign
And Fetch the tracking id and click on close button
And User verify the tracking Id starts with B


Examples: 
		|SheetName    |RowNumber|
		|DM2          |2        |	