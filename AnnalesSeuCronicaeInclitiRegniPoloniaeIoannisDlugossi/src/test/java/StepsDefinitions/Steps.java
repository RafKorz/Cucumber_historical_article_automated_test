package StepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.annotation.WillCloseWhenClosed;


public class Steps {

    private WebDriver driver;
    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rafal\\Desktop\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("a user in http://wikipedia.pl")
    public void userOnPage()
    {
        driver.navigate().to("http://wikipedia.pl");
    }

    @When("the user types \"Roczniki czyli kroniki sławnego Królestwa Polskiego\" in input search")
    public void userOnArticle()
    {
        driver.findElement(By.id("searchInput")).sendKeys("Roczniki czyli kroniki sławnego Królestwa Polskiego");
    }

    @And("clicks on search button")
    public void userClicks()
    {
        driver.findElement(By.id("searchButton")).click();
    }

    @Then("the user should see this article")
    public void userSeeArticle()
    {
        Assert.assertEquals(true, verifyElementPresent(driver, By.id("Historia")));
    }

    public static boolean verifyElementPresent(WebDriver driver, By by)
    {
        try
        {
            driver.findElement(by);
            System.out.println("Element found");
            return true;
        }
        catch(NoSuchElementException e)
        {
            System.out.println("Element not found");
            return false;
        }
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}

