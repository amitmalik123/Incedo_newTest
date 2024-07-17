@Regression    @Shell
Feature: WFI Regression- Shell

Background:
Given Establish DB connection and execute the query to check citrix job status

@C71651    
Scenario Outline: C71651_BAW_Shell_FlipDtoBitem_WFI
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
Then Validate notes history section "submitted to Operations"

Examples: 
		|SheetName    |RowNumber|
		|Shell        |2        |
		

@C82186
Scenario Outline: C82186_BAW_Shell_RunBitem_WFI
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

Examples: 
		|SheetName    |RowNumber|
		|Shell        |3        |		   


@C71652
Scenario Outline: C71652_BAW_Shell_UploadFromTrackingCenter_WFI
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
Then Validate "first" uploaded document
When Switch to respective tab 1 with details "switch to ewm to upload another doc"
When User upload the PDF file
And Switch to respective tab 3 with details "switch back to shell process page"
Then Click on save & refresh button
Then Validate "second" uploaded document

Examples: 
		|SheetName    |RowNumber|
		|Shell        |4        |		    

		
		
@C83241
Scenario Outline: C83241_BAW_Shell_Upload a document to BPM_WFI
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Account Billing Authorization - ACH Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
And Click on add document, upload "pdfFilePath" document and validate
Then Validate "first" uploaded document
When Switch to respective tab with title "Shell Process"
Then Validate advisor visibility
And Validate received date timestamp format

Examples: 
		|SheetName    |RowNumber|
		|Shell        |7        |	
		

@C83242
Scenario Outline: C83242_BAW_Shell_Open document in BPM_WFI
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button
When Select work item type "Account Maintenance"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
And Click on add document, upload "pdfFilePath" document and validate
And Click on add document, upload "tifFilePath" document and validate

Examples: 
		|SheetName    |RowNumber|
		|Shell        |10       |	  
		

@C83243
Scenario Outline: C83243_BAW_Shell_Complete a WI with notes_WFI
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button
When Select work item type "Account Maintenance"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
And Add a note on shell page "Add a note"
And Click on save & refresh button
Then Validate added note in description "Add a note"
And Update internal status "Complete"
And Click on save exit button

Examples: 
		|SheetName    |RowNumber|
		|Shell        |8        |			



@C83247
Scenario Outline: C83247_BAW_Shell_Add, edit, delete OA_WFI
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button
When Select work item type "Investment Solution Change Journal"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
When Update internal status "In Process"
And click on Update OA button
And Select action type "Acct setup change" 
And enter action value "submit"
Then Validate added OA details on create OA page "submit"
When Edit the OA record "submit final"
Then Validate added OA details on create OA page "submit final"
And Delete the OA record

Examples: 
		|SheetName    |RowNumber|
		|Shell        |9        |		
				

@C123401     
Scenario Outline: C123401_BAW_Shell_Take Shell all the way (with QC)_WFI
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Transfer In Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
When Update internal status "In Process- Pending Submission"
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item "Transfer In Request" with "percentage" allocation in destination
Then Validate transfer details added on shell page
And Fetch b number from shell process page    
And Click on save exit button
And Click on "Search Work Item" tab
And Enter external id and click on search button
Then Validate searched result "internal Status" for "In Process- Pending QC"
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
When Update internal status "Complete"
And Click on save exit button

Examples: 
		|SheetName    |RowNumber|
		|Shell        |11        |			  

@C169723
Scenario Outline: C169723_BAW_Shell_Close D Section_WFI
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
Then Validate D list and close the D number
Then Validate notes history section "has been closed"
When Switch to respective tab 1 with details "switch to ewm to check closed d number"
When User is on the tracking center page and click on tracking id
Then Validate item status "Request Canceled"

Examples: 
		|SheetName    |RowNumber|
		|Shell        |6        |		
				
@C124019
Scenario Outline: C124019_BAW_Shell_Add Investment change OA (model change) from BPM_WFI
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button
When Select work item type "Investment Solution Change Same Account"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix
And Select individual owner and click run now
When Update internal status "In Process"
And click on Update OA button
And Select action type "Investment Change"
And select account type as "GMS-GMS", straegist id as "GWUMA-Savos Investments" & model code "GMS3VL-Savos GMS Global, Profile 3, Moderate Municipal"
Then Validate added OA details on create OA page "Investment Change"
When Click on save and close button on "createOAPage" page
Then Validate modal change or OA has been created on shell page "Acct setup change"
When click on Update OA button
And Cancel the OA record
Then Validate added OA details on create OA page "Cancelled"
When Click on save and close button on "createOAPage" page
Then Validate modal change or OA has been created on shell page "Cancelled"

Examples: 
		|SheetName    |RowNumber|
		|Shell        |14        |
	
	
