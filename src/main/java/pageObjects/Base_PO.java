package pageObjects;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
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
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Base_PO {

    private WebDriverWait webDriverWait;
    private WebDriver webDriver;
    public Base_PO() {
        webDriver = DriverFactory.getDriver();
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(Global_Vars.DEFAULT_TIMEOUT));
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

    public void closePopupIfPresent(By popupSelector, By closeButtonSelector) {
        List<WebElement> popups = getDriver().findElements(popupSelector);
        if (!popups.isEmpty()) {
            System.out.println("Обнаружено всплывающее окно. Пытаюсь закрыть...");
            // Проверяем наличие кнопки закрытия внутри всплывающего окна
            WebElement closeButton = popups.get(0).findElement(closeButtonSelector);
            if (closeButton != null) {
                closeButton.click();
                System.out.println("Всплывающее окно закрыто.");
            }
        }
    }

    public void setupPopupCloser(By popupSelector, By closeButtonSelector) {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(() -> {
            try {
                closePopupIfPresent(popupSelector, closeButtonSelector);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, 1, TimeUnit.SECONDS); // Проверка каждые 2 секунды
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdown();
        }
    }


    public void sendKeysFill(WebElement element, String textToType) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }

    public void sendKeys(WebElement element, String textToType) {
        for (char c : textToType.toCharArray()) {
            try {
                Thread.sleep(RandomUtils.nextInt(50, 100)); // Имитация задержки между нажатиями клавиш
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            element.sendKeys(String.valueOf(c));
        }
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
        //sendKeys(element, decodedPassStr);
    }

    public void waitElementToBeClickable(By by) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    /*public void waitElementToBeClickable(WebElement element) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element)).click();
    }*/

    public void waitElementToBeClickable(WebElement element) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
        performActions().moveToElement(element).pause(Duration.ofMillis(500)).click().build().perform();
    }

    /*public void waitElementToBeClickableAndFocused(WebElement element) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
        performActions().moveToElement(element).click().build().perform();
    }*/

    public void waitElementToBeClickableAndFocused(WebElement element) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
        performActions().moveToElement(element).pause(Duration.ofMillis(500)).click().build().perform();
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
