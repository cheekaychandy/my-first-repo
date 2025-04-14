package webapp.hooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthHooks {
    public static WebDriver driver;
    public final static int TIMEOUT = 5;

    /**
     * This method sets up the WebDriver before each test scenario.
     */
    @Before
    public void setUp() {
        // Set up WebDriverManager for ChromeDriver
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        WebDriverManager.chromedriver().setup();

        // Configure ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "135.0.7049.84"); // Specify browser version
        //options.addArguments("headless=true"); // Run in headless mode
        options.addArguments("window-size=1200,800"); // Set browser window size
        options.addArguments("disable-infobars"); // Disable infobars
        //options.addArguments("--headless=chrome"); // Additional headless argument

        // Initialize WebDriver with ChromeOptions
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT)); // Set implicit wait timeout
    }

    /**
     * This method tears down the WebDriver after each test scenario.
     * It also captures a screenshot if the scenario fails.
     *
     * @param scenario The current test scenario
     */
    @After
    public void tearDown(Scenario scenario) {
        try {
            // Capture screenshot if the scenario fails
            if (scenario.isFailed()) {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "img/png", scenario.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the WebDriver
            driver.quit();
        }
    }
}
