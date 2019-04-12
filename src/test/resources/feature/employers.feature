Feature: the message can be retrieved

  Scenario: client makes call to GET /api/employers
    Given the client calls get /api/employers
    When the client receives status code of 200
    And the client receives all employees :
      | firstName | lastName | matricule |
      | Mohamed   | Jarray   | MJA14588  |
      | Alice     | Johnason | AJO45008  |
      | Elisa     | Quaston  | EQU162705 |
      | Kevin     | Bokin    | KBO145889 |

  Scenario: client makes call to POST /api/employers
    When the client calls post /api/employers
    Then the client receives status code of 201
    And the client receives the created employee :
      | firstName | lastName | matricule |
      | toto      | titi     | 12345     |