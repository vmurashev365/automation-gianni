package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.Base_PO;
import pageObjects.crSearchSection_PO;


public class crSearchSectionSteps extends Base_PO{

    private final WebDriver driver = getDriver();
    private final crSearchSection_PO crSearchSectionPo;

    public crSearchSectionSteps(crSearchSection_PO crSearchSectionPo) { this.crSearchSectionPo = crSearchSectionPo; }


    @Given("I am on the CR Beta as any user")
    public void i_am_on_the_cr_beta_as_any_user() {
        // Write code here that turns the phrase above into concrete actions
        crSearchSectionPo.navigateCRHomePage();

    }
    @When("I click on the search icon")
    public void i_click_on_the_search_icon() {
        // Write code here that turns the phrase above into concrete actions
        crSearchSectionPo.clickOnSearchIcon();

    }
    @And("I fill in the search field with {string}")
    public void i_fill_in_the_search_field_with(String string) {
        // Write code here that turns the phrase above into concrete actions
        crSearchSectionPo.typeInSearchField();
    }
    @And("I click on any card from the top results section")
    public void i_click_on_any_card_from_the_top_results_section() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I should be redirected to the desired content page")
    public void i_should_be_redirected_to_the_desired_content_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
