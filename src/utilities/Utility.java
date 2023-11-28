package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    /**
     * This method will click on any element whatever locator we pass
     */

    public void clickOnElement(By by){
        driver.findElement(by).click();
    }

    /**
     * This method will send text to element
     */
    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will get text from element
     */

    public String getTextFromElement(By by){
        return  driver.findElement(by).getText();
    }

    //*************************** Alert Methods ********************

    /**
     * This method will switch to alert
     */
    public void switchAlert(){
        driver.switchTo().alert();
    }

    /**
     * This method will accept alert
     */
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    /**
     * This method will dismiss alert
     */
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    /**
     * This method will get text from alert
     */
    public void getTextFromAlert(){
        driver.switchTo().alert().getText();
    }

    //************************* Select Class Methods ****************************

    /**
     * This method will select by value from drop down
     */

    public void selectByValueFromDropDown(By by, String value){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }

    /**
     * This method will select by Visible text from drop down
     */

    public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    /**
     * This method will select by index from drop down
     */

    public void selectByIndexFromDropDown(By by, int index){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }

    //*********************** Action Methods *************************

    /**
     * This method will use to hover mouse on element
     */

    public void mouseHoverToElement(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }
}
