package com.envision.orangehrmautomationscripts.util;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ObjectRepoHandler {

    public static WebElement getElement(WebDriver driver, String locator_type, String locator_input) {
        if (locator_type.equalsIgnoreCase("xpath")) {
            return driver.findElement(By.xpath(locator_input));
        } else if (locator_type.equalsIgnoreCase("css")) {
            return driver.findElement(By.cssSelector(locator_input));
        } else if (locator_type.equalsIgnoreCase("link")) {
            return driver.findElement(By.linkText(locator_input));
        } else if (locator_type.equalsIgnoreCase("partiallink")) {
            return driver.findElement(By.linkText(locator_input));
        } else if (locator_type.equalsIgnoreCase("class")) {
            return driver.findElement(By.className(locator_input));
        } else if (locator_type.equalsIgnoreCase("name")) {
            return driver.findElement(By.name(locator_input));
        } else if (locator_type.equalsIgnoreCase("id")) {
            return driver.findElement(By.id(locator_input));
        } else if (locator_type.equalsIgnoreCase("tag")) {
            return driver.findElement(By.tagName(locator_input));
        }

        return null;
    }

    public static WebElement getElementAfterWait(WebDriver driver, String locator_type, String locator_input) {
        FluentWait<WebDriver> fw = new WebDriverWait(driver, Duration.ofSeconds(100));
        fw.pollingEvery(Duration.ofSeconds(5));
        fw.ignoring(StaleElementReferenceException.class);
        if (locator_type.equalsIgnoreCase("xpath")) {
            return fw.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator_input)));
        } else if (locator_type.equalsIgnoreCase("css")) {
            return fw.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator_input)));
        } else if (locator_type.equalsIgnoreCase("link")) {
            return fw.until(ExpectedConditions.presenceOfElementLocated(By.linkText(locator_input)));
        } else if (locator_type.equalsIgnoreCase("partiallink")) {
            return fw.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(locator_input)));
        } else if (locator_type.equalsIgnoreCase("class")) {
            return fw.until(ExpectedConditions.presenceOfElementLocated(By.className(locator_input)));
        } else if (locator_type.equalsIgnoreCase("name")) {
            return fw.until(ExpectedConditions.presenceOfElementLocated(By.name(locator_input)));
        } else if (locator_type.equalsIgnoreCase("id")) {
            return fw.until(ExpectedConditions.presenceOfElementLocated(By.id(locator_input)));
        } else if (locator_type.equalsIgnoreCase("tag")) {
            return fw.until(ExpectedConditions.presenceOfElementLocated(By.tagName(locator_input)));
        }

        return null;
    }

    public static List<WebElement> getElementsList(WebDriver driver, String locator_type, String locator_input) {
        if (locator_type.equalsIgnoreCase("xpath")) {
            return driver.findElements(By.xpath(locator_input));
        } else if (locator_type.equalsIgnoreCase("css")) {
            return driver.findElements(By.cssSelector(locator_input));
        } else if (locator_type.equalsIgnoreCase("link")) {
            return driver.findElements(By.linkText(locator_input));
        } else if (locator_type.equalsIgnoreCase("partiallink")) {
            return driver.findElements(By.linkText(locator_input));
        } else if (locator_type.equalsIgnoreCase("class")) {
            return driver.findElements(By.className(locator_input));
        } else if (locator_type.equalsIgnoreCase("name")) {
            return driver.findElements(By.name(locator_input));
        } else if (locator_type.equalsIgnoreCase("id")) {
            return driver.findElements(By.id(locator_input));
        } else if (locator_type.equalsIgnoreCase("tag")) {
            return driver.findElements(By.tagName(locator_input));
        }

        return null;
    }

    public static List<WebElement> getElementsListAfterWait(WebDriver driver, String locator_type, String locator_input) {
        FluentWait<WebDriver> fw = new WebDriverWait(driver, Duration.ofSeconds(100));
        fw.pollingEvery(Duration.ofSeconds(5));
        fw.ignoring(StaleElementReferenceException.class);
        if (locator_type.equalsIgnoreCase("xpath")) {
            return fw.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator_input)));
        } else if (locator_type.equalsIgnoreCase("css")) {
            return fw.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(locator_input)));
        } else if (locator_type.equalsIgnoreCase("link")) {
            return fw.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(locator_input)));
        } else if (locator_type.equalsIgnoreCase("partiallink")) {
            return fw.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.partialLinkText(locator_input)));
        } else if (locator_type.equalsIgnoreCase("class")) {
            return fw.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(locator_input)));
        } else if (locator_type.equalsIgnoreCase("name")) {
            return fw.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(locator_input)));
        } else if (locator_type.equalsIgnoreCase("id")) {
            return fw.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(locator_input)));
        } else if (locator_type.equalsIgnoreCase("tag")) {
            return fw.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName(locator_input)));
        }

        return null;
    }
}
