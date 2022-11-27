import com.AuthorizationPage;
import com.CreateUser;
import com.MainPage;
import com.RegistrationPage;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {

    @Before
    public void setUp() {
        open("https://stellarburgers.nomoreparties.site/register");
    }

    @AfterClass
    public static void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }

    @DisplayName("Регистрация пользователя с валидными значения")
    @Description("Регистрация пользователя.Позитивная проверка")
    @Step("Проверка регистрации пользователя с валидными значениями")
    @Test
    public void registrationTest(){
        MainPage mainPage = open(MainPage.BASE_URL,MainPage.class);
        mainPage.personalAreaClick();
        AuthorizationPage authorizationPage = open(AuthorizationPage.LOGIN_PAGE, AuthorizationPage.class);
        authorizationPage.registerButtonClick();
        RegistrationPage registrationPage = open(RegistrationPage.REGISTER_URL, RegistrationPage.class);
        registrationPage.setName(CreateUser.getName());
        registrationPage.setEmailField(CreateUser.getEmail());
        registrationPage.setPassword(CreateUser.getPassword());
        registrationPage.registerButtonClick();
        assertTrue(authorizationPage.toComeInIsDispayed());
    }

    @DisplayName("Регистрация пользователя с невалидным паролем")
    @Description("Регистрация пользователя.Негативная проверка")
    @Step("Проверка регистрации пользователя с невалидным паролем (5 символов)")
    @Test
    public void registrationWithInvalidPasswordTest(){
        MainPage mainPage = open(MainPage.BASE_URL,MainPage.class);
        mainPage.personalAreaClick();
        AuthorizationPage authorizationPage = open(AuthorizationPage.LOGIN_PAGE, AuthorizationPage.class);
        authorizationPage.registerButtonClick();
        RegistrationPage registrationPage = open(RegistrationPage.REGISTER_URL, RegistrationPage.class);
        registrationPage.setName(CreateUser.getName());
        registrationPage.setEmailField(CreateUser.getEmail());
        registrationPage.setPassword(CreateUser.getInvalidPassword());
        registrationPage.registerButtonClick();
        assertTrue(registrationPage.invalidPasswordMessageIsVisible());
    }
}
