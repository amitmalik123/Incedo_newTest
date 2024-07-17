@Regression				@Withdrawal
Feature: WFI Regression- Withdrawal

Background:
Given Establish DB connection and execute the query to check citrix job status
		
@C59669
Scenario Outline: C59669_BAW - Withdrawal - Complete and Print - OCR Not Skipped - Reassign to Shell
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Select request and type in Account Management
When User clicks on complete and print button
And User select withdrawal method and click on continue button
Then User navigates to docu sign page and clicks on Continue & Finish button
And Fetch the tracking id and click on close button
And User upload the PDF file
And User verify the tracking Id starts with B
When User wait for 1 min
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Withdrawal Request" page
Then Validate OCR screen should be skipped "No"
When User clicks on Not a withdrawal_button
Then Select work item "Account Maintenance" and click on reclassify work item
When User wait for 1 min
When Validate the frame and switch to it on "bawDashboardPage" page
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Shell Process" page
Then Validate notes history section "Work Item reclassified to Shell Work Item"
When Switch to respective tab with title "Process Portal"
And Click on "Search Work Item" tab
Then Enter external id and click on search button
When Click on "history" link
Then Validate "Not a Withdrawal" trackpoint


Examples: 
		|SheetName    |RowNumber|
		|Withdrawal   |2        |
		
	

@C69188
Scenario Outline: C69188_BAW - Withdrawal - Complete and Submit - OCR Skipped - Cancel WI in IWR
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Select request and type in Account Management
When User clicks on complete and submit button and click on complete button on client signature button
Then User does the esign
And Fetch the tracking id and click on close button
And User verify the tracking Id starts with B
When User wait for 1 min
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Withdrawal Request" page
Then Validate OCR screen should be skipped "Yes"
And User clicks on cancel advisor request button
And Click on "Search Work Item" tab
Then Enter external id and click on search button
Then Validate searched result "internal Status" for "Close"
When Click on "history" link
Then Validate "Work Item Cancelled" trackpoint

Examples: 
		|SheetName    |RowNumber|
		|Withdrawal   |3        |		

		

@C69199
Scenario Outline: C69199_BAW - Withdrawal - QC and NIGO - TrackPoints - Cancel Item in View Only screen
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Select request and type in Account Management
When User clicks on complete and print button
And User select withdrawal method and click on continue button
Then User navigates to docu sign page and clicks on Continue & Finish button
And Fetch the tracking id and click on close button
And User upload the PDF file
And User verify the tracking Id starts with B
When User wait for 1 min
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Withdrawal Request" page
Then Validate OCR screen should be skipped "No"
When User clicks on OCR Complete button
Then User validate IWR screen should display
When User enters withdrawal amount "1000" and click continue button
Then Validate distribution reason section and navigate to tax withHolding
Then Validate tax section with "no withhold" and navigate to delivery method segment
Then User enters required information on delivery section
When User select "ACH" SLOA
Then Navigate to signature segment
Then add "nigo text" in the signature section and continue
Then Validate "IWR summary" page and nigo added note "nigo text"
When Click on save notes button
Then Validate added note "nigo text" in notes history
And Add nigo reason and validate added reason and click on IWR complete button  
Then Delete note and click on GotoIWR button
Then Validate "Initial Work Review" task
Then Navigate to signature section, uncheck NIGO checkbox and click continue
Then Validate "Initiate OA" task
Then Validate IWR & Place Trade tabs and enter date in followup date modal
Then Validate "Setup SLOA" task
When User click on add bank instructions and add the bank details
When User clicks on setup instructions complete button
Then Validate "Initiate Distribution" task
Then Validate request distribution tab and submit to beta
When Validate the frame and switch to it on "bawDashboardPage" page
When User search via B tracking number "viaeWM"
Then User validate internal status "In Process- Submitted to Custodian/Bank" on dashboard page
When User click on b number link and switch to "Withdrawal Request" page
And User navigate to special handling and cancel advisor request
And Click on "Search Work Item" tab
Then Enter external id and click on search button
Then Validate searched result "internal Status" for "Close"
When Click on "history" link
Then Validate "completed" trackpoint

Examples: 
		|SheetName    |RowNumber|
		|Withdrawal   |4        |		
		
		
		
