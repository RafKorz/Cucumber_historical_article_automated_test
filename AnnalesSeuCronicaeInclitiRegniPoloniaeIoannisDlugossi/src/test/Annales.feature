Feature: Assert historical article

  Scenario: Assert element on historical article in wikipedia
    Given a user in http://wikipedia.pl
    When the user types "Roczniki czyli kroniki sławnego Królestwa Polskiego" in input search
    And clicks on search button
    Then the user should see this article