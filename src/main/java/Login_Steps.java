import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class Login_Steps {
    private WebDriver driver;

    @Given("the user is on the GitHub login page")
    public void user_is_on_login_page() {
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\Jala\\Downloads\\geckodriver-v0.33.0-win64");
        driver = new FirefoxDriver();
        // Code to navigate to the login page
        driver.get("https://github.com/login");
        driver.manage().window().maximize();
        System.out.println("User is on the login page");
    }

    @When("the user enters valid GitHub username and password")
    public void user_enters_username_and_password() {
        // Code to enter username and password
        WebElement usernameInput = driver.findElement(By.id("login_field"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        usernameInput.sendKeys("zhale7");
        passwordInput.sendKeys("Jala7799");
        System.out.println("User enters username and password");
    }

    @When("clicks on the login button")
    public void clicks_on_sign_in_button() {
        // Code to click on the login button
        WebElement signInButton = driver.findElement(By.cssSelector("#login > div.auth-form-body.mt-3 > form > div > input.btn.btn-primary.btn-block.js-sign-in-button"));
        signInButton.click();
        System.out.println("User clicks on login button");
    }

    @Then("the user is navigated to the GitHub homepage")
    public void user_is_navigated_to_homepage() {
        // Code to verify navigation to the homepage
        assertTrue(driver.getCurrentUrl().startsWith("https://github.com/"));
        System.out.println("User is navigated to the homepage");
        driver.quit();
    }
}