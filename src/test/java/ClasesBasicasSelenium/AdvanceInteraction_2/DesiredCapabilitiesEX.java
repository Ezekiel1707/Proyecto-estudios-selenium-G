package ClasesBasicasSelenium.AdvanceInteraction_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//NAda de esto ya funciona. solo usando la clse de OPTIONS se puede hacer ahora lo que esto hacia. 
// https://www.selenium.dev/documentation/webdriver/getting_started/upgrade_to_selenium_4/
//el link arriba muestra como escribir lo que antes se hacia con Capabilities

public class DesiredCapabilitiesEX {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");

        // DesiredCapabilities cap = DesiredCapabilities.chrome();// esto ya no funciona
        // y no va a funcionar. ver link

        // cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        // cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        // option.merge(cap);

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://expired.badssl.com/");
        Thread.sleep(3000);
        driver.quit();
    }
}
