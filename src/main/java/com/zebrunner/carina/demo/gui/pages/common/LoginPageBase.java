package com.zebrunner.carina.demo.gui.pages.common;

import com.zebrunner.carina.demo.gui.entities.User;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    public abstract void typeUsername(String text);

    public abstract void typePass(String text);

    public abstract void clickOnLoginButton();

    public abstract ProductsPageBase login(User user);
}
