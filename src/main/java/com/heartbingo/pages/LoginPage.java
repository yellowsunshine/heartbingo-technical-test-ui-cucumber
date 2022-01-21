package com.heartbingo.pages;

import com.heartbingo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Utility {

    //logger defined to print logs
    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    //Constructor used to initialise the WebElements with @FindBy annotation to this page
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (xpath = "//a[normalize-space()='Log In']")
    WebElement loginButton;

    @CacheLookup
    @FindBy (xpath = "//iframe[@class='oneauth-iframe']")
    WebElement iFrame;

    @CacheLookup
    @FindBy(id = "username")
    WebElement userName;

    @CacheLookup
    @FindBy(id = "password")
    WebElement password;

    @CacheLookup
    @FindBy(name = "login_submit")
    WebElement logIn;

    @CacheLookup
    @FindBy(className = "login_errorMessageWrapper__2ZcGx")
    WebElement loginError;

    public void clickOnLogInButton(){
        doClickOnElement(loginButton);
        log.info("Clicking on Login button : " + loginButton.toString());
    }

    public void logIn(String email, String pw){
        doSwitchToIframe(iFrame);
        log.info("Switching to the iframe : " + iFrame.toString());
        doSendTextToElement(userName,email );
        log.info("Entering Username " + userName.toString());
        doSendTextToElement(password, pw);
        log.info("Entering Password " + password.toString());
        doClickOnElement(logIn);
        log.info("Clicking on Login button : " + logIn.toString());
    }

    public void verifyLoginErrorMessage(String message){
        Assert.assertTrue(loginError.getText().contains(message));
        log.info("Verifying error message : " + loginError.toString());
        System.out.println("The verified login error message is : " + loginError.getText());
    }

}
