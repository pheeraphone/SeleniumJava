package pages;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class inventoryPage {

    WebDriver driver;
    public inventoryPage(WebDriver driver) {
		this.driver=driver;
	}

    public void verifyLoggedinSuccessfully() {
        WebElement btnCart = driver.findElement(By.cssSelector("[data-test='shopping-cart-link']"));
        boolean btnCartIsvisible = btnCart.isDisplayed();
        assertTrue(btnCartIsvisible);
        if (btnCartIsvisible){
            System.out.println("Element is Visible");
            }else{
            System.out.println("Element is InVisible");
        }
    }

    public void clickDropdown(){
        WebElement dropdownSort = driver.findElement(By.cssSelector("[data-test='product-sort-container']"));
        dropdownSort.click();
    }

    public void clickSortHighToLow(){
        driver.findElement(By.cssSelector("option[value='hilo']")).click();
    }

    public void verifySortProducePriceHighToLow(){
        List<WebElement> productPrices = driver.findElements(By.cssSelector("[data-test='inventory-item-price']"));
        boolean sorted = true;
        for (int i = 1; i < productPrices.size(); i++) {
            String textCurrentPrice = (productPrices.get(i).getText()).replace("$", "");
            String textPrevPrice = (productPrices.get(i - 1).getText()).replace("$", "");
            Double currentPrice = Double.parseDouble(textCurrentPrice);
            Double prevPrice = Double.parseDouble(textPrevPrice);
            if (currentPrice > prevPrice) {
                sorted = false;
                break;
            }
        }
        assertTrue(sorted);
    }

    public void addProductToCartByName(String productName){
        WebElement addToCart = driver.findElement(By.xpath("//*[contains(text(),'"+productName+"')]/following::button[1]"));
        addToCart.click();
    }

    public void clickOnCart(){
        WebElement btnCart = driver.findElement(By.cssSelector("[data-test='shopping-cart-link']"));
        btnCart.click();
    }

}
