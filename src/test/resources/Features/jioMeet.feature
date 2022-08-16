
Feature: Plan a meeting

  Scenario: Sign in and plan a meeting
    Given Sign-in to JioMeet stage
    When Click on Plan a meeting option
    Then Select checkbox and Don’t allow Guest user
    And Scroll till Schedule button
    And Click on Close button in the displayed window

