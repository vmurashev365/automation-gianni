package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepDefinitions.base.Hooks;

import static driver.DriverFactory.getDriver;


public class contactUsSteps {

private WebDriver driver = (WebDriver) getDriver();

    public String generateRandomNumber(int length){
        return RandomStringUtils.randomNumeric(length);
    }
    @Given("I access the webdiver university contact us page")
    public void i_access_the_webdiver_university_contact_us_page() {
        driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {

        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("AutoFN" + generateRandomNumber(5));
    }

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {

        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Blogs" + generateRandomNumber(5));
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("AutoEmail" + generateRandomNumber(10) + "@mail.com");
        }


    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Hello world");
    }

    @When("I enter  a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
    }
    @When("I enter  a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastName);
    }
    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String emailAddress) {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(emailAddress);
    }
    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(comment);
    }


    @And("I click Submit button")
    public void i_click_submit_button() {

        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("I should be presented with contact us submission message")
    public void i_should_be_presented_with_contact_us_submission_message() {
        WebElement contactUsSubmissionMessage= driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(contactUsSubmissionMessage.getText(), "Thank You for your Message!");
    }

}
