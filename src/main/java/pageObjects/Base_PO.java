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

    public void handle_window () {
        Set<String> windows = getDriver().getWindowHandles();
        Iterator<String>it = windows.iterator();
        String parentID = it.next();
        String childID = it.next();
        getDriver().switchTo().window(childID);
    }

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public void sendKeys(WebElement element, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }

    public void selectDropDown(WebElement element, String textSelected) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(textSelected);
    }

    public void suggestiveDropDown(List<WebElement> element, String textSelected) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_TIMEOUT));
        //wait.until(ExpectedConditions.elementToBeClickable((By) element));
        List<WebElement> options = element;
        for(WebElement option :options){

            if (option.getText().contains(textSelected))
            {
                System.out.println(option.getText());
                option.click();
                break;
            }
        }
    }

    public void clearField (WebElement element, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
    }

    public void sendEcryptedKeys(WebElement element, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_TIMEOUT));
        byte[] decodedPass = Base64.getDecoder().decode(textToType);
        String decodedPassStr = new String(decodedPass, StandardCharsets.UTF_8);
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(decodedPassStr);
    }

    public void sendKeys(By by, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
    }

    public void waitElementToBeClickable(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void waitElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitElementToBeClickableAndFocused(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).click().build().perform();
    }

    public void waitElementToBeEnabled(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
    }

    public void waitElementToBeSelected(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeSelected(element));
        element.isSelected();
    }

    public void waitElementToBeSelectedAndFocused(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeSelected(element));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).click(element);
        element.isSelected();
    }


    public void waitForAlertAndValidateMessage(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.alertIsPresent());
        String alertMessageText = getDriver().switchTo().alert().getText();
        Assert.assertEquals(alertMessageText, text);
    }

    public void waitForAlertAndCancelMessage() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(getDriver().switchTo().alert().getText());
        getDriver().switchTo().alert().accept();

    }

    public void waitFor(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitFor(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
