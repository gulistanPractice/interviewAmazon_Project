package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Driver;

import java.sql.DriverManager;

public class Testing {

    public static void main(String[] args) {
        Driver.getDriver().findElement(By.id("username")).sendKeys("name");
    }


}
