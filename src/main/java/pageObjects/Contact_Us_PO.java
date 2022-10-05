package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;


public class Contact_Us_PO extends Base_PO {

    private @FindBy(xpath = "//input[@name='first_name']") WebElement firstNameTextField;
    private @FindBy(xpath = "//input[@name='last_name']") WebElement lastNameTextField;
    private @FindBy(xpath = "//input[@name='email']") WebElement emailAddressTextField;
    private @FindBy(how = How.XPATH, using = "//textarea[@name='message']") WebElement commentTextField;
    private @FindBy(xpath = "//input[@type='submit']") WebElement clickOnSubmitButton;
    private @FindBy(xpath = "//div[@id='contact_reply']/h1") WebElement submissionMessageText;

    public Contact_Us_PO() {
        super();
    }

    public void navigateWebDriverContactUsPage() {
        navigate_To_URL("https://webdriveruniversity.com/Contact-Us/contactus.html");
    }


    public void setUniqueFirstName() {
        sendKeys(firstNameTextField, "AutoFN" + generateRandomNumber(5));

    }

    public void setUniqueLastName() {
        sendKeys(lastNameTextField, "AutoLN" + generateRandomNumber(5));
    }

    public void setEmailAddress() {
        sendKeys(emailAddressTextField, "AutoEmail" + generateRandomNumber(10) + "@mail.com");
    }

    public void setUniqueComment() {
        sendKeys(commentTextField, "Hello world");
    }

    public void setSpecificFirstName(String firstName) {
        sendKeys(firstNameTextField, firstName);
    }

    public void setSpecificLastName(String lastName) {
        sendKeys(lastNameTextField, lastName);
    }

    public void setSpecificEmailAddress(String emailAddress) {
        sendKeys(emailAddressTextField, emailAddress);
    }

    public void setSpecificComment(String comment) {
        sendKeys(commentTextField, comment);
    }

    public void clickOnSubmitButton() {
        clickOnSubmitButton.click();
    }

    public void validateForSuccessfulMessage() {
        waitFor(submissionMessageText);
        Assert.assertEquals(submissionMessageText.getText(), "Thank You for your Message!");
    }
}
