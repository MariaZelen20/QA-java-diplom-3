package com;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {

    public static final String REGISTER_URL = "https://stellarburgers.nomoreparties.site/register";

    @FindBy(how = How.XPATH,using = "(.//input[@class=\"text input__textfield text_type_main-default\"])[1]")
    private SelenideElement nameField;

    @FindBy(how = How.XPATH,using = "(.//input[@class=\"text input__textfield text_type_main-default\"])[2]")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH,using = ".//input[@class=\"text input__textfield text_type_main-default\"][@type=\"password\"]")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH,using = ".//button[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH,using = ".//p[@class=\"input__error text_type_main-default\"]")
    private SelenideElement invalidPasswordMessage;

    @FindBy(how = How.CLASS_NAME,using = "Auth_link__1fOlj")
    private SelenideElement logInButton;

    public void setName(String name){
        nameField.setValue(name);
    }

    public void setEmailField(String email){
        emailField.setValue(email);
    }

    public void setPassword(String pass){
        passwordField.setValue(pass);
    }

    public void registerButtonClick(){
        registerButton.scrollTo().click();
    }

    public boolean invalidPasswordMessageIsVisible(){
        return invalidPasswordMessage.shouldBe(Condition.visible).isDisplayed();
    }

    public void logInButtonClick(){
        logInButton.click();
    }
}
