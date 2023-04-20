package ClasesBasicasSelenium.LocatorsBasics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorByxpath {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.automationtesting.co.uk/buttons.html");

        // tiene dos Absolute y Relative. es mejor usar el Relative
        // Absolute
        // driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div[1]/button")).click();//

        // driver.findElement(By.xpath("//button[@id='btn_two']")).click(); // Relative
        driver.findElement(By.xpath("//*[@id='btn_two']")).click(); // Relative
        driver.quit();
    }
}
