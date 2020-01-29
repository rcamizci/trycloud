package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    public BasePage(){

        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = "[id = appmenu]>li>span")
    public List<WebElement> menuList;

    public WebElement getFromMenu(String name){
        String css="[id = appmenu]>[data-id="+ name.toLowerCase() + "]";
        return Driver.get().findElement(By.cssSelector(css));
    }

    public void navigateTo(String name){
        String css="[id = appmenu]>[data-id="+ name.toLowerCase() + "]";
        WebElement element = Driver.get().findElement(By.cssSelector(css));
        try{
            element.click();
        }catch (Exception e){
            BrowserUtils.waitForClickablility(element,5);
            element.click();
        }
    }




}
