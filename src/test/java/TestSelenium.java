import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



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
}
