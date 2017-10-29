import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Содержит тесты, которые
 * имитируют пользовательские сценарии работы с формой
 */
public class TestUserScript {
    private PurchaseSearchForm psf;

    @BeforeSuite
    public void setUp(){
        Driver.log = new Logger();
        Driver.log.init("src\\rezult\\log" + Driver.log.getDate() + ".txt");
        Driver.init();
        Driver.log.writeLog("Создание объекта страницы");
        psf = new PurchaseSearchForm(Driver.driver);
        Driver.log.writeLog("Начинается тестирование на пользовательских сценариях");
    }
    @AfterSuite
    public void close(){
        Driver.log.writeLog("Завершение работы драйвера");
        Driver.finish();
        Driver.log.finishLog();
    }

    /**
     * Поиск по полям:
     * Организатор
     * Начальная цена от
     * Закупка малого объема
     * Тест успешен, если данные найдены (таблица не пуста)
     */
    @Test
    public void fillOraganazPriceSmallPurchase(){
        Driver.log.writeLog("Сценарий №1:\n" +
                "Ввод полей:\n" +
                "Организатор: МБУ \"БЛАГОУСТРОЙСТВО П.ДУБОВОЕ\"\n" +
                "Начальная цена от: 99900\n" +
                "Закупка малого объема");
        psf.fillOrganizerName("МБУ \"БЛАГОУСТРОЙСТВО П.ДУБОВОЕ\"");
        psf.fillPriceFrom("99900");
        psf.selectTypePurchaseSmall();
        Driver.log.writeLog("Поиск");
        psf.clickSearch();
        Driver.log.writeLog("Ожидание загрузки таблицы с результатами - 5 секунд");
        Driver.await(5); //ждем загрузку таблицы с результатами
        Driver.scroll();
        Assert.assertEquals(true,psf.countTRinTable() > 0);
        Driver.log.writeLog("Таблица не пуста, результаты есть");
        Driver.log.writeLog("Тест прошел успешно");
        psf.clickCancel();
    }

    /**
     * Поиск по полям:
     * Номер лота
     * Номер ЕИС
     * Регион поставки
     * Тест успешен, если результат только один в таблице
     */
    @Test
    public void fillNumLotNumEISRegion(){
        Driver.log.writeLog("Сценарий №2:\n" +
                "Ввод полей:\n" +
                "Номер лота: 130119\n" +
                "Номер ЕИС: 31705667665\n" +
                "Регион поставки: Ростовская область");
        psf.fillLotNumber("130119");
        psf.fillEIS("31705667665");
        psf.selectRegion(24);//Ростовская обл.
        Driver.log.writeLog("Поиск");
        psf.clickSearch();
        Driver.log.writeLog("Ожидание загрузки таблицы с результатами - 5 секунд");
        Driver.await(5); //ждем загрузку таблицы с результатами
        Driver.scroll();
        Assert.assertEquals(1,psf.countTRinTable());
        Driver.log.writeLog("В таблице только одна ожидаемая запись");
        Driver.log.writeLog("Тест прошел успешно");
        psf.clickCancel();
    }

    /**
     * Поиск по полям:
     * Способ закупки: аукцион
     * Коммерческая закупка
     * Дата начала торгов/переторжки
     * Тест успешен, если результатов поиска нет
     */
    @Test
    public void fillMethodPurchCommerticalDataOfTorg(){
        Driver.log.writeLog("Сценарий №3:\n" +
                "Ввод полей:\n" +
                "Способ закупки: аукцион\n" +
                "Коммерческая закупка\n" +
                "Дата начала торгов/переторжки: 30.12.2017");
        psf.selectMethodPurchase(new int[]{0});
        psf.selectTypePurchaseCommercial();
        psf.fillDateStartTradingFrom("30.12.2017");
        Driver.log.writeLog("Поиск");
        psf.clickSearch();
        Driver.log.writeLog("Ожидание загрузки таблицы с результатами - 5 секунд");
        Driver.await(5); //ждем загрузку таблицы с результатами
        Driver.scroll();
        Assert.assertEquals(0,psf.countTRinTable());
        Driver.log.writeLog("Таблица результатов пуста");
        Driver.log.writeLog("Тест прошел успешно");
        psf.clickCancel();
    }
}
