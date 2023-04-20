package ClasesBasicasSelenium.TestNgAnotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class anotationsTestNg {

    WebDriver driver;

    @BeforeSuite
    public void setup() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        driver.get("https://www.automationtesting.co.uk/popups.html");
    }

    @AfterSuite
    public void end() {
        driver.close();
        driver.quit();

    }

}