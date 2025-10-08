package com.zebrunner.carina.demo.gui.pages.desktop;

import com.zebrunner.carina.demo.gui.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy(xpath = "//span[text()='Your Cart']")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//div[div/a/div[text()='%s']]")
    private ExtendedWebElement productCardByName;

    @FindBy(xpath = "//div[div/a/div[text()='%s']]/div/div/button[text()='Remove']")
    private ExtendedWebElement removeBtnByProductName;

    public CartPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(pageTitle);
    }

    public boolean isProductByNamePresent(String productName) {
        productCardByName.format(productName).scrollTo();
        return productCardByName.isPresent();
    }

    public void removeProductByName(String productName) {
        removeBtnByProductName.format(productName).click();
    }


}
