package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkoutYourCartInformationPage {

    WebDriver driver;
    public checkoutYourCartInformationPage(WebDriver driver) {
		this.driver=driver;
	}

    public void inputCheckoutInformation(String inputFirstname, String inputLastname, String inputZipcode){
        WebElement txtFirstName = driver.findElement(By.cssSelector("[data-test='firstName']"));
        WebElement txtLastName = driver.findElement(By.cssSelector("[data-test='lastName']"));
        WebElement txtZipcode = driver.findElement(By.cssSelector("[data-test='postalCode']"));
        txtFirstName.sendKeys(inputFirstname);
        txtLastName.sendKeys(inputLastname);
        txtZipcode.sendKeys(inputZipcode);
    }

    public void clickOnContinueCheckoutPage(){
        WebElement btnContinue = driver.findElement(By.cssSelector("[data-test='continue']"));
        btnContinue.click();
    }

}
