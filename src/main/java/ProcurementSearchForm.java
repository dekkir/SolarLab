import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProcurementSearchForm {

    private WebDriver driver;
    private static String title = "Поиск закупок";

    /**
     * Номер закупки/лота
     */
    @FindBy(id = "BaseMainContent_MainContent_txtNumber_txtText")
    private WebElement lotNumber;

    /**
     *  Наименование объекта закупки
     */
    @FindBy(id = "BaseMainContent_MainContent_txtName_txtText")
    private WebElement nameObject;

    /**
     *  Искать в
     Наименование закупки
     */
    @FindBy(id = "BaseMainContent_MainContent_cbxUseTradeName")
    private WebElement searchInName;


    /**
     *  Способ закупки
     */
    @FindBy(className = ".ui-multiselect.ui-widget.ui-state-default.ui-corner-all.no-overflow.ui-state-hover")
    private WebElement methodPurchase;

    /**
     *  Статус лота
     */
    @FindBy(xpath = ".//*[@id='BaseMainContent_MainContent_ddlTradeLotState_ddlList_chzn']/a")
    private WebElement statLot;

    /**
     *  ОКДП
     */
    @FindBy(id = "BaseMainContent_MainContent_okdpField_btnSelect")
    private WebElement okdp;

    /**
     *  Регион поставки
     */
    @FindBy(xpath = ".//*[@id='BaseMainContent_MainContent_ddlRegion_ddlList_chzn']/a")
    private WebElement region;

    /**
     *  Дата начала торгов/переторжки
     *  от
     */
    @FindBy(id = "BaseMainContent_MainContent_txtPerformingDate_txtDateFrom")
    private WebElement dateStartTradingFrom;

    /**
     *  Дата начала торгов/переторжки
     *  до
     */
    @FindBy(id = "BaseMainContent_MainContent_txtPerformingDate_txtDateTo")
    private WebElement dateStartTradingTo;

    /**
     *  Номер в ЕИС
     */
    @FindBy(id = "BaseMainContent_MainContent_txtOosNumber_txtText")
    private WebElement eis;

    /**
     *  Организатор
     */
    @FindBy(id = "BaseMainContent_MainContent_txtOrgnizer_txtText")
    private WebElement organizer;

    /**
     *  Организатор
     *  искать по ИНН
     */
    @FindBy(id = "BaseMainContent_MainContent_rbUseOrganizerInn")
    private WebElement organizerINNSearch;

    /**
     *  Заказчик
     */
    @FindBy(id = "BaseMainContent_MainContent_txtCustomer_txtText")
    private WebElement customer;

    /**
     *  Заказчик
     *  искать по наименованию
     */
    @FindBy(id = "BaseMainContent_MainContent_rbUseCustomerName")
    private WebElement customerNameSearch;

    /**
     *   Начальная цена
     *   от
     */
    @FindBy(id = "BaseMainContent_MainContent_txtStartPrice_txtRangeFrom")
    private WebElement priceFrom;

    /**
     *   Начальная цена
     *   до
     */
    @FindBy(id = "BaseMainContent_MainContent_txtStartPrice_txtRangeTo")
    private WebElement priceTo;

    /**
     *   Совместные закупки
     */
    @FindBy(id = "BaseMainContent_MainContent_cbxCollectivePurchasing")
    private WebElement joinPurchas;

    /**
     *   Тип закупки:
     *   Коммерческая закупка
     */
    @FindBy(id = "BaseMainContent_MainContent_chkPurchaseType_1")
    private WebElement typePurchaseCommercial;

    /**
     *   Тип закупки:
     *   Закупка малого объема
     */
    @FindBy(id = "BaseMainContent_MainContent_chkPurchaseType_2")
    private WebElement typePurchaseSmall;

    /**
     *   Кнопка Поиск
     */
    @FindBy(id = "BaseMainContent_MainContent_btnSearch")
    private WebElement buttonSearch;

    public ProcurementSearchForm(WebDriver driver){
        if(!driver.getTitle().equals(title)){
            throw new IllegalStateException(
                    "This is not the page you are expected"
            );
        }

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * Заполнение
     * Номер закупки/лота
     */
    public void fillLotNumber(String s){
        lotNumber.sendKeys(s);
    }

    /**
     * Заполнение
     * Наименование объекта закупки
     */
    public void fillNameObject(String s){
        nameObject.sendKeys(s);
    }

    /**
     * Выбор
     * Искать в
     * Наименование закупки
     */
    public void selectNameObject(){
        searchInName.click();
    }

    /**
     * Заполнение
     * Номер в ЕИС
     */
    public void fillEIS(String s){
        eis.sendKeys();
    }

    /**
     * Заполнение
     * Организатор
     */
    public void fillOrganizerName(String s){
        organizer.sendKeys();
    }

    /**
     * Выбор
     * Организатор
     * искать по ИНН
     */
    public void selectOrganizerINNSearh(){
        organizerINNSearch.click();
    }

    /**
     * Заполнение
     * Заказчик
     */
    public void fillСustomerINN(String s){
        customer.sendKeys();
    }

    /**
     * Заполнение
     * Начальная цена
     * от
     */
    public void fillPriceFrom(String s){
        priceFrom.sendKeys();
    }

    /**
     * Заполнение
     * Начальная цена
     * до
     */
    public void fillPriceTo(String s){
        priceTo.sendKeys();
    }

    /**
     * Выбор
     * Совместные закупки
     */
    public void selectjoinPurchas(){
        joinPurchas.click();
    }

    /**
     * Выбор
     * Тип закупки:
     * Коммерческая закупка
     */
    public void selectTypePurchaseCommercial(){
        typePurchaseCommercial.click();
    }

    /**
     * Выбор
     * Тип закупки:
     * Закупка малого объема
     */
    public void selectTypePurchaseSmall(){
        typePurchaseSmall.click();
    }

    /**
     * Выбор
     * ОКДП
     * (только первый уровень)
     */
    public void selectOKDP(int number){
        okdp.click();
        driver.findElement
                (By.cssSelector(
                        "li.ui-jqtreeview-item:nth-last-of-type(" +
                                number +
                                ") input.ui-jqtreeview-item-checkbox")).click();
        driver.findElement(By.xpath("html/body/div[5]/div[3]/div/button[1]")).click();
    }

    /**
     * Выбор
     * Способ закупки
     */
    public void selectMethodPurchase(int number[], int count){
        methodPurchase.click();
        //выбираем столько, сколько count
        for(int i = count; i > 0; i--)
            driver.findElement
                (By.cssSelector(".ui-multiselect-BaseMainContent_" +
                "MainContent_lbxPurchaseMethods-option-" +
                        number[i])).click();
        //убрать выпадающий список после выбора
        driver.findElement(By.cssSelector(".column.left"));
    }

    /**
     * Выбор
     * Статус лота
     */
    public void selectStatLot(int number){
        statLot.click();
        Driver.scroll();
        driver.findElement
                (By.cssSelector("#BaseMainContent_MainContent_" +
                        "ddlTradeLotState_ddlList_chzn_o_" +
                        number)).click();
    }

    /**
     * Выбор
     * Регион поставки
     */
    public void selectRegion(int number){
        region.click();
        Driver.scroll();
        driver.findElement
                (By.cssSelector("#BaseMainContent_MainContent_" +
                        "ddlRegion_ddlList_chzn_o_" + number)).click();
    }



}
