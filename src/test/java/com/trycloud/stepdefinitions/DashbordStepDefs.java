package com.trycloud.stepdefinitions;

import com.trycloud.pages.DashboardPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class DashbordStepDefs {

    @When("The user navigates to Settings Menu")
    public void the_user_navigates_to_Settings_Menu() {
       DashboardPage dashboardPage = new DashboardPage();
       BrowserUtils.hover(dashboardPage.settingsMenu);
       dashboardPage.settingsMenu.click();
    }

    @When("Clicks to settings button")
    public void clicks_to_settings_button() {
        new DashboardPage().settingsButton.click();
    }

    @Then("the user should see following input options")
    public void the_user_should_see_following_input_options(List<String> optionList) {
        DashboardPage dashboardPage = new DashboardPage();
        List<String> actualList = BrowserUtils.getElementsText(dashboardPage.optionList);
        List<String> expectedList = optionList;

        Assert.assertEquals(actualList,expectedList);
    }
}
