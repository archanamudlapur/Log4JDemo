package com.qa.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    Logger log=Logger.getLogger(LoginTest.class);

    @BeforeMethod
    public void SetUp(){
        log.info("****************************************Launching Chrome and URL*********************************************************");
        System.setProperty("webdriver.chrome.driver","/Users/archanamudlapur/Documents/LogDemo/src/test/resources/chromedriver");
        driver=new ChromeDriver();
        driver.get("https://freecrm.com/");
    }

    @Test(priority = 1)
    public void LandpageTitleTest(){
        log.info("********************************************Executing TestCases***********************************************************");
       String T= driver.getTitle();
        Assert.assertEquals(T,"Free CRM Software for ever business","Title mismatch");
    }

    @Test(priority =2 )
    public void LogoTest(){
       boolean b= driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]")).isDisplayed();
        Assert.assertTrue(b);
    }
    @AfterMethod
    public void teardown(){
        log.info("*******************************************Closing Browser*****************************************************");
        driver.quit();
    }
}
