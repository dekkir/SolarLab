import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;

public class TestSelenium {
    WebDriver wd = null;


    @BeforeMethod()
    public void setUp(){
        //System.setProperty("geckodriver", "C:\\Program Files\\Java\\jdk1.8.0_111\\bin");
        wd = new FirefoxDriver();
    }

    @AfterMethod()
    public void closed(){
        wd.close();
    }

    @Test
    public void testMainPage() throws InterruptedException {
        wd.get("http://irissh.beon.ru/");
        sleep(5000);
        String s = wd.getTitle();
        if(s.equals("Future")) System.out.println("true");
        else System.out.println("false");
        List<WebElement> we = wd.findElements(By.cssSelector("*.blog"));
        for (WebElement aWe : we) {
            System.out.println(aWe.toString());
        }
    }
}
