package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Login_PO;


public class LoginSteps extends Base_PO {
    private WebDriver driver = getDriver();
    private Login_PO login_po;

    public LoginSteps(Login_PO login_po) {
        this.login_po = login_po;
    }

    @Given("I access the webdiver university login page")
    public void i_access_the_webdiver_university_login_page() {
        login_po.navigate_toWeb_DriverUniversity_LoginPage();
    }

    @When("I enter a username {}")
    public void i_enter_a_username(String username) {
        login_po.setUserName(username);
    }

    @And("I enter a password {}")
    public void i_enter_a_password(String password) {
        login_po.setPassword(password);
    }

    @Then("I should be presented with the successful login message")
    public void i_should_be_presented_with_the_successful_login_message() {
        login_po.validateForMessage("validation succeeded");
    }

    @Then("I should be presented with the unsuccessful login message")
    public void i_should_be_presented_with_the_unsuccessful_login_message() {
        login_po.validateForMessage("validation failed");
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() {

        //driver.findElement(By.id("login-button")).click();
        login_po.click_OnLoginButton();
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

        //driver.findElement(By.id("login-button")).click();
        waitElementToBeClickable(By.id("login-button"));
    }


    @Then("I should presented with the following login validation message {}")
    public void i_should_presented_with_the_following_login_validation_message_validation_succeeded(String expectedMessage) {
        login_po.validateForMessage(expectedMessage);
    }

}
