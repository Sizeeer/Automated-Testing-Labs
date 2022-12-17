package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleResultsPage extends AbstractPage {
    static final By searchItemLocator = By.xpath("//div[@class='tF2Cxc']/div/a");
    public GoogleResultsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public HomePage goToAsos(){
        WebElement item = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(searchItemLocator));
        item.click();
        logger.info("Found item page opened");
        return new HomePage(driver);
    }

}
