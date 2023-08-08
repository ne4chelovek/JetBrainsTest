package com.example.jetbrainstest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FleetPage {

  private final Logger LOG = LoggerFactory.getLogger(FleetPage.class);

    WebDriver driver;

    @FindBy(css = "a[data-test='button' ][href='/fleet/download/']")
    private WebElement downloadButton;

    public Boolean checkIfDownloadButtonIsClickable() {
        LOG.info("Проверка активности кнопки загрузки");
        return downloadButton.isEnabled();
    }

    public FleetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css ="span > button:nth-child(2)")
    private WebElement DistributedButton;

        public Boolean checkIfDistributedButtonIsClickable () {
            LOG.info("Проверка кликабельности кнопки 'Distributed'");
            return DistributedButton.isEnabled();
        }
    }
