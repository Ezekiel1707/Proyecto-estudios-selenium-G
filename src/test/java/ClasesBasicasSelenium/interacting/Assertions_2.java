package ClasesBasicasSelenium.interacting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Assertions_2 {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.automationtesting.co.uk");
        driver.findElement(By.cssSelector(".close-cookie-warning > span")).click();
        driver.findElement(By.linkText("TEST STORE")).click();
        driver.findElement(By.cssSelector("[alt='Hummingbird printed t-shirt']")).click();
        driver.findElement(By.cssSelector(".add-to-cart.btn.btn-primary")).click();

        Thread.sleep(3000);

        String total = driver.findElement(By.cssSelector(".product-total > .value")).getText();
        Assert.assertEquals("$26.12", total);
        
        driver.quit();
    }
}
