package com.gs.poi.h5.sight;

import com.gs.poi.utils.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import sun.misc.JavaSecurityAccess;

import java.io.IOException;
import java.time.Duration;

public class SightDetailSafari {
    public WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;

    @BeforeTest
    public void setDriver(){
        WebDriverManager.safaridriver().setup();
    }

    @BeforeMethod
    public void setup(){
        SafariOptions options = new SafariOptions();
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setHeadless(true);
        driver = new SafariDriver(options);
        js = (JavascriptExecutor)driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.get("https://m.ctrip.com/webapp/you/gspoi/sight/2/762.html?seo=0");
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }

    @Test
    public void test() throws IOException, InterruptedException {
//
//        wait.until(ExpectedConditions.alertIsPresent());
//        Alert alert = driver.switchTo().alert();
//
////Store the alert in a variable for reuse
//        String text = alert.getText();
//        System.out.println(text);
//
////Press the Cancel button
//        alert.dismiss();
//        获取景点名称元素

        wait.until(driver -> driver.findElement(By.cssSelector(".poiTitle.title-box")));
        WebElement element = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[4]/div[2]/p"));
//        因为名称元素里面有text+html标签，通过js来获取名称
        Object o = js.executeScript("return arguments[0].childNodes[0].textContent", element);
        Assert.assertEquals("东方明珠",o);

        if (ElementUtil.isExist(By.cssSelector(".noticeTitleInner"),driver)) {
            driver.findElement(By.cssSelector(".noticeTitleInner")).click();
            System.out.println("jj");
            driver.findElement(By.cssSelector(".notice-modal-close")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        }
        {
            WebElement until = wait.until(driver -> driver.findElement(By.cssSelector(".poiTitle.title-box")));
            System.out.println("wait"+until.getText());
            until.click();
        }
//        String title = driver.findElement(By.cssSelector(".poiTitle.title-box")).getText();
//        System.out.println(title);
        js.executeScript("window.scrollBy(0,1000);");
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://m.ctrip.com/webapp/you/gspoi/sight/2/762.html?seo=0");
        System.out.println(driver.getTitle());
        wait.until(driver -> driver.findElement(By.cssSelector(".poiTitle.title-box")));
        driver.findElement(By.cssSelector(".poiTitle.title-box")).click();
        Thread.sleep(3000);
    }
}
