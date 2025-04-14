package pages.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.POMBase;

public class HomePage extends POMBase {
    /**
     * Constructor to initialize the WebDriver instance.
     *
     * @param webDriver WebDriver instance to be used by this class.
     */
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
    By headingLocator = By.xpath("//*[@class='oxd-topbar-header-breadcrumb']/h6");
    public String GetHeading(){
        return getText(headingLocator);
    }

}
