package com.example.jetbrainstest.pages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

import static com.example.jetbrainstest.tests.MyWait.myWait;


public class FleetPage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(FleetPage.class));
    //private final Logger LOG = LoggerFactory.getLogger(FleetPage.class);

    WebDriver driver;

    @FindBy(css = "a[data-test='button' ][href='/fleet/download/']")
    private WebElement downloadButton;

    @FindBy(css = "#sticky_switcher button:nth-child(1)")
    private WebElement smartButton;

    @FindBy(css = "span > button:nth-child(2)")
    private WebElement DistributedButton;

    @FindBy(css = "#sticky_switcher button:nth-child(3)")
    private WebElement collaborativeButton;

    @FindBy(css = "#sticky_switcher button:nth-child(4)")
    private WebElement polyglotButton;

    @FindBy(css = "div.wt-col-auto-fill.wt-col-sm-12.switcher-container__toc > span")
    private WebElement stickySwitcher;

    @FindBy(css = "div:nth-child(4) > span > button")
    private WebElement languageButton;

    @FindBy(xpath = "//span[contains(text(), 'Русский')]")
    private WebElement languageRussian;

    @FindBy(xpath = "//span[contains(text(), 'Français')]")
    private WebElement languageFrancais;

    @FindBy(xpath = "//span[contains(text(), 'Deutsch')]")
    private WebElement languageGerman;

    @FindBy(xpath = "//span[contains(text(), 'Español')]")
    private WebElement languageSpain;

    @FindBy(xpath = "//span[contains(text(), '한국어')]")
    private WebElement languageKorean;

    @FindBy(xpath = "//span[contains(text(), '日本語')]")
    private WebElement languageJapanese;

    @FindBy(xpath = "//span[contains(text(), '简体中文')]")
    private WebElement languageChinese;

    @FindBy(xpath = "//span[contains(text(), 'Português do Brasil')]")
    private WebElement languagePortuguese;

    @FindBy(css = "div.wt-input__wrapper > div > input")
    private WebElement emailInput;

    @FindBy(css = "div.wt-row.wt-row_direction_column.wt-row_size_m > div > button")
    private WebElement submitButton;

    @FindBy(css = " div.wt-input__error-message.wt-text-3.wt-text-3_theme_dark ")
    private WebElement errorMessageAfterSubscription;

    @FindBy(css = ".social-footer p:last-child")
    private WebElement validMessageAfterSubscription;

    @FindBy(xpath = "//button[@data-test='site-header-search-action']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@data-test='search-input']")
    private WebElement searchField;

    @FindBy(css = "li > span")
    private List<WebElement> resultsElement;

    @FindBy(xpath = "//button[contains(text(), 'Developer Tools')]")
    private WebElement headerDevButton;

    @FindBy(xpath = "//button[contains(text(), 'Team Tools')]")
    private WebElement headerTeamButton;

    @FindBy(xpath = "//button[contains(text(), 'Education')]")
    private WebElement headerEducationButton;

    @FindBy(xpath = "//button[contains(text(), 'Solutions')]")
    private WebElement headerSolutionsButton;

    @FindBy(xpath = "//button[contains(text(), 'Support')]")
    private WebElement headerSupportButton;

    @FindBy(xpath = "//button[contains(text(), 'Store')]")
    private WebElement headerStoreButton;


    public Boolean checkIfDownloadButtonIsClickable() {
        LOG.info("Проверка активности кнопки загрузки");
        return downloadButton.isEnabled();
    }

    public FleetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean checkIfDistributedButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки 'Distributed'");
        return DistributedButton.isEnabled();
    }

    public Boolean checkStickySwitchIsVisibility() {
        LOG.info("Липка панель отображается");
        return stickySwitcher.isDisplayed();
    }

    public void clickSmartButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        smartButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(smartButton));
        LOG.info("Клик по кнопке Smart");
    }


    public void clickDistributedButton() {
        DistributedButton.click();
        LOG.info("Клик по кнопке Distributed");
    }

    public void clickCollaborativeButton() {
        collaborativeButton.click();
        LOG.info("Клик по кнопке Collaborative");
    }

    public void clickPolyglotButton() {
        polyglotButton.click();
        LOG.info("Клик по кнопке Polyglot");
    }

    public void switchLanguageTab() {
        languageButton.click();
        LOG.infoWithScreenshot("Нажатие на кнопку смены языка");
    }

    public void languageChangeRussian() {
        languageRussian.click();
        LOG.infoWithScreenshot("В выпадающем списке клик по языку 'Русский'");
    }

    public void languageChangeFrench() {
        languageFrancais.click();
        LOG.infoWithScreenshot("В выпадающем списке клик по языку 'Français' ");
    }

    public void languageChangeGerman() {
        languageGerman.click();
        LOG.infoWithScreenshot("В выпадающем списке клик по языку 'Deutsch' ");
    }

    public void languageChangeSpain() {
        languageSpain.click();
        LOG.infoWithScreenshot("В выпадающем списке клик по языку 'Español' ");
    }

    public void languageChangeKorean() {
        languageKorean.click();
        LOG.infoWithScreenshot("В выпадающем списке клик по языку '한국어' ");
    }

    public void languageChangeJapanese() {
        languageJapanese.click();
        LOG.infoWithScreenshot("В выпадающем списке клик по языку '日本語' ");
    }

    public void languageChangeChinese() {
        languageChinese.click();
        LOG.infoWithScreenshot("В выпадающем списке клик по языку '简体中文' ");
    }

    public void languageChangePortuguese() {
        languagePortuguese.click();
        LOG.infoWithScreenshot("В выпадающем списке клик по языку 'Português do Brasil' ");
    }

    public void inputEmail(String email) {
        LOG.info("Ввод email");
        emailInput.sendKeys(email);
        submitButton.click();
    }

    public String inputInvalidEmail(String email){
        inputEmail(email);
        LOG.info("Получение сообщения при вводе невалидного email");
        return errorMessageAfterSubscription.getText();
    }

    public boolean validTextAfterSub() {
        LOG.infoWithScreenshot("Появление текста после валидного ввода email");
        myWait(5).visible(validMessageAfterSubscription);
        return validMessageAfterSubscription.isDisplayed();
    }

    public void searchButtonClick() {
        LOG.info("Нажатие на кнопку посика");
        searchButton.click();
    }

    public void searchButtonInput(String inputText) {
        LOG.info("Ввод текста");
        searchField.sendKeys(inputText);
    }

    public void searchElements() {
        resultsElement.get(0).click();
        LOG.info("Нажатие на результат в списке");
    }

    public Boolean checkDevtoolsButton() {
        LOG.info("Проверка активности кнопки Developer Tools");
        return headerDevButton.isDisplayed();
    }

    public Boolean checkTeamToolsButton() {
        LOG.info("Проверка активности кнопки Team Tools");
        return headerTeamButton.isDisplayed();
    }

    public Boolean checkEducationButton() {
        LOG.info("Проверка активности кнопки Education");
        return headerEducationButton.isDisplayed();
    }

    public Boolean checkSolutionsButton() {
        LOG.info("Проверка активности кнопки Solutions");
        return headerSolutionsButton.isDisplayed();
    }

    public Boolean checkSupportButton() {
        LOG.info("Проверка активности кнопки Support");
        return headerSupportButton.isDisplayed();
    }

    public Boolean checkStoreButton() {
        LOG.info("Проверка активности кнопки Store");
        return headerStoreButton.isDisplayed();
    }
}




