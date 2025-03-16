package com.automation.steps;

import com.automation.pages.TaskCreationPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TaskCreationSteps {

    TaskCreationPage taskCreationPage = new TaskCreationPage();

    @Then("verify user is on create task page")
    public void verifyUserIsOnCreateTaskPage() {
        Assert.assertTrue(taskCreationPage.isTaskCreationPageDisplayed());
    }

    @When("user enter details {string} , {string} , {string}")
    public void userEnterDetails(String taskName, String startDate, String dueDate) {
        taskCreationPage.enterTaskName(taskName);
        taskCreationPage.enterstartDate(startDate);
        taskCreationPage.enterDueDate(dueDate);
        taskCreationPage.clickSaveButton();
    }

    @When("user enter details {string} , {string} , {string} , {string} , {string}")
    public void userEnterDetails(String taskName, String startDate, String dueDate, String taskDescription, String taskLocation) {
        taskCreationPage.enterTaskName(ConfigReader.getConfigValue(taskName));
        taskCreationPage.enterstartDate(ConfigReader.getConfigValue(startDate));
        taskCreationPage.enterDueDate(ConfigReader.getConfigValue(dueDate));
        taskCreationPage.enterTaskDescription(ConfigReader.getConfigValue(taskDescription));
        taskCreationPage.enterTaskLocation(ConfigReader.getConfigValue(taskLocation));
        taskCreationPage.clickSaveButton();
    }
}
