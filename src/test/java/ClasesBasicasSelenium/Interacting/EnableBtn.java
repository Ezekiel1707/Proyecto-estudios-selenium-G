package ClasesBasicasSelenium.Interacting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnableBtn {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.automationtesting.co.uk/buttons.html");

        Boolean Var = driver.findElement(By.cssSelector("button#btn_four")).isEnabled();
        // isEnabled es un valor true or false. para esto se debe recordar que el
        // ccsSelectro tiene que ser un input
        Boolean Var2 = driver.findElement(By.cssSelector("button#btn_three")).isEnabled();

        System.out.println(Var);
        System.out.println(Var2);

        Thread.sleep(3000);

        driver.quit();
    }
}
