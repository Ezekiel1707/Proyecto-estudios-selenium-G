package ClasesBasicasSelenium.AdvanceInteraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class BrowserTabschange {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.automationtesting.co.uk/browserTabs.html");

        for (int i = 0; i < 3; i++) {
            driver.findElement(By.xpath("//input[@value='Open Tab']")).click();

        }

        ArrayList<String> windowsHandels = new ArrayList<>(driver.getWindowHandles());
        System.out.println("There are " + windowsHandels.size() + " tabs open");

        for (String item : windowsHandels) {
            Thread.sleep(2000);
            driver.switchTo().window(item);
        }
        Thread.sleep(2000);
        driver.switchTo().window(windowsHandels.get(0));

        Thread.sleep(2000);
        driver.quit();
    }
}
