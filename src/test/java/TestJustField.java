
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Содержит тесты, которые проверяют доступность следующих полей:
 * Номер закупки/лота
 * Наименование объекта закупки
 * Check-box Наименование закупки
 * Дата начала торгов/переторжки
 * Номер в ЕИС
 * Организатор
 * radio-button искать по ИНН (организатор)
 * Заказчик
 * Начальная цена от, до
 * check-box Совместные закупки
 * check-box Тип закупки: коммерческая закупка, закупка малого объема
 *
 */
public class TestJustField {
    private PurchaseSearchForm psf;

    @BeforeSuite
    public void setUp(){
        Driver.log = new Logger();
        Driver.log.init("src\\rezult\\log" + Driver.log.getDate() + ".txt");
        Driver.init();
        Driver.log.writeLog("Создание объекта страницы");
        psf = new PurchaseSearchForm(Driver.driver);
        Driver.log.writeLog("Начинается тестирование доступности простых полей");
    }
    @AfterSuite
    public void close(){
        Driver.log.writeLog("Завершение работы драйвера");
        Driver.finish();
        Driver.log.finishLog();
    }

    /**
     * Номер закупки/лота
     */
    @Test
    public void writeLot(){
        Driver.log.writeLog("Тестирование поля \"Номер закупки/лота\"");
        Driver.log.writeLog("Ввод \"1289532\"");
        psf.fillLotNumber("1289532");
        Driver.log.writeLog("Тест прошел успешно");
    }

    /**
     * Наименование объекта закупки
     * Check-box Наименование закупки
     */
    @Test
    public void writeNameObject(){
        Driver.log.writeLog("Тестирование поля \"Наименование объекта закупки\"\n" +
                " check-box \"Наименование закупки\"");
        Driver.log.writeLog("Ввод \"Компьютер\"");
        psf.fillNameObject("Компьютер");
        psf.notSelectNameObject();
        Driver.log.writeLog("Тест прошел успешно");
    }

    /**
     * check-box Тип закупки: закупка малого объема
     */
    @Test
    public void selectTypePurchaseSmall(){
        Driver.log.writeLog("Тестирование check-box \"Тип закупки: закупка малого объема\"");
        psf.selectTypePurchaseSmall();
        Driver.log.writeLog("Тест прошел успешно");
    }

    /**
     * check-box Тип закупки: коммерческая закупка
     */
    @Test
    public void selectTypePurchaseCommercial(){
        Driver.log.writeLog("Тестирование check-box \"Тип закупки: коммерческая закупка\"");
        psf.selectTypePurchaseCommercial();
        Driver.log.writeLog("Тест прошел успешно");
    }

    /**
     * check-box Совместные закупки
     */
    @Test
    public void selectJoinPurchas(){
        Driver.log.writeLog("Тестирование check-box \"Совместные закупки\"");
        psf.selectJoinPurchas();
        Driver.log.writeLog("Тест прошел успешно");
    }

    /**
     * Начальная цена от, до
     */
    @Test
    public void fillPriceFrom_To(){
        Driver.log.writeLog("Тестирование поля \"Начальная цена: от, до\"");
        Driver.log.writeLog("Ввод \"1000\"");
        Driver.log.writeLog("Ввод \"9900000000\"");
        psf.fillPriceFrom("1000");
        psf.fillPriceTo("9900000000");
        Driver.log.writeLog("Тест прошел успешно");
    }

    /**
     * Заказчик
     */
    @Test
    public void fillCustomer(){
        Driver.log.writeLog("Тестирование поля \"Заказчик\"");
        Driver.log.writeLog("Ввод \"Иванов\"");
        psf.fillСustomer("Иванов");
        Driver.log.writeLog("Тест прошел успешно");
    }

    /**
     * Организатор
     * radio-button искать по ИНН (организатор)
     */
    @Test
    public void fillOrganizerByINN(){
        Driver.log.writeLog("Тестирование поля \"Организатор\", radio-button искать по ИНН");
        Driver.log.writeLog("Ввод \"236928594834\"");
        psf.fillOrganizerName("236928594834");
        psf.selectOrganizerINNSearh();
        Driver.log.writeLog("Тест прошел успешно");
    }

    /**
     * Номер в ЕИС
     */
    @Test
    public void writeEIS(){
        Driver.log.writeLog("Тестирование поля \"Номер в ЕИС\"");
        Driver.log.writeLog("Ввод \"31705678443\"");
        psf.fillEIS("31705678443");
        Driver.log.writeLog("Тест прошел успешно");
    }

    /**
     * Дата начала торгов/переторжки
     */
    @Test
    public void fillDateStartTrading(){
        Driver.log.writeLog("Тестирование поля \"Дата начала торгов/переторжки\"");
        Driver.log.writeLog("Ввод \"12.12.2009\"");
        Driver.log.writeLog("Ввод \"01.01.2010\"");
        psf.fillDateStartTradingFrom("12.12.2009");
        psf.fillDateStartTradingTo("01.01.2010");
        Driver.log.writeLog("Тест прошел успешно");
    }

    /**
     * Ввод несуществующей даты
     * Должно быть сообщение об ошибке ввода
     */
    @Test
    public void fillNonexistentDateStartTrading(){
        psf.clickCancel();
        Driver.log.writeLog("Тестирование поля \"Дата начала торгов/переторжки\"");
        Driver.log.writeLog("Ввод \"099.99.9999\"");
        psf.fillDateStartTradingFrom("99.99.9999");
        Driver.log.writeLog("Поиск");
        psf.clickSearch();
        Driver.log.writeLog("Ожидание загрузки страницы - 1 секунда");
        Driver.await(1);
        Assert.assertEquals(false, psf.existErroField());
        Driver.log.writeLog("Появление сообщение о неверном заполнении поля");
        Driver.log.writeLog("Тест прошел успешно");
        psf.clickCancel();
    }

    /**
     * Попытка ввода в поле "номер ЕИС" букв
     * Поле Номер в ЕИС должно остаться пустым (длина eis.value == 0
     */
    @Test
    public void writeLetterEIS(){
        psf.clickCancel();
        Driver.log.writeLog("Тестирование поля \"Номер в ЕИС\"");
        Driver.log.writeLog("Ввод \"SolarLab\"");
        psf.fillEIS("SolarLab");
        psf.clickSearch();
        Driver.log.writeLog("Ожидание загрузки таблицы - 1 секунда");
        Driver.await(1);
        Driver.log.writeLog("Проверка поля \"Номер в ЕИС\" на пустоту");
        Assert.assertEquals(false,psf.getValueInFieldEIS().length() != 0);
        Driver.log.writeLog("Поле пустое");
        Driver.log.writeLog("Тест прошел успешно");
        psf.clickCancel();
    }

}
