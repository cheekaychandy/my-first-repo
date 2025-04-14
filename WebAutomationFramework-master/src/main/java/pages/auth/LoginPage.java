package pages.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.POMBase;

public class LoginPage extends POMBase {
    /**
     * Constructor to initialize the WebDriver instance.
     *
     * @param webDriver WebDriver instance to be used by this class.
     */
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    private By usernameLocator = By.name("username");
    private By passwordLocator = By.name("password");

    private By btnLoginLocator = By.xpath("//*[@class='oxd-form']/div[3]/button");


    private By errorMessageLocator = By.xpath("//*[@class='orangehrm-login-error']/div[1]/div[1]/p");

    public void AuthenticateUser(String username, String password){
        setText(usernameLocator,username);
        setText(passwordLocator,password);
        click(btnLoginLocator);
    }

    public String GetErrorMessage()
    {
        return getText(errorMessageLocator);
    }


}
