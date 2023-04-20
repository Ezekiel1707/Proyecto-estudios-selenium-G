package ClasesBasicasSelenium.AdvanceInteraction_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsEX {
        public static void main(String[] args) throws InterruptedException {
                System.setProperty("webdriver.chrome.driver",
                                "D:\\Documents\\Java Selenium\\webdrivers\\chromedriver.exe");

                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.addArguments("incognito");

                options.addArguments("--remote-allow-origins=*");
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
                WebDriver driver = new ChromeDriver(options);
                Thread.sleep(3000);
                driver.quit();
        }
}
