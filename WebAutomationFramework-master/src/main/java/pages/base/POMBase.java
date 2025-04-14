package pages.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.ApplicationConstants;

/**
 * Base Page Object Model (POM) class that provides common utility methods
 * for interacting with web elements using Selenium WebDriver.
 */
public class POMBase {
    public WebDriver driver;

    /**
     * Constructor to initialize the WebDriver instance.
     * 
     * @param webDriver WebDriver instance to be used by this class.
     */
    public POMBase(WebDriver webDriver) {
        this.driver = webDriver;
    }

    /**
     * Highlights a web element by changing its style using JavaScript.
     * 
     * @param element WebElement to be highlighted.
     */
    public void highLightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: #89cff0; border: 2px solid red;');", element);
        try {
            Thread.sleep(500); // Pause to make the highlight visible
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Waits for a web element to become visible on the page.
     * 
     * @param element WebElement to wait for.
     */
    public void waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ApplicationConstants.WEB_DRIVER_WAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Clears the text of an input field.
     * 
     * @param by Locator of the input field.
     */
    public void clearText(By by) {
        var element = driver.findElement(by);
        waitForVisibility(element);
        highLightElement(element);
        element.clear();
    }

    /**
     * Clicks on a web element.
     * 
     * @param by Locator of the element to be clicked.
     */
    public void click(By by) {
        var element = driver.findElement(by);
        waitForVisibility(element);
        highLightElement(element);
        element.click();
    }

    /**
     * Sets text in an input field.
     * 
     * @param by   Locator of the input field.
     * @param text Text to be entered.
     */
    public void setText(By by, String text) {
        var element = driver.findElement(by);
        waitForVisibility(element);
        highLightElement(element);
        element.sendKeys(text);
    }

    /**
     * Retrieves the text of a web element.
     * 
     * @param by Locator of the element.
     * @return Text of the element.
     */
    public String getText(By by) {
        var element = driver.findElement(by);
        waitForVisibility(element);
        highLightElement(element);
        return element.getText();
    }

    /**
     * Checks if a web element is displayed on the page.
     * 
     * @param by Locator of the element.
     * @return True if the element is displayed, otherwise false.
     */
    public boolean isDisplayed(By by) {
        var element = driver.findElement(by);
        waitForVisibility(element);
        highLightElement(element);
        return element.isDisplayed();
    }

    /**
     * Retrieves the title of the current page.
     * 
     * @return Title of the page.
     */
    public String getPageTitle() {
        return driver.getTitle();
    }
}
