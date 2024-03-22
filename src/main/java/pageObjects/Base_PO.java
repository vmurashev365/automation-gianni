package pageObjects;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Global_Vars;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class Base_PO {

    public Base_PO() {
        PageFactory.initElements(getDriver(), this);
    }


    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void navigate_To_URL(String url) {
        getDriver().get(url);
    }

    public void handle_window() {
        Set<String> windows = getDriver().getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentID = it.next();
        String childID = it.next();
        getDriver().switchTo().window(childID);
    }

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    private WebDriverWait getWebDriverWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_TIMEOUT));
    }

    private Actions performActions() {
        return new Actions(getDriver());
    }

    private Select dropdown() {
        return new Select((WebElement) getDriver());
    }


    public void sendKeys(WebElement element, String textToType) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }

    public void selectDropDown(WebElement element, String textSelected) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
        dropdown().selectByVisibleText(textSelected);
    }

    public void suggestiveDropDown(List<WebElement> element, String textSelected) {
        List<WebElement> options = element;
        for (WebElement option : options) {

            if (option.getText().contains(textSelected)) {
                System.out.println(option.getText());
                option.click();
                break;
            }
        }
    }

    public void clearField(WebElement element, String textToType) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element)).clear();
    }

    public void sendEcryptedKeys(WebElement element, String textToType) {
        byte[] decodedPass = Base64.getDecoder().decode(textToType);
        String decodedPassStr = new String(decodedPass, StandardCharsets.UTF_8);
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element)).sendKeys(decodedPassStr);
    }

    public void waitElementToBeClickable(By by) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void waitElementToBeClickable(WebElement element) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitElementToBeClickableAndFocused(WebElement element) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
        performActions().moveToElement(element).click().build().perform();
    }

    public void waitElementToBeEnabled(WebElement element) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
    }

    public void waitElementToBeSelectedAndFocused(WebElement element) {
        performActions().moveToElement(element).click(element).perform();
        getWebDriverWait().until(ExpectedConditions.elementToBeSelected(element));
        element.isSelected();
    }


    public void waitForAlertAndValidateMessage(String text) {
        getWebDriverWait().until(ExpectedConditions.alertIsPresent());
        String alertMessageText = getDriver().switchTo().alert().getText();
        Assert.assertEquals(alertMessageText, text);
    }


    public void waitFor(By by) {
        getWebDriverWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitFor(WebElement element) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(element));
    }

}
