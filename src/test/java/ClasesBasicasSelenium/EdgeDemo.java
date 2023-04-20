package ClasesBasicasSelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDemo {

    public static void main(String[] args) {

        System.setProperty("webdriver.edge.driver",
                System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.automationtesting.co.uk");
    }
}
