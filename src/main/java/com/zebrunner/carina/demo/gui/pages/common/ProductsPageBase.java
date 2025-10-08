package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductsPageBase extends AbstractPage {

    public ProductsPageBase(WebDriver driver) {
        super(driver);
        this.setPageURL("inventory.html");
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);
    }

    public abstract boolean isProductByNamePresent(String productName);

    public abstract void addProductToCart(String productName);

    public abstract CartPageBase openCart();
}
