import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static java.lang.Integer.parseInt;

/**
 * Реализует форму, подлежащую тестированию
 * Используется ObjectPage на снове PageFactory
 */
class PurchaseSearchForm {
    private String title = "Поиск закупок";
    private WebDriver driver;

    /**
     * Номер закупки/лота
     */
    @FindBy(id = "BaseMainContent_MainContent_txtNumber_txtText")
    private WebElement lotNumber = null;

    /**
     *  Наименование объекта закупки
     */
    @FindBy(id = "BaseMainContent_MainContent_txtName_txtText")
    private WebElement nameObject = null;

    /**
     *  Искать в
     Наименование закупки
     */
    @FindBy(id = "BaseMainContent_MainContent_cbxUseTradeName")
    private WebElement searchInName = null;


    /**
     *  Способ закупки
     */
    @FindBy(xpath = ".//*[@id='BaseMainContent_MainContent_upFilter']//button")
    private WebElement methodPurchase = null;

    /**
     *  Статус лота
     */
    @FindBy(xpath = ".//*[@id='BaseMainContent_MainContent_ddlTradeLotState_ddlList_chzn']/a")
    private WebElement statLot = null;

    /**
     *  ОКДП
     */
    @FindBy(id = "BaseMainContent_MainContent_okdpField_btnSelect")
    private WebElement okdp = null;

    /**
     *  Регион поставки
     */
    @FindBy(xpath = ".//*[@id='BaseMainContent_MainContent_ddlRegion_ddlList_chzn']/a")
    private WebElement region = null;

    /**
     *  Дата начала торгов/переторжки
     *  от
     */
    @FindBy(id = "BaseMainContent_MainContent_txtPerformingDate_txtDateFrom")
    private WebElement dateStartTradingFrom = null;

    /**
     *  Дата начала торгов/переторжки
     *  до
     */
    @FindBy(id = "BaseMainContent_MainContent_txtPerformingDate_txtDateTo")
    private WebElement dateStartTradingTo = null;

    /**
     *  Номер в ЕИС
     */
    @FindBy(id = "BaseMainContent_MainContent_txtOosNumber_txtText")
    private WebElement eis = null;

    /**
     *  Организатор
     */
    @FindBy(id = "BaseMainContent_MainContent_txtOrgnizer_txtText")
    private WebElement organizer = null;

    /**
     *  Организатор
     *  искать по ИНН
     */
    @FindBy(id = "BaseMainContent_MainContent_rbUseOrganizerInn")
    private WebElement organizerINNSearch = null;

    /**
     *  Заказчик
     */
    @FindBy(id = "BaseMainContent_MainContent_txtCustomer_txtText")
    private WebElement customer = null;

    /**
     *   Начальная цена
     *   от
     */
    @FindBy(id = "BaseMainContent_MainContent_txtStartPrice_txtRangeFrom")
    private WebElement priceFrom = null;

    /**
     *   Начальная цена
     *   до
     */
    @FindBy(id = "BaseMainContent_MainContent_txtStartPrice_txtRangeTo")
    private WebElement priceTo = null;

    /**
     *   Совместные закупки
     */
    @FindBy(id = "BaseMainContent_MainContent_cbxCollectivePurchasing")
    private WebElement joinPurchas = null;

    /**
     *   Тип закупки:
     *   Коммерческая закупка
     */
    @FindBy(id = "BaseMainContent_MainContent_chkPurchaseType_1")
    private WebElement typePurchaseCommercial = null;

    /**
     *   Тип закупки:
     *   Закупка малого объема
     */
    @FindBy(id = "BaseMainContent_MainContent_chkPurchaseType_2")
    private WebElement typePurchaseSmall = null;

    /**
     *   Кнопка Поиск
     */
    @FindBy(id = "BaseMainContent_MainContent_btnSearch")
    private WebElement buttonSearch = null;

    /**
     *   Кнопка Очистить
     */
    @FindBy(id = "BaseMainContent_MainContent_btnCancel")
    private WebElement buttonCancel = null;


    /**
     *   Полоса "неверное заданное поле"
     */
    @FindBy(id = "BaseMainContent_MainContent_vsFilter")
    private WebElement errorField = null;

    /**
     *   Количество результатов - строк в таблице
     */
    @FindBy(xpath = ".//*[@id='BaseMainContent_MainContent_jqgTrade_toppager_right']/div")
    private WebElement countRez = null;

    PurchaseSearchForm(WebDriver driver){

        if(!driver.getTitle().equals(title)){
             Driver.log.writeLog("Вы находитесь на другой стрианице");
             Driver.log.writeLog("Выполнение тестов невозможно");
             Driver.log.finishLog();
        }
        PageFactory.initElements(driver, this);
        this.driver = driver;
        Driver.log.writeLog("Объект успешно создан");
    }

    /**
     * Заполнение
     * @param s Номер закупки/лота
     */
    void fillLotNumber(String s){
        lotNumber.sendKeys(s);
    }

