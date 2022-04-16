package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchSteps extends CommonFunctions {



    @When("I search for {string}")

    public void enterSearchTextField(String searchTerm) {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchTerm);
    }

    @And("I click search")

    public void clickSearch()
    {
        driver.findElement(By.id("nav-search-submit-button")).click();
    }
    @Then("I should get relevant products as result")

    public void verifySearchResults()
    {
        List<WebElement> productTitleTexts = driver.findElements(By.xpath("//span[@class= 'a-size-base-plus a-color-base a-text-normal']"));
         for (WebElement productTitleText : productTitleTexts)
         {
             String expectedTitleText = "t shirt";
             String actualTitleText = productTitleText.getText();
             Assert.assertTrue(actualTitleText.contains(expectedTitleText));
         }
    }

    @Then("I should be landed on productListPage with heading text as {string}")

    public void verifyIrrelevantSearchResults(String expectedPageText)
    {
        String actualPageText1 = driver.findElement(By.xpath("")).getText();
        String actualPageText2 = driver.findElement(By.xpath("")).getText();
        String actualPageText3 = driver.findElement(By.xpath("")).getText();

        Assert.assertEquals(expectedPageText, actualPageText1+actualPageText2+actualPageText3);


    }
}
