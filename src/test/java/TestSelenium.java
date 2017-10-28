import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;


public class TestSelenium {


    @BeforeMethod
    public void setUp(){
        Driver.init();
    }
    @AfterMethod
    public void close(){
        Driver.finish();
    }

    @Test
    public void testTitle()  {
        Assert.assertEquals("Поиск закупок", Driver.driver.getTitle());
    }

    @Test
    public void editLot(){
        ProcurementSearchForm psf = new ProcurementSearchForm(Driver.driver);
        psf.fillLotNumber("hello");
        psf.fillNameObject("hello2");
        psf.selectNameObject();

        psf.selectOKDP(15);
        psf.selectRegion(2);

        ((JavascriptExecutor) Driver.driver).executeScript("window.scrollBy(0,200)", "");
        psf.selectStatLot(2);

    }
}
