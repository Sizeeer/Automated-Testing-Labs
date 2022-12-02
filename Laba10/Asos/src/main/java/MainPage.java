import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private static final String HOMEPAGE_URL = "https://www.asos.com";

    protected final int WAIT_TIME_IN_SECONDS = 10;
    private final WebDriver driver;

    @FindBy(xpath = "//button[@class='w9hgW1d _19PGtzt']")
    private WebElement flagButton;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
    private WebElement selectCountry;

    @FindBy(xpath = "//input[@id='chrome-search']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[text()='Brand'][@class='pbGFTFS']")
    private WebElement brandList;

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

    public MainPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public void enterSearchText(String searchText) {
        searchInput.sendKeys(searchText);
        searchInput.submit();
    }

    public void enterBrand() throws InterruptedException {
        brandList.click();
        Thread.sleep(2000);
        adidasItem.click();
    }

    public void enterGender() throws InterruptedException {
        genderList.click();
        Thread.sleep(2000);
        womenItem.click();
    }

}
