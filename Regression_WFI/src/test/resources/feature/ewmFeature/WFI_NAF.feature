@Regression    @NAF
Feature: WFI Regression- NAF 		

@C193231
Scenario Outline: C193231_[BAW]-NAF-Cash movement
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Transfer In Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
And Fetch b number from shell process page 
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item "Transfer In Request" with "percentage" allocation in destination  
Then Validate transfer details added on shell page
And Validate notes history section "Funding account"
And User fetched funding account
When Update internal status "In Process- Pending Submission"  
And Click on save exit button
And Click on "Search Work Item" tab
And Enter external id and click on search button
Then Validate searched result "internal Status" for "In Process- Pending QC"

And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And QC user approve the record
Then Validate transfer details status as "QCApprovedFirstPass"
And User clicked on return to last user button
And Click on save exit button
And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And User clicks on submission complete
Then Validate transfer details status as "SubmittedPendingQC"
And User clicked on return to last user button
And Click on save exit button
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And QC user approve the record
Then Validate transfer details status as "Submitted"
And User clicked on return to last user button
And Click on save exit button

When User should generate bearer token
And User should add request header parameters for "CreateJournalEntry"
And User should design request body for "CreateJournalEntry"
And User should hit the request and get the response for "CreateJournalEntry"
Then User should verify status code 200

And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
When Update internal status "In Process - Pending Receipt and Allocation"  
And Click on save exit button

Examples: 
		|SheetName    |RowNumber|
		|NAF		      |2       |		


		
@C193232   @C193266   
Scenario Outline: [BAW]-NAF-Asset movement with "<option>" securities
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Transfer In Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
And Fetch b number from shell process page 
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item "Transfer In Request" with "percentage" allocation in destination  
Then Validate transfer details added on shell page
And Validate notes history section "Funding account"
And User fetched funding account
When Update internal status "In Process- Pending Submission"  
And Click on save exit button
And Click on "Search Work Item" tab
And Enter external id and click on search button
Then Validate searched result "internal Status" for "In Process- Pending QC"

And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And QC user approve the record
Then Validate transfer details status as "QCApprovedFirstPass"
And User clicked on return to last user button
And Click on save exit button
And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And User clicks on submission complete
Then Validate transfer details status as "SubmittedPendingQC"
And User clicked on return to last user button
And Click on save exit button
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And QC user approve the record
Then Validate transfer details status as "Submitted"
And User clicked on return to last user button
And Click on save exit button

When User should generate bearer token
And User should add request header parameters for "CreateShareEntry"
And User should design request body for "<securityCount>"
And User should hit the request and get the response for "CreateShareEntry"
Then User should verify status code 200

And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
When Update internal status "In Process - Pending Receipt and Allocation"  
And Click on save exit button

Examples: 
		|SheetName    |RowNumber|    option    |    securityCount   |
		|NAF	        |3        |		one				|			CreateShareEntry  |
		|NAF	        |4        |		many				|		CreateMultipleShareEntry   |

		
@C208337
Scenario Outline: C208337_[BAW]-NAF-Asset movement - Audit table Verification
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Transfer In Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
Given Establish connection with azure db and execute query to fetch data
And Select individual owner and click run now
And Fetch b number from shell process page 
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item "Transfer In Request" with "percentage" allocation in destination  
Then Validate transfer details added on shell page
And Validate notes history section "Funding account"
And User fetched funding account
When Update internal status "In Process- Pending Submission"  
And Click on save exit button
And Click on "Search Work Item" tab
And Enter external id and click on search button
Then Validate searched result "internal Status" for "In Process- Pending QC"

And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And QC user approve the record
Then Validate transfer details status as "QCApprovedFirstPass"
And User clicked on return to last user button
And Click on save exit button
And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And User clicks on submission complete
Then Validate transfer details status as "SubmittedPendingQC"
And User clicked on return to last user button
And Click on save exit button
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And QC user approve the record
Then Validate transfer details status as "Submitted"
And User clicked on return to last user button
And Click on save exit button

When User should generate bearer token
And User should add request header parameters for "CreateShareEntry"
And User should design request body for "CreateShareEntry"
And User should hit the request and get the response for "CreateShareEntry"
Then User should verify status code 200

And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
When Update internal status "In Process - Pending Receipt and Allocation"  
And Click on save exit button

#Then Validate transfer audit status as "5"

Examples: 
		|SheetName    |RowNumber|
		|NAF	        |5        |	


