package pageObjects;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Global_Vars;

import java.util.Set;
import java.util.Iterator;

import java.time.Duration;


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
