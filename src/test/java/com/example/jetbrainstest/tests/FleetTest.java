package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.AllureAttachmentsManager;
import com.example.jetbrainstest.MyExtension;
import com.example.jetbrainstest.pages.FleetPage;
import com.example.jetbrainstest.pages.PyCharmPage;
import io.qameta.allure.Step;
import org.checkerframework.checker.units.qual.Time;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(MyExtension.class)

public class FleetTest extends BaseTest {

    private FleetPage FleetPage;

    @BeforeEach
    @Override
    @Step("Переход в раздел Fleet")
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
    @DisplayName("Проверка смены языка на Русский")
    public void changeLanguageCheck() {
        FleetPage.switchLanguageTab();
        AllureAttachmentsManager.screenshot();
        FleetPage.languageChange();
        AllureAttachmentsManager.screenshot();
        assertEquals("https://www.jetbrains.com/ru-ru/fleet/", getDriver().getCurrentUrl(),"Открыта не верная страница");
    }
}