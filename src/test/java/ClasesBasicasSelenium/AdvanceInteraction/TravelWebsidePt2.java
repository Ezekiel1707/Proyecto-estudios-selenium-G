package ClasesBasicasSelenium.AdvanceInteraction;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelWebsidePt2 {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.easyjet.com");
        driver.findElement(By.cssSelector("button#ensCloseBanner")).click();

        driver.findElement(By.cssSelector("input[name='origin']")).click();
        driver.findElement(By.cssSelector("input[name='origin']")).sendKeys("l");

        // List<WebElement> origins = driver.findElements(By.cssSelector("#ui-id-1
        // li>a>span"));
        /*
         * Este cssselector lo construi poco a poco revisando los elementos de la
         * pagina. el add on ayuda pero se tiene que tener cuidado al armarlo
         */

        // para introducir un wait por si el desplegable tarda mucho en aparecer
        List<WebElement> origins = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#ui-id-1 li>a>span")));

        for (WebElement origin : origins) {
            // System.out.println(origin.getText());
            if (origin.getText().contains("Luton")) {
                origin.click();
            }
        }

        driver.findElement(By.cssSelector("input[name='destination']")).click();
        driver.findElement(By.cssSelector("input[name='destination']")).sendKeys("a");

        // List<WebElement> origins = driver.findElements(By.cssSelector("#ui-id-1
        // li>a>span"));
        /*
         * Este cssselector lo construi poco a poco revisando los elementos de la
         * pagina. el add on ayuda pero se tiene que tener cuidado al armarlo
         */

        // para introducir un wait por si el desplegable tarda mucho en aparecer
        List<WebElement> destinations = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#ui-id-2 li>a>span")));

        for (WebElement destination : destinations) {
            // System.out.println(origin.getText());
            if (destination.getText().contains("Antalya")) {
                destination.click();
            }
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