    /**
     * Заполнение
     * @param s Наименование объекта закупки
     */
    void fillNameObject(String s){
        nameObject.sendKeys(s);
    }

    /**
     * Выбор
     * Искать в
     * Наименование закупки
     * (по умолчанию галочка уже стоит, поэтому not)
     */
    void notSelectNameObject(){
        searchInName.click();
    }

    /**
     * Заполнение
     * @param s Номер в ЕИС
     */
    void fillEIS(String s){
        eis.sendKeys(s);
    }

    /**
     * Заполнение
     * @param s Организатор
     */
    void fillOrganizerName(String s){
        organizer.sendKeys(s);
    }

    /**
     * Выбор
     * Организатор
     * искать по ИНН
     */
    void selectOrganizerINNSearh(){
        organizerINNSearch.click();
    }

    /**
     * Заполнение
     * @param s Заказчик
     */
    void fillСustomer(String s){
        customer.sendKeys(s);
    }

    /**
     * Заполнение
     * Начальная цена
     * @param s от
     */
    void fillPriceFrom(String s){
        priceFrom.sendKeys(s);
    }

    /**
     * Заполнение
     * Начальная цена
     * @param s до
     */
    void fillPriceTo(String s){
        priceTo.sendKeys(s);
    }

    /**
     * Выбор
     * Совместные закупки
     */
    void selectJoinPurchas(){
        joinPurchas.click();
    }

    /**
     * Выбор
     * Тип закупки:
     * Коммерческая закупка
     */
    void selectTypePurchaseCommercial(){
        typePurchaseCommercial.click();
    }

    /**
     * Выбор
     * Тип закупки:
     * Закупка малого объема
     */
    void selectTypePurchaseSmall(){
        typePurchaseSmall.click();
    }

    /**
     * Выбор
     * @param number ОКДП (только первый уровень)
     *
     */
    void selectOKDP(int number[]){
        okdp.click();
        for (int aNumber : number)
            driver.findElement
                    (By.cssSelector(
                            "li.ui-jqtreeview-item:nth-last-of-type(" +
                                    aNumber +
                                    ") input.ui-jqtreeview-item-checkbox")).click();
        //плохой селектор
        driver.findElement(By.xpath("html/body/div[5]/div[3]/div/button[1]")).click();
    }

    /**
     * Выбор
     * @param number Способы закупки (номера в списке)
     */
    void selectMethodPurchase(int number[]){
        methodPurchase.click();
        for (int aNumber : number)
            driver.findElement
                    (By.cssSelector("#ui-multiselect-BaseMainContent_" +
                            "MainContent_lbxPurchaseMethods-option-" +
                            aNumber)).click();
        //убрать выпадающий список после выбора
        driver.findElement(By.cssSelector(".column.left")).click();
    }

    /**
     * Выбор
     * @param number Статус лота
     */
    void selectStatLot(int number){
        statLot.click();
        Driver.scroll();
        driver.findElement
                (By.cssSelector("#BaseMainContent_MainContent_" +
                        "ddlTradeLotState_ddlList_chzn_o_" +
                        number)).click();
    }

    /**
     * Выбор
     * @param number Регион поставки (номер в списке)
     */
    void selectRegion(int number){
        region.click();
        Driver.scroll();
        driver.findElement
                (By.cssSelector("#BaseMainContent_MainContent_" +
                        "ddlRegion_ddlList_chzn_o_" + number)).click();
    }

    /**
     * Дата начала торгов/переторжки
     * @param s от
     */
    void fillDateStartTradingFrom(String s){
        dateStartTradingFrom.sendKeys(s);
    }

    /**
     * Дата начала торгов/переторжки
     * @param s до
     */
    void fillDateStartTradingTo(String s){
        dateStartTradingTo.sendKeys(s);
    }

    /**
     * Поиск по выбранным параметрам
     */
    void clickSearch(){
        buttonSearch.click();
    }

    /**
     * Очистить форму
     */
    void clickCancel(){
        buttonCancel.click();
    }

    /**
     *   Поиск сообщения "неверное заполненное поле"
     */
    boolean existErroField(){
        try{
            driver.findElement(By.id(String.valueOf(errorField)));
        } catch (org.openqa.selenium.NoSuchElementException ex){
            return false;
        }
        return true;
    }

    /**
     * Извлекает значение поля Номер в ЕИС
     * @return значение поля Номер в ЕИС
     */
    String getValueInFieldEIS(){
        return  eis.getAttribute("value");
    }

    /**
     *   Извлекает из div'a строку вида "Просмотр 1 - 10 из 120 795"
     * @return число записсей в таблице в формате 120795
     */
    int countTRinTable(){
        String temp = countRez.getText();
        if(temp.contains("Нет")) return 0;
        temp = temp.replaceAll(" ", "");
        temp = temp.substring(temp.indexOf("из")+2);
        return parseInt(temp);
    }

}
