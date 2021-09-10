package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectsPage {
    public WebDriver driver;
    public ProjectsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }


    @FindBy(xpath = "//*[@id=\"grid-crm-project-grid-926206718\"]/div[1]/div/div/span/div[1]/div[1]/span[1]/span")
    private WebElement searchProjectByName;

    public void searchProject(){
        searchProjectByName.click();
        driver.findElement(By.xpath("//*[@id=\"grid-crm-project-grid-926206718\"]/div[1]/div/div/span/div[1]/div[2]/div/div[2]/input[1]")).sendKeys("test_project_Aleksieienko43");
        driver.findElement(By.xpath("//*[@id=\"grid-crm-project-grid-926206718\"]/div[1]/div/div/span/div[1]/div[2]/div/div[2]/input[1]")).sendKeys(Keys.ENTER);
    }


    @FindBy(xpath = "//*[@id=\"grid-crm-project-grid-240898673\"]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[1]")
    private WebElement searchResult;


    public String getProjectName() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"grid-crm-project-grid-240898673\"]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[1]")));
        String projectName = searchResult.getText();
        return projectName;
    }
}
