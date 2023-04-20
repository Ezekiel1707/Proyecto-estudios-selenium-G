package ClasesBasicasSelenium.AdvanceInteraction_2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CookiesEX {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("http://teststore.automationtesting.co.uk/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.findElement(By.cssSelector("div#_desktop_user_info .hidden-sm-down")).click();
        driver.findElement(By.cssSelector("section input[name='email']")).sendKeys("test17@test.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("123456789g");
        driver.findElement(By.cssSelector("[data-link-action='sign-in']")).click();
        driver.findElement(By.linkText("CLOTHES")).click();
        driver.findElement(By.cssSelector("img[alt='Hummingbird printed t-shirt']")).click();
        driver.findElement(By.cssSelector(".add-to-cart.btn.btn-primary")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cart-content-btn [data-dismiss]"))).click();

        driver.manage().deleteAllCookies();
        Thread.sleep(3000);
        driver.quit();
    }
}