package ClasesBasicasSelenium.TestNgAnotations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAnotation {
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
    }

    // si quieres proporcionar varios datos de modo de hacer el test mas de una vez
    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[3][2];
        // data set1
        data[0][0] = "test2@test.com";
        data[0][1] = "test12345";

        // data set1
        data[1][0] = "test@test.com";
        data[1][1] = "test123";

        // data set1
        data[2][0] = "doesntexist@test.com";
        data[2][1] = "xxxxxxxx";

        return data;
    }

    @Test(dataProvider = "getData")

    public void singin(String email, String password) throws InterruptedException {
        driver.get("http://teststore.automationtesting.co.uk/");
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.findElement(By.cssSelector("div#_desktop_user_info .hidden-sm-down")).click();
        driver.findElement(By.cssSelector("section input[name='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button#submit-login")).click();
        System.out.println("user has logged in");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".hidden-sm-down.logout")).click();
        System.out.println("user has logged out");
        Thread.sleep(3000);
    }

    @AfterTest
    public void end() {
        driver.close();
        driver.quit();
    }
}