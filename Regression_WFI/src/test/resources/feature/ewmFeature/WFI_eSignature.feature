@Regression			@eSignature
Feature: WFI Regression- eSignature		
		
Background:
Given Establish DB connection and execute the query to check citrix job status		

#@C71937
#Scenario Outline: C71937_eSign_Agent_CreateNewClient_WFI
#Given User login to the application "<SheetName>" , <RowNumber>
#When User is on Account Wizard tab and click on go button for New Client creation
#And User navigates to client profile page and enter required information
#Then User clicks on next button on client profile page
#When User navigates to Construct portfolio page and enter required information
#Then User clicks on next button on construct portfolio page
#When User navigates to fee page and enter require data
#Then User navigates to portfolio details page and click on Account setup button
#When User navigates to account holder tab and enter require information
#Then User clicks on account information button
#When User navigate to Account information tab and click on account feature button
#Then User navigate to Account features tab and click on funding method button
#When User navigates to funding tab and enter funding method
#Then User click on online access document delivery button
#When User navigates to online access document delivery tab and click on review all accounts button
#Then User navigates to review all accounts tab and click on create documents button
#Then User click on create documents button
#When User does the esignature with "email" method
#Then User Verifies the message after agent is done with its part in esignature "Email Sent to Client(s)"
#When User clicks on tracking center link
#When User wait for 1 min
#Then Validate item status "Pending Signature"
#Then Validate first note "Document sent to signer(s) and is pending electronic signature"
#
#Examples: 
#		|SheetName    |RowNumber|
#		|eSignature   |2        |	  
		


@C72089
Scenario Outline: C72089_Docusign_Agent_OAM_Complete&Print_WFI
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Select request and type in Account Management
When User clicks on complete and print button
Then User navigates to docu sign page and clicks on Continue & Finish button
And Fetch the tracking id and click on close button
And User upload the PDF file
Then User verify the tracking Id starts with B	
When User wait for 1 min	
Then Validate first note "Your document has been submitted to Operations for review and processing"
Then Validate second note "successfully uploaded"

Examples: 
		|SheetName    |RowNumber|
		|eSignature   |3        |	
		
		
@C72090
Scenario Outline: C72090_Docusign_Agent_OAM_Complete&Submit_WFI
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Select request and type in Account Management
When User clicks on complete and submit button and click on complete button on client signature button
Then User does the esign
And Fetch the tracking id and click on close button
Then User verify the tracking Id starts with B		
Then Validate first note "Your document has been submitted to Operations for review and processing"

Examples: 
		|SheetName    |RowNumber|
		|eSignature   |4        |	
		
		
@C72092
Scenario Outline: C72092_Docusign_Admin_OAM_Complete&Submit_WFI
Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Select request and type in Account Management
When User clicks on complete and submit button and click on complete button on client signature button
Then User navigates to docu sign page and clicks on Continue & Finish button
And Fetch the tracking id and click on close button
Then Validate item status "Awaiting Advisor Submission"
Then Validate first note "Document has been routed"
Then Validate second note "Document created"
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the tracking center page and click on tracking id
Then Validate finish now button is visible
When User clicks on finish now button
Then User does the esign
Then User verify the tracking Id starts with B	
Then Validate item status "Request Received"
#Then Validate first note "Your document has been submitted to Operations for review and processing"

Examples: 
		|SheetName    |RowNumber|
		|eSignature   |5        |			
		
		
@C72108		
Scenario Outline: C72108_ICT_Agent_Complete&Submit_WFI
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Click on client management option "Change Your Financial Advisor Fee"
And User Enters the flat fee and click on next ".1"
When User clicks on complete and submit button and click on complete button on client signature button on fee page
Then User does the esign
And Fetch the tracking id and click on close button
And User verify the tracking Id starts with B
Then Validate item status "Request Received"
#Then Validate first note "Your document has been submitted to Operations for review and processing"

Examples: 
		|SheetName    |RowNumber|
		|eSignature   |6        |		
		
		
@C72109     
Scenario Outline: C72109_ICT_Agent_Complete&Submit_WFI
Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Click on client management option "Change Your Financial Advisor Fee"
And User Enters the flat fee and click on next ".1"
When User clicks on complete and submit button and click on complete button on client signature button on fee page
Then User does the esign
And Fetch the tracking id and click on close button
Then Validate item status "Awaiting Advisor Submission"
Then Validate first note "Document has been routed"
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the tracking center page and click on tracking id
Then Validate finish now button is visible
When User clicks on finish now button
Then User check the checkbox and sign the document
Then User verify the tracking Id starts with B	
Then Validate item status "Request Received"
#Then Validate first note "Your document has been submitted to Operations for review and processing"

Examples: 
		|SheetName    |RowNumber|
		|eSignature   |7        |	
		

@C160347		
Scenario Outline: C160347_Pershing eSignature process with Broker Dealer approval
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
When User does the esignature with "in person" method
And User click on initial button
When User answer in person questions
#And User check the checkbox and sign the document
When Navigate to tracking center page
And User search item number
Then Validate item status "Awaiting BD Approval"
Given User login to the application
When User impersonate to an "Broker Dealer" and navigates to account approval page
Then User selects the client fullname and clicks on approval request
When User impersonate to an "Agent" and navigates to account approval page
When Navigate to tracking center page
And User search item number
Then Validate item status "Document Submitted"
Then Validate first note "Document approved by Broker Dealer and routed to Operations for review and processing."

Examples: 
		|SheetName    |RowNumber|
		|eSignature   |8        |
		
		
@C160354		
Scenario Outline: C160354_Pershing eSignature process with no Broker Dealer approval
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
When User does the esignature with "in person" method
#And User click on initial button
When User answer in person questions
And User check the checkbox and sign the document
When Navigate to tracking center page
And User search item number
#When User submit the request after recall or reject
And User clicks on submit button
Then Validate first note "Document routed to Operations for review and processing."

Examples: 
		|SheetName    |RowNumber|
		|eSignature   |9        |
		