package ClasesBasicasSelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDemo {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver",
                System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.get("https://www.automationtesting.co.uk");
    }
}
