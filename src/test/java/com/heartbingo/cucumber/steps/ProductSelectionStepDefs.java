package com.heartbingo.cucumber.steps;

import com.heartbingo.pages.AllProductsPage;
import com.heartbingo.pages.HomePage;
import com.heartbingo.pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.logging.Log;

public class ProductSelectionStepDefs {
    @Given("^user is on the homepage$")
    public void userIsOnTheHomepage() {
    }

    @When("^User selects the \"([^\"]*)\" menu from the menubar$")
    public void userSelectsTheMenuFromTheMenubar(String menu) {
        new HomePage().acceptCookies();
        new HomePage().selectMenuFromTheMenuBar(menu);
    }

    @And("^User verifies that the \"([^\"]*)\" game selection is displayed on the page$")
    public void userVerifiesThatTheGameSelectionIsDisplayedOnThePage(String game) {
        new AllProductsPage().selectGamesFromTheSelection(game);
    }

    @And("^User clicks on the Log In Button$")
    public void userClicksOnTheLogInButton() {
        new LoginPage().clickOnLogInButton();
    }

    @And("^User logs in using username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void userLogsInUsingUsernameAndPassword(String username, String password)  {
        new LoginPage().logIn(username, password);
    }

    @Then("^User gets an error message \"([^\"]*)\"$")
    public void userGetsAnErrorMessage(String errorMessage) {
        new LoginPage().verifyLoginErrorMessage(errorMessage);

    }
}
