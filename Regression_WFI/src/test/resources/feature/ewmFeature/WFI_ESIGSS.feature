@Regression    @ESIGSS
Feature: WFI Regression- ESIGSS
		
@C123987
Scenario Outline: C123987_eWM - Account Wizard - Signature Additional Documents
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
And User add the additional documents
And User upload the "additional" document
And User add label and click on done
Then User validate status "Labeled"
When User clicks the supplemental documents button
And User upload the "supplemental" document
Then User validate the "review and confirm" page
And User validate the confirm message "We have received your documents and are processing them for DocuSign"
And User view and accept additional and supplemental document
Then User fetch the N number

Examples: 
		|SheetName    |RowNumber|
		|ESIGSS       |2        |
	

		
		