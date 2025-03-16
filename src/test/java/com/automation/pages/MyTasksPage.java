package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyTasksPage extends BasePage{

    @FindBy(xpath = "//android.widget.TextView[@text='Dismiss']")
    WebElement dismissButton;
    
    @FindBy(xpath = "//android.widget.TextView[@text='My Tasks']")
    WebElement pageTitle;

    @FindBy(id = "org.tasks:id/fab")
    WebElement createNewTaskButton;

    @FindBy(id = "org.tasks:id/snackbar_text")
    WebElement taskCompletedMessage;

    String XPATH_TASK_DATE = "//android.widget.TextView[@text='%s']";

    String XPATH_TASK_TITLE = "//android.widget.TextView[@resource-id='org.tasks:id/title' and @text='%s']";

    String XPATH_COMPLETED_CHECKBOX = "//android.widget.TextView[@resource-id='org.tasks:id/title' and @text='%s']//preceding-sibling::android.widget.ImageView[@resource-id='org.tasks:id/completeBox']";

    public void openApplication() {
        if(isDisplayed(dismissButton)){
            dismissButton.click();
            dismissButton.click();
        }
    }

    public boolean isMyTasksPageDisplayed() {
        return pageTitle.isDisplayed();
    }

    public void clickCreateNewTaskButton() {
        createNewTaskButton.click();
    }

    public boolean isTaskTitleDisplayed(String taskName) {
       return isDisplayed(String.format(XPATH_TASK_TITLE,taskName));
    }

    public void clickCompleteCheckbox(String taskName) {
        WebElement completedCheckbox = driver.findElement(By.xpath(String.format(XPATH_COMPLETED_CHECKBOX,taskName)));
        completedCheckbox.click();
    }

    public boolean isTaskCompletedMessageDisplayed() {
        return taskCompletedMessage.isDisplayed();
    }

    public boolean isTaskDeleted(String taskName) {
        return !isDisplayed(String.format(XPATH_TASK_TITLE,taskName));
    }

    public void clickTask(String taskName) {
        WebElement taskTitle = driver.findElement(By.xpath(String.format(XPATH_TASK_TITLE,taskName)));
        taskTitle.click();
    }

    public boolean isDateUpdated(String updatedDueDate) {
        String date = getFormattedDate("dd-MMM-",updatedDueDate,"dd MMMM yyyy");
        System.out.println(date);
        return isDisplayed(String.format(XPATH_TASK_DATE,date));
    }
}
