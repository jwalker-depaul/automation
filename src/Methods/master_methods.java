package Methods;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by Joseph on 3/10/2017.
 */
public class master_methods {

    /************************
    ***   Setup Drivers   ***
    ************************/

    public static ChromeDriver driver;

    public static void setupChromeDriver()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Joseph\\Desktop\\automation\\jars\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver();
    }

    public static void setupChromeDriver(String url)
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Joseph\\Desktop\\automation\\jars\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver();
        driver.get(url);
    }

    /*****************************
    ***   Selecting elements   ***
    *****************************/

    public static void clickElement (String xpath, int seconds)
    {
        waitForElementToBeDisplayed(xpath);
        for (int i = 0; i < seconds; i++)
        {
            try
            {
                driver.findElement(By.xpath(xpath)).click();
                return;
            }
            catch (Exception e)
            {
                waitFor(1);
            }
            System.out.println("Element did not appear");
        }
    }

    public static void clickElement(String xpath)
    {
        waitForElementToBeDisplayed(xpath);
        for (int i = 0; i < 10; i++)
        {
            try
            {
                driver.findElement(By.xpath(xpath)).click();
                return;
            }
            catch (Exception e)
            {
                waitFor(1);
            }
            System.out.println("Element did not appear");
        }
    }

    /*******************************
    ***   Waiting for elements   ***
    *******************************/

    // Pause the program for seconds amount of time
    public static void waitFor(int seconds)
    {
        try{
            Thread.sleep(seconds * 1000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public static void waitForElementToBeDisplayed(String xpath)
    {
        for (int i = 0; i < 10; i++)
        {
            try
            {
                if(driver.findElement(By.xpath(xpath)).isDisplayed())
                    return;
            }
            catch (Exception e)
            {
                waitFor(1);
            }
        }
        System.out.println("The element was not displayed");
        Assert.fail();
    }

    public static void waitForElementToBeDisplayed(String xpath, int seconds)
    {
        for (int i = 0; i <= seconds / 4; i++)
        {
            try
            {
                if(driver.findElement(By.xpath(xpath)).isDisplayed());
                    return;
            }
            catch (Exception e)
            {
                waitFor(1);
            }
        }
        System.out.println("The element was not displayed");
        Assert.fail();
    }

    public static boolean isElementPresent(String xpath)
    {
        try
        {
            driver.findElement(By.xpath(xpath));
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

    /****************
    ***   Other   ***
    ****************/

    public static void clearAndEnterText(String xpath, String text)
    {
        driver.findElement(By.xpath(xpath)).clear();
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }

}
