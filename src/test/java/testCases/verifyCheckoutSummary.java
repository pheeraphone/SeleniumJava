package testCases;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.checkoutCompletePage;
import pages.checkoutOverviewPage;
import pages.checkoutYourCartInformationPage;
import pages.inventoryPage;
import pages.loginPage;
import pages.yourCartPage;

public class verifyCheckoutSummary {

    public static WebDriver driver;
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
    }
    loginPage loginPage = new loginPage(driver);
    inventoryPage inventoryPage = new inventoryPage(driver);
    yourCartPage yourCartPage = new yourCartPage(driver);
    checkoutYourCartInformationPage checkoutYourCartInformationPage = new checkoutYourCartInformationPage(driver);
    checkoutOverviewPage checkoutOverviewPage = new checkoutOverviewPage(driver);
    checkoutCompletePage checkoutCompletePage = new checkoutCompletePage(driver);

    @AfterClass
    public static void closeBrowsers(){
        driver.quit();
    }

    @Test
    public void verifyCasesCheckoutSummary()
    {
        loginPage.login("standard_user","secret_sauce");
        inventoryPage.addProductToCartByName("Sauce Labs Backpack");
        inventoryPage.addProductToCartByName("Sauce Labs Bike Light");
        inventoryPage.clickOnCart();
        yourCartPage.clickOnCheckout();
        checkoutYourCartInformationPage.inputCheckoutInformation("Pheeraphon","Moonlao","12000");
        checkoutYourCartInformationPage.clickOnContinueCheckoutPage();
        checkoutOverviewPage.verifyCheckoutOverview("43.18");
    }

}
