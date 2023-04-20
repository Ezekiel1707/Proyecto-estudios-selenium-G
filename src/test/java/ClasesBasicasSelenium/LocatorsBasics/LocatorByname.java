package ClasesBasicasSelenium.LocatorsBasics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorByname {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.automationtesting.co.uk/contactForm.html");

        driver.findElement(By.name("first_name")).sendKeys("abcd"); //.sendkeys() para mandar keys de teclado
        driver.quit();
    }
}
