Feature: Login Test
  As a user I want to test the login functionality from the products page

  Background: User should be on the 'heartbingo' homepage
    Given user is on the homepage

  Scenario Outline: User should not be able to log in with invalid credentials from the products
                    page and error message displayed
    When User selects the "<Menu>" menu from the menubar
    And User verifies that the "<GameSelection>" game selection is displayed on the page
    And User clicks on the Log In Button
    And User logs in using username "<username>" and password "<password>"
    Then User gets an error message "The username or password you entered is incorrect. Please try again."

    Examples:
      | Menu     | GameSelection    | username       | password |
      | Bingo    | Penny Bingo      | yellowsunshine | abc123   |
      | Jackpots | Rainbow Jackpots | prettypink     | 12&^an   |
      | Slots    | Heart Bonanza    | xyz@gmail.com  | 124325   |
      | Casino   | Crazy Time       | 12344215652656 | zyxbac   |










