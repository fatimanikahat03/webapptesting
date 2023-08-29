package Stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import reusable.tobrowser;

import java.io.IOException;
import java.util.List;

public class MyStepdefs extends tobrowser {

    WebDriver driver;
        @Given("URL of application$")
        public void method() throws IOException {
       driver= tobrowser.bowserInvocation();
       driver.get("http://localhost:8081/my/");
        }

    @When("Validate the Green colour")
    public void validateTheGreenColour() {
        WebElement element = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td"));
        String backgroundColor = element.getAttribute("bgcolor");
        System.out.println("Background color is : " + backgroundColor);
    }

    @And("Validate the totalno of colurs")
    public void validateTheTotalnoOfColurs() {
        WebElement mytable = driver.findElement(By.xpath("/html/body/table"));
        List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
        int rows_count = rows_table.size();
        System.out.println("Number of colours: " + rows_count);
    }

    @And("add a new step")
    public void addANewStep() {
        System.out.println("Blank step");
    }

    @Then("Validate the title")
    public void validateTheTitle() {
            String Exp="Setting Colors Code";
            String Act=driver.getTitle();
        Assert.assertEquals(Exp,Act);

    }
}

