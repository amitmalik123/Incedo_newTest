@Regression    @tobiE2E
Feature: WFI Regression- TOBI_E2E


@C206037   @C206036  @C206038
Scenario Outline: Delivery Method- "<Type>"
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
#And User should verify the response body to confirm success

#And Click on update transfer button
#And enter transfer details for work item "Full Transfer Out In Kind" with "no" allocation in destination
#Then Validate transfer details added on shell page
#And Validate notes history section "TOAD Record created successfully"

When Update internal status "In Process"
And Fetch b number from shell process page
And click on Update OA button
And Select action type "Term-acct will not fund" 
And enter action value "submit"
Then Validate added OA details on create OA page "submit"
When Click on save and close button on "createOAPage" page
#When Switch to respective tab with title "Shell Process"
And Click on one time distribution button
And enter one time distribution details
Then Validate one-time distribution status as "IWRComplete"
#And User click on residual distribution button
#And User click on iwr button on distribution button

#And Validate notes history section "Residual distribution instructions committed"
When Update internal status "In Process-Pending Settlement"
And Click on save exit button for rd
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
#And Click on update transfer button
#And QC user approve the record
#And Validate notes history section "Distribution request initiated"
And Click on one time distribution button
And QC user "approve" the record of one time distrbution
Then Validate notes history section "Distribution request initiated"
Then Validate one-time distribution status as "Initiated"

#And User click on residual distribution button
#And QC user "approve" the record on distrbution page



Examples: 
		|SheetName    |RowNumber|    Type   |
		|TOBI_E2E	    |2        |  	 WIRE		|
		|TOBI_E2E	    |3        |		Check		|
		|TOBI_E2E	    |4        |		ACH 		|
		

@C206039
Scenario Outline: C206039_One Time Distribution -eWM- Tracking Center
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

When Update internal status "In Process"
And Fetch b number from shell process page
And Fetch advisor aplid from shell process page
And click on Update OA button
And Select action type "Term-acct will not fund" 
And enter action value "submit"
Then Validate added OA details on create OA page "submit"
When Click on save and close button on "createOAPage" page
And Click on one time distribution button
And enter one time distribution details
Then Validate one-time distribution status as "IWRComplete"

When Update internal status "In Process-Pending Settlement"
And Click on save exit button for rd
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on one time distribution button
And QC user "approve" the record of one time distrbution
Then Validate notes history section "Distribution request initiated"
Then Validate one-time distribution status as "Initiated"

Given User login to ewm and impersonate to "Agent"
When Navigate to tracking center page
And User search item by b number
#Then Validate transfer details added on item details page
And Validate distribution details on item details page

Examples: 
		|SheetName    |RowNumber|   
		|TOBI_E2E	    |5        |		


@C207858
Scenario Outline: C207858_One Time Distribution - Audit table verification
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Full Transfer Out Liquidate"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
Given Establish connection with azure db and execute query to fetch data
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix

When User should generate bearer token
And User should add request header parameters for "delete distribution"
And User should design request body for "delete distribution"
And User should hit the request and get the response for "delete distribution"
Then User should verify status code 200

When Update internal status "In Process"
And Fetch b number from shell process page
And Fetch advisor aplid from shell process page
And click on Update OA button
And Select action type "Term-acct will not fund" 
And enter action value "submit"
#Then Validate added OA details on create OA page "submit"
When Click on save and close button on "createOAPage" page

And Click on one time distribution button
And enter one time distribution details
Then Validate one-time distribution status as "IWRComplete"
#Then Validate transfer audit status as "7"
When Update internal status "In Process-Pending Settlement"
And Click on save exit button for rd
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on one time distribution button
And QC user "approve" the record of one time distrbution
Then Validate notes history section "Distribution request initiated"
Then Validate one-time distribution status as "Initiated"
#Then Validate transfer audit status as "4"
#And User clicked on return to last user button
And Click on save exit button

And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When Click on Open New WorkIteam button 
When Select work item type "Full Transfer Out Liquidate"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
Given Establish connection with azure db and execute query to fetch data
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix

When User should generate bearer token
And User should add request header parameters for "delete distribution"
And User should design request body for "delete distribution"
And User should hit the request and get the response for "delete distribution"
Then User should verify status code 200

When Update internal status "In Process"
And Fetch b number from shell process page
And Fetch advisor aplid from shell process page
And click on Update OA button
And Select action type "Term-acct will not fund" 
And enter action value "submit"
#Then Validate added OA details on create OA page "submit"
When Click on save and close button on "createOAPage" page

And Click on one time distribution button
And enter one time distribution details
Then Validate one-time distribution status as "IWRComplete"
#Then Validate transfer audit status as "7"
When Update internal status "In Process-Pending Settlement"
And Click on save exit button for rd
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on one time distribution button
And QC user "notApprove" the record of one time distrbution
Then Validate one-time distribution status as "QCNotApproved"

#Then Validate transfer audit status as "6"

Examples: 
		|SheetName    |RowNumber|   
		|TOBI_E2E	    |6        |	
		
		
#@C209988
#Scenario Outline: C209988_One Time Distribution - Inflight work item
#Given User should login to BAW application and click on the dashboard "directBAW"
#When Click on Open New WorkIteam button 
#When Select work item type "Full Transfer Out Liquidate"
#Then Enter Custodial Account value "<SheetName>" , <RowNumber>
#When Switch to respective tab with title "Process Portal"
#When User closes windows except current window
#Then Validate the frame and switch to it on "bawDashboardPage" page
#
#Then Establish DB connection and update "request status" in citrix
#Then Establish DB connection and update "completionDate" in citrix
#
#When User should generate bearer token
#And User should add request header parameters for "delete distribution"
#And User should design request body for "delete distribution"
#And User should hit the request and get the response for "delete distribution"
#Then User should verify status code 200
#
#Then User search "distribution" b number "B096151946" and validate	
#When Update internal status "In Process"
#And Fetch b number from shell process page
#And click on Update OA button
#And Select action type "Term-acct will not fund" 
#And enter action value "submit"
#When Click on save and close button on "createOAPage" page
#And Click on one time distribution button
#And enter one time distribution details
#Then Validate one-time distribution status as "IWRComplete"
#
#When Update internal status "In Process-Pending Settlement"
#And Click on save exit button for rd
#And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
#When User search via B tracking number "directBAW"
#When User click on run icon and switch to "Shell Process" page
#And Click on one time distribution button
#And QC user "approve" the record on distrbution page
#Then Validate notes history section "Distribution request initiated"
#Then Validate one-time distribution status as "Initiated"
#
#Examples: 
#		|SheetName    |RowNumber|   
#		|TOBI_E2E	    |7        |	
