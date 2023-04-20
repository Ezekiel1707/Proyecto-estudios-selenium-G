package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class LoginPage extends BasePage {

	public WebDriver driver;

	By email = By.cssSelector("input#login_text");
	By password = By.cssSelector("input#login_password");
	By loginBtn = By.cssSelector("button#login_btn");

	public LoginPage() throws IOException {
		super();
	}

	public WebElement getEmail() throws IOException {
		this.driver = getDriver();
		return driver.findElement(email);
	}

	public WebElement getPassword() throws IOException {
		this.driver = getDriver();
		return driver.findElement(password);
	}

	public WebElement getLoginBtn() throws IOException {
		this.driver = getDriver();
		return driver.findElement(loginBtn);
	}
}
