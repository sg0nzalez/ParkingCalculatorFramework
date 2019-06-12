package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.ParkingCalculatorPage;

public class BaseTests {

    private static WebDriver webDriver;
    protected static ParkingCalculatorPage parkingCalculatorPage;

    @BeforeClass
    public static void launchApplication(){
        setChromeDriverProperty();
        webDriver = new ChromeDriver();
        webDriver.get(Urls.HOME);
        parkingCalculatorPage = new ParkingCalculatorPage(webDriver);
    }

    @AfterClass
    public static void closeBrowser(){
        webDriver.quit();
    }


    public static WebDriver getWebDriver(){
        return webDriver;
    }

    private static void setChromeDriverProperty(){
        if(System.getProperty("os.name").contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        }
        else{
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        }
    }
}
