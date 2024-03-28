package pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkoutCompletePage {
    WebDriver driver;
    public checkoutCompletePage(WebDriver driver) {
		this.driver=driver;
	}

    public void verifyCheckoutComplete(){
        WebElement imgSuccess = driver.findElement(By.cssSelector("[data-test='pony-express']"));
        WebElement lblCompleteTextHeader = driver.findElement(By.cssSelector("[data-test='complete-header']"));
        String completeHeaderText = lblCompleteTextHeader.getText();
        WebElement lblCompleteText = driver.findElement(By.cssSelector("[data-test='complete-text']"));
        String completeText = lblCompleteText.getText();
        boolean imgSuccessIsvisible = imgSuccess.isDisplayed();
        assertTrue(imgSuccessIsvisible);
        assertEquals("Thank you for your order!",completeHeaderText);
        assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!",completeText);
    }

}
