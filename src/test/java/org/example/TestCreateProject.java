package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class TestCreateProject {

    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static CreateProject createProject;
    public static ProjectsPage projectsPage;

    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
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
        loginPage.login("Applanatest1", "Student2020!");
        String user = profilePage.getUserName();
        Assert.assertEquals("Applanatest1 Applanatest1 Applanatest1", user);




        profilePage.clickToCreateProject();

        createProject.inputProjectName("test_project_Aleksieienko40");
        createProject.inputOrganization("1234");
        createProject.selectBusinessUnit("Research & Development");
        createProject.selectCurator("Applanatest Applanatest Applanatest");
        createProject.selectRP("Applanatest Applanatest Applanatest");
        createProject.selectAdmin("Applanatest Applanatest Applanatest");
        createProject.selectManager("Applanatest Applanatest Applanatest");
        createProject.saveProject();


        projectsPage.searchProject();
        String project = projectsPage.getProjectName();
        Assert.assertEquals("test_project_Aleksieienko41", project);

    }

    @AfterClass
    public static void tearDown() {
        //driver.quit();
    }

}
