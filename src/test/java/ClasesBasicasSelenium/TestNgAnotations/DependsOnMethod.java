package ClasesBasicasSelenium.TestNgAnotations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Test;

public class DependsOnMethod {
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
        driver.findElement(By.cssSelector("div#_desktop_user_info .hidden-sm-down")).click();
    }

    @Test
    public void enterEmail() {
        driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test17@test.com");
    }

    @Test
    public void enterPassword() {
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("123456789g");
    }

    /*
     * como los test pueden funcionar en paralelo o algunos mas rapidos, si quiero
     * que algo funcione despues de otro necesito establecer una dependencia
     */
    @Test(dependsOnMethods = { "enterPassword" })
    public void clickLogin() {
        driver.findElement(By.cssSelector("button#submit-login")).click();
    }

    @AfterTest
    public void end() {
        driver.close();
        driver.quit();
    }
}
