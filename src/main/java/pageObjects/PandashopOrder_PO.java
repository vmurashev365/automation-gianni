package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Global_Vars;

public class PandashopOrder_PO extends Base_PO {

    private @FindBy(xpath = "//div[@class='profileIco ico d-none d-sm-inline']//a") WebElement accountEntry;
    private @FindBy(xpath = "//input[@id='txtEmail']") WebElement accountUserName;
    private @FindBy(xpath = "//input[@id='txtPassword']") WebElement accountPassword;
    private @FindBy(xpath = "//input[@class='searchPnl-input ui-autocomplete-input']") WebElement searchProduct_TextField;
    private @FindBy(xpath = "(//i[@class='fa fa-search'])[1]") WebElement searchProduct_Button;
    private @FindBy(xpath = "//span[@class='oneProd-inCos-inner btn btn-green']") WebElement buy_Button;
    private @FindBy(xpath = "//a[@class='btn btn-green w-100']") WebElement cart_Button;
    private @FindBy(css = ".btn.btn.btn-green.text-white.w-100.w-md-auto.btn-gotoSubmitOrder") WebElement prepare_buy_Button;
    //private @FindBy(xpath = "//input[@class='btn btn-green text-white w-100 w-md-auto btn-gotoSubmitOrder']") WebElement prepare_buy_Button;
    private @FindBy(xpath = "(//div[@class='col-12 mt-15px'])[1]") WebElement enter_Button;


    public PandashopOrder_PO(WebElement accountEntry, WebElement accountUserName, WebElement accountPassword, WebElement searchProduct_TextField, WebElement searchProduct_Button, WebElement buy_Button, WebElement cart_Button, WebElement prepare_buy_Button, WebElement enter_Button) {
        this.accountEntry = accountEntry;
        this.accountUserName = accountUserName;
        this.accountPassword = accountPassword;
        this.searchProduct_TextField = searchProduct_TextField;
        this.searchProduct_Button = searchProduct_Button;
        this.buy_Button = buy_Button;
        this.cart_Button = cart_Button;
        this.prepare_buy_Button = prepare_buy_Button;
        this.enter_Button = enter_Button;
    }

    public PandashopOrder_PO() {
        super();

    }


    public void clickOnEntryButton() {
        waitElementToBeClickable(accountEntry);
    }

    public void setAccountUserName(String username) {
        sendKeys(accountUserName, username);
    }

    public void setAccountPassword(String password) {
        sendEcryptedKeys(accountPassword, password);
    }

    public void navigate_toPandashopHome() {
        navigate_To_URL(Global_Vars.PANDA_URL);
    }

    public void setProductName(String product) {
        sendKeys(searchProduct_TextField, product);
    }

    public void clickOnSearchButton() {
        waitElementToBeClickable(searchProduct_Button);
    }

    public void clickOnBuyButton() {
        waitElementToBeClickable(buy_Button);
    }

    public void clickOnCartButton() {
        waitElementToBeClickable(cart_Button);
    }

    public void clickOnPrepareBuyButton() {
        waitElementToBeClickable(prepare_buy_Button);
    }

    public void clickOnEnterButton() {
        waitElementToBeClickable(enter_Button);
    }


}
