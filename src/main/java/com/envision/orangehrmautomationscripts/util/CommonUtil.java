package com.envision.orangehrmautomationscripts.util;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.util.encoders.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CommonUtil {

    //https://www.youtube.com/watch?v=uJk3cZhbjNY


    public static String getScreenshot(WebDriver driver, String name) {
        TakesScreenshot tss = (TakesScreenshot) driver;
        File src = tss.getScreenshotAs(OutputType.FILE);
       // String scrshot = tss.getScreenshotAs(OutputType.BASE64);
        File dest = new File("orangehrm_screenshots/" + name + ".png");
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dest.getAbsolutePath();
    }

    public static String getScreenshot(WebDriver driver) {
        TakesScreenshot tss = (TakesScreenshot) driver;
        String src = tss.getScreenshotAs(OutputType.BASE64);
//        String scrshot= tss.getScreenshotAs(OutputType.BASE64);
        File dest = new File("orangehrm_screenshots/abc.png");
        try {
            FileOutputStream fos = new FileOutputStream(dest);
            fos.write(Base64.decode(src));
            //FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dest.getAbsolutePath();
    }

    public static String getScreenshot(WebElement driver) {
        TakesScreenshot tss = (TakesScreenshot) driver;
        String src = tss.getScreenshotAs(OutputType.BASE64);
//
        return src;
    }

    public static void getScreenshot(WebElement element, String name) {
        TakesScreenshot tss = (TakesScreenshot) element;
        File dest = tss.getScreenshotAs(OutputType.FILE);
        File src = new File("orangehrm_screenshots/" + name + ".png");
        try {
            FileUtils.copyFile(dest, src);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void pauseExecution_InSec(int time_in_sec) {
        try {
            Thread.sleep(time_in_sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
