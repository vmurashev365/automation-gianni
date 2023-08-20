package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Global_Vars;

import java.util.List;

import static java.lang.Thread.sleep;

public class PandashopOrder_PO extends Base_PO {

    private @FindBy(xpath = "//div[@class='profileIco ico d-none d-sm-inline']//a") WebElement accountEntry;

    private @FindBy(xpath = "//input[@id='txtEmail']") WebElement accountUserName;
    private @FindBy(xpath = "//input[@id='txtPassword']") WebElement accountPassword;
    private @FindBy(xpath = "//input[@class='searchPnl-input ui-autocomplete-input']") WebElement searchProduct_TextField;
    private @FindBy(xpath = "(//i[@class='fa fa-search'])[1]") WebElement searchProduct_Button;
    private @FindBy(xpath = "//span[@class='oneProd-inCos-inner btn btn-green']") WebElement buy_Button;
    private @FindBy(xpath = "//a[@class='btn btn-green w-100']") WebElement cart_Button;
    private @FindBy(css = ".text-center > input:nth-of-type(1)") WebElement prepare_buy_Button;
    //private @FindBy(xpath = "//input[@class='btn btn-green text-white w-100 w-md-auto btn-gotoSubmitOrder']") WebElement prepare_buy_Button;
    private @FindBy(xpath = "(//div[@class='col-12 mt-15px'])[1]") WebElement enter_Button;
    private @FindBy(xpath = "//input[@name='name']") WebElement name_Last_Name;
    private @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/form/div[1]/div[1]/div[2]/div[3]/div[2]/div/div") WebElement phone;
    private @FindBy(xpath = "//body/div[@class='body-inner']/div[@class='container-fluid container-fluid_wrapper']/div[@class='container-fluid_inner']/div[@class='wrapperDefault_inner']/form[@class='cart-mainOuter vld-form vld-form-cart']/div[@class='row']/div[@class='col-12 col-lg-8']/div/div[@class='radio-container mt-20px w-100']/div[@class='container-inner w-100']/span[1]") WebElement courierRadio;
    private @FindBy(xpath = "(//span[@class='radio-box'])[4]") WebElement newAddressRadio;
    private @FindBy(name = "city") WebElement city;
    private @FindBy(xpath = "//li[@class='ui-menu-item city']")  List<WebElement> listCities;
    private @FindBy(xpath = "//input[@name='street-address']") WebElement streetAddress;
    private @FindBy(xpath = "//input[@name='street-address-house']") WebElement streetAddressHouse;
    private @FindBy(xpath = "//input[@name='street-address-apartment']") WebElement streetAddressApartment;
    private @FindBy(css = "label[class='radio-container d-flex mb-20px payway-Transfer'] span[class='radio-box']") WebElement bankTransferRadio;
    private @FindBy(xpath = "//input[@name='companyName']") WebElement companyName;
    private @FindBy(xpath = "//input[@name='bankCode']") WebElement bankCode;
    private @FindBy(xpath = "//input[@name='bankAccount']") WebElement bankAccount;
    private @FindBy(xpath = "//input[@name='addressJuridic']") WebElement addressJuridic;
    private @FindBy(xpath = "//input[@name='codeFiscal']") WebElement codeFiscal;
    private @FindBy(css = "#cbBonusExpenditure") WebElement bonusCheckBox;
    private @FindBy(xpath = "(//input[@id='txtBonusExpenditure'])[1]") WebElement bonusValue;
    private @FindBy(xpath = "//textarea[@name='comment']") WebElement commentOfOrder;


    public PandashopOrder_PO(WebElement accountEntry, WebElement accountUserName, WebElement accountPassword, WebElement searchProduct_TextField,
                             WebElement searchProduct_Button, WebElement buy_Button, WebElement cart_Button, WebElement prepare_buy_Button, WebElement enter_Button,
                             WebElement name_Last_Name, WebElement phone, WebElement courierRadio, WebElement newAddressRadio, WebElement city, WebElement streetAddress,
                             WebElement streetAddressHouse, WebElement streetAddressApartment, WebElement bankTransferRadio, WebElement companyName, WebElement bankCode,
                             WebElement bankAccount, WebElement addressJuridic, WebElement codeFiscal, WebElement bonusCheckBox, WebElement bonusValue, WebElement commentOfOrder,
                             List<WebElement> listCities) {
        this.accountEntry = accountEntry;
        this.accountUserName = accountUserName;
        this.accountPassword = accountPassword;
        this.searchProduct_TextField = searchProduct_TextField;
        this.searchProduct_Button = searchProduct_Button;
        this.buy_Button = buy_Button;
        this.cart_Button = cart_Button;
        this.prepare_buy_Button = prepare_buy_Button;
        this.enter_Button = enter_Button;
        this.name_Last_Name = name_Last_Name;
        this.phone = phone;
        this.courierRadio = courierRadio;
        this.newAddressRadio = newAddressRadio;
        this.city = city;
        this.streetAddress = streetAddress;
        this.streetAddressHouse = streetAddressHouse;
        this.streetAddressApartment = streetAddressApartment;
        this.bankTransferRadio = bankTransferRadio;
        this.companyName = companyName;
        this.bankCode = bankCode;
        this.bankAccount = bankAccount;
        this.addressJuridic = addressJuridic;
        this.codeFiscal = codeFiscal;
        this.bonusCheckBox = bonusCheckBox;
        this.bonusValue = bonusValue;
        this.commentOfOrder = commentOfOrder;
        this.listCities = listCities;
    }

    public PandashopOrder_PO() {
        super();

    }


    public void clickOnEntryButton() {
        waitElementToBeClickable(accountEntry);
    }

    public void setAccountUserName(String username) {
        waitElementToBeEnabled(accountUserName);
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

    public void setBuyerName(String buyerName) {
        clearField(name_Last_Name, buyerName);
        sendKeys(name_Last_Name, buyerName);
    }

    public void setPhoneNumber(String phoneNumber) {
        sendKeys(phone, phoneNumber);
    }

    public void setInfoForCourierDelivery(String cityName, String streetName, String house, String appartment) throws InterruptedException {
        waitElementToBeClickableAndFocused(courierRadio);
        waitElementToBeClickableAndFocused(newAddressRadio);

        waitElementToBeClickable(city);
        sendKeys(city, cityName);
        sleep(2000);
        suggestiveDropDown(listCities, cityName);
        sendKeys(streetAddress, streetName);
        sendKeys(streetAddressHouse, house);
        sendKeys(streetAddressApartment, appartment);
    }

    public void setInfoForBankTransfer(String company, String bank, String ibanNum, String address, String fiscalCode) {
        waitElementToBeClickableAndFocused(bankTransferRadio);
        sendKeys(companyName, company);
        sendKeys(bankCode, bank);
        sendKeys(bankAccount, ibanNum);
        sendKeys(addressJuridic, address);
        sendKeys(codeFiscal, fiscalCode);
    }

    public void setBonuses(String bonusVal) {
        waitElementToBeSelectedAndFocused(bonusCheckBox);
        clearField(bonusValue, bonusVal);
        sendKeys(bonusValue, bonusVal);
    }

    public void setCommentText(String commentTxt) {
        clearField(commentOfOrder, commentTxt);
        sendKeys(commentOfOrder, commentTxt);
    }
}
