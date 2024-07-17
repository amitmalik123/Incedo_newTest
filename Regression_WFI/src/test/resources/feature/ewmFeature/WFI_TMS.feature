@Regression    @tms
Feature: WFI Regression- TMS

Background:
Given Establish DB connection and execute the query to check citrix job status

@C192563  @newAccount
Scenario Outline: C192563_eMW-TMS enrolled new account esign with 1 SSA & 2 MSA account
#Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
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
When User navigate to Account information tab and click on tax management services button
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
#When Switch to respective tab with title "Shell Process"
And Click on "select" button under account number association
Then Validate added account number and account name
And Click on save exit button
When Switch to respective tab with title "NAA Coach"
Then User validate "P" letter display under acc and beta
When User add new work item "New Account Tax Management"
And User clicks on "New Account Tax Management" b number open button
When Switch to respective tab with title "Shell Process"
And Click on "add" button under account number association
#Then Validate added account number and account name
And Click on save exit button
When Switch to respective tab with title "NAA Coach"
When User does the activate account
Then User validate "A" letter display under acc and beta

Examples: 
		|SheetName    |RowNumber|
		|TMS	        |2        |	
		
		
@C192411   @C192412   @ict
Scenario Outline: eWM-TMS one to one with "<InvestmentType>" investment
#Given User login to the application "<SheetName>" , <RowNumber>
Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
When User should click on clients tab and navigate to account list page
And User is on the accountlist tab and search with the accountNo
And User should click on searched account and navigate to account wizard page
And Click on client management option "Change Investments"
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix
Then Establish DB connection and update "model change" in citrix
And Click on account number and navigate to investment selection tab
Then Validate Account Number On Destination Investment Tab
When Select new investment on destination investment tab
Then Validate New Investment Modal
When Search and Select Investment Solution on destination investment tab 1
When Select "<InvestmentType>" amount in destination investment tab
When Click on next button
#And Select assign new account number
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
Then Validate added note in description "SUCCESS"

Examples: 
		|SheetName    |RowNumber|   InvestmentType  |
		|TMS          |3        |		100 percentage  |
		|TMS          |4        |		partial  				|
		
	
@C192413  @C192424 @ict
Scenario Outline: eWM-TMS one to many for "<DestinationType>"
Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
When User should click on clients tab and navigate to account list page
And User is on the accountlist tab and search with the accountNo
And User should click on searched account and navigate to account wizard page
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
When Select new investment on destination investment tab
Then Validate New Investment Modal
When Search and Select Investment Solution on destination investment tab 2
And User select all remaining investment checkbox
When Click on next button
And User clicks destination account with "<DestinationType>" option 
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
Then Validate added note in description "SUCCESS"

Examples: 
		|SheetName    |RowNumber|   DestinationType  |
		|TMS          |5        |		new          |
		|TMS          |6        |		Retain          |
		
		
@C192414  @C192429 @ict
Scenario Outline: eWM-TMS Many to One with "<elig>" model
Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
When User should click on clients tab and navigate to account list page
And User is on the accountlist tab and search with the accountNo
And User should click on searched account and navigate to account wizard page
And Click on client management option "Change Investments"
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix
Then Establish DB connection and update "model change" in citrix
And Select "multiple" source account and navigate to investment selection tab
Then Validate Account Number On Destination Investment Tab
When Select new investment on destination investment tab
Then Validate New Investment Modal
When Search and Select Investment Solution on destination investment tab 1
When Select "100 percentage" amount in destination investment tab
When Click on next button
And User clicks destination account with "<DestinationType>" option 
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
Then Validate added note in description "SUCCESS"

Examples: 
		|SheetName    |RowNumber|    DestinationType  |   elig  |
		|TMS          |7        |		Retain 					|		eligible	|
		|TMS          |8        |		Retain					|		ineligible	|


