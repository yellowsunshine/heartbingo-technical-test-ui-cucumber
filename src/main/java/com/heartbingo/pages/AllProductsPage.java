package com.heartbingo.pages;

import com.heartbingo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AllProductsPage extends Utility {

    //logger defined to print logs
    private static final Logger log = LogManager.getLogger(AllProductsPage.class.getName());

    //Constructor used to initialise the WebElements with @FindBy annotation to this page
    public AllProductsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "casino-game-title")
    List<WebElement> gameTitles;

    //This method selects the games from all the inner pages
    public void selectGamesFromTheSelection(String game) {
        List<String> strings = new ArrayList<>();
        for (WebElement title : gameTitles) {
            strings.add(title.getText());
        }
        Assert.assertTrue(strings.contains(game));
        log.info("Verifying that the game " + game + " is displayed on the page");
        System.out.println("The list of games is : " + strings);
        System.out.println("The list contains a game named : " + game);
    }
}


