import com.*;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class AuthorizationTest {
    @Before
    public void setUp() {
        open("https://stellarburgers.nomoreparties.site/login");
    }

    @AfterClass
    public static void quitBrouser() {
        WebDriverRunner.getWebDriver().quit();
    }
    @After
    public void tearDown() throws InterruptedException {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.personalAreaClick();
        AccountPage accountPage = open(AccountPage.PROFILE_URL, AccountPage.class);
        accountPage.exitButtonClick();
        sleep(80);
    }

    @DisplayName("Авторизация пользователя по кнопке Личный кабинет")
    @Description("Авторизация пользователя.Позитивная проверка")
    @Step("Проверка авторизации существующего пользователя по кнопке Личный кабинет")
    @Test
    public void logInWithPersonalAreaButtonTest() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.personalAreaClick();
        AuthorizationPage authorizationPage = open(AuthorizationPage.LOGIN_PAGE, AuthorizationPage.class);
        authorizationPage.setEmail("MariaZel@yandex.ru");
        authorizationPage.setPassword("Mari123321");
        authorizationPage.logInButtonClick();
        assertTrue(mainPage.isMakeOrderButtonDispayed());
        mainPage.modalWindowExitButtonClick();
    }

    @DisplayName("Авторизация пользователя по кнопке Войти в аккаунт на главной странице")
    @Description("Авторизация пользователя.Позитивная проверка")
    @Step("Проверка авторизации существующего пользователя по кнопке Войти в аккаунт")
    @Test
    public void logInWithMainPageSignInButtonTest() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.logInButtonClick();
        AuthorizationPage authorizationPage = open(AuthorizationPage.LOGIN_PAGE, AuthorizationPage.class);
        authorizationPage.setEmail("MariaZel@yandex.ru");
        authorizationPage.setPassword("Mari123321");
        authorizationPage.logInButtonClick();
        assertTrue(mainPage.isMakeOrderButtonDispayed());
        mainPage.modalWindowExitButtonClick();
    }

    @DisplayName("Авторизация пользователя по кнопке Войти на странице регистрации")
    @Description("Авторизация пользователя.Позитивная проверка")
    @Step("Проверка авторизации существующего пользователя по кнопке Войти на странице регистрации")
    @Test
    public void logInWithButtonInRegistrationPage(){
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        RegistrationPage registerPage = open(RegistrationPage.REGISTER_URL,RegistrationPage.class);
        registerPage.logInButtonClick();
        AuthorizationPage authorizationPage = open(AuthorizationPage.LOGIN_PAGE, AuthorizationPage.class);
        authorizationPage.setEmail("MariaZel@yandex.ru");
        authorizationPage.setPassword("Mari123321");
        authorizationPage.logInButtonClick();
        assertTrue(mainPage.isMakeOrderButtonDispayed());
        mainPage.modalWindowExitButtonClick();
    }

    @DisplayName("Авторизация пользователя по кнопке Войти на странице восстановления пароля")
    @Description("Авторизация пользователя.Позитивная проверка")
    @Step("Проверка авторизации существующего пользователя по кнопке Войти на странице восстановления пароля")
    @Test
    public void logInWithRestorePasswordPageTest(){
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        RestorePasswordPage restorePasswordPage = open(RestorePasswordPage.URL, RestorePasswordPage.class);
        restorePasswordPage.logInButtonClick();
        AuthorizationPage authorizationPage = open(AuthorizationPage.LOGIN_PAGE, AuthorizationPage.class);
        authorizationPage.setEmail("MariaZel@yandex.ru");
        authorizationPage.setPassword("Mari123321");
        authorizationPage.logInButtonClick();
        assertTrue(mainPage.isMakeOrderButtonDispayed());
        mainPage.modalWindowExitButtonClick();
    }
}
