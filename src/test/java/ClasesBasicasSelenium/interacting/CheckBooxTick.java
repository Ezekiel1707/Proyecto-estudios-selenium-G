package ClasesBasicasSelenium.interacting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckBooxTick {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.automationtesting.co.uk/dropdown.html");

        Boolean Var = driver.findElement(By.cssSelector("input#cb_red")).isSelected();
        // isSelected es un valor true or false. para esto se debe recordar que el
        // ccsSelectro tiene que ser un input
        Boolean Var2 = driver.findElement(By.cssSelector("input#cb_green")).isSelected();

        System.out.println(Var);
        System.out.println(Var2);
        
        driver.quit();
    }
}
