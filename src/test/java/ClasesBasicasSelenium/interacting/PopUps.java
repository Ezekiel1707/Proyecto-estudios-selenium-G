package ClasesBasicasSelenium.interacting;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PopUps {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.automationtesting.co.uk/popups.html");

        driver.findElement(By.cssSelector("[onclick='popup()']")).click();

        String mainWindow = driver.getWindowHandle();

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterate = handles.iterator();

        while (iterate.hasNext()) {
            String child = iterate.next();

            if (!mainWindow.equalsIgnoreCase(child)) {
                Thread.sleep(3000);
                driver.switchTo().window(child);
                driver.close();

            }
        }
        Thread.sleep(3000);
        driver.switchTo().window(mainWindow);
        driver.findElement(By.cssSelector("[onclick='alertTrigger()']")).click();

        Thread.sleep(3000);
        driver.quit();
    }
}
