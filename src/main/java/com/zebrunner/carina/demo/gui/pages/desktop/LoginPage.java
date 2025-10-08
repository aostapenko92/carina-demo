package com.zebrunner.carina.demo.gui.pages.desktop;

import com.zebrunner.carina.demo.gui.entities.User;
import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.gui.pages.common.ProductsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(id = "user-name")
    private ExtendedWebElement usernameField;

    @FindBy(id = "password")
    private ExtendedWebElement passField;

    @FindBy(id = "login-button")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeUsername(String text) {
        usernameField.type(text);
    }

    @Override
    public void typePass(String text) {
        passField.type(text);
    }

    @Override
    public void clickOnLoginButton() {
        loginButton.click();
    }

    @Override
    public ProductsPageBase login(User user) {
        typeUsername(user.getUsername());
        typePass(user.getPass());
        clickOnLoginButton();
        return initPage(getDriver(), ProductsPageBase.class);
    }


}
