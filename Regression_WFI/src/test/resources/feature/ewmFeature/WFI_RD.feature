@Regression    @rd
Feature: WFI Regression- RD

Background:
#Given Establish DB connection and execute the query to check citrix job status

@C206054     
Scenario Outline: C206054_Transfer In
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
And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And User clicks on submission complete
And User clicked on return to last user button
And Click on save exit button
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And QC user approve the record
And Validate notes history section "TOAR Record created successfully"
And User clicked on return to last user button
And Click on save exit button
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

When User should generate bearer token
And User should add request header parameters for "GetAccountTransferRequests"
And User should design request body for "GetAccountTransferRequests"
And User should hit the request and get the response for "GetAccountTransferRequests"
Then User should verify status code 200
And User should verify "accountTransferStatus" as "Closed" for "GetAccountTransferRequests"

And User should add request header parameters for "GetPeriodicWithdrawalInstructionsByAccount"
And User should design request body for "GetPeriodicWithdrawalInstructionsByAccount"
And User should hit the request and get the response for "GetPeriodicWithdrawalInstructionsByAccount"
Then User should verify status code 200
And User should verify "distributionStatus" as "Active" for "GetPeriodicWithdrawalInstructionsByAccount"

And User should add request header parameters for "GetAccountDetail"
And User should design request body for "GetAccountDetail"
And User should hit the request and get the response for "GetAccountDetail"
Then User should verify status code 200
And User should verify "status" as "Closed" for "GetAccountDetail"

Examples: 
		|SheetName    |RowNumber|
		|RD		        |2        |		
		
		
@C206055     
Scenario Outline: C206055_TransferOutCash
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Full Transfer Out Liquidate"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix

When User should generate bearer token
And User should add request header parameters for "delete distribution"
And User should design request body for "delete distribution"
And User should hit the request and get the response for "delete distribution"
Then User should verify status code 200

And User should add request header parameters for "delete residual"
And User should design request body for "delete residual"
And User should hit the request and get the response for "delete residual"
Then User should verify status code 200

And User should add request header parameters for "openAccount"
And User should design request body for "openAccount"
And User should hit the request and get the response for "openAccount"
Then User should verify status code 200

Given Establish connection with azure db and execute query to fetch data
When User update residual distribution table in azure db
When Update internal status "In Process"
And Fetch b number from shell process page    
And click on Update OA button
And Select action type "Term-acct will not fund" 
And enter action value "submit"
Then Validate added OA details on create OA page "submit"
When Click on save and close button on "createOAPage" page
And Click on one time distribution button
And enter one time distribution details
Then Validate one-time distribution status as "IWRComplete"
When Update internal status "In Process-Pending Settlement"
And User click on residual distribution button when status is "New"
And User click on iwr button on distribution button
Then Validate residual distribution status as "IWRComplete"
And Click on save exit button for rd
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on one time distribution button
And QC user "approve" the record of one time distrbution
And Validate notes history section "One-time distribution record created successfully for account"
Then Validate one-time distribution status as "Initiated"
And User click on residual distribution button when status is "IWRComplete"
And QC user "approve" the record of residual distrbution
Then Validate residual distribution status as "Scheduled"
And Validate notes history section "Residual distribution instructions committed"
And User clicked on return to last user button
And Click on save exit button
And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
When Update internal status "Complete"
And Click on save exit button
And Click on "Search Work Item" tab
And Enter external id and click on search button
And Click on "details" link
And Switch to respective tab with title "Shell Process"
And Validate notes history section "Residual initiated successfully for account"
And Validate notes history section "Account closed during initiate residual distribution"
And Validate notes history section "Residual distribution record created successfully for account"

And User should add request header parameters for "GetAccountDetail"
And User should design request body for "GetAccountDetail"
And User should hit the request and get the response for "GetAccountDetail"
Then User should verify status code 200
And User should verify "status" as "Closed" for "GetAccountDetail"

