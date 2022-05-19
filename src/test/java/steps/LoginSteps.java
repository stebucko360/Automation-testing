package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver = null;
    LoginPage loginPage;

    @Given("browser is open")
    public void browser_is_open() {
        System.out.println("user is on the website");
        String projPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projPath + "/src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        loginPage = new LoginPage(driver);
    }
    @When("user is on the main page")
    public void user_is_on_the_main_page() {
        System.out.println("user is on the main page");
        driver.navigate().to("http://the-internet.herokuapp.com/login");
        Assert.assertEquals("The Internet", driver.getTitle());
    }
    @And("user enters the username")
    public void user_enters_the_username() {
        System.out.println("user is entering username");
        loginPage.enterUsername("tomsmith");
    }
    @And("user enters the password")
    public void user_enters_the_password() {
        System.out.println("user is entering password");
        loginPage.enterPassword("SuperSecretPassword!");
    }
    @And("user clicks the login button")
    public void user_clicks_on_the_sign_in_button() {
        System.out.println("user clicks on the sign in button");
        loginPage.login();
    }
    @Then("user is on the secure area")
    public void user_is_on_the_home_page() {
        System.out.println("user is on the secure page");
        Assert.assertEquals("Secure Area", loginPage.secureHeaderText());
        driver.quit();
    }

}
