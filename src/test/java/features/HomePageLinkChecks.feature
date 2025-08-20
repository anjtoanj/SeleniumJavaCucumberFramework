Feature: Parabank Homepage Tests
  As a Test Engineer
  I want to validate all the links in the home page

  Scenario: Verify all the links under ATM Services
    Given I open the Parabank homepage
    When I cick on Withdraw Services
    Then should go to a SOAPUI page

  Scenario: Verify all the links under Transfer funds
    Given I open the Parabank homepage
    When I cick on Transfer Funds
    Then should go to a SOAPUI page