@C124029
Scenario: C124029_BAW_Check the view only coach of an archived item and it trackpoints_WFI
Given Establish BPM DB connection and execute the query and fetch column "BNUMBER" data
When User should login to BAW application and click on the dashboard "directBAW"
And User search via B tracking number "directBAW"
Then Validate archived B number on dashboard page
And Click on "Search Work Item" tab
And Enter external id and click on search button
And Click on "history" link
Then Validate time stamp in sorted order

		
@C124026
Scenario Outline: C124026_BAW_Shell_Visibility Flags_WFI
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Click on client management option "Change Investments"
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix
Then Establish DB connection and update "model change" in citrix
And Click on account number and navigate to investment selection tab
Then Validate Account Number On Destination Investment Tab
When Select existing investment with "one" account on destination investment tab
When Select "100 percentage" amount in destination investment tab
When Click on next button
Then Validate the "Account Number" tab
And Validate "suitability" tab and navigate to account features tab
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
Then Validate "ICT Activation" alert
And Validate web visibility "Activate ICT button selected"
When Update internal status "In Process"
And click on Update OA button
And Select managed acct
And Select action type "Acct setup change" 
And enter action value "submit"                
Then Validate added OA details on create OA page "submit"
When Click on save and close button on "createOAPage" page
And Validate web visibility "Activate ICT button selected"
And click on Update OA button
And Cancel the OA record
Then Validate added OA details on create OA page "Cancelled"

Examples: 
		|SheetName    |RowNumber|
		|Shell        |13        |	
	
		
@C123362   
Scenario Outline: C123362_BAW_Shell_Reassign B item with notes and changes_WFI
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button
When Select work item type "Account Maintenance"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
And Add a note on shell page "Add a note"
When Update internal status "In Process"
And Click on save & refresh button
Then Validate added note in description "Add a note"
And Validate external status "In Process"
When Update individual owner "BAW TestUser"
When Fetch b number from shell process page
When Click on save exit button
Then Validate the frame and switch to it on "bawDashboardPage" page 
When User search via B tracking number "directBAW"
Then Validate work item on dashboard page

Examples: 
		|SheetName    |RowNumber|
		|Shell        |19        |	
		
		
@C123953
Scenario Outline: C123953_BAW_Shell_Fee Maintenance Activation_WFI
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Click on client management option "Change Your Financial Advisor Fee"
And User Enters the flat fee and click on next "1.01"
And User clicks on complete and print button on fee page
Then User navigates to docu sign page and clicks on Continue & Finish button
And Fetch the tracking id and click on close button
And User upload the PDF file
And User verify the tracking Id starts with B
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Shell Process" page
Then Validate "fee maintenance activation" alert
Then Validate notes history section "Activate Fee"

Examples: 
		|SheetName    |RowNumber|
		|Shell        |20       |	


@C123959
Scenario Outline: C123959_BAW_Shell_Add journal from BPM_WFI
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button
When Select work item type "Investment Solution Change Journal"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
When Update internal status "In Process"
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix
And click on Update OA button
Then "Cancel" added journal
And Select action type "Journal" 
And User add a journal
Then Validate Added Journal
When Click on save and close button on "journalUtilityPage" page
When "Edit" added journal
When Switch to respective tab 3 with details "switch to journal utility to edit journal"
Then Validate the frame and switch to it on "journalUtilityPage" page 
When Click on save and close button on "journalUtilityPage" page
Then "Cancel" added journal

Examples: 
		|SheetName    |RowNumber|
		|Shell        |12       |	
	
		
@C124022
Scenario: C124022_BAW_Shell_Run old shell instance (non migrated)_WFI
Given User should login to BAW application and click on the dashboard "directBAW"
Then Run "any" old workitem and validate
		
@C124025      
Scenario Outline: C124025_BAW_Shell_Transfer Firm  Section_WFI
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button
When Select work item type "Partial Transfer Out In Kind"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
When Update internal status "In Process-Auto close Pending Settlement"
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item "Partial Transfer Out In Kind" with "no" allocation in destination
Then Validate transfer details added on shell page
And Fetch b number from shell process page   
#Given Establish connection with azure db and execute query to fetch data

Examples: 
		|SheetName    |RowNumber|
		|Shell        |18       |	
		

@C121218   
Scenario Outline: C124025_BAW_Shell_Autoclose_WFI
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button
When Select work item type "Partial Transfer Out In Kind"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
When Update internal status "In Process-Auto close Pending Settlement"
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item "Partial Transfer Out In Kind" with "no" allocation in destination
Then Validate transfer details added on shell page
And Fetch b number from shell process page   
And Click on save exit button

Examples: 
		|SheetName    |RowNumber|
		|Shell        |18       |	


