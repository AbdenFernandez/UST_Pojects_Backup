package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskCreationPage extends BasePage{

    @FindBy(xpath = "//android.view.View[@content-desc='Save']")
    WebElement saveButton;

    @FindBy(xpath = "//android.widget.EditText[@text='Task name']")
    WebElement taskNameInput;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'start date')]")
    WebElement startDateInput;
    
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Next month']")
    WebElement nextMonthButton;

    @FindBy(id = "org.tasks:id/ok_button")
    WebElement okButton;

    @FindBy(xpath = "//android.widget.ScrollView/android.view.View[2]")
    WebElement dueDateInput;

    @FindBy(xpath = "//android.widget.EditText[@text='Description']")
    WebElement descriptionInput;

    @FindBy(xpath = "//android.widget.ScrollView")
    WebElement taskCreationPageLayout;

    @FindBy(xpath = "//android.widget.TextView[@text='Add location']")
    WebElement locationInput;

    @FindBy(xpath = "//android.widget.TextView[@text='Search']")
    WebElement searchLocation;

    @FindBy(id = "org.tasks:id/search_src_text")
    WebElement searchLocationInput;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='org.tasks:id/recent_locations']//android.widget.RelativeLayout")
    WebElement suggestedPlaceList;

    @FindBy(xpath = "//android.view.View[@content-desc='Delete task']")
    WebElement deleteIcon;

    @FindBy(id = "android:id/button1")
    WebElement confirmButton;
    
    String XPATH_DATE_INPUT = "//android.view.View[@content-desc='%s']";

    public boolean isTaskCreationPageDisplayed() {
        return saveButton.isDisplayed();
    }

    public void enterTaskName(String taskName) {
        taskNameInput.sendKeys(taskName);
    }

    public void enterstartDate(String startDate) {
        startDateInput.click();
        while(!isDisplayed(String.format(XPATH_DATE_INPUT,startDate))){
            nextMonthButton.click();
        }
        WebElement startDateInput = driver.findElement(By.xpath(String.format(XPATH_DATE_INPUT,startDate)));
        startDateInput.click();
        okButton.click();
    }

    public void enterDueDate(String dueDate) {
        dueDateInput.click();
        while(!isDisplayed(String.format(XPATH_DATE_INPUT,dueDate))){
            nextMonthButton.click();
        }
        WebElement dueDateInput = driver.findElement(By.xpath(String.format(XPATH_DATE_INPUT,dueDate)));
        dueDateInput.click();
        okButton.click();
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public void enterTaskDescription(String taskDescription) {
        scroll();
        descriptionInput.sendKeys(taskDescription);
    }

    public void enterTaskLocation(String taskLocation) {
        if(!isDisplayed(locationInput)){
            int x = taskCreationPageLayout.getLocation().getX();
            int y = taskCreationPageLayout.getLocation().getY();
            int width = taskCreationPageLayout.getSize().getWidth();
            int height = taskCreationPageLayout.getSize().getHeight();
            scroll();
        }
        locationInput.click();
        searchLocation.click();
        searchLocationInput.sendKeys(taskLocation);
        suggestedPlaceList.click();
    }

    public void deleteTask() {
        deleteIcon.click();
        confirmButton.click();
    }
}
