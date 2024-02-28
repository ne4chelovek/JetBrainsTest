package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.MyExtension;
import com.example.jetbrainstest.pages.FleetPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MyExtension.class)
public class FleetTest extends BaseTest {

    private FleetPage FleetPage;
    final String url = "https://www.jetbrains.com/";

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/fleet/");
        FleetPage = new FleetPage(getDriver());
    }

    @Test
    @DisplayName("Проверка, что кнопка скачивания активна")
    public void buttonCheck() {
        assertTrue(FleetPage.checkIfDownloadButtonIsClickable(), "Кнопка скачивания не активна");
    }

    @Test
    @DisplayName("Проверка, что кнопка 'Distributed' активна")
    public void checkIfDistributedButtonIsClickable() {
        assertTrue(FleetPage.checkIfDistributedButtonIsClickable(), "Кнопка 'Distributed' не активна");
    }

    @Test
    @DisplayName("Проверка, что липкая панель отображается при клике на кнопку 'Smart'")
    public void checkVisibilityAfterClickSmart() {
        FleetPage.clickSmartButton();
        assertTrue(FleetPage.checkStickySwitchIsVisibility(), "Панель не отображается");
    }

    @Test
    @DisplayName("Проверка, что липкая панель отображается при клике на кнопку 'Distributed'")
    public void checkVisibilityAfterClickDistributed() {
        FleetPage.clickDistributedButton();
        assertTrue(FleetPage.checkStickySwitchIsVisibility(), "Панель не отображается");
    }

    @Test
    @DisplayName("Проверка, что липкая панель отображается при клике на кнопку 'Collaborative'")
    public void checkVisibilityAfterClickCollaborative() {
        FleetPage.clickCollaborativeButton();
        assertTrue(FleetPage.checkStickySwitchIsVisibility(), "Панель не отображается");
    }

    @Test
    @DisplayName("Проверка, что липкая панель отображается при клике на кнопку 'Polyglot'")
    public void checkVisibilityAfterClickPolyglot() {
        FleetPage.clickPolyglotButton();
        assertTrue(FleetPage.checkStickySwitchIsVisibility(), "Панель не отображается");
    }

    @Test
    @DisplayName("Проверка смены языка на 'Русский'")
    public void changeLanguageRussian() {
        FleetPage.switchLanguageTab();
        FleetPage.languageChangeRussian();
        assertEquals(url + "ru-ru/fleet/", getDriver().getCurrentUrl(), "Открыта не верная страница");
    }

    @Test
    @DisplayName("Проверка смены языка на 'Français'")
    public void changeLanguageFrench() {
        FleetPage.switchLanguageTab();
        FleetPage.languageChangeFrench();
        assertEquals(url + "fr-fr/fleet/", getDriver().getCurrentUrl(), "Открыта не верная страница");
    }

    @Test
    @DisplayName("Проверка смены языка на 'Deutsch'")
    public void changeLanguageGerman() {
        FleetPage.switchLanguageTab();
        FleetPage.languageChangeGerman();
        assertEquals(url + "de-de/fleet/", getDriver().getCurrentUrl(), "Открыта не верная страница");
    }

    @Test
    @DisplayName("Проверка смены языка на 'Español'")
    public void changeLanguageSpain() {
        FleetPage.switchLanguageTab();
        FleetPage.languageChangeSpain();
        assertEquals(url + "es-es/fleet/", getDriver().getCurrentUrl(), "Открыта не верная страница");
    }

    @Test
    @DisplayName("Проверка смены языка на '한국어'")
    public void changeLanguageKorean() {
        FleetPage.switchLanguageTab();
        FleetPage.languageChangeKorean();
        assertEquals(url + "ko-kr/fleet/", getDriver().getCurrentUrl(), "Открыта не верная страница");
    }

    @Test
    @DisplayName("Проверка смены языка на '日本語'")
    public void changeLanguageJapanese() {
        FleetPage.switchLanguageTab();
        FleetPage.languageChangeJapanese();
        assertEquals(url + "ja-jp/fleet/", getDriver().getCurrentUrl(), "Открыта не верная страница");
    }

    @Test
    @DisplayName("Проверка смены языка на '简体中文'")
    public void changeLanguageChinese() {
        FleetPage.switchLanguageTab();
        FleetPage.languageChangeChinese();
        assertEquals(url + "zh-cn/fleet/", getDriver().getCurrentUrl(), "Открыта не верная страница");
    }

    @Test
    @DisplayName("Проверка смены языка на 'Português do Brasil'")
    public void changeLanguagePortuguese() {
        FleetPage.switchLanguageTab();
        FleetPage.languageChangePortuguese();
        assertEquals(url + "pt-br/fleet/", getDriver().getCurrentUrl(), "Открыта не верная страница");
    }

    @Test
    @DisplayName("Отправка email для подписки на новости")
    @Timeout(10)
    public void subValidEmailFleetNews() {
        String email = "nesari3007@wlmycn.com";
        FleetPage.inputEmail(email);
        assertTrue(FleetPage.validTextAfterSub(), "Текст не появился");
    }

    @ParameterizedTest(name = "#{index} - проверка ввода невалидных значений email {0}")
    @CsvSource({".com3432","0@7@wlm@","s123ad" })
    @DisplayName("Отправка невалидного значения для подписки на новости")
    public void subInvalidEmailNews(String email) {
        String warnMessage = FleetPage.inputInvalidEmail(email);
        assertEquals(warnMessage, "Please enter a valid email address.", "Текст сообщения некорректен");
    }

    @Test
    @DisplayName("Проверка результатов выдачи")
    public void searchFleetPage() {
        FleetPage.searchButtonClick();
        String inputText = "Fleet";
        FleetPage.searchButtonInput(inputText);
        FleetPage.searchElements();
        assertEquals(url + "fleet/", getDriver().getCurrentUrl(), "Открыта не верная ссылка");
    }

    @Test
    @DisplayName("Проверка, что кнопка Developer Tools активна")
    public void buttonDevToolsCheck() {
        assertTrue(FleetPage.checkDevtoolsButton(), "Кнопка Developer Tools не активна");
    }

    @Test
    @DisplayName("Проверка, что кнопка Team Tools активна")
    public void buttonTeamToolsCheck() {
        assertTrue(FleetPage.checkTeamToolsButton(), "Кнопка Team Tools не активна");
    }

    @Test
    @DisplayName("Проверка, что кнопка Team Tools активна")
    public void buttonEducationCheck() {
        assertTrue(FleetPage.checkEducationButton(), "Кнопка Education не активна");
    }

    @Test
    @DisplayName("Проверка, что кнопка Solutions активна")
    public void buttonSolutionsCheck() {
        assertTrue(FleetPage.checkSolutionsButton(), "Кнопка Solutions не активна");
    }

    @Test
    @DisplayName("Проверка, что кнопка Support активна")
    public void buttonSupportCheck() {
        assertTrue(FleetPage.checkSupportButton(), "Кнопка  Support не активна");
    }

    @Test
    @DisplayName("Проверка, что кнопка Store активна")
    public void buttonStoreCheck() {
        assertTrue(FleetPage.checkStoreButton(), "Кнопка  Store не активна");
    }
}