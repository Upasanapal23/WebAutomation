Feature: Login Functionality
  As a user, I want to log in to the Demo Web Shop to access my account.

  Scenario: Successful login with valid credentials
    Given I am on the Demo Web Shop homepage
    When I navigate to the login page
    And I enter valid login credentials
    Then I should be redirected to the homepage

  Scenario: Failed login with invalid credentials
    Given I am on the Demo Web Shop homepage
    When I navigate to the login page
    And I enter invalid login credentials
    Then I should see an error message