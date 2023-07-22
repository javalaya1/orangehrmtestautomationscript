package com.envision.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='My Info']")
    private WebElement myInfoLink;

    public MyInfoPage click_MyInfolink() {
        this.myInfoLink.click();

        return PageFactory.initElements(driver, MyInfoPage.class);
    }

}
