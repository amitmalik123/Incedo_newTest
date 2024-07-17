@Regression				@tobi
Feature: WFI Regression- TOBI		

		
@C123192	
Scenario Outline: C7123192_BAW - GNW activation in BETA (Traditional IRA) using BD approval - check name convention - Add features/records (MDRO,DAML)
Given User login to the application "<SheetName>" , <RowNumber>
When User is on Account Wizard tab and click on go button for New Client creation
And User navigates to client profile page and enter required information
Then User clicks on next button on client profile page
When User navigates to Construct portfolio page and enter required information
Then User clicks on next button on construct portfolio page
When User navigates to fee page and enter require data
Then User navigates to portfolio details page and click on Account setup button
When User navigates to account holder tab and enter require information
And User navigate through beneficiaries tabs
Then User clicks on account information button
When User navigate to Account information tab and click on account feature button
Then User navigate to Account features tab and click on funding method button
When User navigates to funding tab and enter funding method
Then User click on online access document delivery button
When User navigates to online access document delivery tab and click on review all accounts button
Then User navigates to review all accounts tab and click on create documents button
Then User click on create documents button
When User clicks on Separate Documents and select Accounts Establishment option
When User navigates to view documents page and click on procees to submit button
Then User navigates to submit page and clicks on submit button
Given User login to the application
When User impersonate to an "Broker Dealer" and navigates to account approval page
Then User selects the client fullname and clicks on approval request
Given User should login to BAW application and click on the dashboard "viaeWM"
When Click on Open New WorkIteam button
When Select work item type "New Account Application"
Then Select custodian type "GNW"
And Select individual owner and click run now
When Fetch b number from shell process page
When User enter hrc number and click on submit
And Click on "Search Work Item" tab
And Enter external id and click on search button
And Fetch parent b number
And Click on "Dashboard" tab
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "NAA Coach" page
Then User validate "Application approved by BD" alert message
When User select CIP value "Exception Granted" and save client
And User clicks on "New Account Application" b number open button
#When Switch to respective tab with title "Shell Process"
And Click on "select" button under account number association
Then Validate added account number and account name
And Click on save exit button
When Switch to respective tab with title "NAA Coach"
Then User validate "P" letter display under acc and beta
When User does the activate account
Then User validate "A" letter display under acc and beta

Examples: 
		|SheetName    |RowNumber|
		|TOBI         |2        |		
		
		
@C123318
Scenario Outline: C123318_BAW - ICT Activation for GNW account - 8 digits
Given Establish DB connection and execute the query to check citrix job status
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
When Search and Select Investment Solution on destination investment tab 1
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
Then Validate account number digits should be 8
Then Validate "ICT Activation" alert

Examples: 
		|SheetName    |RowNumber|
		|TOBI         |3        |	
		
		
@C123191	
Scenario Outline: C123191_BAW - GNW activation in BETA (joint) using non bd approval - check name convention - Add features/records
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
When User clicks on Separate Documents and select Accounts Establishment option
Given User should login to BAW application and click on the dashboard "viaeWM"
When Click on Open New WorkIteam button
When Select work item type "New Account Application"
Then Select custodian type "GNW"
And Select individual owner and click run now
When Fetch b number from shell process page
When User enter hrc number and click on submit
And Click on "Search Work Item" tab
And Enter external id and click on search button
And Fetch parent b number
And Click on "Dashboard" tab
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "NAA Coach" page
And User expand registration section
And User add new feature
Then User validate added feature
When User select CIP value "Exception Granted" and save client
And User clicks on "New Account Application" b number open button
#When Switch to respective tab with title "Shell Process"
And Click on "select" button under account number association
Then Validate added account number and account name
And Click on save exit button
When Switch to respective tab with title "NAA Coach"
Then User validate "P" letter display under acc and beta
When User does the activate account
Then User validate "A" letter display under acc and beta

Examples: 
		|SheetName    |RowNumber|
		|TOBI         |4        |	
	

@C123187	
Scenario Outline: C123187_EWM - Add registration(Individual) to an existing account and activate in beta
Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
When User is on the account wizard tab and search the client
And Click on client management option "Add a Registration"
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
When User clicks on Separate Documents and select Accounts Establishment option
Given User should login to BAW application and click on the dashboard "viaeWM"
When Click on Open New WorkIteam button
When Select work item type "New Account Application"
Then Select custodian type "GNW"
And Select individual owner and click run now
When Fetch b number from shell process page
When User enter hrc number and click on submit
And Click on "Search Work Item" tab
And Enter external id and click on search button
And Fetch parent b number
And Click on "Dashboard" tab
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "NAA Coach" page
When User select CIP value "Not Required/Duplicate" and save client
And User clicks on "New Account Application" b number open button
And Click on "select" button under account number association
Then Validate added account number and account name
And Click on save exit button
When Switch to respective tab with title "NAA Coach"
Then User validate "P" letter display under acc and beta
When User does the activate account
Then User validate "A" letter display under acc and beta

