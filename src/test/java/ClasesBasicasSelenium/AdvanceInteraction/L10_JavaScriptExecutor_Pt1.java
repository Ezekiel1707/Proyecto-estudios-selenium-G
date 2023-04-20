package ClasesBasicasSelenium.AdvanceInteraction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class L10_JavaScriptExecutor_Pt1 {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://www.automationtesting.co.uk");
		// este codigo es para mover la pantalla y hacer scroll con javasript
		driver.findElement(By.cssSelector(".close-cookie-warning > span")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");

		Thread.sleep(2000);
		driver.quit();
	}

}
