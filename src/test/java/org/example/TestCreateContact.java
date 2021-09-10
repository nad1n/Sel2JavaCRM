package org.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestCreateContact {

    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static CreateContact createContact;

    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        createContact = new CreateContact(driver);
        driver.manage().window().setSize(new Dimension(1248, 883));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(LOGIN_PAGE_URL);
    }

    @Test
    public void createContactTest() {
        loginPage.inputLogin("Applanatest1");
        loginPage.inputPasswd("Student2020!");
        loginPage.clickLoginBtn();

        profilePage.clickProjectMenuContr();

        createContact.inputLastName("Алексеенко55");
        createContact.inputFirstName("Nadin");
        createContact.inputJobTitle("QA");
        createContact.inputOrganization("1234");
        createContact.saveContact();

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
