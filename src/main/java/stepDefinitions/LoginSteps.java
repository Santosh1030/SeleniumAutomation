package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class LoginSteps extends CommonFunctions {

    @Given("Im on home page {string} with title as {string}")

    public void openHomePage(String url, String expectedPageTitle) {
        driver.get(url);
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(expectedPageTitle, actualPageTitle);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id("sp-cc-accept")).click();
    }

    @When("I click on signIn page link")

    public void clickSignINPageLink() {
        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
    }

    @When("I enter username {string}")

    public void enterUsername(String username) {
        driver.findElement(By.id("ap_email")).sendKeys(username);
    }

    @When("I click continue")

    public void clickContinue() {
        driver.findElement(By.id("continue")).click();
    }

    @When("I enter password {string}")

    public void enterPassword(String password) {
        driver.findElement(By.id("ap_password")).sendKeys(password);
    }

    @When("I click signIn button")

    public void clickSignIn() {
        driver.findElement(By.id("signInSubmit")).click();
    }

    @Then("I should be landed on product page with heading text as {string}")
    public void VerifyLoginSuccess(String expectedPageHeading) {
        String actualPageHeading = driver.findElement(By.id("nav-logo-sprites")).getText();
        Assert.assertEquals(expectedPageHeading, actualPageHeading);
    }

    @Then("I should see a text in the same page with heading as {string} and text as {string}")

    public void verifyLoginFailure(String expectedFailedHeading, String expectedFailedText) {
        String actualFailedHeading = driver.findElement(By.xpath("//h4[@class = \"a-alert-heading\"]")).getText();
        Assert.assertEquals(expectedFailedHeading, expectedFailedHeading);

        String actualFailedText = driver.findElement(By.xpath("")).getText();
        Assert.assertEquals(expectedFailedText, actualFailedText);
    }
}
