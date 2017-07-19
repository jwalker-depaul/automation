package Applications;

/**
 * Created by Joseph on 3/10/2017.
 */

import Methods.master_methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class amazon_search_demo extends master_methods{


    public static void main (String args[])
    {
        System.out.println("Beginning program");

        // Preliminary setup
        setupChromeDriver("https://amazon.com");

        // Enter information
        clearAndEnterText("//input[@id = 'twotabsearchtextbox']", "Autodesk maya 2017");

        // Click the search button
        clickElement("//input[@type = 'submit'][@value = 'Go']");

        // Grab list of results
        List<WebElement> results = driver.findElements(By.xpath("//li[contains(@id, 'result_')]"));

        /******************************
        ***   Display the Results   ***
        ******************************/

        int i;

        // Loop through results
        for (i = 0; i < results.size(); i++)
        {
            // Grab the name of the textbook
            String textbookName = driver.findElement(By.xpath("//li[@id = 'result_" + i + "']")).getText();

            // Print the name
            System.out.println(textbookName);
            System.out.println();
            System.out.println();
        }

        // Program end
        driver.close();
        System.out.println("Program ran successfully!");
    }
}
