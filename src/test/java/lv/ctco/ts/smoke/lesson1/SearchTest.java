package lv.ctco.ts.smoke.lesson1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by okunev on 8/4/2016.
 */
public class SearchTest {

    private WebDriver driver;

    @Test
    public void verifySearchWorkingProperly(){
        driver = new FirefoxDriver();

        //Navigate to application url
        driver.get("http://demowebshop.tricentis.com");

        //Maximize browser window
        driver.manage().window().maximize();

        //Set implicitly wait. Wait will be triggered when element is not present
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        //Find input field Search
        WebElement txtSearch = driver.findElement(By.id("small-searchterms"));
        txtSearch.sendKeys("$100 Physical Gift Card");

        //Find button Search
        WebElement btnSearch = driver.findElement(By.cssSelector(".search-box input[value='Search']"));
        btnSearch.click();

        //Verify correct product is found
        WebElement lblProduct = driver.findElement(By.cssSelector(".product-item .product-title a"));
        Assert.assertTrue(lblProduct.isDisplayed());
        Assert.assertEquals("$100 Physical Gift Card", lblProduct.getText());

        //Close browser
        driver.quit();
    }
}
