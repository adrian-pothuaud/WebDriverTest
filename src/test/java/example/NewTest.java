package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {

    private WebDriver driver;

    @Test
    public void testEasy() {
        driver.get("http://demo.guru99.com/test/guru99home/");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Demo Guru99 Page"));
    }

    @BeforeTest
    public void beforeTest() throws Exception {
        if (OSValidator.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/bin/chromedriver.exe");
        }
        else if (OSValidator.isMac()) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/bin/chromedriver_mac64");
        }
        else if (OSValidator.isUnix()) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/bin/chromedriver_linux64");
        }
        else {
            throw new Exception("OS is not supported");
        }
        driver = new ChromeDriver();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
