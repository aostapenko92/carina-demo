package com.zebrunner.carina.demo.gui.pages.desktop;

import com.zebrunner.carina.demo.gui.pages.common.CartPageBase;
import com.zebrunner.carina.demo.gui.pages.common.ProductsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductsPageBase.class)
public class ProductsPage extends ProductsPageBase {

    @FindBy(xpath = "//div[@class='app_logo']")
    private ExtendedWebElement swagLabsLogo;

    @FindBy(xpath = "//div[div/a/div[text()='%s']]/div[@class = 'pricebar']/button[text()='Add to cart']")
    private ExtendedWebElement addToCartButtonByProductName;

    @FindBy(xpath = "//div[div/a/div[text()='%s']]")
    private ExtendedWebElement productCardByName;

    public ProductsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(swagLabsLogo);
    }

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private ExtendedWebElement cartButton;

    @Override
    public boolean isProductByNamePresent(String productName){
        productCardByName.format(productName).scrollTo();
        return productCardByName.isPresent();
    }

    @Override
    public void addProductToCart(String productName){
        addToCartButtonByProductName.format(productName).click();
    }

    @Override
    public CartPageBase openCart() {
        cartButton.click();
        return initPage(getDriver(), CartPageBase.class);
    }

}
