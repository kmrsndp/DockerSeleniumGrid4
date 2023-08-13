package org.practice.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
//import org.testng.log4testng.Logger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;


public class DockerSeleniumGridTest {

    public WebDriver driver;
    private Logger log = Logger.getAnonymousLogger();

    @Parameters("browser")
    @BeforeTest
    public void setUpBrowser(String browserType) throws IOException, InterruptedException {

//        startDockerGrid();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if(browserType.equalsIgnoreCase("chrome")){
            capabilities.setBrowserName(Browser.CHROME.browserName());
            System.out.println("Test execution started on ===>" + browserType);
        }else if (browserType.equalsIgnoreCase("firefox")){
            capabilities.setBrowserName(Browser.FIREFOX.browserName());
            System.out.println("Test execution started on ===>" + browserType);
        }else if(browserType.equalsIgnoreCase("edge")){
            capabilities.setBrowserName(Browser.EDGE.browserName());
            System.out.println("Test execution started on ===>" + browserType);
            log.info("Test execution started on ===>" + browserType);
        }

        driver = new RemoteWebDriver(new URL("http://localhost:4445/"), capabilities);
//        driver = new RemoteWebDriver(new URL("https://35.154.225.229:4445/"), capabilities);

    }







    @AfterTest
    public void teardown() throws IOException, InterruptedException {
        System.out.println("Test execution finished");
        driver.quit();

//        stopDockerGrid();
    }

//    @BeforeSuite
//    void startDockerGrid() throws IOException, InterruptedException {
//        Runtime.getRuntime().exec("cmd /c start start_docker.bat");
//        Thread.sleep(15000);
//    }
//
//    @AfterSuite
//    void stopDockerGrid() throws IOException, InterruptedException {
//        Runtime.getRuntime().exec("cmd /c start stop_docker.bat");
//        Thread.sleep(15000);
//
//        Runtime.getRuntime().exec("taskKill /f /im cmd.exe"); //closes cmd
//    }



}
