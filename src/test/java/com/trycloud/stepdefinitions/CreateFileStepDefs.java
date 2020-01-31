package com.trycloud.stepdefinitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.awt.*;
import java.util.List;

public class CreateFileStepDefs {

    @When("click create button")
    public void click_create_button() {
        FilesPage filesPage=new FilesPage();
        filesPage.clickCreate();
    }

    @When("create {string} {string}")
    public void create(String type, String name) throws AWTException {
        FilesPage filesPage=new FilesPage();
        filesPage.createWith(type, name);
    }

    @Then("verify {string} {string} uploaded succesfully")
    public void verify_uploaded_succesfully(String type, String name) {
        FilesPage filesPage=new FilesPage();
        BrowserUtils.waitFor(2);
        Assert.assertTrue(filesPage.fileUpload(type,name));
    }

    @When("click search button")
    public void click_search_button() {
        FilesPage filesPage=new FilesPage();
        BrowserUtils.waitFor(3);
        filesPage.searchBox.click();

    }

    @Then("delete listed items {string}")
    public void delete_listed_items(String name) {
        FilesPage filesPage=new FilesPage();
        filesPage.searchBox.sendKeys(name);
        BrowserUtils.waitFor(3);
        List<WebElement> list = filesPage.rowsOfList;

        System.out.println("list.size() = " + list.size());
        int count=0;
        for (int i=0; i<list.size(); i++){
            if(list.get(i).getAttribute("data-file").contains(name)) {
                count++;
                filesPage.clickSelected(i);
                BrowserUtils.waitFor(1);
            }
        }

        System.out.println("count = " + count);
        if(count==0){
            System.out.println("no file to delete");
        }else {
            filesPage.actionList.click();

            BrowserUtils.clickWithJS(filesPage.delete);
        }
    }
}
