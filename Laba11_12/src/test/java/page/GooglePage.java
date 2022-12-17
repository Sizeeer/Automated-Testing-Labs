package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GooglePage extends AbstractPage {
    public static final String HOMEPAGE_URL = "https://www.google.com";

    public GooglePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public GooglePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public GoogleResultsPage setSearchQuery(String query){

        By searchInputLocator = By.xpath("//input[@class='gLFyf']");

        WebElement searchInput = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(searchInputLocator));

        searchInput.sendKeys(query);
        searchInput.sendKeys(Keys.ENTER);

        logger.info("Search query set");
        return new GoogleResultsPage(driver);
    }



}
