package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

public class loginPage {
    WebDriver driver;

    public loginPage(WebDriver driver) {
		this.driver=driver;
	}

    public void login(String username, String password) {
        WebElement txtUsername = driver.findElement(By.id("user-name"));
        WebElement txtPassword = driver.findElement(By.id("password"));
        WebElement btnLogin = driver.findElement(By.id("login-button"));
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();
    }

    public void verifyLoginErrorMessage(String expectedMessage){
        WebElement lblLoginErrorMessage = driver.findElement(By.cssSelector("[data-test='error']"));
        String textLoginErrorMessage = lblLoginErrorMessage.getText();

        assertEquals(expectedMessage,textLoginErrorMessage);
    }

}
