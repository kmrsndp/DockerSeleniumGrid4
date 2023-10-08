package org.practice.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
//import org.testng.log4testng.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
//import java.util.logging.Logger;


public class DockerSeleniumGridTest {

    public static WebDriver driver;
    final static Logger log = LoggerFactory.getLogger(DockerSeleniumGridTest.class);


    @BeforeSuite
    void startDockerGrid() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("cmd /c start start_docker.bat");
        Thread.sleep(15000);
    }

    @AfterSuite
    void stopDockerGrid() throws IOException, InterruptedException {
        driver.quit();
        System.out.println("shutting down webdriver...");

        Runtime.getRuntime().exec("cmd /c start stop_docker.bat");
        Thread.sleep(10000);

        Runtime.getRuntime().exec("taskKill /f /im cmd.exe"); //closes cmd
    }

    @Parameters("browser")
    @BeforeTest
//    @BeforeSuite
    public void setUpBrowser(String browserType) throws IOException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

//        ChromeOptions browserOptions = new ChromeOptions();
//        browserOptions.setPlatformName("Windows 11");
//        browserOptions.setBrowserVersion("latest");
//        Map<String, Object> sauceOptions = new HashMap<>();
//        sauceOptions.put("name", methodName);
//        sauceOptions.put("username", "oauth-kmr.sndp-bbc30");
//        sauceOptions.put("accessKey", "1c5e3997-a8c0-441a-b277-886e33162d65");
//        sauceOptions.put("build", "selenium-build-A5U7D");
//        sauceOptions.put("name", "Title verification");
//        browserOptions.setCapability("sauce:options", sauceOptions);

//        capabilities.setCapability("browserVersion", "latest");
//        capabilities.setCapability("platformName", "Windows 11");
//        capabilities.setCapability("sauce:options", sauceOptions);


        if(browserType.equalsIgnoreCase("chrome")){
            capabilities.setBrowserName(Browser.CHROME.browserName());
            System.out.println("TestV1 execution started on ===>" + browserType);
        }else if (browserType.equalsIgnoreCase("firefox")){
            capabilities.setBrowserName(Browser.FIREFOX.browserName());
            System.out.println("TestV1 execution started on ===>" + browserType);
        }else if(browserType.equalsIgnoreCase("edge")){
            capabilities.setBrowserName(Browser.EDGE.browserName());
            System.out.println("TestV1 execution started on ===>" + browserType);
            log.info("TestV1 execution started on ===>" + browserType);
        }


//        SauceLabs url
//        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
//        driver = new RemoteWebDriver(url, capabilities);

        //docker local
        driver = new RemoteWebDriver(new URL("http://localhost:4445/"), capabilities);

        //aws ec-2 public address
//        driver = new RemoteWebDriver(new URL("https://35.154.225.229:4445/"), capabilities);

    }

    @AfterTest
    public void teardown(){
        System.out.println("TestV1 execution finished");
    }



}
