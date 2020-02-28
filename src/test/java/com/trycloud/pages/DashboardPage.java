package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage extends BasePage {

    public DashboardPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = ".avatardiv.avatardiv-shown>img")
    public WebElement settingsMenu;

    @FindBy(xpath = "//li[@data-id='settings']")
    public WebElement settingsButton;

    public List<WebElement> optionList = Driver.get().findElements(By.cssSelector("#personal-settings h3"));

}
