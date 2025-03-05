Feature: Login feature

  Scenario: Login Scenario
    Given Login Page is opened
    When I enter email "karina.usmanova01@testpro.io"
    And I enter password "YrEdlRVe"
    And I click on login button
    Then I am logged in


  Scenario Outline: Negative Login Scenario
    Given Login Page is opened
    When I enter email "<email>"
    And I enter password "<password>"
    And I click on login button
    Then I should not get logged in
    Examples:
      |  email                       | password     |
      | karina.usmanova01@testpro.io | invalidemail |
      | invalidemail@testpro.io.     | YrEdlRVe     |
      | karina.usmanova01@testpro.io |              |
      |                              | YrEdlRVe     |

    Scenario: Registration navigation
      Given Login Page is opened
      When I click on registration link
      Then I should be redirected to registration page