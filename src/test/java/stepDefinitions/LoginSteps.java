package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;


public class LoginSteps {

    private WebDriver driver;

    @Before("@login")
    public void setup_Chrome() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After("@login")
    public void tearDown() {
        driver.quit();
    }

    @Given("I access the webdiver university login page")
    public void i_access_the_webdiver_university_login_page() {
        driver.get("https://www.webdriveruniversity.com/Login-Portal/index.html?");
    }
    @When("I enter a username {}")
    public void i_enter_a_username(String username) {
        driver.findElement(By.id("text")).sendKeys(username);
    }

    @And("I enter a password {}")
    public void i_enter_a_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("I should be presented with the successful login message")
    public void i_should_be_presented_with_the_successful_login_message() {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message, "validation succeeded");
    }

    @Then("I should be presented with the unsuccessful login message")
    public void i_should_be_presented_with_the_unsuccessful_login_message() {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message, "validation failed");
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() {
        driver.findElement(By.id("login-button")).click();
    }
     @When("I enter username {word}")
    public void i_enter_username_webdriver(String username) {
        driver.findElement(By.id("text")).sendKeys(username);
    }


    @And("I enter password {}")
    public void i_enter_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("I click on login button")
    public void i_click_on_login_button() {
        driver.findElement(By.id("login-button")).click();
    }


    @Then("I should presented with the following login validation message {}")
    public void i_should_presented_with_the_following_login_validation_message_validation_succeeded(String expectedMessage) {
        String login_message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_message, expectedMessage);
    }

}