And User should add request header parameters for "GetPeriodicWithdrawalInstructionsByAccount"
And User should design request body for "GetPeriodicWithdrawalInstructionsByAccount"
And User should hit the request and get the response for "GetPeriodicWithdrawalInstructionsByAccount"
Then User should verify status code 200
And User should verify "distributionStatus" as "Active" for "GetPeriodicWithdrawalInstructionsByAccount"

Examples: 
		|SheetName    |RowNumber|    
		|RD     	    |3        |	
		
		
@C206056  
Scenario Outline: C206056_TransferOutInKind
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Full Transfer Out In Kind"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix

When User should generate bearer token
And User should add request header parameters for "delete distribution"
And User should design request body for "delete distribution"
And User should hit the request and get the response for "delete distribution"
Then User should verify status code 200

And User should add request header parameters for "delete residual"
And User should design request body for "delete residual"
And User should hit the request and get the response for "delete residual"
Then User should verify status code 200

And User should add request header parameters for "openAccount"
And User should design request body for "openAccount"
And User should hit the request and get the response for "openAccount"
Then User should verify status code 200

Given Establish connection with azure db and execute query to fetch data
When User update residual distribution table in azure db
And Fetch b number from shell process page 
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item "Full Transfer Out In Kind" with "no" allocation in destination  
Then Validate transfer details added on shell page
And Validate notes history section "TOAD Record created successfully"
When Update internal status "In Process"
And click on Update OA button
And Select action type "Term-acct will not fund" 
And enter action value "submit"
When Click on save and close button on "createOAPage" page
And Click on one time distribution button
And enter one time distribution details
Then Validate one-time distribution status as "IWRComplete"
And User click on residual distribution button when status is "New"
And User click on iwr button on distribution button
Then Validate residual distribution status as "IWRComplete"
When Update internal status "In Process- Pending Submission"  
And Click on save exit button for rd
And Click on "Search Work Item" tab
And Enter external id and click on search button
Then Validate searched result "internal Status" for "In Process- Pending QC"

And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And QC user approve the record
Then Validate transfer details status as "QCApprovedFirstPass"

And Click on one time distribution button
And QC user "approve" the record of one time distrbution
Then Validate notes history section "Distribution request initiated"
Then Validate one-time distribution status as "Initiated"

And Click on residual distribution button for qc user
And QC user "approve" the record of residual distrbution
Then Validate residual distribution status as "Scheduled"
And User clicked on return to last user button
And Click on save exit button
And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And User clicks on ready for submission
Then Validate transfer details status as "ReadyForSubmissionPendingQC"
And User clicked on return to last user button
And Click on save exit button
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And QC user approve the record
Then Validate transfer details status as "QCApprovedSecondPass"
And User clicked on return to last user button
And Click on save exit button
And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And User clicks on submission complete
Then Validate transfer details status as "Submitted"
And User clicks on initiate rd and close account button
Then Validate residual distribution status as "Initiated"
And Validate notes history section "Residual initiated successfully for account"
And Validate notes history section "Account closed during initiate residual distribution"
And Validate notes history section "Residual distribution record created successfully for account"

And User should add request header parameters for "GetAccountDetail"
And User should design request body for "GetAccountDetailTransferOut"
And User should hit the request and get the response for "GetAccountDetail"
Then User should verify status code 200
And User should verify "status" as "Closed" for "GetAccountDetail"

And User should add request header parameters for "GetPeriodicWithdrawalInstructionsByAccount"
And User should design request body for "GetPeriodicWithdrawalInstructionsByAccountTranferOut"
And User should hit the request and get the response for "GetPeriodicWithdrawalInstructionsByAccount"
Then User should verify status code 200
And User should verify "distributionStatus" as "Active" for "GetPeriodicWithdrawalInstructionsByAccount"

Examples: 
		|SheetName    |RowNumber|
		|RD		        |4       |		


