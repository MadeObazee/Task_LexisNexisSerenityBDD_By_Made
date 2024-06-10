package StepDefinitions;

import PageObjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.steps.UIInteractionSteps;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyFinancialMenuStepsDef extends UIInteractionSteps {
    HomePage homePage = new HomePage();


    @Given("User opens the home page")
    public void user_opens_the_home_page() {
        homePage.open();
        homePage.acceptCookies();
    }

    //Verify menu items text on home page
    @Then("I verify the following on Home Page:")
    public void iVerifyTheFollowingOnHomePage(List<String> expectedValues) {
        List<String> actualValues = homePage.getTableValues();
        assertThat(actualValues).containsExactlyElementsOf(expectedValues);
    }

    //Verify meun link text on financial service page
    @Then("I verify the following on Financial page:")
    public void iVerifyTheFollowingOnFinancialPage(List<String> expectedValues) {
        List<String> actualValues = homePage.getTableValues2();
        assertThat(actualValues).containsExactlyElementsOf(expectedValues);
    }

    //Click on Choose Your Industry menu link
    @When("I expand Choose your industry accordion")
    public void iExpandChooseYourIndustryAccordion() {
        homePage.clickChooseYourIndustry();
    }

    //Select financial service item
    @And("I click Financial Services")
    public void iClickFinancialServices() {
        homePage.clickFinancialServiceTab();
    }
}