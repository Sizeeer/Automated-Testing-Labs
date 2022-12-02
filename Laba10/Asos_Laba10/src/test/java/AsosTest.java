import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AsosTest {
    private WebDriver driver;
    MainPage mainPage;

    @BeforeMethod
    public void driverSetup() {
        driver = new ChromeDriver();
    }

    @Test
    public void AccessoriesInfoTest() throws InterruptedException {
        driver.manage().window().setSize(new Dimension(1760, 1080));
        mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.selectIndiaAsCountry();
        mainPage.enterSearchText("polo ralph lauren polo shirt");
        mainPage.sortPrice();
        Assert.assertTrue(true);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
        driver = null;
    }
}
