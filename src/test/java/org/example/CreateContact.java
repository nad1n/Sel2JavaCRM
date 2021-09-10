package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateContact {
    public WebDriver driver;

    public CreateContact(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name = "crm_contact[lastName]")
    private WebElement fieldLastName;

    public void inputLastName(String lastName) {
        fieldLastName.sendKeys(lastName);
    }

    @FindBy(name = "crm_contact[firstName]")
    private WebElement fieldFirstName;

    public void inputFirstName(String firstName) {
        fieldFirstName.sendKeys(firstName);
    }

    @FindBy(name = "crm_contact[jobTitle]")
    private WebElement fieldJobTitle;

    public void inputJobTitle(String jobTitle) {
        fieldJobTitle.sendKeys(jobTitle);
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']/..")
    protected WebElement fieldOrganization;

    public void inputOrganization(String organizationName) {
        fieldOrganization.click();
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys("1234");
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);
    }

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    private WebElement btnSaveContact;

    public void saveContact() {
        btnSaveContact.click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Контактное лицо сохранено']")));
        driver.findElement(By.xpath("//*[text()='Контактное лицо сохранено']"));
    }


}
