package com.automation.steps;

import com.automation.pages.MyTasksPage;
import com.automation.pages.TaskCreationPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MyTasksSteps {

    MyTasksPage myTasksPage = new MyTasksPage();
    TaskCreationPage taskCreationPage = new TaskCreationPage();

    @Given("user open application")
    public void userOpenApplication() {
        myTasksPage.openApplication();
    }

    @Then("verify user is on my tasks page")
    public void verifyUserIsOnMyTasksPage() {
        Assert.assertTrue(myTasksPage.isMyTasksPageDisplayed());
    }

    @When("user click create task button")
    public void userClickCreateTaskButton() {
        myTasksPage.clickCreateNewTaskButton();
    }

    @Then("verify task is added to my tasks {string}")
    public void verifyTaskIsAddedToMyTasks(String taskName) {
        Assert.assertTrue(myTasksPage.isTaskTitleDisplayed(taskName));
    }

    @When("user clicks on complete checkbox for task {string}")
    public void userClicksOnCompleteCheckboxForTask(String taskName) {
        myTasksPage.clickCompleteCheckbox(ConfigReader.getConfigValue(taskName));
    }

    @Then("verify task is checked to completed")
    public void verifyTaskIsCheckedToCompleted() {
        Assert.assertTrue(myTasksPage.isTaskCompletedMessageDisplayed());
    }

    @Then("verify task is added to my tasks page {string}")
    public void verifyTaskIsAddedToMyTasksPage(String taskName) {
        Assert.assertTrue(myTasksPage.isTaskTitleDisplayed(ConfigReader.getConfigValue(taskName)));
    }

    @When("user delete a task {string}")
    public void userDeleteATask(String taskName) {
        myTasksPage.clickTask(ConfigReader.getConfigValue(taskName));
        taskCreationPage.deleteTask();
    }

    @Then("verify task {string} is not displayed in my tasks page")
    public void verifyTaskIsNotDisplayedInMyTasksPage(String taskName) {
        Assert.assertTrue(myTasksPage.isTaskDeleted(ConfigReader.getConfigValue(taskName)));
    }

    @When("user update due date of the task {string} as {string}")
    public void userUpdateDueDateOfTheTaskAs(String taskName, String updatedDueDate) {
        myTasksPage.clickTask(ConfigReader.getConfigValue(taskName));
        taskCreationPage.enterDueDate(ConfigReader.getConfigValue(updatedDueDate));
        taskCreationPage.clickSaveButton();
    }

    @Then("verify due date is updated")
    public void verifyDueDateIsUpdated() {
        Assert.assertTrue(myTasksPage.isDateUpdated(ConfigReader.getConfigValue("updated.due.date")));
    }
}
