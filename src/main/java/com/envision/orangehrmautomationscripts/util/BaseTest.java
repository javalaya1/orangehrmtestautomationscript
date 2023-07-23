package com.envision.orangehrmautomationscripts.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class BaseTest {
    protected WebDriver driver;

    @Parameters("browsername")
    @BeforeMethod
    public void openBrowser_openUrl(ITestContext context, @Optional("chrome") String brname) {
        this.driver = BrowserFactory.getBrowser(brname);
        BrowserFactory.openUrl(PropertiesFileReader.getPropValue("config.properties", "orangehrm.url"));

//        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
//        String device = cap.getBrowserName() + " " + cap.getBrowserVersion();
//        String author = context.getCurrentXmlTest().getParameter("author");
//        BaseTest.extentTest = BaseTest.extentReports.createTest(context.getName());
    }



//    @AfterMethod
//    public void closure(Method m, ITestResult result) {
//        if (result.getStatus() == ITestResult.FAILURE) {
//            String screenShotPath = CommonUtil.getScreenshot(this.driver, result.getTestContext().getName() + "_" + result.getMethod().getMethodName());
//            BaseTest.extentTest.addScreenCaptureFromPath(screenShotPath);
//            BaseTest.extentTest.fail(result.getThrowable());
//        } else {
//            BaseTest.extentTest.pass(m.getName() + " is passed");
//        }
//
//    }

    public static ExtentReports extentReports;
//    public static ExtentTest extentTest;
//
    @BeforeSuite
    public void initializeReport() {
        ExtentSparkReporter esr = new ExtentSparkReporter("orangehrm_reports/AllTestScriptResults.html");
//
        BaseTest.extentReports = new ExtentReports();
        BaseTest.extentReports.attachReporter(esr);
//        BaseTest.extentReports.setSystemInfo("OS", System.getProperty("os.name"));
//        BaseTest.extentReports.setSystemInfo("OS", System.getProperty("java.version"));
    }
//
    @AfterSuite
    public void generateReport() {
        BaseTest.extentReports.flush();
//        try {
//            Desktop.getDesktop().browse(new File("eagle/AllTests.html").toURI());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    @AfterMethod
    public void closure() {
        BrowserFactory.closeAllWindows();
    }

}
