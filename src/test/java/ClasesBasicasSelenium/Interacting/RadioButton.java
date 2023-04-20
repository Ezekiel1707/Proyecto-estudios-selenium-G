package ClasesBasicasSelenium.Interacting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RadioButton {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.automationtesting.co.uk/dropdown.html");

        driver.findElement(By.cssSelector("[for='demo-priority-low']")).click();
        Thread.sleep(3000);// para esperar.
        driver.findElement(By.cssSelector("[for='demo-priority-normal']")).click();
        Thread.sleep(3000);// para esperar.
        driver.findElement(By.cssSelector("[for='demo-priority-high']")).click();
        Thread.sleep(3000);
        driver.quit();
    }
}
