package ClasesBasicasSelenium.interacting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SendKyes {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.automationtesting.co.uk/contactForm.html");

        //
        driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys("Giulio");
        driver.findElement(By.cssSelector("input[name='last_name']")).sendKeys("Faragalli");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("email@email.com");
        driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("This is a message");

        Thread.sleep(3000);
        driver.quit();
    }
}
