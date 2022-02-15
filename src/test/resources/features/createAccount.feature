@createAccount
Feature: user should not see password visible
  Scenario: user create new account and user should not see password
    Given user go to Amazon homepage
    When Click Sign in button
    When user click create your Amazon account
    And user fill Create account form
    Then verify user should not see password visible