@C123916
Scenario Outline: C123916_BAW - Withdrawal Submission - ACH Bank - IRA with Tax
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Select request and type in Account Management
When User clicks on complete and print button
And User select withdrawal method and click on continue button
Then User navigates to docu sign page and clicks on Continue & Finish button
And Fetch the tracking id and click on close button
And User upload the PDF file
And User verify the tracking Id starts with B
When User wait for 1 min
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Withdrawal Request" page
Then Validate OCR screen should be skipped "No"
When User clicks on OCR Complete button
Then User validate IWR screen should display
When User enters withdrawal amount "1000" and click continue button
Then Validate distribution reason section and navigate to tax withHolding
Then Validate tax section with "withhold" and navigate to delivery method segment
Then User enters required information on delivery section
When User select "ACH" SLOA
Then Navigate to signature segment
Then add "no text" in the signature section and continue
Then Validate "Initiate OA" task
Then Validate IWR & Place Trade tabs and enter date in followup date modal
Then Validate "Setup SLOA" task
When User click on add bank instructions and add the bank details
When User clicks on setup instructions complete button
Then Validate "Initiate Distribution" task
Then Validate request distribution tab and submit to beta
When Validate the frame and switch to it on "bawDashboardPage" page
When User search via B tracking number "viaeWM"
Then User validate internal status "In Process- Submitted to Custodian/Bank" on dashboard page
When User click on b number link and switch to "Withdrawal Request" page
Then Validate beta submission request

Examples: 
		|SheetName    |RowNumber|
		|Withdrawal   |5        |		
		
		
@C123917
Scenario Outline: C123917_BAW - Withdrawal Submission - Check Bank - IRA with No Tax
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Select request and type in Account Management
When User clicks on complete and print button
And User select withdrawal method and click on continue button
Then User navigates to docu sign page and clicks on Continue & Finish button
And Fetch the tracking id and click on close button
And User upload the PDF file
And User verify the tracking Id starts with B
When User wait for 1 min
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Withdrawal Request" page
Then Validate OCR screen should be skipped "No"
When User clicks on OCR Complete button
Then User validate IWR screen should display
When User enters withdrawal amount "1000" and click continue button
Then Validate distribution reason section and navigate to tax withHolding
Then Validate tax section with "no withhold" and navigate to delivery method segment
Then User enters required information on delivery section
Then Navigate to signature segment
Then add "no text" in the signature section and continue
Then Validate "Initiate OA" task
Then Validate IWR & Place Trade tabs and enter date in followup date modal
Then Validate "Initiate Distribution" task
Then Validate request distribution tab and submit to beta
When Validate the frame and switch to it on "bawDashboardPage" page
When User search via B tracking number "viaeWM"
Then User validate internal status "In Process- Submitted to Custodian/Bank" on dashboard page
When User click on b number link and switch to "Withdrawal Request" page
Then Validate beta submission request

Examples: 
		|SheetName    |RowNumber|
		|Withdrawal   |6        |	
		
		
@C123919
Scenario Outline: C123919_BAW - Withdrawal Submission - Wire Bank - NON IRA
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Select request and type in Account Management
When User clicks on complete and print button
And User select withdrawal method and click on continue button
Then User navigates to docu sign page and clicks on Continue & Finish button
And Fetch the tracking id and click on close button
And User upload the PDF file
And User verify the tracking Id starts with B
When User wait for 1 min
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Withdrawal Request" page
Then Validate OCR screen should be skipped "No"
When User clicks on OCR Complete button
Then User validate IWR screen should display
When User enters withdrawal amount "1000" and click continue button
Then Validate distribution reason section and navigate to tax withHolding
Then Validate tax section with "no withhold" and navigate to delivery method segment
Then User enters required information on delivery section
When User select "Wire" SLOA
Then Navigate to signature segment
Then add "no text" in the signature section and continue
Then Validate "Initiate OA" task
Then Validate IWR & Place Trade tabs and enter date in followup date modal
Then Validate "Setup SLOA" task
When User click on add bank instructions and add the bank details
When User clicks on setup instructions complete button
Then Validate "Initiate Distribution" task
Then Validate request distribution tab and submit to beta
When Validate the frame and switch to it on "bawDashboardPage" page
When User search via B tracking number "viaeWM"
Then User validate internal status "In Process- Submitted to Custodian/Bank" on dashboard page
When User click on b number link and switch to "Withdrawal Request" page
Then Validate beta submission request

Examples: 
		|SheetName    |RowNumber|
		|Withdrawal   |7        |	
		
		
