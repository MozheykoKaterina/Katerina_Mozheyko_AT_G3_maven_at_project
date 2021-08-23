package week10.day19.fake;

import driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FakeGuiSteps {
    
    @Given(value = "I go to trashmail.com")
    public void checkHeaderTest() {
        Driver.getWebDriver().get("https://trashmail.com/");
    }
    
    @When("I start waiting")
    public void checkFooterTest() throws InterruptedException {
        Thread.sleep(2000);
    }
    
    @Then("I just passed")
    public void verify() {
        Assert.assertTrue(true);
    }
}
