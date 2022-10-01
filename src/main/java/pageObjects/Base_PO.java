package pageObjects;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class Base_PO {

    public Base_PO() {
        }


    public WebDriver getDriver () {
        return DriverFactory.getDriver();
    }

    public void navigate_To_URL(String url){
        getDriver().get(url);
    }

    public String generateRandomNumber(int length){
        return RandomStringUtils.randomNumeric(length);}

}
