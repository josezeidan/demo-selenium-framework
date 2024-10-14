# Author Jose Zeidan

@calculator
Feature: calculator

#  1. The calculator only accepts numbers between -9999.99 and 9999.99.
  @AC-1
  Scenario: Validate that an error message is shown when the entered number is out of range.
    Given User navigates to the calculator page
    When User enters the number 999999.99
    Then User clicks on "x" button
    And Validate display screen with value "ERROR: number out of boundaries."

#  2.  Internal calculations should truncate extra digits after the second decimal digit.
  @AC-2
  Scenario: Validate that any extra digits beyond two decimal places are truncated.
    Given User navigates to the calculator page
    When User enters the number 4.321
    Then User clicks on "x" button
    And User enters the number 3.452
    And User clicks on "=" button
    Then Validate display screen with value "14.91"

#  3. Internal calculations should throw an error when the calculated number is out of range, and display it on the screen.
  @AC-3
  Scenario: Validate that an error message is displayed when the internal calculation result is out of range.
    Given User navigates to the calculator page
    When User clicks on "C" button
    Then User enters the number 999.99
    And User clicks on "x" button
    And User enters the number 999.99
    And User clicks on "=" button
    Then Validate display screen with value "ERROR: number out of boundaries."

#  4.  The sign can be changed at any time when a number is entered.
  @AC-4
  Scenario: Validate that the sign of a number can be changed at any time.
    Given User navigates to the calculator page
    Then Validate display screen with value "0"
    When User enters the number 7.00
    And User clicks on "+/-" button
    Then Validate display screen with value "-7.00"
    And User clicks on "+/-" button
    Then Validate display screen with value "7.00"
    And User clicks on "-" button
    And User enters the number 10.00
    And User clicks on "=" button
    Then Validate display screen with value "-3"

#  5.  The display can be cleared at any time.
  @AC-5
  Scenario: Validate that the display can be cleared at any time.
    Given User navigates to the calculator page
    When User clicks on "C" button
    Then Validate display screen with value "0"
    When User enters the number 999.99
    And User clicks on "x" button
    And User enters the number 999.99
    And User clicks on "=" button
    Then Validate display screen with value "ERROR: number out of boundaries."
    And User clicks on "C" button
    Then Validate display screen with value "0"
    And User enters the number 999.99
    And User clicks on "C" button
    Then Validate display screen with value "0"

#  6.  Consecutive calculations are allowed before clearing the display.
  @AC-6
  Scenario: Validate that consecutive calculations can be performed without needing to clear the display.
    Given User navigates to the calculator page
    Then Validate display screen with value "0"
    When User enters the number 10
    And User clicks on "x" button
    And User enters the number 5
    And User clicks on "=" button
    Then Validate display screen with value "50"
    And User clicks on "+" button
    And User clicks on "5" button
    And User clicks on "0" button
    And User clicks on "/" button
    And User clicks on "4" button
    And User clicks on "-" button
    And User clicks on "5" button
    And User clicks on "=" button
    Then Validate display screen with value "20"
    And User clicks on "C" button
    Then Validate display screen with value "0"