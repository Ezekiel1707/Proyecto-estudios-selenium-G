package ClasesBasicasSelenium.interacting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HiddenElement {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.automationtesting.co.uk/hiddenElements.html");
        Boolean var;
        Boolean var2;
        var = driver.findElement(By.cssSelector(".col-12.col-12-small > p:nth-of-type(2)")).isDisplayed();
        var2 = driver.findElement(By.cssSelector(".col-12.col-12-small > p:nth-of-type(3)")).isDisplayed();
        System.out.println(var);
        System.out.println(var2);
        Thread.sleep(3000);
        driver.quit();
    }
}
