package com.example.jetbrainstest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

//url = https://www.jetbrains.com/all/
public class AllProductsPage {
    WebDriver driver;

    @FindBy(css = "a[data-test='button' ][href ='/idea/buy/']")
    private WebElement downloadButton;

    @FindBy(css="#js-menu-second-desktop > a")
    private WebElement buyButton;

    public AllProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public Boolean checkIfDownloadButtonIsClickable(){
        System.out.println("Проверка активности кнопки загрузки");
        return downloadButton.isEnabled();
    }
    public Boolean checkIfBuyButtonEnabled(){
        System.out.println("Проверка наличия кнопки Buy");
        return buyButton.isEnabled();
    }

    public void buyButtonClick(){
        System.out.println("Нажатие на кнопку Buy");
        buyButton.click();
    }

    public void switchToStoreTab(int num){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(num-1));
        System.out.println("Перешли на вкладку №" + (num));
    }


}