@C123778
Scenario Outline: C123778_BAW_Shell_ICT activation test - model change only_Complete and Submit_WFI
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Click on client management option "Change Investments"
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix
Then Establish DB connection and update "model change" in citrix
And Click on account number and navigate to investment selection tab
Then Validate Account Number On Destination Investment Tab
When Select new investment on destination investment tab
Then Validate New Investment Modal
When Search and Select Investment Solution on destination investment tab 2
When Select "100 percentage" amount in destination investment tab
When Click on next button
Then Validate the "Account Number" tab
And Validate "suitability" tab and navigate to account features tab
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
Then Validate "ICT Activation" alert
Then Validate modal change or OA has been created on shell page "ICT_Activation"
Then Validate journal creation

Examples: 
		|SheetName    |RowNumber|
		|Shell        |16       |	
		

@C123946
Scenario Outline: C123946_BAW_Shell_ICT + Journal activation_WFI
Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Click on client management option "Change Investments"
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix
Then Establish DB connection and update "model change" in citrix
And Click on account number and navigate to investment selection tab
Then Validate Account Number On Destination Investment Tab
When Select new investment on destination investment tab
Then Validate New Investment Modal
When Search and Select Investment Solution on destination investment tab 1
When Select "partial" amount in destination investment tab
When Click on next button
Then Validate the "Account Number" tab
And Validate "suitability" tab and navigate to account features tab
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
Then Validate "ICT Activation" alert
Then Validate modal change or OA has been created on shell page "ICT_Activation"
Then Validate journal creation

Examples: 
		|SheetName    |RowNumber|
		|Shell        |21       |		
		

@C83228
Scenario Outline: C83228_BAW_Shell_Fax and upload to PRS a document_WFI
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Account Billing Authorization - ACH Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
And Click on add document, upload "pdfFilePath" document and validate
Then Validate "first" uploaded document
When Switch to respective tab with title "Shell Process"
And Check doc visibility and click on submit to bank button
And Select pershing and click upload button
And Click on save & refresh button
Then Validate notes history section "has been Committed"

Examples: 
		|SheetName    |RowNumber|
		|Shell        |22       |	
		
		
@C83232
Scenario Outline: C83232_BAW_Shell_Fax and email for TDA account_WFI
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Account Billing Authorization - ACH Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
And Click on add document, upload "pdfFilePath" document and validate
Then Validate "first" uploaded document
When Switch to respective tab with title "Shell Process"
And Check doc visibility and click on submit to bank button
Then Validate notes history section "has been Committed"

Examples: 
		|SheetName    |RowNumber|
		|Shell        |23       |	
			
		
@C83233
Scenario Outline: C83233_BAW_Shell_Send to bancorp_WFI
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Add Checking to Existing Account"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
And Click on add document, upload "pdfFilePath" document and validate
Then Validate "first" uploaded document
When Switch to respective tab with title "Shell Process"
And Check doc visibility and click on submit to bank button
Then Validate notes history section "has been faxed successfully"
Given Launcing bancorp application
Then Validate file in bancorp

Examples: 
		|SheetName    |RowNumber|
		|Shell        |24       |	
		

@C123991
Scenario Outline: C123991_BAW_Shell_Highlights in header-3rd party, HNW_WFI
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button
When Select work item type "Account Maintenance"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
Then Validate "party element" is present and highlight with color "rgb(255, 255, 102)" on shell page
When Update internal status "In Process"
And click on Update OA button
Then Validate party element is present and highlight with color "rgb(255, 255, 102)" on Create OA page

Examples: 
		|SheetName    |RowNumber|
		|Shell        |25       |	


@C124027
Scenario Outline: C124027_BAW_Check the WI and documents links in the different levels_WFI
Given Establish EWM DB connection and execute the query and fetch column "AccountNo" data
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Account Billing Authorization - ACH Request"
And Enter Custodial Account value from "firstRow"
And Select individual owner and click run now "<SheetName>" , <RowNumber>
And Click on add document, upload "pdfFilePath" document and validate
Then Validate "first" uploaded document
When Switch to respective tab with title "Process Portal"
When User closes windows except current window
Then Validate the frame and switch to it on "bawDashboardPage" page 
When Click on Open New WorkIteam button 
When Select work item type "Account Not Trading: Allocation Instructions Required"
And Select custodian type "GNW"
And Select individual owner and click run now "<SheetName>" , <RowNumber>
And Click on add document, upload "pdfFilePath" document and validate
Then Validate "first" uploaded document
When Switch to respective tab with title "Process Portal"
When User closes windows except current window
Then Validate the frame and switch to it on "bawDashboardPage" page 
When Click on Open New WorkIteam button 
When Select work item type "Advisor Notification Needed"
And Select custodian type "GNW"
And Select individual owner and click run now "<SheetName>" , <RowNumber>
And Click on add document, upload "pdfFilePath" document and validate
Then Validate "first" uploaded document

