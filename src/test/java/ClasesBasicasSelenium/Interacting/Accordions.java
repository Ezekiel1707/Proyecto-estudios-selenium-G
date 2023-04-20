package ClasesBasicasSelenium.Interacting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class Accordions {

    public static void main(String[] args) throws InterruptedException, IOException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.automationtesting.co.uk/accordion.html");
        //driver.findElement(By.cssSelector(".close-cookie-warning > span")).click();
        driver.findElement(By.cssSelector(".accordion .accordion-header:nth-of-type(1)")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".accordion .accordion-header:nth-of-type(1)")).click();
        driver.findElement(By.cssSelector(".accordion .accordion-header:nth-of-type(3)")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".accordion .accordion-header:nth-of-type(3)")).click();
        driver.findElement(By.cssSelector(".accordion .accordion-header:nth-of-type(5)")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".accordion .accordion-header:nth-of-type(5)")).click();
        driver.quit();
        // si voy a repetir algo es mejor un while o un for loop

        // for (int i = 0; i<10; i++ ){
        // driver.findElement(By.cssSelector(".accordion
        // .accordion-header:nth-of-type(1)")).click();
        // driver.findElement(By.cssSelector(".accordion
        // .accordion-header:nth-of-type(3)")).click();
        // driver.findElement(By.cssSelector(".accordion
        // .accordion-header:nth-of-type(5)")).click();
        // }
    }
}
