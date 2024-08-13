package com.skillstorm;

//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

//import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {
    private WebDriver driver;

    //junit tests
//    @BeforeEach
//    public void setup(){
//        this.driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
//        driver.get("http://testfire.net");
//    }
//
//    @Test
//    public void login(){
////        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
////        driver.get("http://testfire.net");
//        String title = driver.getTitle();
//        assertEquals("Altoro Mutual", title);
//
//        driver.navigate().to("http://testfire.net/login.jsp");
//        WebElement loginHeader = driver.findElement(By.tagName("h1"));
//        String loginHeaderText = loginHeader.getText();
//        assertEquals("Online Banking Login", loginHeaderText);
//    }
//
//    @AfterEach
//    public void teardown(){
//        driver.quit();
//    }

    //testNG tests
    @BeforeTest
    public void launchBrowser(){
        System.out.println("BeforeTest: launching chrome browser");
        driver = new ChromeDriver();
        driver.get("http://testfire.net");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("this will execute before class");

    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod: Start Testing on Browser");
    }

    @Test(priority = 1)
    public void verifyTitle(){
        System.out.println("Test 1: verify title");
        String expectedTitle = "Altoro Mutual";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test(priority = 2)
    public void navigateToLogin(){
        System.out.println("Test 2: Navigate to Login");
        driver.navigate().to("http://testfire.net/login.jsp");
        WebElement loginHeader = driver.findElement(By.tagName("h1"));
        String loginHeaderText = loginHeader.getText();
        Assert.assertEquals("Online Banking Login", loginHeaderText);
    }

    @Test(priority = 3)
    public void login(){
        System.out.println("Test 3: Login user");
        WebElement username = driver.findElement(By.id("uid"));
        WebElement password = driver.findElement(By.id("passw"));
        WebElement loginButton = driver.findElement(By.name("btnSubmit"));

        username.sendKeys("admin");
        password.sendKeys("admin");
        loginButton.submit();
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method: After each method");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test: After all tests");
        driver.quit();
    }
}
