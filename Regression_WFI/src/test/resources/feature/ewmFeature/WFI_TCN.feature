@Regression   @TCN
Feature: WFI Regression- TCN

Background:
Given Establish DB connection and execute the query to check citrix job status

@C121229
Scenario Outline: C121229_TCN_WI_Add note from TC
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Select request and type in Account Management
When User clicks on complete and print button
Then User navigates to docu sign page and clicks on Continue & Finish button
And Fetch the tracking id and click on close button
And User upload the PDF file
And User verify the tracking Id starts with B
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Shell Process" page
When Switch to respective tab 1 with details "switch back to tracking center page"
When User add the new note "add a note on tracking center page"
Then Validate first note "add a note on tracking center page"
When Switch to respective tab 3 with details "switch back to shell page"
When Add a note on shell page "add a note on shell page"
And Fetch b number from shell process page    
And Click on save & refresh button
Then Validate added note in description "add a note on shell page"


Examples: 
		|SheetName    |RowNumber|
		|TCN          |2        |
		
	
@C121230		
Scenario Outline: C121230_TCN_WI_Check visibilty flag for images and notes
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Click on client management option "Change Your Financial Advisor Fee"
And User Enters the flat fee and click on next ".1"
And User clicks on complete and print button on fee page
Then User navigates to docu sign page and clicks on Continue & Finish button
And Fetch the tracking id and click on close button
And User upload the PDF file
And User verify the tracking Id starts with B
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Shell Process" page
When User check Uncheck web visibility
When User check Uncheck Advisor visibility
Then Click on save & refresh button
When Switch to respective tab 1 with details "switch back to tracking center page"
Then Validate first note "successfully uploaded"

Examples: 
		|SheetName    |RowNumber|
		|TCN          |3        |
		
		
	
@C121232		
Scenario Outline: C121232_TCN_WI_Validate client level Tracking center
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Click on client management option "Change Your Financial Advisor Fee"
And User Enters the flat fee and click on next ".1"
And User clicks on complete and print button on fee page
Then User navigates to docu sign page and clicks on Continue & Finish button
And Fetch the tracking id and click on close button
And User upload the PDF file
And User verify the tracking Id starts with B
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Shell Process" page
And Click on add document, upload "pdfFilePath" document and validate
And Add a note on shell page "Add a note"
And Click on save & refresh button
When User check Uncheck web visibility
And Click on save & refresh button
Then Validate added note in description "Add a note"
When Switch to respective tab 1 with details "switch back to tracking center page"
Then Validate first note "Add a note"
Then Validate second note "submitted to Operations for review and processing"

Examples: 
		|SheetName    |RowNumber|
		|TCN          |4        |		
		

@C121231
Scenario Outline: C121231_TCN_WI_Change the internal status of WI to Complete in BPM
Given User login to the application "<SheetName>" , <RowNumber>
When Navigate to tracking center page
Given User should login to BAW application and click on the dashboard "viaeWM"
When Click on Open New WorkIteam button
When Select work item type "Account Maintenance"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
When Update internal status "Complete"
And Fetch b number from shell process page
And Click on save exit button
When Switch to respective tab with title "AssetMark"
And User search item by b number
Then Validate item status "Complete"

Examples: 
		|SheetName    |RowNumber|
		|TCN          |5        |			
		
@C121226
Scenario Outline: C121226_TCN_WI_Change the status of B number to in progress in BPM
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Select request and type in Account Management
When User clicks on complete and print button
Then User navigates to docu sign page and clicks on Continue & Finish button
And Fetch the tracking id and click on close button
And User upload the PDF file
And User verify the tracking Id starts with B
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Shell Process" page
When Update internal status "In Process"
And Click on save & refresh button
When Switch to respective tab 1 with details "switch back to tracking center page"
Then Validate item status "In Process"

Examples: 
		|SheetName    |RowNumber|
		|TCN          |6        |		
		
		
@C121228		
Scenario Outline: C121228_TCN_WI_Upload from TC
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Click on client management option "Change Your Financial Advisor Fee"
And User Enters the flat fee and click on next ".1"
And User clicks on complete and print button on fee page
Then User navigates to docu sign page and clicks on Continue & Finish button
And Fetch the tracking id and click on close button
And User upload the PDF file
And User verify the tracking Id starts with B
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Shell Process" page
And Click on add document, upload "pdfFilePath" document and validate
When User check Uncheck Advisor visibility
And Click on save & refresh button
When Switch to respective tab 1 with details "switch back to tracking center page"
And User clicks on view button
Then Validate view documents popup

Examples: 
		|SheetName    |RowNumber|
		|TCN          |7        |	
		
		
@C121227
Scenario Outline: C121227_TCN_WI_Change the status to advisor response requested
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Select request and type in Account Management
When User clicks on complete and print button
Then User navigates to docu sign page and clicks on Continue & Finish button
And Fetch the tracking id and click on close button
And User upload the PDF file
And User verify the tracking Id starts with B
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Shell Process" page
When Update internal status "Advisor Response requested"
And Click on save exit button
When Switch to respective tab 1 with details "switch back to tracking center page"
Then Validate item status "Advisor Response Requested"
Then Validate item advisor alert required "Yes"

Examples: 
		|SheetName    |RowNumber|
		|TCN          |8        |		
		

@C152663
Scenario Outline: C121226_TCN_WI_Change the status to NIGO
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Select request and type in Account Management
When User clicks on complete and print button
Then User navigates to docu sign page and clicks on Continue & Finish button
And Fetch the tracking id and click on close button
And User upload the PDF file
And User verify the tracking Id starts with B
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Shell Process" page
When Update internal status "In Process- Request Not In Good Order"
And User add NIGO reason
And Click on save exit button
When Switch to respective tab 1 with details "switch back to tracking center page"
Then Validate item status "Not In Good Order"
Then Validate item advisor alert required "Yes"

Examples: 
		|SheetName    |RowNumber|
		|TCN          |6        |	
		
		