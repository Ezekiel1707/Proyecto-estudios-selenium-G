package ClasesBasicasSelenium.AdvanceInteraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Iframes {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.automationtesting.co.uk/iframes.html");
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector(".close-cookie-warning > span")).click();

        driver.findElement(By.cssSelector(".toggle")).click();

        driver.switchTo().parentFrame();
        driver.findElement(By.cssSelector(".toggle")).click();

        Thread.sleep(3000);
        driver.switchTo().frame(1);
        driver.findElement(By.cssSelector("[aria-label='Play']")).click();
        // aqui tengo que estar pendiente del idioma que abra el browser selenium

        Thread.sleep(2000);
        driver.quit();

    }
}
