import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static java.lang.Thread.sleep;

/**
 * Реализует драйвер для проведения тестов в браузере FireFox
 */
class Driver {
    static Logger log;
    static WebDriver driver = null;
    private static String URL =  "https://223.rts-tender.ru/supplier/auction/Trade/Search.aspx";

    /**
     * Инициализация драйвера
     */
    static void init(){
        log.writeLog("Инициализация драйвера FirefoxDriver");
        driver = new FirefoxDriver();
        log.writeLog("Переход по " + Driver.URL);
        driver.get(URL);
        log.writeLog("Ожидание загрузки страницы - 1 секунда");
        await(1);
    }

    /**
     * Завершение работы драйвера
     */
    static void finish(){
        driver.close();
    }

    /**
     * Приостановить работу на заданное время
     * @param sec количество секунд, на которые поток заснет
     */
    static void await(int sec){
        try{
            sleep(sec * 1000);
        } catch (InterruptedException ie){
            System.out.println("In method await\n" + ie);
        }
    }

    /**
     * Прокрутка страницы
     */
    static void scroll(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 250)");
    }

}