Examples: 
		|SheetName    |RowNumber|
		|Shell        |27       |	


@C123992
Scenario Outline: C123992_BAW_Shell_Highlights in header - suspend\restriction OA (suspend highlight is done with suspend - Addition)_WFI
Given Establish EWM DB connection and execute the query and fetch column "APLID" data
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Account Trading Suspension or Removal"
And Enter account apl id
And Select individual owner and click run now "<SheetName>" , <RowNumber>
When Update internal status "In Process"
And click on Update OA button
And Select action type "Suspend Trading - Other" 
And enter action value "submit"
Then Validate added OA details on create OA page "submit"
When Click on save and close button on "createOAPage" page
Then Validate "Open Suspend OA" is present and highlight with color "rgb(255, 255, 102)" on shell page
Then Validate modal change or OA has been created on shell page "Suspend Trading - Other"

Examples: 
		|SheetName    |RowNumber|
		|Shell        |27       |	


@C123355
Scenario Outline: C123355_BAW_Shell_Edit Shell Item from IPG to ADG Channel_WFI
Given Establish EWM DB connection and execute the query
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Account Billing Authorization - ACH Request"
And Enter Custodial Account value from "secondRow"
And Select individual owner and click run now "<SheetName>" , <RowNumber>
And Fetch b number from shell process page
Then Validate client name "before" edit
When Edit workitem header
Then Validate client name "after" edit
When Switch to respective tab with title "Process Portal"
And User clicks on dashboard tab
When User search via B tracking number "directBAW"
Then User validate updated data on dashboard page

Examples: 
		|SheetName    |RowNumber|
		|Shell        |26       |	


@C123990   
Scenario Outline: C123990_BAW_Shell_Special routing_WFI
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button
When Select work item type "Account Setup Form"
And Select custodian type "PRS"
And Select individual owner and click run now "<SheetName>" , <RowNumber>
And Edit header data
Then Validate special routing section

Examples: 
		|SheetName    |RowNumber|
		|Shell        |28        |	


@C123355
Scenario Outline: C123355_BAW_Shell_Edit Shell Item from IPG to ADG Channel_WFI
Given Establish EWM DB connection and execute the query
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Account Billing Authorization - ACH Request"
And Enter Custodial Account value from "secondRow"
And Select individual owner and click run now "<SheetName>" , <RowNumber>
And Fetch b number from shell process page
Then Validate client name "before" edit
When Edit workitem header
Then Validate client name "after" edit
When Switch to respective tab with title "Process Portal"
And User clicks on dashboard tab
When User search via B tracking number "directBAW"
Then User validate updated data on dashboard page

Examples: 
		|SheetName    |RowNumber|
		|Shell        |26       |	



@C123343
Scenario Outline: C123343_BAW_Shell_Create a Journal and change the status_WFI
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button
When Select work item type "Investment Solution Change Journal"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
Then Validate external status "Request Received"
When Fetch b number from shell process page
When Update internal status "In Process"
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix
And click on Update OA button
Then "Cancel" added journal
And Select action type "Journal" 
And User add a journal
Then Validate Added Journal
When Click on save and close button on "journalUtilityPage" page
When Click on save and close button on "createOAPage" page
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix
And Click on save & refresh button
And Click on save & refresh button
And Validate journal creation

Examples: 
		|SheetName    |RowNumber|
		|Shell        |29       |



@C123623
Scenario Outline: C123355_BAW_Shell_Termination notification - add\delete agent from notification_WFI
#Given Establish EWM DB connection and execute the query
Given User should login to BAW application and click on the dashboard "directBAW"
And Click on "Opt-out List" tab
And User enters agent id and stop agent notifications "<SheetName>" , <RowNumber>
And Click on "Search Work Item" tab
And Click on "Dashboard" tab
When Click on Open New WorkIteam button 
When Select work item type "Terminate 100%"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
And Fetch b number from shell process page
And Click termination notification button
Then Validate notes history section "due to advisor Opt Out"
When Switch to respective tab with title "Process Portal"
When User closes windows except current window
And Click on "Opt-out List" tab
And User enters agent id and resume agent notifications
And Click on "Search Work Item" tab
And Click on "Dashboard" tab
When Click on Open New WorkIteam button 
When Select work item type "Terminate 100%"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
And Fetch b number from shell process page
And Click termination notification button
Then Validate notes history section should not have "due to advisor Opt Out"

Examples: 
		|SheetName    |RowNumber|
		|Shell        |30       |	

		
		
		
		
		
		
		
		
		
		
		