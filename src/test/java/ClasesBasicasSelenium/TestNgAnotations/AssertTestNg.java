package ClasesBasicasSelenium.TestNgAnotations;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AssertTestNg {
    WebDriver driver;

    @BeforeSuite
    public void setup() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://teststore.automationtesting.co.uk/");
        driver.findElement(By.cssSelector("[href='loginPortal\\.html']")).click();
    }

    @Test
    public void enterEmail() {
        Assert.fail();
        driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test17@test.com");
    }

    @Test
    public void enterPassword() {
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("123456789g");
    }
}
