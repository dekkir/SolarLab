import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Содержит тесты, которые проверяет на доступность следующие поля:
 * Способ закупки
 * Статус лота
 * Номенклатура (ОКДП)
 * Регион доставки
 *
 */
public class TestComplexField {
    private PurchaseSearchForm psf;


    @BeforeSuite
    public void setUp(){
        Driver.log = new Logger();
        Driver.log.init("src\\rezult\\log" + Driver.log.getDate() + ".txt");
        Driver.init();
        Driver.log.writeLog("Создание объекта страницы");
        psf = new PurchaseSearchForm(Driver.driver);
        Driver.log.writeLog("Начинается тестирование доступности сложных полей");
    }

    @AfterSuite
    public void close(){
        Driver.log.writeLog("Завершение работы драйвера");
        Driver.finish();
        Driver.log.finishLog();
    }

    /**
     * Ввод Номенклатура (ОКДП)
     */
    @Test
    public void selectOKDP(){
        Driver.log.writeLog("Тестирование поля \"Номенклатура (ОКДП)\"");
        Driver.log.writeLog("Выбор категории B и Q");
        psf.selectOKDP(new int[]{16, 1});
        Driver.log.writeLog("Тест окончен успешно");
    }

    /**
     * Ввод Регион доставки
     */
    @Test
    public void selectRegion(){
        Driver.log.writeLog("Тестирование поля \"Регион доставки\"");
        Driver.log.writeLog("Выбор Воронежской области");
        psf.selectRegion(4);
        Driver.log.writeLog("Тест окончен успешно");
    }

    /**
     * Ввод Статус лота
     */
    @Test
    public void selectStatusLot(){
        Driver.log.writeLog("Тестирование поля \"Статус лота\"");
        Driver.log.writeLog("Выбор значения \"Ожидает переторжку\"");
        psf.selectStatLot(12);
        Driver.log.writeLog("Выбор значения \"Публикация извещения\"");
        psf.selectStatLot(1);
        Driver.log.writeLog("Тест окончен успешно");
    }
    /**
     * Ввод Способ закупки
     */
    @Test
    public void selectMethodPurchase(){
        Driver.log.writeLog("Тестирование поля \"Способ закупки\"");
        Driver.log.writeLog("Выбор значений \"Запрос предложений, " +
                "Сбор коммерческих предложений (архив), Конкурс\"");
        psf.selectMethodPurchase(new int[]{2, 4, 1});
        Driver.log.writeLog("Тест окончен успешно");
    }

}
