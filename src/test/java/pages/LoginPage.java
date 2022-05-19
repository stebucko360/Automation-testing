package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver = null;
    @FindBy(id = "username")
    WebElement txt_username;
    @FindBy(id = "password")
    WebElement txt_password;
    @FindBy(className = "radius")
    WebElement btn_submit;
    @FindBy(xpath = "//*[@id=\"content\"]/div/h2")
    WebElement secureAreaHeader;
    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // this statement will initialise all of the above elements
        PageFactory.initElements(driver, this);
    }
    public void enterUsername(String username) {
        txt_username.sendKeys(username);
    }
    public void enterPassword(String password) {
        txt_password.sendKeys(password);
    }
    public void login() {
        btn_submit.click();
    }
    public String secureHeaderText() {
        return secureAreaHeader.getText();
    }

}
