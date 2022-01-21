package com.heartbingo.cucumber;

import com.cucumber.listener.Reporter;
import com.heartbingo.propertyreader.PropertyReader;
import com.heartbingo.utility.Utility;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import java.io.IOException;

public class Hooks extends Utility {

    //This will run before every scenario
    @Before
    public void setUp(){
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));
        Reporter.assignAuthor("Kinjal");
    }

    //This will run before every scenario
    @After
    public void tearDown(Scenario scenario){

        //Using the isFailed method of the scenario interface to get a screenshot upon test failure
        if(scenario.isFailed()){
            //if failed take screenshot
            String screenShotPath = Utility.getScreenshot(driver,scenario.getName().replace(" ", "_"));
            try {
                //adds screenshot to the report
                Reporter.addScreenCaptureFromPath(screenShotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        closeBrowser();
    }
}
