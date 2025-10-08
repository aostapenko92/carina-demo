
package com.zebrunner.carina.demo;

import com.zebrunner.carina.demo.gui.entities.User;
import com.zebrunner.carina.demo.gui.pages.common.CartPageBase;
import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.gui.pages.common.ProductsPageBase;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

public class SauceDemoTest implements IAbstractTest {

    private User user = new User(R.TESTDATA.get("login"), R.TESTDATA.get("pass"));
    private final String TEST_PRODUCT_NAME = "Sauce Labs Backpack";

    @Test()
    @MethodOwner(owner = "aostapenko")
    @TestLabel(name = "feature", value = {"web"})
    public void sauceDemoLoginTest() {
        ProductsPageBase productsPage = login(user);
        Assert.assertTrue(productsPage.isPageOpened(), "Product page is not opened");
    }

    @Test()
    @MethodOwner(owner = "aostapenko")
    @TestLabel(name = "feature", value = {"web"})
    public void sauceDemoCartTest() {
        ProductsPageBase productsPage = login(user);
        Assert.assertTrue(productsPage.isPageOpened(), "Product page is not opened");
        Assert.assertTrue(productsPage.isProductByNamePresent(TEST_PRODUCT_NAME), TEST_PRODUCT_NAME + " product is not present on Product page");
        productsPage.addProductToCart(TEST_PRODUCT_NAME);
        CartPageBase cartPage = productsPage.openCart();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened");
        Assert.assertTrue(cartPage.isProductByNamePresent(TEST_PRODUCT_NAME), TEST_PRODUCT_NAME + " product is not present on Card page");
        cartPage.removeProductByName(TEST_PRODUCT_NAME);
        Assert.assertFalse(cartPage.isProductByNamePresent(TEST_PRODUCT_NAME), TEST_PRODUCT_NAME + " product present on Card page");
    }

    private ProductsPageBase login(User user) {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        return loginPage.login(user);
    }

}
