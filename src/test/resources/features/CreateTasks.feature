Feature: Validate Task Creation in the Application

  Scenario Outline: Verify user can create tasks
    Given user open application
    Then verify user is on my tasks page
    When user click create task button
    Then verify user is on create task page
    When user enter details "<task.name>" , "<start.date>" , "<due.date>"
    Then verify task is added to my tasks "<task.name>"

    Examples:
      | task.name | start.date    | due.date      |
      | shopping  | 12 March 2025 | 13 March 2025 |
      | gym       | 10 March 2025 | 04 April 2025 |
      | swimming  | 22 March 2025 | 24 May 2025   |
