package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "prependedInput")
    private WebElement loginField;

    @FindBy(id = "prependedInput2")
    private WebElement passwdField;

    @FindBy(id = "_submit")
    private WebElement loginBtn;

    public void inputLogin(String login) {
        loginField.click();
        loginField.sendKeys(login);
    }

    public void inputPasswd(String passwd) {
        passwdField.click();
        passwdField.sendKeys(passwd);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }
}