@C192416 @ict
Scenario Outline: C192416_eWM-TMS many to many with existing account
Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
When User should click on clients tab and navigate to account list page
And User is on the accountlist tab and search with the accountNo
And User should click on searched account and navigate to account wizard page
And Click on client management option "Change Investments"
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix
Then Establish DB connection and update "model change" in citrix
And Select "multiple" source account and navigate to investment selection tab
Then Validate Account Number On Destination Investment Tab
When Select existing investment with "multiple" account on destination investment tab
When Select "100 percentage" amount in destination investment tab
When Click on next button
#And User clicks destination account with "<DestinationType>" option 
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
Then Validate added note in description "SUCCESS"

Examples: 
		|SheetName    |RowNumber|  
		|TMS          |9        |		


@C192417 @ict
Scenario Outline: C192417_eWM-TMS many to many with New Retain account
Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
When User should click on clients tab and navigate to account list page
And User is on the accountlist tab and search with the accountNo
And User should click on searched account and navigate to account wizard page
And Click on client management option "Change Investments"
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix
Then Establish DB connection and update "model change" in citrix
And Select "multiple" source account and navigate to investment selection tab
Then Validate Account Number On Destination Investment Tab
When Select new investment on destination investment tab
Then Validate New Investment Modal
When Search and Select Investment Solution on destination investment tab 1
When Select "partial" amount in destination investment tab
When Select new investment on destination investment tab
Then Validate New Investment Modal
When Search and Select Investment Solution on destination investment tab 2
And User select all remaining investment checkbox
When Click on next button
#And User clicks destination account with "<DestinationType>" option 
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
Then Validate added note in description "SUCCESS"

Examples: 
		|SheetName    |RowNumber|    DestinationType  |
		|TMS          |10        |		Retain 					|
		

@C192433 @ict
Scenario Outline: C192433_eWM-TMS Cancel form
Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
When User should click on clients tab and navigate to account list page
And User is on the accountlist tab and search with the accountNo
And User should click on searched account and navigate to account wizard page
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
And User fetch account number from retain account number section
Then Validate the "Account Number" tab
And Validate "suitability" tab and navigate to account features tab
Then Validate the "Account Features" tab
Then Validate the "Fees" tab
Then Validate the "Summary" tab
#And Validate cancel tms form is present
When User clicks on complete and print button
Then User navigates to docu sign page and clicks on Continue & Finish button
And Fetch the tracking id and click on close button
And User upload the PDF file
And User verify the tracking Id starts with B
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Shell Process" page
#Then Validate notes history section "Change Request Form"
Then Validate retained account number
Then Validate "ICT Activation" alert
Then Validate modal change or OA has been created on shell page "ICT_Activation"
Then Validate added note in description "SUCCESS"

Examples: 
		|SheetName    |RowNumber|   
		|TMS          |11        |	


@C192434 @192435  @C192996 @oam
Scenario Outline: OAM_TMS- Enroll,update and canacl with cash and securities Restriction - Complete and submit
Given User login to the application "<SheetName>" , <RowNumber>
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix
Then Establish DB connection and update "model change" in citrix
Then Establish DB connection and update "tms id" in citrix
When User should click on clients tab and navigate to account list page
And User is on the accountlist tab and search with the accountNo
And User should click on searched account and navigate to account wizard page
And Select request and type in Account Management
When User clicks on complete and submit button and click on complete button on client signature button
And User fill all tms data to enroll
And User does the esign
And Fetch the tracking id and click on close button
#And User upload the PDF file
And User verify the tracking Id starts with B
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Shell Process" page
#Then Validate notes history section "Cancel Tax Management Enrollment"
Then Validate "tms activation" alert
Then Validate modal change or OA has been created on shell page "Restriction"
Then Validate added note in description "Tax Management activated"
When Switch to respective tab with title "Assetmark"
#modify
And User closes windows except current window
When User should click on clients tab and navigate to account list page
And User is on the accountlist tab and search with the accountNo
And User should click on searched account and navigate to account wizard page
And Select request and "<type1>" in Account Management
When User clicks on complete and print button to navigate to tms
And User modify tms data
And User does the esign
And Fetch the tracking id and click on close button
And User upload the PDF file
And User verify the tracking Id starts with B
When User wait for 1 min
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Shell Process" page
Then Validate "tms activation" alert
Then Validate modal change or OA has been created on shell page "Cancel Restriction"
Then Validate added note in description "Tax Management updated"
When Switch to respective tab with title "Assetmark"
#Cancel
And User closes windows except current window
When User should click on clients tab and navigate to account list page
And User is on the accountlist tab and search with the accountNo
And User should click on searched account and navigate to account wizard page
And Select request and "<type2>" in Account Management
When User clicks on complete and print button to navigate to tms
And User cancel tms enrollment
And User does the esign
And Fetch the tracking id and click on close button
And User upload the PDF file
And User verify the tracking Id starts with B
Given User should login to BAW application and click on the dashboard "viaeWM"
When User search via B tracking number "viaeWM"
And User click on run icon and switch to "Shell Process" page
Then Validate "tms activation" alert
Then Validate added note in description "Tax Management removed"
Then User validate OA has deleted
Then Establish DB connection and update "tms id" in citrix

