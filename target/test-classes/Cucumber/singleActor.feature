Feature: get a specific actor.


  Scenario Outline: getting a specific actor from the database.
    Given Actor exists with ID <actor_id>
    When I request that actors details
    Then the webpage should show the actors "<first_name>" and "<last_name>"
    Examples:
      | actor_id | first_name | last_name    |
      |   1      | PENELOPE   | GUINESS      |
      |   5      | JOHNNY     | LOLLOBRIGIDA |