Examples: 
		|SheetName    |RowNumber|
		|TOBI         |5        |	
		
		
@C161800     
Scenario Outline: C161800_TOAR-Allocation is 1 to one by %
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
And Validate notes history section "Funding account"
And Fetch b number from shell process page    
And Click on save exit button
And Click on "Search Work Item" tab
And Enter external id and click on search button
Then Validate searched result "internal Status" for "In Process- Pending QC"
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And QC user approve the record
And Validate notes history section "TOAR Record created successfully"
And User clicked on return to last user button
And Click on save exit button
Given Establish connection with azure db and execute query to fetch data
Then Validate external id status as "3"
And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And User clicks on submission complete
And User clicked on return to last user button
And Click on save exit button
Then Validate external id status as "7"
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And QC user approve the record
#And Validate notes history section "TOAR Record created successfully"
And User clicked on return to last user button
And Click on save exit button
Then Validate external id status as "10"
And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
When Update internal status "Complete"
And Click on save exit button
And Click on "Search Work Item" tab
And Enter external id and click on search button
And Click on "details" link
And Switch to respective tab with title "Shell Process"
And Validate notes history section "Residual update initiated successfully for funding account"
And Validate notes history section "SUCCESS"
And Validate notes history section "TOAR record closed successfully for account"
And Validate notes history section "Account closed during initiate residual distribution"
And Validate notes history section "closed in BETA"
And Validate notes history section "Residual distribution record created successfully for account"

Examples: 
		|SheetName    |RowNumber|
		|TOBI	        |6        |


@C161804     
Scenario Outline: C161804_TOAR-Allocation includes Special instruction (Whether 1 vs 1 or 1 to many)
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Transfer In Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
When Update internal status "In Process- Pending Submission"
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item "Transfer In Request" with "special instructions" allocation in destination
Then Validate transfer details added on shell page
And Validate notes history section "Funding account"
And Fetch b number from shell process page    
And Click on save exit button
And Click on "Search Work Item" tab
And Enter external id and click on search button
Then Validate searched result "internal Status" for "In Process- Pending QC"
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And QC user approve the record
And Validate notes history section "TOAR Record created successfully"
And User clicked on return to last user button
And Click on save exit button
Given Establish connection with azure db and execute query to fetch data
Then Validate external id status as "3"
And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And User clicks on submission complete
And User clicked on return to last user button
And Click on save exit button
Then Validate external id status as "7"
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And QC user approve the record
And User clicked on return to last user button
And Click on save exit button
Then Validate external id status as "10"
And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
When Update internal status "Complete"
And Click on save exit button
And Switch to respective tab with title "Shell Process"
Then Validate notes history section "Residual record not added for account"

Examples: 
		|SheetName    |RowNumber|
		|TOBI	        |7        |
		
		

@C161801     
Scenario Outline: C161801_TOAR-Allocation is 1 to many by %
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Transfer In Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
When Update internal status "In Process- Pending Submission"
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item "Transfer In Request" with "multiple" allocation in destination
Then Validate transfer details added on shell page
And Validate notes history section "Funding account"
And Fetch b number from shell process page    
And Click on save exit button
And Click on "Search Work Item" tab
And Enter external id and click on search button
Then Validate searched result "internal Status" for "In Process- Pending QC"
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And QC user approve the record
And Validate notes history section "TOAR Record created successfully"
And User clicked on return to last user button
And Click on save exit button
Given Establish connection with azure db and execute query to fetch data
Then Validate external id status as "3"
And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And User clicks on submission complete
And User clicked on return to last user button
And Click on save exit button
Then Validate external id status as "7"
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And QC user approve the record
#And Validate notes history section "TOAR Record created successfully"
And User clicked on return to last user button
And Click on save exit button
Then Validate external id status as "10"
And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
When Update internal status "Complete"
And Click on save exit button
And Click on "Search Work Item" tab
And Enter external id and click on search button
And Click on "details" link
And Switch to respective tab with title "Shell Process"
And Validate notes history section "Residual update initiated successfully for funding account"
And Validate notes history section "SUCCESS"
And Validate notes history section "TOAR record closed successfully for account"
And Validate notes history section "Account closed during initiate residual distribution"
And Validate notes history section "closed in BETA"

