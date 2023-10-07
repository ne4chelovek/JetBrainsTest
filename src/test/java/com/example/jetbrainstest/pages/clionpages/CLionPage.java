package com.example.jetbrainstest.pages.clionpages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import java.util.List;

//page url = https://www.jetbrains.com/clion/
public class CLionPage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(CLionPage.class));
    private final WebDriver driver;

    @FindBy(css = "a[href=\"/clion/download/\"]")
    private WebElement downloadButton;

    @FindBy(css = "a[href=\"/clion/whatsnew/\"]")
    private WebElement whatIsNewButton;

    @FindBy(css = "button[data-test=\"youtube-player-button\"]")
    private WebElement imgVideoButton;

    @FindBy(css = "iframe[title=\"CLion Quick Tour\"]")
    private WebElement videoIframe;

    @FindBy(css = "#player a[href^=\"https://www.youtube.com/watch\"]")
    private WebElement videoTitle;

    @FindBy(css = ".social-footer__link")
    private List<WebElement> followButtons;

    @FindBy(css = "[name='Email']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[contains(text(), 'Submit')]")
    private  WebElement emailSubmit;

    @FindBy(css = ".social-footer p:last-child")
    private WebElement messageAfterEnteringValidEmail;

    @FindBy(css = "[data-test=\"error-message\"]")
    private WebElement messageAfterEnteringInvalidEmail;

    @FindBy(css = "[data-test='language-picker']")
    private WebElement languageButton;

    @FindBy(css = "div > span[data-test=\"list-item\"] > span")
    private List<WebElement> listOfLanguages;

    @FindBy(css = "h2 + div img[alt=\"Code Analysis screenshot\"]")
    private List<WebElement> ScreenshotsInCodeAnalysisSection;

    public CLionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Integer getCountOfScreenshotsInCodeAnalysisSection() {
        return ScreenshotsInCodeAnalysisSection.size();
    }

    public Boolean checkIfDownloadButtonIsClickable() {
        LOG.info("Проверка активности кнопки загрузки");
        return downloadButton.isEnabled();
    }

    public void clickDownloadButton() {
        LOG.info("Переход на страницу загрузки");
        downloadButton.click();
    }

    public Boolean checkIfwhatIsNewButtonClickable() {
        LOG.info("Проверка активности кнопки 'what's new'");
        return whatIsNewButton.isEnabled();
    }

    public void switchOnIframe() {
        LOG.info("Переключение на frame с видео");
        imgVideoButton.click();
        driver.switchTo().frame(videoIframe);
    }

    public String getNameOfVideo() {
        switchOnIframe();
        LOG.infoWithScreenshot("Получение названия видео");
        return videoTitle.getText();
    }

    public Boolean checkIfFollowButtonsAreClickable(int num) {
        LOG.info("Получение активности кнопки из блока Follow Us");
        return followButtons.get(num).isEnabled();
    }

    public void enterEmail(String email) {
        LOG.info("Ввода email");
        emailInput.sendKeys(email);
        emailSubmit.click();
    }

    public String getAnswerAfterEnteringValidEmail(String email) {
        enterEmail(email);
        LOG.info("Получение сообщения при вводе валидного email");
        return messageAfterEnteringValidEmail.getText();
    }

    public String getWarningAfterEnteringInvalidEmail(String email) {
        enterEmail(email);
        LOG.info("Получение сообщения при вводе невалидного email");
        return messageAfterEnteringInvalidEmail.getText();
    }

    public void changeLanguage(String language) {
        languageButton.click();
        LOG.infoWithScreenshot("Смена языка страницы на указанный");
        for (WebElement i: listOfLanguages) {
            if (i.getText().equals(language)) {
                i.click();
                break;
            }
        }
    }
}
