package org.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestCreateProject {

    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static CreateProject createProject;

    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        createProject = new CreateProject(driver);
        driver.manage().window().setSize(new Dimension(1248, 883));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(LOGIN_PAGE_URL);
    }

    @Test
    public void createProjectTest() {
        loginPage.inputLogin("Applanatest1");
        loginPage.inputPasswd("Student2020!");
        loginPage.clickLoginBtn();

        profilePage.clickProjectMenuItem();

        createProject.inputProjectName("test_project_Aleksieienko44");
        createProject.inputOrganization("1234");
        createProject.selectBusinessUnit("Research & Development");
        createProject.selectCurator("Applanatest Applanatest Applanatest");
        createProject.selectRP("Applanatest Applanatest Applanatest");
        createProject.selectAdmin("Applanatest Applanatest Applanatest");
        createProject.selectManager("Applanatest Applanatest Applanatest");
        createProject.saveProject();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
