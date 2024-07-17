@Regression    @General
Feature: WFI Regression- General  		

@C83236
Scenario Outline: C83236_BAW_General_CreateDEinShell_WFI
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button
When Select work item type "Account Maintenance"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
Then Validate "Account Maintenance" work item is created
And User switch to baw page
Then Validate the frame and switch to it on "bawDashboardPage" page
When Click on Open New WorkIteam button 
When Select work item type "Partial Transfer Out In Kind"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
Then Validate "Partial Transfer Out" work item is created


Examples: 
		|SheetName    |RowNumber|
		|General      |2        |	  
		
		
@C83237
Scenario Outline: C83237_BAW_General_CheckAlerts_WFI
Given Establish DB connection and execute the query to check citrix job status
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Select request and type in Account Management
When User clicks on complete and print button
Then User navigates to docu sign page and clicks on Continue & Finish button
#Then User check the checkbox and sign the document
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
When Switch to respective tab 2 with details "switch to tracking center page"
And Click on "Search Work Item" tab
When Enter external id and click on search button
And Click on "details" link
When Switch to respective tab 4 with details "switch to shell view page"
When Add a note on shell page "add a note on shell view page"
And Click on save & refresh button
Then Validate added note in description "add a note on shell view page"

Examples: 
		|SheetName    |RowNumber|
		|General      |3        |
		


@C121946
Scenario: C121946_BAW_Check dashboard_WFI
Given User should login to BAW application and click on the dashboard "directBAW"
When User creates a filter on "amount" and enter value ">=5K and <=25K"
Then User validate the filter model and save the filter by name "Filter A"
Then User validate saved filter "Filter A"
When User clicks on filter button
Then User validate the filterd data on amount in range 5000 to 25000
When User clicks on reset button
Then User validate deactivate filter
When User clicks on flter all button
Then User validate deactivate filter
When User delete the created filter "Filter A"
Then User validate the deleted filter "Filter A"


@C121958
Scenario Outline: C121958_BAW_Open Multiple (2-3) work items at same time in BAW_WFI
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button
When Select work item type "Account Maintenance"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
Then Validate "Account Maintenance" work item is created
When Switch to respective tab 1 with details "switch to baw dashboard page"
Then Validate the frame and switch to it on "bawDashboardPage" page
When Click on Open New WorkIteam button 
When Switch to respective tab 3 with details "switch to new shell window"
When Select work item type "Partial Transfer Out In Kind"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
Then Validate "Partial Transfer Out In Kind" work item is created
Then Validate open windows number 3


Examples: 
		|SheetName    |RowNumber|
		|General      |4        |
		
		
		
@C121960
Scenario Outline: C121960_BAW_Open Multiple images (3) at the same time in BAW_WFI
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button
When Select work item type "Account Maintenance"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
And Click on add document, upload "pdfFilePath" document and validate
And Click on add document, upload "tifFilePath" document and validate


Examples: 
		|SheetName    |RowNumber|
		|General      |5        |		
		
		
		
@C121957
Scenario Outline: C121957_BAW_Set QC selection_WFI
Given User should login to BAW application and click on the dashboard "directBAW"
And Click on "Set QC Selection" tab
Then Validate icon and rate updated "<SheetName>" , <RowNumber>
When Click get list button
And Validate list displayed for user name

Examples: 
		|SheetName    |RowNumber|
		|General      |7        |	
		

@C83238
Scenario Outline: C83238_BAW_General_ValidateTrackingPoints_WFI
Given Establish DB connection and execute the query to check citrix job status
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Select request and type in Account Management
When User clicks on complete and print button
Then User navigates to docu sign page and clicks on Continue & Finish button
#Then User check the checkbox and sign the document
And Fetch the tracking id and click on close button
And User upload the PDF file
And User verify the tracking Id starts with B
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Shell Process" page
When Update internal status "In Process"
And Update owning group
And Click on save exit button
When Switch to respective tab with title "Process Portal"
And Click on "Search Work Item" tab
And Enter external id and click on search button
And Click on "history" link
Then Validate time stamp in sorted order

Examples: 
		|SheetName    |RowNumber|
		|General      |6        |










