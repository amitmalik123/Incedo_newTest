#@Regression				@TLH
Feature: WFI Regression - TLH

  #@C123160
  Scenario Outline: C123160_eWM - TLH Request - Complete and Submit - HNW account - Gains
    Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
    When User is on the accountWizard tab and Search and open a client
    Then Select a applicable HNW account and select the TLH option and do complete and print
    And verifying the Eligible cusip displayed on securities
    And opting for Harvest type "Gains"
    And Choosing "SelectTradeList" as Harvest amount type
    And clicking on "None" and accepting the Disclosures and click on finish button.
    And User navigates to docu sign page and clicks on Continue & Finish button
    And Fetch the tracking id and click on close button

    Examples: 
      | SheetName | RowNumber |
      | TLH       |         2 |

  #@C123161
  #Scenario Outline: C123161_eWM - TLH Request - Complete and Print - HNW account - Losses
    #Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
    #When User is on the accountWizard tab and Search and open a client
    #And Select a applicable HNW account and select the TLH option and do complete and Submit
    #And opt for client physical signature and Navigate to Harvest options
    #And verifying the Eligible cusip displayed on securities
    #And opting for Harvest type "Looses"
    #And Choosing "AddSpecificAmount" as Harvest amount type and entering "<valueabove100>"
    #And clicking on "InTheMarket" and accepting the Disclosures and click on finish button.
    #And User navigates to docu sign page and clicks on Continue & Finish button
    #Then Fetch the tracking id and click on close button
#
    #Examples: 
      #| SheetName | RowNumber | valueabove100 |
      #| TLH       |         6 |           123 |

  #@C123163
  Scenario Outline: C123163_eWM - TLH Request - Complete and eSign - non HNW - Losses - max available - in market
    Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
    When User is on the accountWizard tab and Search and open a client
    Then Select a applicable HNW account and select the TLH option and click Complete and Esign button
    And provide account details and opt for client physical signature and Navigate to Harvest options
    And opting for Harvest type "Looses"
    And Choosing "MaxLossesAvailable" as Harvest amount type
    And clicking on "InTheMarket" and accepting the Disclosures and click on finish button.
    And User navigates to docu sign page and clicks on Continue & Finish button
    And Fetch the tracking id and click on close button

    Examples: 
      | SheetName | RowNumber |
      | TLH       |         3 |

  #@C123164
  Scenario Outline: C123164_eWM - TLH Request - Complete and eSign - non HNW - Losses- select trade list - all trade - out of market
    Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
    When User is on the accountWizard tab and Search and open a client
    Then Select a applicable HNW account and select the TLH option and click Complete and Esign button
    And provide account details and opt for client physical signature and Navigate to Harvest options
    And opting for Harvest type "Looses"
    And Choosing "SelectTradeList_ALL" as Harvest amount type
    And clicking on "OutOfMarket" and accepting the Disclosures and click on finish button.
    And User navigates to docu sign page and clicks on Continue & Finish button
    And Fetch the tracking id and click on close button

    Examples: 
      | SheetName | RowNumber |
      | TLH       |         5 |

 # @C123162
  Scenario Outline: C123162_BAW - TLH Request - Approve Harvest Request
  Given Establish DB connection and execute the query to check citrix job status
    Given User should login to the application and impersonate into an agent "<SheetName>" , <RowNumber>
    When User is on the accountWizard tab and Search and open a client
    Then Select a applicable HNW account and select the TLH option and do complete and print
    And verifying the Eligible cusip displayed on securities
    And Choosing Harverst options and Navigating to DocuSign page and click on finish button
    And Fetch the tracking id and click on close button
    And User is on the tracking center page and click on tracking id
    And User upload the PDF file
    And User verify the tracking Id starts with B
    Given User should login to BAW application and click on the dashboard "viaeWM"
    And User search for the tracking id and select app id checkbox and click on run
    Then Validate the "Shell Process" page
    Then User should Approve Harvest Request
    And Establish DB connection and execute query to verify Approval Status.

    Examples: 
      | SheetName | RowNumber |
      | TLH       |         4 |

