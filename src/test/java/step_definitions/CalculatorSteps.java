package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.CalculatorPage;
import utils.Driver;


public class CalculatorSteps {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorSteps.class);

    CalculatorPage calculator = new CalculatorPage();

    @Given("User navigates to the calculator page")
    public void userNavigatesToTheCalculatorPage() {
        calculator.loadPage();
        String title = Driver.getInstance().getDriver().getTitle();
        logger.info("Page Title is: " + title);
    }

    @And("User clicks on {string} button")
    public void userClickOnButton(String button) throws InterruptedException {

        switch (button) {
            case "1":
                calculator.one.click();
                break;
            case "2":
                calculator.two.click();
                break;
            case "3":
                calculator.three.click();
                break;
            case "4":
                calculator.four.click();
                break;
            case "5":
                calculator.five.click();
                break;
            case "6":
                calculator.six.click();
                break;
            case "7":
                calculator.seven.click();
                break;
            case "8":
                calculator.eight.click();
                break;
            case "9":
                calculator.nine.click();
                break;
            case "0":
                calculator.zero.click();
                break;
            case ".":
                calculator.period.click();
                break;
            case "+":
                calculator.plus.click();
                break;
            case "-":
                calculator.minus.click();
                break;
            case "x":
                calculator.multiplication.click();
                break;
            case "/":
                calculator.division.click();
                break;
            case "=":
                calculator.equals.click();
                break;
            case "+/-":
                calculator.sign.click();
                break;
            case "C":
                calculator.clear.click();
                break;
        }
        logger.info("Clicked on: " + button);
    }

    @Then("Validate display screen with value {string}")
    public void validateDisplayScreenWithValue(String value) {
        String actualValue = calculator.display.getAttribute("value").trim();
        logger.info("display value is :" + actualValue);
        String expectedValue = value.trim();
        Assert.assertEquals("Value did not match expected.", expectedValue, actualValue);
    }

    @When("^User enters the number (.*)$")
    public void userEntersTheNumber(Object num) throws InterruptedException {
        String number = String.valueOf(num);
        int size = number.length();

        logger.info("String number is :" + number);

        for (int i = 0; i < size; i++) {
            if (number.charAt(i) == '.') {
                calculator.period.click();
            } else {
                userClickOnButton(Character.toString(number.charAt(i)));
            }
        }
    }
}
