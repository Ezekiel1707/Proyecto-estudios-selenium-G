package ClasesBasicasSelenium.Interacting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class dropDownMenu {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.automationtesting.co.uk/dropdown.html");

        WebElement Variable = driver.findElement(By.cssSelector("select#cars"));

        Select menuItem = new Select(Variable);
        // menuItem.selectByValue("jeep");

        // menuItem.selectByVisibleText("Audi");
        menuItem.selectByIndex(1); // El index es un array o List, comienza en cero para elegir
        Thread.sleep(3000);

        driver.quit();
    }
}
