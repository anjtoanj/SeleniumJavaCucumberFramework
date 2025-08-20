Feature: Parabank Homepage Tests
  As a Test Engineer
  I want to verify if the website works in all browsers

  @edge
  Scenario: Verify logo is displayed
    Given I open the Parabank homepage
    Then the logo should be visible

  @chrome
  Scenario: Verify logo is displayed
    Given I open the Parabank homepage
    Then the logo should be visible
