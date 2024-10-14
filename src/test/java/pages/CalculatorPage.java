package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigReader;

public class CalculatorPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorPage.class);

    @Override
    public void loadPage() {
        String url = ConfigReader.getInstance().getProperty("config.properties", "base.url");
        driver.get(url);
        logger.info("Navigated to URL: " + url);
    }

    @FindBy(xpath = "//input[@id='display']")
    public WebElement display;

    @FindBy(xpath = "//div[@id='operator-display']/span")
    public WebElement operator;

    @FindBy(xpath = "//*[text()='0']")
    public WebElement zero;

    @FindBy(xpath = "//*[text()='1']")
    public WebElement one;

    @FindBy(xpath = "//*[text()='2']")
    public WebElement two;

    @FindBy(xpath = "//*[text()='3']")
    public WebElement three;

    @FindBy(xpath = "//*[text()='4']")
    public WebElement four;

    @FindBy(xpath = "//*[text()='5']")
    public WebElement five;

    @FindBy(xpath = "//*[text()='6']")
    public WebElement six;

    @FindBy(xpath = "//*[text()='7']")
    public WebElement seven;

    @FindBy(xpath = "//*[text()='8']")
    public WebElement eight;

    @FindBy(xpath = "//*[text()='9']")
    public WebElement nine;

    @FindBy(xpath = "//*[text()='.']")
    public WebElement period;

    @FindBy(xpath = "//*[text()='Clear']")
    public WebElement clear;

    @FindBy(xpath = "//*[text()='=']")
    public WebElement equals;

    @FindBy(xpath = "//*[text()='/']")
    public WebElement division;

    @FindBy(xpath = "//*[text()='*']")
    public WebElement multiplication;

    @FindBy(xpath = "//*[text()='-']")
    public WebElement minus;

    @FindBy(xpath = "//*[text()='+']")
    public WebElement plus;

    @FindBy(xpath = "//*[text()='+/-']")
    public WebElement sign;

}