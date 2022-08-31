package com.gs.poi.h5.sight.sightlist;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gs.poi.pojo.POIInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;


public class ListCard {
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    @BeforeSuite
    public void managerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setDriver(){
        driver = new ChromeDriver();
        //隐式等待
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void testCardPoiInfo(){
        driver.get("https://m.ctrip.com/webapp/you/gspoi/sight/2.html?seo=0");
        List<WebElement> cardList = driver.findElements(By.xpath("//div[starts-with(@itemobj,\"{\")]"));
        for (WebElement card : cardList) {
            String itemObj = card.getAttribute("itemobj");
            POIInfo poiInfo = JSONObject.parseObject(itemObj, POIInfo.class);
            Assert.assertTrue(poiInfo.isSuccess());
        }
    }

    @Test
    public void test1(){
        driver.get("https://m.ctrip.com/webapp/you/gspoi/sight/2/762.html?seo=0");
        String text = driver.findElement(By.xpath("//p[@class='poiTitle title-box']")).getText();
        System.out.println(text);
        driver.navigate().refresh();
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }
}
