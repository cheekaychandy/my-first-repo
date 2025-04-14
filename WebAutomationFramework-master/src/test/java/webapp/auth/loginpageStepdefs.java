package webapp.auth;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.auth.HomePage;
import pages.auth.LoginPage;
import webapp.hooks.AuthHooks;
public class loginpageStepdefs {
    AuthHooks authHooks;
    LoginPage loginPage;
    HomePage homePage;

    @Given("User is on HRMLogin page {string}")
    public void loginTest(String url) {
        authHooks.driver.get(url);
        loginPage = new LoginPage(authHooks.driver);
    }

    @When("User enters username as {string} and password as {string}")
    public void goToHomePage(String userName, String passWord) {
        loginPage.AuthenticateUser(userName,passWord);
    }

    @Then("User should be able to login successfully and new page open")
    public void verifyLogin() {
        homePage = new HomePage(authHooks.driver);
        String actual = homePage.GetHeading();
        String expected = "Dashboard";
        Assert.assertEquals(expected,actual);
    }

    @Then("User should be able to see error message {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {
        String actual = loginPage.GetErrorMessage();
        String expected = "Dashboard";
        Assert.assertEquals(expected,actual);
    }
}
