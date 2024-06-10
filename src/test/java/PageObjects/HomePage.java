package PageObjects;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.annotations.WhenPageOpens;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

@DefaultUrl("https://risk.lexisnexis.co.uk/")

public class HomePage extends PageObject {

    private static final By FinancialServiceText = By.xpath("//div[@class='caption']/h4[.='Financial Services']");
    private static final By InsuranceText = By.xpath("//div[@class='caption']/h4[.='Insurance']");
    private static final By LifeAndPensionText = By.xpath("//div[@class='caption']/h4[.='Life and Pensions']");
    private static final By CorporationAndNonProfitText = By.xpath("//div[@class='caption']/h4[.='Corporations and Non-Profits']");
    private static final By ChooseYourIndustryMenuitem =  By.linkText("Choose Your Industry");
    private static final By FinancialServiceMTab =  By.xpath("//div[@class='subpage-title'][.='Financial Services ']");
    public static final By Cookies_Button = By.cssSelector("#onetrust-accept-btn-handler");

    private static final By FinancialServiceLink = By.cssSelector("[href ='/financial-services/financial-crime-compliance']");
    private static final By CustomerDataManagementLink = By.cssSelector("[href='/financial-services/customer-data-management']");
    private static final By CollectionsAndRecoveryLink = By.cssSelector("[href='/financial-services/collections-and-recovery']");
    private static final By RiskOrchestrationLink = By.cssSelector("[href='/financial-services/risk-orchestration']");
    private static final By FraudAndIdentityManagementLink = By.cssSelector("[href='/financial-services/fraud-and-identity-management']");
    private static final By CreditRiskAssessmentLink = By.cssSelector("[href='/financial-services/credit-risk-assessment']");
    private static final By InvestigationsAndDueDiligenceLink = By.cssSelector("[href='/financial-services/tracing-and-investigations']");

    //Click on cookies
    public void acceptCookies(){
        find(Cookies_Button).click();
    }

    @WhenPageOpens
    public void maximiseScreen() {
        getDriver().manage().window().maximize();
    }

    //Verify list item of items on the home page
    public List<String> getTableValues(){
        withTimeoutOf(Duration.ofSeconds(3))
                .waitFor(presenceOfElementLocated(FinancialServiceText));
        List<String> elem = new ArrayList<String>();
        By[] locators = {
                FinancialServiceText,
                InsuranceText,
                LifeAndPensionText,
                CorporationAndNonProfitText
        };

        for (By locator : locators) {
            WebElement element = withTimeoutOf(Duration.ofSeconds(3))
                    .waitFor(elementToBeClickable(locator));
            elem.add(element.getText());
        }
        return elem;
    }

    //Select and Click ChooseYourIndustryMenuitem
    public void clickChooseYourIndustry(){
        find(ChooseYourIndustryMenuitem).click();
    }

    //Click FinancialServiceMTab
    public void clickFinancialServiceTab(){

        find(FinancialServiceMTab).click();
    }

    //Verify list item of items on the financial service page
    public List<String> getTableValues2() {
        withTimeoutOf(Duration.ofSeconds(3))
                .waitFor(visibilityOfElementLocated(FinancialServiceLink));
        List<String> elem = new ArrayList<String>();
        By[] locators = {
                FinancialServiceLink,
                CustomerDataManagementLink,
                CollectionsAndRecoveryLink,
                RiskOrchestrationLink,
                FraudAndIdentityManagementLink,
                CreditRiskAssessmentLink,
                InvestigationsAndDueDiligenceLink
        };

        for (By locator : locators) {
            elem.add(find(locator).getText());
        }
        return elem;
    }
}