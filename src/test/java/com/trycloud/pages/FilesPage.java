package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

public class FilesPage extends BasePage {

    @FindBy(css = ".actions.creatable>a")
    public WebElement create;

    @FindBy(id = "searchbox")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@id='app-content-files']//tbody//tr")
    public List<WebElement> rowsOfList;

    public void clickSelected(int i){
        String xpath="//div[@id='app-content-files']//tbody//tr["+ (i+1) + "]/td[1]/input";
        WebElement element = Driver.get().findElement(By.xpath(xpath));
        BrowserUtils.clickWithJS(element);
    }

    @FindBy(xpath = "//span[text()='Actions']")//div[@id='app-content-files']//thead//th[2]/div/span
    public WebElement actionList;

    @FindBy(css = ".icon.icon-delete")
    public WebElement delete;

    public void clickCreate(){
        BrowserUtils.waitForClickablility(create,3);
        create.click();
    }

    public void createWith(String type, String name) throws AWTException {
        String xpath=" //*[text()='" + type + "']";
        WebElement element = Driver.get().findElement(By.xpath(xpath));

        BrowserUtils.waitForClickablility(element,5);
        element.click();

        BrowserUtils.waitFor(3);
        String text = name;
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);

        try {
            WebElement error = Driver.get().findElement(By.className("tooltip-inner"));
            System.out.println(error.getText());
            System.out.println("Change your file or folder name and try again..");
            Assert.assertTrue("assertion false",false);
        }catch (Exception e){

        }

        try {
            BrowserUtils.waitFor(3);
            WebElement newFiles = Driver.get().findElement(By.xpath("//label[@for='checkbox-allnewfiles']"));
            BrowserUtils.waitForClickablility(newFiles,2);
            newFiles.click();
            WebElement continueButton = Driver.get().findElement(By.xpath("//button[@class='continue']"));
            BrowserUtils.waitForClickablility(continueButton,2);
            BrowserUtils.waitFor(1);
            continueButton.click();
        }catch (Exception e){

        }

        try {
            WebElement editor_close = Driver.get().findElement(By.id("editor_close"));
            BrowserUtils.waitForClickablility(editor_close,3);
            editor_close.click();
        }catch (Exception e){

        }
    }

    public boolean fileUpload(String type, String name){
        if(type.contains("text"))
            name=name+".txt";
        String xpath="//tbody//tr[@data-file='" + name + "']";
        try {
            Driver.get().findElement(By.xpath(xpath));
            return true;
        }catch (Exception e){
            System.out.println(e);
            System.out.println("file not found");
            return false;
        }
    }


}