@C196202	
Scenario Outline: C196202_[BAW]-Parent/Child-End to End scenario
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
#Given Establish connection with azure db and execute query to fetch data
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
When User select CIP value "Exception Granted" and save client
And User clicks on "New Account Application" b number open button
And Click on "select" button under account number association
Then Validate added account number and account name
And Click on save exit button
When Switch to respective tab with title "NAA Coach"
When User add new work item "New Account Transfer In"
And User clicks on "New Account Transfer In" b number open button
When Click on add button under account number association
And Click on save exit button
When Switch to respective tab with title "NAA Coach"
Then User validate "P" letter display under acc and beta
When User does the activate account
Then User validate "A" letter display under acc and beta
And User clicks on "New Account Transfer In" b number open button
And Click on update transfer button
And enter transfer details for work item "Transfer In Request" with "percentage" allocation in destination
And Fetch b number from shell process page   
And Validate notes history section "Funding account"
And User fetched funding account
When Update internal status "In Process- Pending Submission"
And Click on save exit button
And User clicks on save and exit button
When User closes windows except current window
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
And User fetch parent b number from shell process page
And Click on save exit button
And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "NAA Coach" page
And User clicks on "New Account Transfer In" b number open button
And Click on update transfer button
And User clicks on submission complete
And User clicked on return to last user button
And Fetch b number from shell process page  
And Click on save exit button
And User clicks on save and exit button 
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And QC user approve the record
And User clicked on return to last user button
And User fetch parent b number from shell process page
And Click on save exit button

When User should generate bearer token
And User should add request header parameters for "CreateShareEntry"
And User should design request body for "CreateShareEntry"
And User should hit the request and get the response for "CreateShareEntry"
Then User should verify status code 200

And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
When Update internal status "In Process - Pending Receipt and Allocation"  

Examples: 
		|SheetName    |RowNumber|
		|NAF          |6        |			
		
		
		
@C206034   @1
Scenario Outline: C206034_[OWB]-Transfer Coach - Clearing firm with name longer than 30 characters
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Transfer In Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
When Update internal status "In Process- Pending Submission"
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item "Transfer In Request" with "percentage" allocation in destination
And Validate notes history section "Funding account"
Then Validate transfer details added on shell page

Examples: 
		|SheetName    |RowNumber|
		|NAF	        |7        |	
		

@C213218    @1
Scenario Outline: C213218_[BAW]-NAF-Create Checklist
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Transfer In Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item
And enter destination accounts details
Then User validate checklist update options
And User validate all checklist options are selected or not

Examples: 
		|SheetName    |RowNumber|
		|NAF	        |8        |
		
		
@C213225			@1
Scenario Outline: C213225_[BAW]-NAF- Create Fidelity Transfer Form
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Transfer In Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
When Update internal status "In Process- Pending Submission"
And Fetch b number from shell process page 
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item
And enter destination accounts details
And User clicks on IWR button  
And Click on save exit button
And Click on "Search Work Item" tab
And Enter external id and click on search button
Then Validate searched result "internal Status" for "In Process- Pending QC"
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And QC user approve the record
And User clicked on return to last user button
And Click on save exit button
And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And User click on transfer fidelity form
Then User verify form is downloaded
When Remove downloaded file

Examples: 
		|SheetName    |RowNumber|
		|NAF	        |9        |
		
		
@C213221			@1
Scenario Outline: C213221_[BAW]-NAF- Modify Checklist- Cash
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Transfer In Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
When Update internal status "In Process- Pending Submission"
And Fetch b number from shell process page 
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item
And enter destination accounts details 
And User clicks on create checklist button
And User validate all checklist options are selected or not
And User clicks on IWR button  
And Click on save exit button
And Click on "Search Work Item" tab
And Enter external id and click on search button
Then Validate searched result "internal Status" for "In Process- Pending QC"
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And QC user approve the record
And User clicked on return to last user button
And Click on save exit button
And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And User clicks on update checklist button
And User switch transfer type to "InKind"
Then User validate checklist response after switch

Examples: 
		|SheetName    |RowNumber|
		|NAF	        |10       |
		
		
@C213415     @1
Scenario Outline: C213415_[BAW]-NAF- Modify Checklist- InKind
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Transfer In Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
When Update internal status "In Process- Pending Submission"
And Fetch b number from shell process page 
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item "Transfer In Request" with "percentage" allocation in destination 
And Validate notes history section "Funding account"
And Click on save exit button
And Click on "Search Work Item" tab
And Enter external id and click on search button
Then Validate searched result "internal Status" for "In Process- Pending QC"
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And QC user approve the record
And User clicked on return to last user button
And Click on save exit button
And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And User clicks on update checklist button
And User remove funding account

Examples: 
		|SheetName    |RowNumber|
		|NAF	        |11       |
		
		
@C213420    @1
Scenario Outline: C213420_[BAW]-NAF-Modify Checklist - Cash - Switch between "Mail" to "Fax"
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Transfer In Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
When Update internal status "In Process- Pending Submission"
And Fetch b number from shell process page 
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item
And enter destination accounts details 
And User clicks on create checklist button
And User validate all checklist options are selected or not
And User clicks on IWR button  
And Click on save exit button
And Click on "Search Work Item" tab
And Enter external id and click on search button
Then Validate searched result "internal Status" for "In Process- Pending QC"
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And QC user approve the record
And User clicked on return to last user button
And Click on save exit button
And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And User clicks on update checklist button
And User switch delivery method to "Fax"
Then User validate delivery method after switch

Examples: 
		|SheetName    |RowNumber|
		|NAF	        |12       |
		
		
