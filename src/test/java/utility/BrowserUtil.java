package utility;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BrowserUtil {

    /**
     * A method to pause the thread certain seconds
     * @param seconds
     */
    public static void waitFor( int seconds){
        try {
            Thread.sleep(seconds *1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    /**
     *   WebDriverWait wait =new WebDriverWait(Driver.getDriver(),2);
     *         //check of visibility pf the errorMsg in 2 seconds
     *         try {
     *             wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='blablactl00_MainContent_status']")));
     *         }catch (TimeoutException e){
     *             //System.out.println("Error message is "+e.getMessage());
     *             e.printStackTrace();
     *         }
     */

    /**
     * This method will check for visibility of element within the time given
     * @param locator By.id or By.xpath or By.whatever
     * @param second time to wait
     * @return true if the element is found within the time and visible , false if not
     */
    public static boolean checkVisibilityOfElement(By locator, int second){
        boolean result=false;
        WebDriverWait wait =new WebDriverWait(Driver.getDriver(),second);
        //check of visibility pf the errorMsg in 2 seconds
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            result=true;
        }catch (TimeoutException e){
            //System.out.println("Error message is "+e.getMessage());
            // e.printStackTrace();
            System.out.println("WE DID NOT SEE THE ERROR MESSAGE ELEMENT");
        }

        return result;

    }

    /**
     * A utility method to get the texts out of list of webElements
     * @param listOfWebElements the target list of webElement
     * @return  the text inside those web element as List<String>
     */

    public static List<String> getAllText(List<WebElement> listOfWebElements){

        List<String> allTextList=new ArrayList<>();

        for(WebElement eachElement: listOfWebElements){
            allTextList.add(eachElement.getText());
        }

        return allTextList;
    }


    public  static Map<String ,String> createMapFromTwoListsOfWebElements(List<WebElement> keys, List<WebElement> values){
        //create a map:
        // key as column name,
        // value as cell value

        Map<String,String> rowMap = new LinkedHashMap<>();// map to put keys and values

        //how to get all header as key
        List<String> allHeaders = getAllText(keys);// List<String> headers

        //how to get all first row and use it as value
        List<String> allFirstRow = getAllText(values);

        //Grab first header and use it as key , get first row data and use it as value


        for (int columnIndex =0;columnIndex<allHeaders.size();columnIndex++ )
            //go through each column and add column header as key, and cell value as value
            rowMap.put(allHeaders.get(columnIndex), allFirstRow.get(columnIndex));

        return rowMap;
    }


    /**
     * returns random number between a to b
     *
     * @param a
     * @param b
     * @return
     */
    public static int randomNumber(int a, int b) {
        return new Faker().number().numberBetween(a, b);
    }



    /** Creating method which accepts WebElement as a parameter
     *  and scroll down to specific webelement by using JavaScriptExecutor
     */

    public static void scrollingDown (WebElement targetElement){

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("arguments[0].scrollIntoView(true)", targetElement);

    }



    public static List<String> switchingWindows(Set<String> windows){

        List<String> allTitles = new ArrayList<>();

        for(String eachWindow: windows){

            Driver.getDriver().switchTo().window(eachWindow);

            BrowserUtil.waitFor(3);
            allTitles.add(Driver.getDriver().getTitle());
        }

        return allTitles;

    }


    public static void clickingMultipleLinks(List<WebElement> links){

        for(WebElement eachLink : links){
            eachLink.click();
            BrowserUtil.waitFor(2);
        }


    }


}