Examples: 
		|SheetName    |RowNumber|   type1  																	|    type2  |
		|TMS          |12       |	Modify Tax Management Services Settings   |  Cancel Tax Management Services and Add Cash Restriction   |


@C192426  @C192430   @192431  @auu
Scenario Outline: eWM-TMS Enroll, update and unenroll
Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
Then Establish DB connection and update "request status" in citrix
Then Establish DB connection and update "completionDate" in citrix
Then Establish DB connection and update "model change" in citrix
Then Establish DB connection and update "tms id" in citrix
When User should click on clients tab and navigate to account list page
And User is on the accountlist tab and search with the accountNo
And User should click on searched account and navigate to account wizard page
And Select request and type in Account Management
When User clicks on complete and submit button and click on complete button on client signature button
And User fill all tms data to enroll
And User does the esign
And Fetch the tracking id and click on close button
#And User upload the PDF file
#And User verify the tracking Id starts with B
And Establish BPM DB connection and execute the query and fetch column "taxManagementId" data
Given User should login to BAW application and click on the dashboard "viaeWM"
When Click on "Account Update Utility" tab
When User search with accountNo
And User "enroll" tax management section
Then Validate "tax management activated" confirmation message
When Switch to respective tab with title "Assetmark"

#modify
#And User closes windows except current window
When User should click on clients tab and navigate to account list page
And User is on the accountlist tab and search with the accountNo
And User should click on searched account and navigate to account wizard page
And Select request and "<type1>" in Account Management
When User clicks on complete and print button to navigate to tms
And User modify tms data
And User does the esign
And Fetch the tracking id and click on close button
And Establish BPM DB connection and execute the query and fetch column "taxManagementId" data
When Switch to respective tab with title "Process Portal"
When Click on "Account Update Utility" tab
When User search with accountNo
And User "update" tax management section
Then Validate "tax management updated" confirmation message
When Switch to respective tab with title "Assetmark"

#cancel
#And User closes windows except current window
When User should click on clients tab and navigate to account list page
And User is on the accountlist tab and search with the accountNo
And User should click on searched account and navigate to account wizard page
And Select request and "<type2>" in Account Management
When User clicks on complete and print button to navigate to tms
And User cancel tms enrollment
And User does the esign
And Fetch the tracking id and click on close button
And Establish BPM DB connection and execute the query and fetch column "taxManagementId" data
When Switch to respective tab with title "Process Portal"
When Click on "Account Update Utility" tab
When User search with accountNo
And User "unenroll" tax management section
Then Validate "tax management removed" confirmation message
Then Establish DB connection and update "tms id" in citrix

Examples: 
		|SheetName    |RowNumber|     type1  																	|    type2  |
		|TMS          |13       |	Modify Tax Management Services Settings   |  Cancel Tax Management Services and Add Cash Restriction   |


@C206880
Scenario Outline: C206880_BAW-Account update utility-Account Update Details section
Given User login to the application "<SheetName>" , <RowNumber>
Given User should login to BAW application and click on the dashboard "viaeWM"
When Click on "Account Update Utility" tab
When User search with accountNo
Then enter and validate funding account number

Examples: 
		|SheetName    |RowNumber|    
		|TMS          |14       |
		
		