@C213224    @1
Scenario Outline: C213224_[BAW]-NAF-Use/Complete Checklist
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Transfer In Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
When Update internal status "In Process- Pending Submission"
And Fetch b number from shell process page 
Then Validate transfer firm details section
And Click on update transfer button
And enter transfer details for work item
And enter destination accounts details
And User clicks on create checklist button
And User validate all checklist options are selected or not
And User clicks on IWR button  
And Click on save exit button
And Click on "Search Work Item" tab
And Enter external id and click on search button
Then Validate searched result "internal Status" for "In Process- Pending QC"
And Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And QC user approve the record
And User clicked on return to last user button
And Click on save exit button
And Baw qc user login using username "ishan.mehta" and password "Vighnharta@2021"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on update transfer button
And User clicks on update checklist button
Then Validate error message on submission "Please review and complete the Submission Checklist"

Examples: 
		|SheetName    |RowNumber|
		|NAF	        |13       |
		
		
		
@C213223   @1
Scenario Outline: C213223_[BAW]-NAF-Inflight Checklist work item
Given User should login to BAW application and click on the dashboard "directBAW"
Then User search "transfer" b number "B096117636" and validate	
And Click on update transfer button
Then Validate checklist section when transfer status is "inflight"

Examples: 
		|SheetName    |RowNumber|
		|NAF	        |14       |
		
		
@C206044   @1 
Scenario Outline: C206044_[OWB] - Contra Firm - Add New Contra Firm
Given User should login to OWB application and go to homepage
When User click on "Contra Firms" tab
And User enter firm details and money in sections
And User expand tab "Submission"
And User update submission methods
And User expand tab "Follow"
And User enter follow up section details
And User expand tab "Out"
And User enter money out section details
And User search "" firm and click on "Update Firm Details"
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Transfer In Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
Then Validate transfer firm details section
And Click on update transfer button
And User select transfer type to "InKind"
Then Validate created contra firm on transfer page
When Switch to respective tab with title "Process Portal"
When User closes windows except current window
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
Then Validate created contra firm on funding page

Examples: 
		|SheetName    |RowNumber|
		|NAF	        |15       |
		
		
@C206045   @1
Scenario: C206045_[OWB] - Contra Firm - Update Contra Firm details
Given User should login to OWB application and go to homepage
When User click on "Contra Firms" tab
And User search "Test_SampleFirm_DoNotUpdateMe" firm and click on "Update Firm Details"
Then User validate clearing firm visibility
And User expand tab "Submission"
Then User validate money in submission tab
And User expand tab "Follow"
Then User validate money in follow up tab
		
		
@C206046    @1
Scenario Outline: C206046_[OWB] - Contra Firm - Update Instructions for Contra Firm
Given User should login to OWB application and go to homepage
When User click on "Contra Firms" tab
And User enter firm details and money in sections
And User expand tab "Submission"
And User update submission methods
And User expand tab "Follow"
And User enter follow up section details
And User expand tab "Out"
And User enter money out section details
And User search "" firm and click on "Update Instructions"
And User select transfer form instructions of criteria "TIK"
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
Then Validate created contra firm on funding page
And User enters all transfer information on funding page
Then User click on online access document delivery button
When User navigates to online access document delivery tab and click on review all accounts button
Then User navigates to review all accounts tab and click on create documents button
Then User click on create documents button
When User clicks on Separate Documents and validate "transfer" instructions

Examples: 
		|SheetName    |RowNumber|
		|NAF	        |16       |
		
		
@C206053			@1
Scenario Outline: C206053_[OWB] - Contra Firm - Update Instructions for Contra Firm with Liquidate
Given User should login to OWB application and go to homepage
When User click on "Contra Firms" tab
And User enter firm details and money in sections
And User expand tab "Submission"
And User update submission methods
And User expand tab "Follow"
And User enter follow up section details
And User expand tab "Out"
And User enter money out section details
And User search "" firm and click on "Update Instructions"
And User select transfer form instructions of criteria "TIK"
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
Then Validate created contra firm on funding page
And User enters all transfer information on funding page
Then User click on online access document delivery button
When User navigates to online access document delivery tab and click on review all accounts button
Then User navigates to review all accounts tab and click on create documents button
Then User click on create documents button
When User clicks on Separate Documents and validate "liquidate" instructions

Examples: 
		|SheetName    |RowNumber|
		|NAF	        |17       |		
		
		
@C206047			@1
Scenario Outline: C206047_[OWB] - Transfer in-kind & Cash
Given User should login to OWB application and go to homepage
When User click on "Contra Firms" tab
And User enter firm details and money in sections
And User expand tab "Submission"
And User update submission methods
And User expand tab "Follow"
And User enter follow up section details
And User expand tab "Out"
And User enter money out section details
And User search "" firm and click on "Update Firm Details"
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button 
When Select work item type "Transfer In Request"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
Then Validate transfer firm details section
And Click on update transfer button
And User select transfer type to "InKind"
Then Validate created contra firm on transfer page
Then Validate contra firm submission section for "InKind"
And User select transfer type to "Cash"
Then Validate contra firm submission section for "Cash"

Examples: 
		|SheetName    |RowNumber|
		|NAF	        |18       |		
		
		
		
		
		
		
		
		
		
		
		
		