Examples: 
		|SheetName    |RowNumber|
		|TOBI	        |8        |
		
		
@C161802     
Scenario Outline: C161802_TOAR-Allocation is 1 to many by $ with A/R
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Transfer In Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
When Update internal status "In Process- Pending Submission"
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item "Transfer In Request" with "multipleAR" allocation in destination
Then Validate transfer details added on shell page
And Validate notes history section "Funding account"
And Fetch b number from shell process page    
And User fetched funding account
And Click on save exit button
And Click on "Search Work Item" tab
And Enter external id and click on search button
Then Validate searched result "internal Status" for "In Process- Pending QC"
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And QC user approve the record
And Validate notes history section "TOAR Record created successfully"
And User clicked on return to last user button
And Click on save exit button
Given Establish connection with azure db and execute query to fetch data
Then Validate external id status as "3"
And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And User clicks on submission complete
And User clicked on return to last user button
And Click on save exit button
Then Validate external id status as "7"
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And QC user approve the record
#And Validate notes history section "TOAR Record created successfully"
And User clicked on return to last user button
And Click on save exit button
Then Validate external id status as "10"
And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
When Update internal status "Complete"
And Click on save exit button
And Click on "Search Work Item" tab
And Enter external id and click on search button
And Click on "details" link
And Switch to respective tab with title "Shell Process"
And Validate notes history section "Residual update initiated successfully for funding account"
And Validate notes history section "SUCCESS"
And Validate notes history section "TOAR record closed successfully for account"
And Validate notes history section "Account closed during initiate residual distribution"
And Validate notes history section "closed in BETA"

Examples: 
		|SheetName    |RowNumber|
		|TOBI	        |9        |
		
		
@C151989   
Scenario Outline: C151989_TOAR- Funding account number not shared
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Custodian Change Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
Given Establish connection with azure db and execute query to fetch data
And Select individual owner and click run now
And Click on update transfer button
And enter transfer details for work item "Custodian Change Request" with "percentage" allocation in destination
And Validate notes history section "Funding account"
When User fetched transfer tracking number
And User fetch account transfer id from transfer db
When User should generate bearer token
And User should add request header parameters for "CloseAccountTransferRequest"
And User should design request body for "CloseAccountTransferRequest"
And User should hit the request and get the response for "CloseAccountTransferRequest"
Then User should verify status code 200

Examples: 
		|SheetName    |RowNumber|
		|TOBI	        |10        |
		
		
@C151990   
Scenario Outline: C151990_TOAD- Funding account number not shared
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Full Transfer Out In Kind"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
Given Establish connection with azure db and execute query to fetch data
And Select individual owner and click run now
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item "Full Transfer Out In Kind" with "no" allocation in destination
And Validate notes history section "TOAD Record created successfully"
When User fetched transfer tracking number
And User fetch account transfer id from transfer db
When User should generate bearer token
And User should add request header parameters for "CloseAccountTransferRequest"
And User should design request body for "CloseAccountTransferRequest"
And User should hit the request and get the response for "CloseAccountTransferRequest"
Then User should verify status code 200

Examples: 
		|SheetName    |RowNumber|
		|TOBI	        |11        |
		
		
@C151988  
Scenario Outline: C151988_TOAD- Managed account number shared across multiple work items with
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Full Transfer Out In Kind"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
Given Establish connection with azure db and execute query to fetch data
And Select individual owner and click run now
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item "Full Transfer Out In Kind" with "no" allocation in destination
And Validate notes history section "TOAD Record created successfully"
When Switch to respective tab with title "Process Portal"
When User closes windows except current window
Then Validate the frame and switch to it on "bawDashboardPage" page 
When Click on Open New WorkIteam button 
When Select work item type "Full Transfer Out In Kind"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item "Full Transfer Out In Kind" with "no" allocation in destination
And Validate notes history section "TOAD Record created successfully"
When User fetched transfer tracking number
And User fetch account transfer id from transfer db
When User should generate bearer token
And User should add request header parameters for "CloseAccountTransferRequest"
And User should design request body for "CloseAccountTransferRequest"
And User should hit the request and get the response for "CloseAccountTransferRequest"
Then User should verify status code 200

Examples: 
		|SheetName    |RowNumber|
		|TOBI	        |12        |
		
		
		
		
		
		
		
		
		
		
		
		
		