@C123918
Scenario Outline: C123918_BAW - Withdrawal Submission - Existing Bank - NON IRA
Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Select request and type in Account Management
When User clicks on complete and print button
And User select withdrawal method and click on continue button
Then User navigates to docu sign page and clicks on Continue & Finish button
And Fetch the tracking id and click on close button
And User upload the PDF file
And User verify the tracking Id starts with B
When User wait for 1 min
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Withdrawal Request" page
Then Validate OCR screen should be skipped "No"
When User clicks on OCR Complete button
Then User validate IWR screen should display
When User enters withdrawal amount "1000" and click continue button
When User select existing bank
Then Navigate to signature segment
Then add "no text" in the signature section and continue
Then Validate "Initiate OA" task
Then Validate IWR & Place Trade tabs and enter date in followup date modal
Then Validate "Initiate Distribution" task
Then Validate request distribution tab and submit to beta
When Validate the frame and switch to it on "bawDashboardPage" page
When User search via B tracking number "viaeWM"
Then User validate internal status "In Process- Submitted to Custodian/Bank" on dashboard page
When User click on b number link and switch to "Withdrawal Request" page
Then Validate beta submission request

Examples: 
		|SheetName    |RowNumber|
		|Withdrawal   |8        |	
		
		

@C69213
Scenario Outline: C69213_BAW - Withdrawal - Documents and WI Links Different Levels - Upload Document
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Select request and type in Account Management
When User clicks on complete and print button
And User select withdrawal method and click on continue button
Then User navigates to docu sign page and clicks on Continue & Finish button
And Fetch the tracking id and click on close button
And User upload the PDF file
And User verify the tracking Id starts with B
When User wait for 1 min
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Withdrawal Request" page
Then Validate OCR screen should be skipped "No"
When User clicks on OCR Complete button
Then User validate IWR screen should display
Then Validate work item under work items and images sections
When User enters withdrawal amount "1000" and click continue button
Then Validate distribution reason section and navigate to tax withHolding
Then Validate tax section with "no withhold" and navigate to delivery method segment
Then User enters required information on delivery section
Then Navigate to signature segment
Then add "no text" in the signature section and continue
Then Validate "Initiate OA" task
When Expand document OCR Compare tab and upload document
Then Validate uploaded document in document OCR section

Examples: 
		|SheetName    |RowNumber|
		|Withdrawal   |9        |
		
		
@C69214
Scenario Outline: C69214_BAW - Withdrawal - PRS - Fax and Email - Upload Document
Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Select request and type in Account Management
When User clicks on complete and print button
Then User navigates to docu sign page and clicks on Continue & Finish button
And Fetch the tracking id and click on close button
And User upload the PDF file
And User verify the tracking Id starts with B
When User wait for 1 min
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Withdrawal Request" page
When User clicks on OCR Complete button
Then User validate IWR screen should display
When User enters withdrawal amount "1000" and click continue button
Then User enters required information on delivery section
Then Navigate to signature segment
Then add "no text" in the signature section and continue
Then Validate "Initiate OA" task
When Expand document OCR Compare tab and upload document
Then Validate uploaded document in document OCR section
Then Validate submitToCustodianModal

Examples: 
		|SheetName    |RowNumber|
		|Withdrawal   |10       |
		
			

@C69189
Scenario: C69189_BAW - Withdrawal - Run Old Withdrawal
Given User should login to BAW application and click on the dashboard "directBAW"
Then User search "withdrawal" b number "B096228992" and validate	
		
		
@C160444
Scenario Outline: C160444_BAW - Withdrawal - Special handling task IWR
Given User login to the application "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Select request and type in Account Management
When User clicks on complete and print button
And User select withdrawal method and click on continue button
Then User navigates to docu sign page and clicks on Continue & Finish button
And Fetch the tracking id and click on close button
And User upload the PDF file
And User verify the tracking Id starts with B
When User wait for 1 min
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Withdrawal Request" page
Then Validate OCR screen should be skipped "No"
When User clicks on OCR Complete button
Then User validate IWR screen should display
When User enters withdrawal amount "1000" and click continue button
Then Validate distribution reason section and navigate to tax withHolding
Then Validate tax section with "withhold" and navigate to delivery method segment
Then User enters required information on delivery section
When User select "ACH" SLOA
Then Navigate to signature segment
Then add "no text" in the signature section and continue
Then Validate "Initiate OA" task
Then Validate IWR & Place Trade tabs and enter date in followup date modal
Then Validate "Setup SLOA" task
When User click on add bank instructions and add the bank details
When User clicks on setup instructions complete button
Then Validate "Initiate Distribution" task
Then Validate request distribution tab and submit to beta
When Validate the frame and switch to it on "bawDashboardPage" page
When User search via B tracking number "viaeWM"
Then User validate internal status "In Process- Submitted to Custodian/Bank" on dashboard page
When User click on b number link and switch to "Withdrawal Request" page
Then Validate "View Only Summary Coach" task
When User update special handling section
Then Validate rd on baw page

Examples: 
		|SheetName    |RowNumber|
		|Withdrawal   |5        |	
		
		