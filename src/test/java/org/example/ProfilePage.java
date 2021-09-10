package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//span[text()='Проекты']/ancestor::a")
    private WebElement projectMenuItem;

    @FindBy(xpath = "//li[@data-route='crm_project_my']/a")
    private WebElement projectMenuItem2;

    @FindBy(xpath = "//a[text()='Создать проект']")
    private WebElement createProjectItem;

    public void clickToCreateProject() {
        Actions actions = new Actions(driver);
        actions.moveToElement(projectMenuItem).perform();
        projectMenuItem2.click();
        createProjectItem.click();
    }

    public void clickToAllProject() {
        Actions actions = new Actions(driver);
        actions.moveToElement(projectMenuItem).perform();
        projectMenuItem2.click();
    }

    @FindBy(xpath = "//span[text()='Контрагенты']/ancestor::a")
    private WebElement projectMenuContr;

    @FindBy(xpath = "//li[@data-route='crm_contact_index']/a")
    private WebElement projectMenuContr2;

    @FindBy(xpath = "//a[text()='Создать контактное лицо']")
    private WebElement createContact;

    public void clickProjectMenuContr() {
        Actions actions = new Actions(driver);
        actions.moveToElement(projectMenuContr).perform();
        projectMenuContr2.click();
        createContact.click();
    }

    @FindBy(xpath = "//*[@id=\"user-menu\"]/a")
    private WebElement userMenu;

    public String getUserName() {
        String userName = userMenu.getText();
        return userName;
    }


}
