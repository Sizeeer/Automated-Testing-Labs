package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ItemPage extends AbstractPage {
    public ItemPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

}
