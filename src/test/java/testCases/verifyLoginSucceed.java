package testCases;

import pages.inventoryPage;
import pages.loginPage;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class verifyLoginSucceed {
    public static WebDriver driver;
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
    }
    loginPage loginPage = new loginPage(driver);
    inventoryPage inventoryPage = new inventoryPage(driver);

    @AfterClass
    public static void closeBrowsers(){
        driver.quit();
    }

    @Test
    public void verifyLoginSuccess()
    {
        loginPage.login("standard_user","secret_sauce");
        inventoryPage.verifyLoggedinSuccessfully();
    }

}
