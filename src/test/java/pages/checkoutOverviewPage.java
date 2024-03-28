package pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkoutOverviewPage {
    WebDriver driver;
    public checkoutOverviewPage(WebDriver driver) {
		this.driver=driver;
	}

    public void clickOnFinishCheckoutOverviewPage(){
        WebElement btnFinish = driver.findElement(By.cssSelector("[data-test='finish']"));
        btnFinish.click();
    }

    public void verifyCheckoutOverview(String expectedTotalPrice){
        WebElement lblCreditCardInfoValue = driver.findElement(By.cssSelector("[data-test='payment-info-value']"));
        String textCreditCardInfo = lblCreditCardInfoValue.getText();

        WebElement lblShipInfoValue = driver.findElement(By.cssSelector("[data-test='shipping-info-value']"));
        String textShipInfo = lblShipInfoValue.getText();

        WebElement lblTotalPrice = driver.findElement(By.cssSelector("[data-test='total-label']"));
        String textTotalPrice = lblTotalPrice.getText();
        assertEquals("SauceCard #31337",textCreditCardInfo);
        assertEquals("Free Pony Express Delivery!",textShipInfo);
        assertTrue(textTotalPrice.contains(expectedTotalPrice));
    }

}
