@Regression    @toar
Feature: WFI Regression- TOAR

Background:
#Given Establish DB connection and execute the query to check citrix job status

@C206048     
Scenario Outline: C206048_TOAR Record
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Custodian Change Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item "Custodian Change Request" with "percentage" allocation in destination 
Then Validate transfer details added on shell page
And Validate notes history section "TOAR Record created successfully"

Examples: 
		|SheetName    |RowNumber|
		|TOAR		        |2        |	
		

@C206051     
Scenario Outline: C206051_TOAD Record
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Full Transfer Out In Kind"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item "Full Transfer Out In Kind" with "no" allocation in destination
And Validate notes history section "TOAD Record created successfully"

Examples: 
		|SheetName    |RowNumber|
		|TOAR		        |3        |		
		
		
@C208350   
Scenario Outline: C208350_Transfer In status- Audit table verification
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

Examples: 
		|SheetName    |RowNumber|
		|TOAR		        |4       |		
		
		
@C208352
Scenario Outline: C208352_Transfer Out status- Audit table verification
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

#And User should add request header parameters for "delete residual"
#And User should design request body for "delete residual"
#And User should hit the request and get the response for "delete residual"
#Then User should verify status code 200

And Fetch b number from shell process page 
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item "Full Transfer Out In Kind" with "no" allocation in destination  
Then Validate transfer details added on shell page
And Validate notes history section "TOAD Record created successfully"
Given Establish connection with azure db and execute query to fetch data
Then Validate external id status as "2"

When Update internal status "In Process"
And click on Update OA button
And Select action type "Term-acct will not fund" 
And enter action value "submit"
#Then Validate added OA details on create OA page "submit"
When Click on save and close button on "createOAPage" page
#When Switch to respective tab with title "Shell Process"
And Click on one time distribution button
And enter one time distribution details
Then Validate one-time distribution status as "IWRComplete"

And User click on residual distribution button when status is "New"
And User click on iwr button on distribution button
#And Validate notes history section "Residual distribution instructions committed"

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
#And Validate notes history section "Residual distribution instructions"
And User clicked on return to last user button
And Click on save exit button
Then Validate external id status as "3"
And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And User clicks on ready for submission
Then Validate transfer details status as "ReadyForSubmissionPendingQC"
And User clicked on return to last user button
And Click on save exit button
Then Validate external id status as "6"
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And QC user approve the record
Then Validate transfer details status as "QCApprovedSecondPass"
Then Validate external id status as "8"
And User clicked on return to last user button
And Click on save exit button
And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And User clicks on submission complete
Then Validate transfer details status as "Submitted"
Then Validate external id status as "10"

Examples: 
		|SheetName    |RowNumber|
		|TOAR		        |5       |		
		
		
@C209989    
Scenario: C209989_TOAR Record - Inflight work item
Given User should login to BAW application and click on the dashboard "directBAW"
Then User search "transfer" b number "B096078369" and validate	
And Click on update transfer button
Then Validate checklist section when transfer status is "inflight"
	
@C209990    
Scenario: C209990_TOAD Record - Inflight work item
Given User should login to BAW application and click on the dashboard "directBAW"
Then User search "transfer" b number "B096083226" and validate	
And Click on update transfer button
Then Validate checklist section when transfer status is "inflight"

