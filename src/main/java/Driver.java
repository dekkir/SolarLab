import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.Thread.sleep;


public class Driver {
    static WebDriver driver = null;


    static void init(){
       // System.setProperty("geckodriver", "C:\\Program Files\\Java\\jdk1.8.0_111\\bin");
        driver = new FirefoxDriver();
        Driver.driver.get("https://223.rts-tender.ru/supplier/auction/Trade/Search.aspx");
        wait(1);
    }

    static void finish(){
        driver.close();
    }

    private static void wait(int sec){
        try{
            sleep(sec * 1000);
        } catch (InterruptedException ie){
            System.out.println(ie);
        }
    }

    public static void scroll(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 250)");
    }

}
