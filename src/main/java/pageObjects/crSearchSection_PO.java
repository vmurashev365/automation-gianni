package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Global_Vars;

public class crSearchSection_PO extends Base_PO {
    private @FindBy(css = "title#search-svg") WebElement searchIcon;
    private @FindBy(css = "input.search-input") WebElement searchField;
    private @FindBy(xpath = "//input[@name='email']") WebElement emailAddressTextField;
    private @FindBy(how = How.XPATH, using = "//textarea[@name='message']") WebElement commentTextField;
    private @FindBy(xpath = "//input[@type='submit']") WebElement clickOnSubmitButton;
    private @FindBy(xpath = "//div[@id='contact_reply']/h1") WebElement submissionMessageText;

    public crSearchSection_PO() {  super();  }

    public void navigateCRHomePage() {
        navigate_To_URL(Global_Vars.HOME_CR);
    }

    public void clickOnSearchIcon() {
        waitElementToBeClickable(searchIcon);
    }

    public void typeInSearchField() {
        sendKeys(searchField, "the");
    }



}
