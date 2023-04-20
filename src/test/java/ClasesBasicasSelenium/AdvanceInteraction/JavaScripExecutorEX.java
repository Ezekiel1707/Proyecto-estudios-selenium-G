package ClasesBasicasSelenium.AdvanceInteraction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JavaScripExecutorEX {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.automationtesting.co.uk/contactForm.html");

        driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys("Giulio");
        driver.findElement(By.cssSelector("input[name='last_name']")).sendKeys("Faragalli");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("email@email.com");
        driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("This is a message");

        WebElement submit = driver.findElement(By.cssSelector("[type='submit']"));
        // submit.click();
        // para hacer lo de arroba pero con javascrip

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", submit);
        // esto es javascript code, arguments hace referencia a el primer argumento,
        // puedo poner mas argumentos
        // js.executeScript("arguments[0].click(), arguments[1]", argumento 0, argumento
        // 1 );

        Thread.sleep(2000);
        driver.quit();
    }

}
