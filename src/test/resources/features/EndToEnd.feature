Feature: Validate End to End Scenario of the Application

  Scenario: Verify user can create, update and delete the task
    Given user open application
    Then verify user is on my tasks page
    When user click create task button
    Then verify user is on create task page
    When user enter details "task.name" , "start.date" , "due.date" , "task.description" , "task.location"
    Then verify task is added to my tasks page "task.name"
    When user update due date of the task "task.name" as "updated.due.date"
    Then verify due date is updated
    When user clicks on complete checkbox for task "task.name"
    Then verify task is checked to completed
    When user delete a task "task.name"
    Then verify task "task.name" is not displayed in my tasks page