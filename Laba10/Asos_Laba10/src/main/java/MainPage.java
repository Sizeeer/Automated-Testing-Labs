import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private static final String HOMEPAGE_URL = "https://www.asos.com";

    protected final int WAIT_TIME_IN_SECONDS = 10;
    private final WebDriver driver;

    @CacheLookup
    @FindBy(tagName = "html")
    private WebElement __document;

    @FindBy(xpath = "//button[@class='w9hgW1d _19PGtzt']")
    private WebElement flagButton;

    @FindBy(className = "_3jBV0Hh")
    private WebElement updatePreferencesButton;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
    private WebElement selectCountry;

    @FindBy(xpath = "//input[@id='chrome-search']")
    private WebElement searchInput;

    @FindBy(id = "country")
    private WebElement countrySelect;

    @FindBy(xpath = "//div[text()='Brand'][@class='pbGFTFS']")
    private WebElement brandList;

    @FindBy(xpath = "//div[text()='Sort']")
    private WebElement sortPriceList;

    @FindBy(id = "plp_web_sort_price_low_to_high")
    private WebElement sortItem;

    @FindBy(xpath = "//div[text()='adidas'][@class='hLBn89t']")
    private WebElement adidasItem;

    @FindBy(xpath = "//div[text()='Gender'][@class='pbGFTFS']")
    private WebElement genderList;

    @FindBy(xpath = "//div[text()='Women'][@class='hLBn89t']")
    private WebElement womenItem;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForReload() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.stalenessOf(this.__document));
        wait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public MainPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public void enterSearchText(String searchText)  throws InterruptedException {
        searchInput.sendKeys(searchText);
        searchInput.submit();
        Thread.sleep(4000);
    }

    public void selectIndiaAsCountry() throws InterruptedException {
        flagButton.click();
        Thread.sleep(2000);
        countrySelect.click();
        countrySelect.sendKeys("India");
        countrySelect.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        updatePreferencesButton.click();
        Thread.sleep(4000);
    }

    public void sortPrice() throws InterruptedException {
        sortPriceList.click();
        Thread.sleep(2000);
        sortItem.click();
    }
}
