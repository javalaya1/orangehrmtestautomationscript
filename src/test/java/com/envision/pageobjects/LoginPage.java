package com.envision.pageobjects;

import com.envision.orangehrmautomationscripts.util.ObjectRepoHandler;
import com.envision.orangehrmautomationscripts.util.PropertiesFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "username")
    private WebElement usernameTextBox;

    @FindBy(name = "password")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement login_clickButtton;

    By userNameLocator = By.name("username");

    public String getUserNameText() {
        //Step1 - reading the value from objectrepo.properties file for a particular element
        String locator_type_value = PropertiesFileReader.getPropValue("objectrepo.properties", "orangehrm.loginpage.username.textvalue");

        //step2 - from the above value take the value that is before first _ which is locator type
        String locator_type = locator_type_value.substring(0, locator_type_value.indexOf("_"));

        //step3 _ from step1 value take the value that is after frist _ which is locator value.
        String locator_value = locator_type_value.substring(locator_type_value.indexOf("_") + 1);

        //ste4 - find the WebElement - by using the method written in side a class ObjectRepoHandler.
        WebElement userNameText = ObjectRepoHandler.getElement(this.driver, locator_type, locator_value);

        //return the text that is needed for validation.
        return userNameText.getText();
    }

    public String getPasswordText() {
        //Step1 - reading the value from objectrepo.properties file for a particular element
        String locator_type_value = PropertiesFileReader.getPropValue("objectrepo.properties", "orangehrm.loginpage.password.textvalue");

        //step2 - from the above value take the value that is before first _ which is locator type
        String locator_type = locator_type_value.substring(0, locator_type_value.indexOf("_"));

        //step3 _ from step1 value take the value that is after frist _ which is locator value.
        String locator_value = locator_type_value.substring(locator_type_value.indexOf("_") + 1);

        //ste4 - find the WebElement - by using the method written in side a class ObjectRepoHandler.
        WebElement passwordText = ObjectRepoHandler.getElement(this.driver, locator_type, locator_value);

        //return the text that is needed for validation.
        return passwordText.getText();
    }


    public LoginPage enterUserName(String inputValue) {
        //1. the below one of is finding Element by taking the global variable By
        // WebElement user_name_element = driver.findElement(userNameLocator);
        //user_name_element.sendKeys(inputValue);

        //2. Below code is taking element using @FindBy
        this.usernameTextBox.sendKeys(inputValue);

        return this;  //facade desing pattern
    }

    public LoginPage enterPassword(String pwd) {
        this.passwordTextBox.sendKeys(pwd);

        return this;
    }

    public DashboardPage clickSubmit() {
        login_clickButtton.click();
        return new DashboardPage(super.driver);
    }

    public static void main(String[] args) {
        String s ="hello";
        System.out.println(s);

        s="world";
        System.out.println(s);

        Number n = 100;
        System.out.println(n);

        Integer i = (Integer)n; //downcasting
        System.out.println(i*2);

        Integer i2 = n.intValue(); //rtp
        System.out.println(i2*2);



    }
}