@C208333 
Scenario Outline: C208333_Residual Distribution - Audit table verification
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Full Transfer Out Liquidate"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
Given Establish connection with azure db and execute query to fetch data
When User update residual distribution table in azure db
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix
And Fetch b number from shell process page 
When Update internal status "In Process"
And click on Update OA button
And Select action type "Term-acct will not fund" 
And enter action value "submit"
When Click on save and close button on "createOAPage" page
And Click on one time distribution button
And enter one time distribution details
Then Validate one-time distribution status as "IWRComplete"
Given Establish connection with azure db and execute query to fetch data
Then Validate external id status as "7"
When Update internal status "In Process-Pending Settlement"
And User click on residual distribution button when status is "New"
#And enter residual distribution details
And User click on iwr button on distribution button
Then Validate residual distribution status as "IWRComplete"
And Click on save exit button for rd

And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on one time distribution button
And QC user "approve" the record of one time distrbution
Then Validate one-time distribution status as "Initiated"
When Click on residual distribution button for qc user
And QC user "approve" the record of residual distrbution
Then Validate residual distribution status as "Scheduled"
Then Validate external id status as "4"
And User clicked on return to last user button
And Click on save exit button

And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When Click on Open New WorkIteam button 
When Select work item type "Full Transfer Out Liquidate"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
Given Establish connection with azure db and execute query to fetch data
When User update residual distribution table in azure db
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix
And Fetch b number from shell process page 
When Update internal status "In Process"
And click on Update OA button
And Select action type "Term-acct will not fund" 
And enter action value "submit"
When Click on save and close button on "createOAPage" page
And Click on one time distribution button
And enter one time distribution details
Then Validate one-time distribution status as "IWRComplete"
When Update internal status "In Process-Pending Settlement"
And User click on residual distribution button when status is "New"
And enter residual distribution details
And User click on iwr button on distribution button
Then Validate residual distribution status as "IWRComplete"
Given Establish connection with azure db and execute query to fetch data
Then Validate external id status as "7"
And Click on save exit button for rd

And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on one time distribution button
And QC user "notApprove" the record of one time distrbution
Then Validate one-time distribution status as "QCNotApproved"
When Click on residual distribution button for qc user
And QC user "notApprove" the record of residual distrbution
Then Validate residual distribution status as "QCNotApproved"
Then Validate external id status as "6"

Examples: 
		|SheetName    |RowNumber|
		|RD		        |6       |	
		
			
		
@C210004
Scenario Outline: C210004_Residual Distribution - Journal Update allocation
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Full Transfer Out Liquidate"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
Given Establish connection with azure db and execute query to fetch data
When User update residual distribution audit table in azure db
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix
And Fetch b number from shell process page 
When Update internal status "In Process"
And click on Update OA button
And Select action type "Term-acct will not fund" 
And enter action value "submit"
When Click on save and close button on "createOAPage" page
And Click on one time distribution button
And enter one time distribution details
Then Validate one-time distribution status as "IWRComplete"
When Update internal status "In Process-Pending Settlement"

And User click on residual distribution button when status is "New"
And User select delivery method as "Journal"
And enter residual distribution details
And User click on iwr button on distribution button
Then Validate one-time distribution status as "IWRComplete"
And Click on save exit button for rd

And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on one time distribution button
And QC user "notApprove" the record of one time distrbution
Then Validate one-time distribution status as "QCNotApproved"
When Click on residual distribution button for qc user
And QC user "notApprove" the record of residual distrbution
Then Validate residual distribution status as "QCNotApproved"
And User clicked on return to last user button
And Click on save exit button
And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And User click on residual distribution button when status is "QCNotApproved"
And User update the journal with account no "40026823"
Then Validate residual distribution status as "InProcess"

Examples: 
		|SheetName    |RowNumber|
		|RD		        |5       |		
		
		
		
		
		
		
		
		