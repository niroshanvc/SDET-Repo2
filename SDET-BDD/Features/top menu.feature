@Regression
Feature: Test top menu of the HCLTech website
 

  @TestTopMenu
  Scenario: Test top menu of the HCLTech website
    Given I want to navigate to the HCLTech website
    Then I want to get the total count of menu items
    And I want to display the Sub Menus with their corresponding Main Menu in the console

  
