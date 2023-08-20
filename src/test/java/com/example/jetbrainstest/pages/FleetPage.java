package com.example.jetbrainstest.pages;

import com.example.jetbrainstest.AllureLogger;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FleetPage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(FleetPage.class));
    //private final Logger LOG = LoggerFactory.getLogger(FleetPage.class);

    WebDriver driver;

    @FindBy(css = "a[data-test='button' ][href='/fleet/download/']")
    private WebElement downloadButton;

    @FindBy(css = "span > button:nth-child(2)")
    private WebElement DistributedButton;

    @FindBy(css = "div:nth-child(4) > span > button")
    private WebElement languageButton;

    @FindBy(xpath ="//span[contains(text(), 'Русский')]")
    private WebElement languageTab;

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

    public void switchLanguageTab() {
        languageButton.click();
        LOG.info("Нажатие на кнопку смены языка");
    }

    public void languageChange(){
        languageTab.click();
       LOG.info("В выпадающем списке клик по языку Русский");
    }
}




