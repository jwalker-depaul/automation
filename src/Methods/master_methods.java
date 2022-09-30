package Methods;

//import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import java.io.File;
//import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Joseph on 3/10/2017.
 * For questions reach out to jwalker.depaul@gmail.com
 */
public class master_methods {

    /************************
    ***   Setup Drivers   ***
    ************************/

    public static ChromeDriver driver;

    public static void setupChromeDriver(String url)
    {
        System.setProperty("webdriver.chrome.driver", "..\\automation\\jars\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get(url);
    }

    /******************
    ***   Browser   ***
    ******************/

    public void closeBrowser()
    {
        driver.quit();
    }

    public void refreshPage(int seconds)
    {
        driver.navigate().refresh();
        waitFor(seconds);
    }

    /***************
    ***   Page   ***
    ***************/

    public void waitForPageToLoad(int waitTime)
    {
        driver.manage().timeouts().pageLoadTimeout(waitTime, TimeUnit.SECONDS);
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

    public List<WebElement> getWebElements(String xpath)
    {
        return driver.findElements(By.xpath(xpath));
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

    public boolean isElementDisplayed(String xpath)
    {
        try
        {
            driver.findElement(By.xpath(xpath)).isDisplayed();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    /***************
    ***   Text   ***
    ***************/

    public static void clearAndEnterText(String xpath, String text)
    {
        driver.findElement(By.xpath(xpath)).clear();
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    public boolean isCorrectText(String expectedText, String xpath)
    {
        String actualText = driver.findElement(By.xpath(xpath)).getText();
        if (actualText.equals(expectedText))
        {
            return true;
        }

        return false;
    }

    /********************
    ***   Utilities   ***
    ********************/
    /*
    public void takeScreenshot(String name, String directory)
    {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File targetFile = new File(directory + name + ".jpg");

        try
        {
            FileUtils.copyFile(srcFile, targetFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    */

    public String getCurrentDate()
    {
        DateTimeFormatter timeFormater = DateTimeFormatter.ofPattern("MM/dd/YYYY");
        LocalDate localDate = LocalDate.now();
        return timeFormater.format(localDate);
    }

}
