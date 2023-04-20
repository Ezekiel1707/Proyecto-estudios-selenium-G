package ClasesBasicasSelenium.AdvanceInteraction_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class L02_DesiredCapabilities {
	/*
	 * Este es como deberia funcionar ahora. Desired Capabilities esta completamente
	 * eliminado de selenium 4.0 Haciendo lo que modificque abajo se puede hacer lo
	 * que queria hacerl todo ahora es con OPTIONS. en este link explican como hacer
	 * los cambios por si te consigues con codigo viejo
	 */
	// https://www.selenium.dev/documentation/webdriver/getting_started/pgrade_to_selenium_4/
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");

		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://expired.badssl.com/");
		Thread.sleep(3000);
		driver.quit();
	}

}
