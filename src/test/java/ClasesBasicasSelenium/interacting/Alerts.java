package ClasesBasicasSelenium.interacting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.automationtesting.co.uk/popups.html");

        //driver.findElement(By.cssSelector(".close-cookie-warning > span")).click();
        driver.findElement(By.cssSelector("button[onclick='alertTrigger()']")).click();
        Thread.sleep(3000);// para esperar.
        driver.switchTo().alert().accept(); // Esto es para una alerta con un boton de OK
        // driver.switchTo().alert().dismiss();// Para una alerta con boton de CANCEL
        driver.quit();
    }
}
