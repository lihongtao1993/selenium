package com.gs.poi.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementUtil {
    public static boolean isExist(By by, WebDriver driver){
        try {
            driver.findElement(by);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
