package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PO extends Base_PO {

    private @FindBy(id = "text") WebElement username_TextField;
    private @FindBy(id = "password") WebElement password_TextField;
    private @FindBy(id = "login-button") WebElement loginButton;

    public Login_PO(WebElement username_TextField, WebElement password_TextField, WebElement loginButton) {
        this.username_TextField = username_TextField;
        this.password_TextField = password_TextField;
        this.loginButton = loginButton;
    }

    public Login_PO() {
        super();

    }

    public void navigate_toWeb_DriverUniversity_LoginPage() {
        navigate_To_URL("https://www.webdriveruniversity.com/Login-Portal/index.html?");
    }

    public void setUserName(String username) {
        sendKeys(username_TextField, username);
    }

    public void setPassword(String password) {
        sendKeys(password_TextField, password);
    }

    public void click_OnLoginButton() {
        waitElementToBeClickable(loginButton);
    }

    public void validateForMessage(String text){
        waitForAlertAndValidateMessage(text);
    }

}
