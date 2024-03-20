package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.Base_PO;
import pageObjects.Contact_Us_PO;


public class contactUsSteps extends Base_PO {

    private final WebDriver driver = getDriver();

    private final Contact_Us_PO contact_us_po;

    public contactUsSteps(Contact_Us_PO contact_us_po) {
        this.contact_us_po = contact_us_po;
    }

    @Given("I access the webdiver university contact us page")
    public void i_access_the_webdiver_university_contact_us_page() {
        contact_us_po.navigateWebDriverContactUsPage();
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        contact_us_po.setUniqueFirstName();
    }

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        contact_us_po.setUniqueLastName();
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        contact_us_po.setEmailAddress();
    }


    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        contact_us_po.setUniqueComment();
    }

    @When("I enter  a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        //driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
        contact_us_po.setSpecificFirstName(firstName);
    }

    @When("I enter  a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        contact_us_po.setSpecificLastName(lastName);
    }

    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String emailAddress) {
        contact_us_po.setSpecificEmailAddress(emailAddress);
    }

    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        contact_us_po.setSpecificComment(comment);
    }

    @And("I click Submit button")
    public void i_click_submit_button() {

        //driver.findElement(By.xpath("//input[@type='submit']")).click();
        contact_us_po.clickOnSubmitButton();
    }

    @Then("I should be presented with contact us submission message")
    public void i_should_be_presented_with_contact_us_submission_message() {
        //WebElement contactUsSubmissionMessage = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        //Assert.assertEquals(contactUsSubmissionMessage.getText(), "Thank You for your Message!");

        contact_us_po.validateForSuccessfulMessage();
    }

}
