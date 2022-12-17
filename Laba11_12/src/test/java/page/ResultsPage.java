package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResultsPage extends AbstractPage {
    public ResultsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ItemPage openFoundItem(String id){
        By searchItemLocator = By.xpath("//article[@id='"+id+"']/a");

        WebElement item = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(searchItemLocator));

        item.click();

        logger.info("Found item page opened");
        return new ItemPage(driver);
    }

}
