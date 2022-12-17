package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected final static int WAIT_TIME_IN_SECONDS = 5;
    protected final Logger logger = LogManager.getRootLogger();

    protected AbstractPage(WebDriver driver){
        this.driver = driver;
    }

    protected void CustomDelay(int seconds){
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
