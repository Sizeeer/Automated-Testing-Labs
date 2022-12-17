package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends AbstractPage {

    public static final String HOMEPAGE_URL = "https://www.asos.com";
    private final By menButton = By.id("men-floor");
    private final By womenButton = By.id("women-floor");

    static final By searchInputLocator = By.id("chrome-search");

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public HomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public HomePage chooseMaleGender(){
        WebElement gender = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(menButton)).get(0);
        gender.click();
        logger.info("Male page opened");
        return new HomePage(driver);
    }

    public HomePage chooseFemaleGender(){
        WebElement gender = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(womenButton)).get(0);
        gender.click();
        logger.info("Female page opened");
        return new HomePage(driver);
    }

    public PageWithFilters setSearchQuery(String query){
        WebElement searchInput = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(searchInputLocator));
        searchInput.sendKeys(query);
        searchInput.sendKeys(Keys.ENTER);
        logger.info("Search query set");
        return new PageWithFilters(driver);
    }

    public HomePage selectCountry(String country) throws InterruptedException {
        By selectCountryLocation = By.xpath("//button[@data-testid='country-selector-btn']");

        WebElement countryButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(selectCountryLocation));

        countryButton.click();

        By selectWithCountriesLocator = By.xpath("//select[@id='country']");

        WebElement selectWithCountries = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(selectWithCountriesLocator));

        selectWithCountries.click();

        selectWithCountries.sendKeys(country);
        selectWithCountries.sendKeys(Keys.ENTER);

        By updateButtonLocator = By.xpath("//button[@data-testid='save-country-button']");

        WebElement updateButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(updateButtonLocator));

        updateButton.click();

        Thread.sleep(5000);

        return this;
    }

}
