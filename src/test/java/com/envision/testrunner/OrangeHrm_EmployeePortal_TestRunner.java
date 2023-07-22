package com.envision.testrunner;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.envision.orangehrmautomationscripts.excelutil.ExcelReader;
import com.envision.orangehrmautomationscripts.listeners.RunFailedTests;
import com.envision.orangehrmautomationscripts.util.BaseTest;
import com.envision.pageobjects.DashboardPage;
import com.envision.pageobjects.LoginPage;
import com.envision.pageobjects.MyInfoPage;
import com.envision.orangehrmautomationscripts.util.CommonUtil;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import javax.print.attribute.standard.Media;
import java.lang.reflect.Method;

public class OrangeHrm_EmployeePortal_TestRunner extends BaseTest {

    @Test(dataProvider = "orangehrm_testcase_data", dataProviderClass = ExcelReader.class, retryAnalyzer = RunFailedTests.class)
    public void VerifyingTheLoginCredentialsAvailability(Method m, String expectedUname, String expectedPassword) {
        ExtentTest current_test = BaseTest.extentReports.createTest(m.getName());

        try {
            current_test.log(Status.INFO, m.getName() + " started execution");

            LoginPage lp = new LoginPage(super.driver);
            current_test.log(Status.INFO, "login page opened successfully");

            String un_txt = lp.getUserNameText();
            current_test.log(Status.INFO, "username text is displayed");

            Assert.assertTrue(un_txt.equals(expectedUname));
            current_test.log(Status.PASS, un_txt + " validation is successful");

            String pwd_txt = lp.getPasswordText();
            current_test.log(Status.INFO, pwd_txt + " text is displayed");
            Assert.assertTrue(pwd_txt.equals(expectedPassword));
            current_test.log(Status.PASS, pwd_txt + " validation is successful");
        } catch (Throwable t) {
            current_test.fail(t.fillInStackTrace());

            current_test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(CommonUtil.getScreenshot(driver, m.getName())).build());
            throw t;
        }
    }


    @Test(dataProvider = "orangehrm_testcase_data", dataProviderClass = ExcelReader.class)
    public void VerifyTheUserProfilePageLinks2(ITestContext c, String username, String pwd, String linkToAssert) {
        ExtentTest et = BaseTest.extentReports.createTest(c.getName());
        LoginPage lp = new LoginPage(super.driver);
        et.info("login page opened successfully");
        CommonUtil.pauseExecution_InSec(5);
        boolean result = lp.enterUserName(username).enterPassword(pwd).clickSubmit().click_MyInfolink().validateAnyLink(linkToAssert);
        Assert.assertTrue(result);
    }


    @Test(dataProvider = "orangehrm_testcase_data", dataProviderClass = ExcelReader.class)
    public void VerifyTheUserProfilePageLinks(Method m, ITestContext t, String username, String pwd, String linkToAssert) {
        ExtentTest et = BaseTest.extentReports.createTest(m.getName() + " - " + linkToAssert);
        try {
            LoginPage lp = new LoginPage(super.driver);
            et.info("login page opened successfully");
            // BaseTest.extentTest.info("NavigatedTo Login Page");
            CommonUtil.pauseExecution_InSec(2);
            lp.enterUserName(username);
            et.info("user name entered successfully");
            lp.enterPassword(pwd);
            et.info("password entered successfully");
            lp.clickSubmit();
            et.info("submit button clicked successfully");

            DashboardPage dp = new DashboardPage(this.driver);
            et.info("navigated to Dashboard Page");
            //  BaseTest.extentTest.info("NavigatedTo Dashboard Page");
            dp.click_MyInfolink();
            et.info("navigated to My Info Page");
            MyInfoPage mp = new MyInfoPage(this.driver);
            //  BaseTest.extentTest.info("NavigatedTo My Info Page");

            boolean linkAvailable = mp.validateAnyLink(linkToAssert);

            System.out.println("HI");
            Assert.assertTrue(linkAvailable);
            System.out.println("hi");
            et.pass(linkToAssert + " is displayed successfully");
        } catch (Throwable t1) {
            System.out.println("Hello");
            et.fail(t1.fillInStackTrace());
            et.fail(linkToAssert + " is not displayed on the web page");
            et.addScreenCaptureFromBase64String(CommonUtil.getScreenshot(driver));

            et.log(Status.INFO, (Markup) MediaEntityBuilder.createScreenCaptureFromPath(CommonUtil.getScreenshot(this.driver, m.getName()), "error screenshot"));
            throw t1;
        }

        //   BaseTest.extentTest.info("UserName and Password test validation on Login Page is completed");
        // Assert.assertTrue(lp.enterUserName(username).enterPassword(pwd).clickSubmit().click_MyInfolink().validateAnyLink(linkToAssert));
    }


}
