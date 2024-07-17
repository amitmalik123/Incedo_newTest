@Regression			@ECON
Feature: WFI Regression- ECON

@C145310
Scenario Outline: C145310_Econ_BAW_When_no_check record linked to Workitem
Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
When Navigate to tracking center page
Given User should login to BAW application and click on the dashboard "viaeWM"
When Click on Open New WorkIteam button 
When Select work item type "Digital Check"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
When Fetch b number from shell process page
When Switch to respective tab with title "AssetMark"
And User search item by b number
Then Validate first note "not check"
When Switch to respective tab with title "Shell Process"
When Update internal status "In Process"
And Click on save & refresh button
When Switch to respective tab with title "AssetMark"
Then Validate first note "not check"

Examples: 
		|SheetName    |RowNumber|
		|Econ		      |3        |
		
		
@C169731
Scenario Outline: C169731_Econ_BAW_Digital Check
Given User should login to BAW application and click on the dashboard "directBAW"
When Click on Open New WorkIteam button
When Select work item type "Digital Check"
Then Enter Custodial Account value "<SheetName>" , <RowNumber>
And Select individual owner and click run now
Then Validate check details section
When Fetch b number from shell process page
And Click on add document, upload "pdfFilePath" document and validate
Then Validate "first" uploaded document
When Switch to respective tab with title "Shell Process"
When Click on create new digital record button
And Click on add update check details button
And enter check and allocation details
Then Validate added allocation
When User click on IWR Complete button
Then Validate added check details on shell page
When Update internal status "Complete"
And Click on save exit button
And Click on "Search Work Item" tab
And Enter external id and click on search button
Then Validate searched result "internal Status" for "In Process- Pending QC"
Given Baw qc user login using username "BAW.TestUser2" and password "Asset0419Mark!"
When User search via B tracking number "directBAW"
When User click on run icon and switch to "Shell Process" page
And Click on add update check details button
And User click on qc passed button
Given User should login to OWB application and go to homepage
When User click on "Check Management" tab
And User search B number
And User click on view button
And User select status and press save button
And User fetch check number
When User click on "Check Management" tab
And User click on deposit digital link
Then User validate check number
When User click on start batch button
And User perform mark deposit
And User search B number
Then User validate check status "DepositedToBank"

Examples: 
		|SheetName    |RowNumber|
		|Econ		      |2        |

		
		