package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateProject {
    public WebDriver driver;
    public CreateProject(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(name = "crm_project[name]")
    private WebElement fieldProjectName;

    public void inputProjectName(String projectName) {
        fieldProjectName.sendKeys(projectName);
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']/..")
    private WebElement fieldOrganization;

    public void inputOrganization(String organizationName){
        fieldOrganization.click();
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys("1234");
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);
    }

    @FindBy(name = "crm_project[businessUnit]")
    private WebElement fieldBusinessUnit;

    public void selectBusinessUnit(String businessUnit){
        Select bu = new Select(fieldBusinessUnit);
        bu.selectByVisibleText(businessUnit);
    }

    @FindBy(name = "crm_project[curator]")
            private WebElement fieldCurator;

    public void selectCurator(String curator){
        Select pc = new Select(fieldCurator);
        pc.selectByVisibleText(curator);
    }

    @FindBy(name = "crm_project[rp]")
            private WebElement fieldRP;

    public void selectRP(String rp){
        Select projectRP = new Select(fieldRP);
        projectRP.selectByVisibleText(rp);
    }

    @FindBy(name = "crm_project[administrator]")
    private WebElement fieldAdministrator;

    public void selectAdmin(String admin){
        Select projectAdministrator = new Select(fieldAdministrator);
        projectAdministrator.selectByVisibleText(admin);
    }

    @FindBy(name = "crm_project[manager]")
    private WebElement fieldManager;

    public void selectManager(String manager){
        Select projectManager = new Select(fieldManager);
        projectManager.selectByVisibleText(manager);
    }

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    private WebElement btnSaveProject;

    public void saveProject() {
        btnSaveProject.click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Проект сохранен']")));
        driver.findElement(By.xpath("//*[text()='Проект сохранен']"));
    }

}
