package com.heartbingo.pages;

import com.heartbingo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends Utility {

    //logger defined to print logs
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    //Constructor used to initialise the WebElements with @FindBy annotation to this page
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//ul[@class='bvs-carousel__slider']//li//a")
    List<WebElement> menuBar;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Ok, I Agree']")
    WebElement cookies;

    public void acceptCookies() {
        doWaitUntilVisibilityOfElementLocated(cookies, 30).click();
        log.info("Clicking on cookies button : " + cookies.toString());
    }

    public void selectMenuFromTheMenuBar(String menu) {
        for (WebElement selection :
                menuBar) {
            if (selection.getText().equalsIgnoreCase(menu)) {
                doWaitUntilVisibilityOfElementLocated(selection, 30).click();
                log.info("Clicking on the selected menu : " + selection);
            }
        }
    }


}
