 Feature: Login to HRM Application
# This feature file tests the login functionality of the HRM application.

  Background:
    # Precondition: Navigate to the HRM login page before executing scenarios.
    Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/"

  @ValidCredentials
  Scenario: Login with valid credentials
    # Scenario to test login with valid username and password.
    When User enters username as "Admin" and password as "admin123"
    Then User should be able to login successfully and new page open

  @InvalidCredentials
  Scenario Outline: Login with invalid credentials
    # Scenario outline to test login with various invalid username and password combinations.
    When User enters username as "<username>" and password as "<password>"
    Then User should be able to see error message "<errorMessage>"

    Examples:
      # Test data for invalid login attempts.
      | username   | password    | errorMessage                      |
      | Admin        | admin12$$ | Invalid credentials               |
      | admin$$     | admin123   | Invalid credentials               |
      | abc123       | xyz$$          | Invalid credentials               |
      | 234             | xyz$$         | Invalid credentials!              |
