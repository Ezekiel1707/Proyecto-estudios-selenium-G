package uk.co.automationtesting;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import pageObjects.Homepage;
import pageObjects.LoginPage;

public class Login extends Hooks {

    public Login() throws IOException {
        super();
    }

    @Test
    public void singin() throws InterruptedException, IOException {

        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        getDriver().findElement(By.cssSelector(".close-cookie-warning > span")).click();
        // getDriver().findElement(By.cssSelector(".toggle")).click();

        getDriver().findElement(By.cssSelector("[href='loginPortal\\.html']")).click();
        getDriver().findElement(By.cssSelector("input#login_text")).sendKeys("test17@test.com");
        getDriver().findElement(By.cssSelector("input#login_password")).sendKeys("123456789g");
        getDriver().findElement(By.cssSelector("button#login_btn")).click();

        System.out.println("user has logged in");
        Thread.sleep(3000);
    }

    @Test
    public void login() throws IOException, InterruptedException {

        Homepage home = new Homepage();
        LoginPage login = new LoginPage();
        home.getCookiesBtn().click();
        home.getLoginPortalLink().click();
        Thread.sleep(3000);
        login.getEmail().sendKeys("test17@test.com");
        login.getPassword().sendKeys("123456789g");
        login.getLoginBtn().click();

        System.out.println("user has logged in");
        Thread.sleep(3000);
    }
}
