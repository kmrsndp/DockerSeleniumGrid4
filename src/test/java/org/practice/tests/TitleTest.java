package org.practice.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class TitleTest {
    DockerSeleniumGridTest dockerSeleniumGridTest = new DockerSeleniumGridTest();
    WebDriver driver = dockerSeleniumGridTest.driver;
    private Logger log = Logger.getAnonymousLogger();

    @Test
    public void googleOnChromeTest() throws InterruptedException {

        driver.get("https://www.google.com");
        log.info("google on chromepage title is: " +driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Google", "Wrong page title");
        Thread.sleep(8000);
    }

    @Test
    public void linkedInOnFirefoxTest() throws InterruptedException {

        driver.get("https://in.linkedin.com/");
        log.info("linkedin on firefox page title is: " +driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "LinkedIn India: Log In or Sign Up", "Wrong page title");
        Thread.sleep(8000);
    }

    @Test
    public void facebookOnChromeTest() throws InterruptedException {

        driver.get("https://www.facebook.com");
        log.info("fb on chrome page title is: " +driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up", "Wrong page title");
        Thread.sleep(8000);
    }

    @Test
    public void facebookOnEdgeTest() throws InterruptedException {

        driver.get("https://www.facebook.com");
        log.info("fb on edge page title is: " +driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up", "Wrong page title");
        Thread.sleep(8000);
    }
}
