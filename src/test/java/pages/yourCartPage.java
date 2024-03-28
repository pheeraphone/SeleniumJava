package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class yourCartPage {

    WebDriver driver;
    public yourCartPage(WebDriver driver) {
		this.driver=driver;
	}

    public void clickOnCheckout(){
        WebElement btnCheckout = driver.findElement(By.cssSelector("[data-test='checkout']"));
        btnCheckout.click();
    }

}
