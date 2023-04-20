package ClasesBasicasSelenium.TestNgAnotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class anotationsTestNg2 {
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

    @BeforeMethod
    public void singin() throws InterruptedException {
        driver.get("http://teststore.automationtesting.co.uk/");
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.findElement(By.cssSelector("div#_desktop_user_info .hidden-sm-down")).click();
        driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test17@test.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("123456789g");
        driver.findElement(By.cssSelector("[data-link-action='sign-in']")).click();
        System.out.println("user has logged in");
        Thread.sleep(3000);
    }

    @Test(groups = { "smoke" })
    public void test() throws InterruptedException {
        driver.findElement(By.linkText("CLOTHES")).click();
        System.out.println("user has clicked clothes link");
        Thread.sleep(3000);
    }

    @AfterMethod
    public void signout() throws InterruptedException {
        driver.findElement(By.cssSelector(".user-info [rel='nofollow']:nth-of-type(1)")).click();
        System.out.println("user has logged out");
        Thread.sleep(3000);
    }

    @AfterTest
    public void end() {
        driver.close();
        driver.quit();
    }
}