package com.skillstorm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class selenium_demo {
    public static void main(String... args){
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        String title = driver.getTitle();
        String currentUrl = driver.getCurrentUrl();

        System.out.println(title);
        System.out.println(currentUrl);

        WebElement textbox = driver.findElement(By.name("my-text"));
        textbox.sendKeys("test test test");
        WebElement button = driver.findElement(By.cssSelector("button"));
        button.submit();

        driver.close();
    }
}
