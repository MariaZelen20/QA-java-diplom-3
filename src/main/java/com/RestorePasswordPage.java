package com;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RestorePasswordPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(how = How.CLASS_NAME,using = "Auth_link__1fOlj")
    private SelenideElement logInButton;

    public void logInButtonClick(){
        logInButton.click();
    }
}
