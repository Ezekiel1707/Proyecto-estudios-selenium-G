package ClasesBasicasSelenium.AdvanceInteraction_2;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Screenshots {
    public static void main(String[] args) throws InterruptedException, IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.automationtesting.co.uk");

        takeSnapshots(driver);Thread.sleep(3000);
        driver.quit();

    }

    public static void takeSnapshots(WebDriver webDriver) throws IOException {
        File srcFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);

        File destFile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\ClasesBasicasSelenium\\AdvanceInteraction_2\\" + timestamp() + ".png");

        FileUtils.copyFile(srcFile, destFile);

    }

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());

    }

}