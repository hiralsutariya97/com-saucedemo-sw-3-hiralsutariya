package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/**
 * userSholdLoginSuccessfullyWithValidCredentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 */
public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {

        //Finding element for username and sending text to username field
        sendTextToElement(By.id("user-name"), "standard_user");

        //Finding element for password and sending text to password field
        sendTextToElement(By.name("password"), "secret_sauce");

        //Finding element to click on login button and perform click
        clickOnElement(By.name("login-button"));

        //Verifying the actual and expected text
        Assert.assertEquals("Invalid name", "Products", getTextFromElement(By.xpath("//span[contains(text(), 'Products')]")));


    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        
        // Finding Element for username and sending text to username field
        sendTextToElement(By.id("user-name"), "standard_user");

        //Finding Element for password and sending text to password field
        sendTextToElement(By.name("password"), "secret_sauce");

        //Finding element to click on login button and perform click
        clickOnElement(By.name("login-button"));

        List<WebElement> productDisplayed = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int count = productDisplayed.size();
        System.out.println("Number of items displayed in the page : " + count);


        List<WebElement> productNames = driver.findElements(By.xpath("//div[@class='inventory_item_description']//div/a"));
        for (WebElement products : productNames) {
            System.out.println(products.getText());
        }
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}