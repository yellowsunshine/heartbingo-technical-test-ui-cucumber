package com.heartbingo.utility;

import com.heartbingo.drivermanager.ManageDriver;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class Utility extends ManageDriver {

    //*****************BASIC WEBDRIVER METHODS******************************


    /**
     * This method will click on element using By
     *
     * @ param by
     */
    public void doClickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    /**
     * This method will click on element using WebElement
     *
     * @param element
     */

    public void doClickOnElement(WebElement element) {
        element.click();
    }

    /**
     * This method gets text from an element using By
     *
     * @param by
     * @return
     */
    public String doGetTextFromElement(By by) {

        return driver.findElement(by).getText();
    }

    /**
     * This method gets text from an element using WebElement
     *
     * @param element
     * @return
     */

    public String doGetTextFromElement(WebElement element) {

        return element.getText();
    }

    /**
     * This method will send text to an element using By
     *
     * @param by
     * @param text
     */
    public void doSendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will send text to an element using WebElement
     *
     * @param element
     * @param text
     */
    public void doSendTextToElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    /**
     * This method will find the element and clear all the data from it using By
     *
     * @param by
     */
    public void doFindElementAndClearText(By by) {
        WebElement elementToClear = driver.findElement(by);
        elementToClear.clear();
    }

    /**
     * This method will find the element and clear all the data from it using WebElement
     *
     * @param element
     */
    public void doFindElementAndClearText(WebElement element) {
        element.clear();
    }

    /**
     * This method will extract the value of a particular attribute from an element using By
     *
     * @param by
     * @param attribute
     * @return
     */
    public String doGetAttributeFromElement(By by, String attribute) {
        return driver.findElement(by).getAttribute(attribute);
    }

    /**
     * This method will extract the value of a particular attribute from an element using WebElement
     *
     * @param element
     * @param attribute
     * @return
     */
    public String doGetAttributeFromElement(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }


//*************************** Alert Methods ***************************************//

    /**
     * This is a generic method to switch to an Alert
     */
    public void doSwitchToAlert() {
        driver.switchTo().alert();
    }

    /**
     * This is a generic method to accept an Alert
     */
    public void doAcceptAlert() {
        driver.switchTo().alert().accept();
    }

    /**
     * This is a generic method to dismiss an Alert
     */
    public void doDismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    /**
     * This is a generic method to get text from an Alert
     */
    public String doGetTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    /**
     * This is a generic method to send text to an Alert
     */
    public void doSendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //********************* Switching to iFrames ***************************************

    /**
     * Switching to an iFrame using index of the iFrame
     *
     * @param index
     */
    public void doSwitchToIframe(int index) {
        //Note: Index of iFrame starts from 0
        driver.switchTo().frame(index);
    }

    /**
     * Switching to an iFrame using name or ID attributes
     *
     * @param nameOrId
     */
    public void doSwitchToIframe(String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    /**
     * Switching to an iFrame using WebElement
     *
     * @param element
     */
    public void doSwitchToIframe(WebElement element) {
        driver.switchTo().frame(element);
    }


//*************************** Select Class Methods ***************************************//

    /**
     * This method will select the option from dropdown by visible text using By
     *
     * @param by
     * @param text
     */
    public void doSelectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    /**
     * This method will select the option from dropdown by visible text using WebElement
     *
     * @param element
     * @param text
     */
    public void doSelectByVisibleTextFromDropDown(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    /**
     * Selects the option whose value of the “value” attribute matches the specified parameter
     * using By
     *
     * @param by
     * @param value
     */
    public void doSelectByValueFromDropDown(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);
    }

    /**
     * Selects the option whose value of the “value” attribute matches the specified parameter
     * using WebElement
     *
     * @param webElement
     * @param value
     */
    public void doSelectByValueFromDropDown(WebElement webElement, String value) {
        new Select(webElement).selectByValue(value);
    }

    /**
     * Selects the option at the given index using By
     *
     * @param by
     * @param index
     */
    public void doSelectByIndexFromDropDown(By by, int index) {
        new Select(driver.findElement(by)).selectByIndex(index);
    }

    /**
     * Selects the option at the given index using WebElement
     *
     * @param element
     * @param index
     */
    public void doSelectByIndexFromDropDown(WebElement element, int index) {
        new Select(element).selectByIndex(index);
    }

    /**
     * This method will select the option by contains text after extracting from a list
     * using By
     *
     * @param by
     * @param text
     */
    public void doSelectByContainsTextFromDropDown(By by, String text) {
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }

    /**
     * This method will select the option by contains text after extracting from a list
     * using a WebElement
     *
     * @param webElement
     * @param text
     */
    public void doSelectByContainsTextFromDropDown(WebElement webElement, String text) {
        List<WebElement> allOptions = new Select(webElement).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }

    //*************************** Select From Menu Methods ***************************************//

    /**
     * This method selects individual menu from MenuBar list using By
     *
     * @param by
     * @param menu
     * @throws InterruptedException
     */
    public void doSelectMenu(By by, String menu) {

        List<WebElement> names = driver.findElements(by);
        for (WebElement name : names) {

            if (name.getText().equalsIgnoreCase(menu)) {
                name.click();
                break;
            }
        }
    }

    /**
     * This method selects individual menu from MenuBar list using WebElement
     *
     * @param element
     * @param menu
     */
    public void doSelectMenu(List<WebElement> element, String menu) {
        for (WebElement name : element) {
            if (name.getText().equalsIgnoreCase(menu)) {
                name.click();
                break;
            }
        }
    }

    /**
     * This method selects an item from multiple pages
     * @param searchList
     * @param nextButton
     * @param item
     * @return
     * @throws InterruptedException
     */
    public boolean findSelectionFromMultiplePages(List<WebElement> searchList, WebElement nextButton, String item) throws InterruptedException {
        boolean myBreak = true;
        boolean selection = false;
        while (myBreak) {
            for (WebElement e : searchList) {
                if (e.getText().equalsIgnoreCase(item)) {
                    System.out.println(e.getText());
                    doClickOnElement(e);
                    selection = true;
                    myBreak = false;
                    break;
                }
            }
            if (myBreak) {
                if (!driver.getCurrentUrl().contains("page=20")) {
                    doWaitUntilVisibilityOfElementLocated(nextButton, 100).click();
                } else {
                    selection = false;
                    myBreak = false;
                }
                PageFactory.initElements(driver, this);
                Thread.sleep(5000);
            }
        }
        return selection;
    }

//*************************** Window Handle Methods ***************************************//

    /**
     * This is a generic method for close all window handles
     *
     * @param hList
     * @param parentWindow
     */
    public void doCloseAllWindows(List<String> hList, String parentWindow) {
        for (String str : hList) {
            if (!str.equals(parentWindow)) {
                driver.switchTo().window(str).close();
            }
        }
    }

    /**
     * This is a generic method to switch to the parent window
     *
     * @param parentWindowId
     */
    public void doSwitchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    /**
     * This is a generic method to check if we have switched to the correct window
     *
     * @param windowTitle
     * @param hList
     * @return
     */
    public boolean doSwitchToRightWindow(String windowTitle, List<String> hList) {
        for (String str : hList) {
            String title = driver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right window....");
                return true;
            }
        }
        return false;
    }
//*************************** Action Methods ***************************************//

    /**
     * This method will hover mouse over an element using By
     *
     * @param by
     */
    public void doMouseHoverNoClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    /**
     * This method will hover mouse over an element using WebElement
     *
     * @param element
     */
    public void doMouseHoverNoClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    /**
     * This method will hover the mouse over a particular element and click it using By
     *
     * @param by
     */
    public void doMouseHoverAndClick(By by) {
        Actions hover = new Actions(driver);
        WebElement a = driver.findElement(by);
        hover.moveToElement(a).click().build().perform();
    }

    /**
     * This method will hover the mouse over a particular element and click it using WebElement
     *
     * @param element
     */
    public void doMouseHoverAndClick(WebElement element) {
        Actions hover = new Actions(driver);
        hover.moveToElement(element).click().build().perform();
    }

    /**
     * This method will hover mouse on element 1, then element 2 and click element 2 using By
     *
     * @param by1
     * @param by2
     */
    public void doMouseHoverOnFirstThenSecondAndClick(By by1, By by2) {
        Actions hover = new Actions(driver);
        WebElement destination1 = driver.findElement(by1);
        WebElement destination2 = driver.findElement(by2);
        hover.moveToElement(destination1).moveToElement(destination2).click().build().perform();
    }

    /**
     * This method will hover mouse on element 1, then element 2 and click element 2 using WebElement
     *
     * @param element1
     * @param element2
     */
    public void doMouseHoverOnFirstThenSecondAndClick(WebElement element1, WebElement element2) {
        Actions hover = new Actions(driver);
        hover.moveToElement(element1).moveToElement(element2).click().build().perform();
    }

    /**
     * This method performs a Right Click Mouse Action at the current mouse location using By     *
     *
     * @param by
     */
    public void doRightClick(By by) {
        Actions rightClick = new Actions(driver);
        WebElement a = driver.findElement(by);
        rightClick.contextClick(a).build().perform();
    }

    /**
     * This method performs a Right Click Mouse Action at the current mouse location using WebElement
     *
     * @param element
     */
    public void doRightClick(WebElement element) {
        Actions rightClick = new Actions(driver);
        rightClick.contextClick(element).build().perform();
    }

    /**
     * This method performs click and hold at the source location, moves to target location
     * and then releases the mouse using By
     *
     * @param source
     * @param target
     */
    public void doDragAndDrop(By source, By target) {
        Actions builder = new Actions(driver);
        WebElement draggable = driver.findElement(source);
        WebElement droppable = draggable.findElement(target);
        builder.dragAndDrop(draggable, droppable).build().perform();
    }

    /**
     * This method performs click and hold at the source location, moves to target location
     * and then releases the mouse using WebElement
     *
     * @param source
     * @param target
     */
    public void doDragAndDrop(WebElement source, WebElement target) {
        Actions builder = new Actions(driver);
        builder.dragAndDrop(source, target).build().perform();
    }

    /**
     * Moves the slider from its current position to the desired position using By
     *
     * @param sliderBox
     * @param xAxis
     * @param yAxis
     */
    public void doSliderMovement(By sliderBox, int xAxis, int yAxis) {
        Actions moveSlider = new Actions(driver);
        WebElement slider = driver.findElement(sliderBox);
        moveSlider.dragAndDropBy(slider, xAxis, yAxis).build().perform();
    }

    /**
     * Moves the slider from its current position to the desired position using WebElement
     *
     * @param sliderBox
     * @param xAxis
     * @param yAxis
     */
    public void doSliderMovement(WebElement sliderBox, int xAxis, int yAxis) {
        Actions moveSlider = new Actions(driver);
        moveSlider.dragAndDropBy(sliderBox, xAxis, yAxis).build().perform();
    }

//************************** WebDriver Wait Methods *********************************************//

    /**
     * This method will use to wait until VisibilityOfElementLocated using By
     *
     * @param by
     * @param timeout
     * @return
     */
    public WebElement doWaitUntilVisibilityOfElementLocated(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by);
    }

    /**
     * This method will use to wait until VisibilityOfElementLocated using WebElement
     *
     * @param element
     * @param timeout
     * @return
     */
    public WebElement doWaitUntilVisibilityOfElementLocated(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    /**
     * This is a generic method to wait until the title is equal to the String provided
     *
     * @param expectedMessage
     * @return
     */
    public String doWaitUntilTitleIsEqualTo(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.titleContains(expectedMessage));
        return expectedMessage;
    }

    /**
     * This method will wait for an element using Fluent Wait using By
     *
     * @param by
     * @param time
     * @param pollingTime
     * @return
     */
    public WebElement doWaitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }

    /**
     * This method will wait for an element using Fluent Wait using WebElement
     *
     * @param element
     * @param time
     * @param pollingTime
     * @return
     */

    public WebElement doWaitForElementWithFluentWait(WebElement element, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);
        WebElement e = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return element;
            }
        });
        return e;
    }

    // *********************VERIFICATION METHODS---ASSERT CLASS**********************

    /******
     * This method verifies with assertEquals using By using 20 seconds wait until visibility
     * @param expectedMessage
     * @param by
     */
    public void doVerifyElementsWithAssertEquals(String expectedMessage, By by) {
        doWaitUntilVisibilityOfElementLocated(by, 20);
        String actualMessage = doGetTextFromElement(by);
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    /**
     * This method verifies with assertEquals using WebElement using 20 second wait until visibility
     *
     * @param expectedMessage
     * @param element
     */
    public void doVerifyElementsWithAssertEquals(String expectedMessage, WebElement element) {
        doWaitUntilVisibilityOfElementLocated(element, 20);
        String actualMessage = doGetTextFromElement(element);
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    /**
     * Verifies with assertTrue using By and 20 seconds wait until visibility of element
     *
     * @param actualMessage
     * @param expectedMessage
     */
    public void doVerifyElementsWithAssertTrue(By actualMessage, String expectedMessage) {
        doWaitUntilVisibilityOfElementLocated(actualMessage, 20);
        Assert.assertTrue(driver.findElement(actualMessage).getText().contains(expectedMessage));
    }

    /**
     * Verifies with assertTrue using WebElement and 20 seconds wait until visibility of element
     *
     * @param element
     * @param expectedMessage
     */
    public void doVerifyElementsWithAssertTrue(WebElement element, String expectedMessage) {
        doWaitUntilVisibilityOfElementLocated(element, 20);
        Assert.assertTrue(element.getText().contains(expectedMessage));
    }

    /**********************SORTING METHODS************************
     * THIS METHOD SORTS ELEMENTS IN THE ORDER OF PRICE LOW TO HIGH
     * @param dropDown
     */

    public void verifyTheSortingOrderOfPriceLowToHighIsCorrect(By beforeFilterElements, By dropDown, By lowToHigh) {
        List<WebElement> beforeFilterWebElementPrice = driver.findElements(beforeFilterElements);
        List<Double> beforeFilterDoublePriceList = new ArrayList<>();
        for (WebElement p : beforeFilterWebElementPrice) {
            beforeFilterDoublePriceList.add(Double.valueOf(p.getText().replace("$", " ")));
        }
        //Select dropDownBox = new Select(driver.findElement(dropDown));
        //dropDownBox.selectByVisibleText("Price Low - High");
        doMouseHoverNoClick(dropDown);
        doMouseHoverAndClick(lowToHigh);

        List<WebElement> afterFilterWebElementPriceList = driver.findElements(beforeFilterElements);
        List<Double> afterFilterDoublePriceList = new ArrayList<>();

        for (WebElement p : afterFilterWebElementPriceList) {
            afterFilterDoublePriceList.add(Double.valueOf(p.getText().replace("$", " ")));
        }

        Collections.sort(beforeFilterDoublePriceList);
        Assert.assertEquals("List is not sorted according to price Low to High", afterFilterDoublePriceList, beforeFilterDoublePriceList);
    }

    /**
     * THIS METHOD SORTS ELEMENTS IN THE ORDER OF PRICE HIGH TO LOW
     *
     * @throws InterruptedException
     */

    public void verifyIfProductsAreSortedByPriceHighToLow(By beforeFilterElements, By dropDown, By hToLow) throws InterruptedException {
        List<WebElement> originalList = driver.findElements(beforeFilterElements);

        List<Double> originalProductPriceList = new ArrayList<>();
        for (WebElement price : originalList) {
            originalProductPriceList.add(Double.valueOf(price.getText().replace("$", "")));
        }

        System.out.println(originalProductPriceList);

        Collections.sort(originalProductPriceList, Collections.reverseOrder());
        doMouseHoverNoClick(dropDown);
        doMouseHoverAndClick(hToLow);
        Thread.sleep(3000);

        List<WebElement> afterSortingList = driver.findElements(beforeFilterElements);
        List<Double> afterSortingProductPrice = new ArrayList<>();
        for (WebElement price1 : afterSortingList) {
            afterSortingProductPrice.add(Double.valueOf(price1.getText().replace("$", "")));
        }
        System.out.println(afterSortingProductPrice);
        Assert.assertEquals("products are not sorted", afterSortingProductPrice, originalProductPriceList);

    }

    /**
     * THIS METHOD SORTS ELEMENTS IN THE ORDER OF STAR RATINGS HIGH TO LOW
     *
     * @param beforeFilterElements
     * @param dropDown
     * @param hToLow
     * @throws InterruptedException
     */

    public void verifyProductsAreSortedAccordingToRatingHighToLow(By beforeFilterElements, By dropDown, By hToLow) throws InterruptedException {
        List<WebElement> originalList = driver.findElements(beforeFilterElements);

        List<Integer> originalProductRating = new ArrayList<>();
        for (WebElement rating : originalList) {
            originalProductRating.add(rating.getAttribute("style").indexOf(3, 6));
        }

        Collections.sort(originalProductRating, Collections.reverseOrder());
        doMouseHoverNoClick(dropDown);
        doMouseHoverAndClick(hToLow);
        Thread.sleep(3000);
        List<WebElement> afterSortingList = driver.findElements(beforeFilterElements);
        List<Integer> afterSortingProductRating = new ArrayList<>();
        for (WebElement rating1 : afterSortingList) {
            afterSortingProductRating.add(rating1.getAttribute("style").indexOf(2, 6));
        }
        System.out.println(afterSortingProductRating);
        Assert.assertEquals("products are not sorted", afterSortingProductRating, originalProductRating);

    }

    /**
     * THIS METHOD VERIFIES IF ELEMENTS ARE SORTED FROM BY TITLES FROM A TO Z
     *
     * @param beforeFilterElements
     * @param dropDown
     * @param aToZ
     * @throws InterruptedException
     */
    public void verifyProductsAreSortedAlphabeticallyFromAToZ(By beforeFilterElements, By dropDown, By aToZ) throws InterruptedException {

        List<WebElement> originalList = driver.findElements(beforeFilterElements);
        List<String> originalProductRatingList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductRatingList.add(product.getText());
        }
        Collections.sort(originalProductRatingList);
        System.out.println(originalProductRatingList);

        doMouseHoverNoClick(dropDown);
        doMouseHoverAndClick(aToZ);

        List<WebElement> afterSortingList = driver.findElements(beforeFilterElements);
        List<String> afterSortingProductName = new ArrayList<>();
        for (WebElement product : afterSortingList) {
            afterSortingProductName.add(product.getText());
        }
        System.out.println(afterSortingProductName);
        Assert.assertEquals("Products are not sorted", afterSortingProductName, originalProductRatingList);
    }

    /**
     * THIS METHOD VERIFIES IF ELEMENTS ARE SORTED FROM BY TITLES FROM Z TO A
     *
     * @throws InterruptedException
     */

    public void verifyProductsAreSortedFromZtoA(By beforeFilterElements, By dropDown, By zToA) throws InterruptedException {
        List<WebElement> originalList = driver.findElements(beforeFilterElements);
        List<String> originalProductNameList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductNameList.add(product.getText());
        }
        originalProductNameList.sort(String.CASE_INSENSITIVE_ORDER.reversed());

        System.out.println("Expected Result is : " + originalProductNameList);
        doMouseHoverNoClick(dropDown);
        doMouseHoverAndClick(zToA);
        Thread.sleep(3000);


        List<WebElement> afterSortingList = driver.findElements(beforeFilterElements);
        List<String> afterSortingProductName = new ArrayList<>();
        for (WebElement product1 : afterSortingList) {
            afterSortingProductName.add(product1.getText());
        }
        System.out.println("actual result is : )" + afterSortingProductName);
        Assert.assertEquals("products are now sorted", afterSortingProductName, originalProductNameList);
    }

    // *************************** Date Picker Method *****************************************

    /**
     * This method picks a date from the calendar using By
     * @param yr
     * @param mn
     * @param dt
     * @param mthYear
     * @param datePicker
     * @param arrowKey
     * @param dateTable
     */
    public void pickDateFromCalendar(String yr, String mn, String dt,By mthYear, By datePicker, By arrowKey, By dateTable) {
        String year = yr;
        String month = mn;
        String date = dt;

        doClickOnElement(datePicker); // Opens the date picker
        while (true) {
            String monthYear = driver.findElement(mthYear).getText();
            String arr[] = monthYear.split(" ");//split using java split method and stored in String array
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                doClickOnElement(arrowKey);
            }
        }
        // Date Selection
        List<WebElement> allDates = driver.findElements(dateTable);
        for (WebElement dte : allDates) {
            if (dte.getText().equalsIgnoreCase(date)) {
                dte.click();
                break;
            }
        }
    }

    /**
     * This method picks a date from the calendar using WebElement
     * @param yr
     * @param mn
     * @param dt
     * @param mthYear
     * @param datePicker
     * @param arrowKey
     * @param dateTable
     */
    public void pickDateFromCalendar(String yr, String mn, String dt,WebElement mthYear, WebElement datePicker, WebElement arrowKey, List<WebElement> dateTable) {
        String year = yr;
        String month = mn;
        String date = dt;

        doClickOnElement(datePicker); // Opens the date picker
        while (true) {
            String monthYear = mthYear.getText();
            String arr[] = monthYear.split(" ");//split using java split method and stored in String array
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                doClickOnElement(arrowKey);
            }
        }
        // Date Selection
        List<WebElement> allDates = dateTable;
        for (WebElement dte : allDates) {
            if (dte.getText().equalsIgnoreCase(date)) {
                dte.click();
                break;
            }
        }
    }

    //*********************** File Upload From Computer ***********************************

    /**
     * This method uploads a file from a computer using WebElement
     * @param attachBox
     * @param filePath
     */
    public void fileUpload(WebElement attachBox, String filePath){
        attachBox.sendKeys(filePath);
    }

    //******************** Drawing Signature on a Signature Pad *************

    public void createSignature(WebElement canvasElement) throws InterruptedException {

        Actions builder = new Actions(driver);

        Thread.sleep(2000);

        Action signature = builder.moveToElement(canvasElement)
                .clickAndHold()
                .moveToElement(canvasElement, 20, -50)
                .moveByOffset(50, 50)
                .moveByOffset(80, -50)
                .moveByOffset(100, 50)
                .release(canvasElement)
                .build();
        signature.perform();
        Thread.sleep(10000);
        //doClickOnElement(signatureLabel);
    }

    //************************** ScreenShot Methods *********************************************//

    /**
     * This method gets current time for Screenshots
     *
     * @return
     */
    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    /**
     * This method takes screenshots
     *
     * @param fileName
     * @return
     */
    public static String doTakeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/"; // path where screen shot needs to be saved
        TakesScreenshot screenshot = (TakesScreenshot) driver; // method to take screenshot
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    /**
     *
     * @param driver
     * @param screenshotName
     * @return
     */
    public static String getScreenshot(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // After execution, you could see a folder "FailedTestsScreenshots" under screenshot folder
        String destination = System.getProperty("user.dir") + "/src/main/java/screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }
}
