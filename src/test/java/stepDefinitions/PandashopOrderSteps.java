package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.Base_PO;
import pageObjects.PandashopOrder_PO;

public class PandashopOrderSteps extends Base_PO {
    private WebDriver driver = getDriver();
    private PandashopOrder_PO pandashopOrder_po;


    public PandashopOrderSteps(PandashopOrder_PO pandashopOrder_po) {
        this.pandashopOrder_po = pandashopOrder_po;
    }

    @Given("I access the Pandashop home page")
    public void i_access_the_pandashop_home_page() {

        pandashopOrder_po.navigate_toPandashopHome();
        pandashopOrder_po.clickOnEntryButton();
    }

    @Given("I click on Log In icon")
    public void i_click_on_log_in_icon() {
        pandashopOrder_po.clickOnEntryButton();
    }

    @When("I click on search field, type {} and click on search button")
    public void i_click_on_search_field_type_sven_ps_and_click_on_search_button(String product) {
        pandashopOrder_po.setProductName(product);
        pandashopOrder_po.clickOnSearchButton();

    }


    @Then("Product named {} should be returned as result of the searching")
    public void product_named_sven_ps_should_be_returned_as_result_of_the_searching(String productReturned) {
        String searchResult = "//span[contains(text(),'" + productReturned + "')]";
        waitFor(By.xpath(searchResult));
    }

    @Then("Click on the link related to the found {} to buy it")
    public void click_on_the_link_related_to_the_found_sven_ps_blue_to_buy_it(String productReturned) {
        String searchResult = "//span[contains(text(),'" + productReturned + "')]";
        waitElementToBeClickable(By.xpath(searchResult));
        String productToBuy = "//h1[contains(text(),'" + productReturned + "')]";
        waitFor(By.xpath(productToBuy));
    }


    @When("Click on Buy button")
    public void click_on_buy_button() {
        pandashopOrder_po.clickOnBuyButton();
    }

    @When("Click on Add-To-Cart button")
    public void click_on_add_to_cart_button() {
        pandashopOrder_po.clickOnCartButton();
    }


    @And("Click on Processed To Checkout Button")
    public void clickOnProcessedToCheckoutButton() {
        pandashopOrder_po.clickOnPrepareBuyButton();
    }

    @Given("I enter Panda username {}")
    public void i_enter_a_panda_username(String username) throws InterruptedException {
        Thread.sleep(1000);
        pandashopOrder_po.setAccountUserName(username);
    }

    @Given("I enter Panda password {}")
    public void i_enter_a_panda_password(String password) {
        pandashopOrder_po.setAccountPassword(password);
    }

    @Given("Click on Enter button")
    public void click_on_enter_button() {
        pandashopOrder_po.clickOnEnterButton();
    }

    @Then("I enter my name and last name {}")
    public void iEnterMyNameAndLastName(String buyerName) {
        pandashopOrder_po.setBuyerName(buyerName);
    }
    @Then("I enter my phone {}")
    public void i_enter_my_phone(String phone) {
        pandashopOrder_po.setPhoneNumber(phone);
    }
    @And("I select delivery by Courier to address: city {}, str. {}, bl. {}, ap. {}")
    public void iSelectDeliveryByCourierToAddress(String cityName, String streetName, String house, String appartment) throws InterruptedException {
        pandashopOrder_po.setInfoForCourierDelivery(cityName, streetName, house, appartment);
    }
    @Then("I select to pay by Bank Transfer to Company {}, Bank {}, IBAN {}, address {}, fiscal {}")
    public void i_select_to_pay_by_bank_transfer(String company, String bank, String ibanNum, String address, String fiscalCode) {
        pandashopOrder_po.setInfoForBankTransfer(company, bank, ibanNum, address, fiscalCode);

    }
    @Then("I buy with bonuses {}")
    public void i_buy_with_bonuses(String bonusVal) {
        pandashopOrder_po.setBonuses(bonusVal);
    }


    @And("I enter the following note {}")
    public void iEnterTheFollowingNoteNoteToTheOrder(String commentTxt) {
        pandashopOrder_po.setCommentText(commentTxt);
    }



}
