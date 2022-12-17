package page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageWithFilters extends AbstractPage {

    public PageWithFilters(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public PageWithFilters selectGender(String id) throws InterruptedException {
        By genderSelectLocator = By.xpath("//li[@data-auto-id='floor']/div/button");

        WebElement genderSelect = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(genderSelectLocator));

        genderSelect.click();

        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(("document.getElementById('"+id+"').click()"));

        Thread.sleep(5000);

        return this;
    }

    public PageWithFilters selectBrand(String id) throws InterruptedException {
        By brandSelectLocator = By.xpath("//li[@data-auto-id='brand']/div/button");

        WebElement brandSelect = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(brandSelectLocator));

        brandSelect.click();

        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(("document.getElementById('"+id+"').click()"));

        Thread.sleep(5000);

        return this;
    }

    public PageWithFilters sort(String id) throws InterruptedException {
        By sortElementLocator = By.xpath("//li[@data-dropdown-id='sort']/div/button");

        WebElement sortElement = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sortElementLocator));

        sortElement.click();

        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(("document.getElementById('"+id+"').click()"));

        Thread.sleep(5000);

        return this;
    }

    public PageWithFilters selectColour(String id) throws InterruptedException {
        By colourElementLocator = By.xpath("//li[@data-auto-id='base_colour']/div/button");

        WebElement colourElement = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(colourElementLocator));

        colourElement.click();

        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(("document.getElementById('"+id+"').click()"));

        Thread.sleep(5000);

        return this;
    }

    public PageWithFilters selectSize(String id) throws InterruptedException {
        By sizeElementLocator = By.xpath("//li[@data-auto-id='size']/div/button");

        WebElement sizeElement = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sizeElementLocator));

        sizeElement.click();

        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(("document.getElementById('"+id+"').click()"));

        Thread.sleep(5000);

        return this;
    }

    public PageWithFilters selectPriceRange(Integer from, Integer to) throws InterruptedException {
        By priceRangeElementLocator = By.xpath("//li[@data-auto-id='currentprice']/div/button");

        WebElement priceRangeElement = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(priceRangeElementLocator));

        priceRangeElement.click();

        Thread.sleep(1000);

        By maxElementLocator = By.xpath("//div[@data-testid='maxIndicator']");

        WebElement maxElement = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(maxElementLocator));

        By minElementLocator = By.xpath("//div[@data-testid='minIndicator']");

        WebElement minElement = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(minElementLocator));

        Actions act = new Actions(driver);

        act.dragAndDropBy(maxElement, -((165 - to) / 5 * 10), 0).dragAndDropBy(minElement, (from - 20) / 5 * 10, 0)
                .build().perform();

        Thread.sleep(5000);

        return this;
    }

    public ResultsPage getResults(){
        return new ResultsPage(driver);
    }
}
