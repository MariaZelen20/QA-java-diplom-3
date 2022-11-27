import com.AccountPage;
import com.AuthorizationPage;
import com.MainPage;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class UnloggedTest {

    @Before
    public void setUp() {
        open("https://stellarburgers.nomoreparties.site/");
    }

    @AfterClass
    public static void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }

    @DisplayName("Выход из личного кабинета")
    @Description("Выход из личного кабинета авторизовавшегося пользователя")
    @Step("Проверка возможности выхода из личного кабинета после авторизации пользователя")
    @Test
    public void logInWithMainPageSignInButtonTest() throws InterruptedException {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.logInButtonClick();
        AuthorizationPage authorizationPage = open(AuthorizationPage.LOGIN_PAGE, AuthorizationPage.class);
        authorizationPage.setEmail("Router@yandex.ru");
        authorizationPage.setPassword("Router");
        authorizationPage.logInButtonClick();
        assertTrue(mainPage.isMakeOrderButtonDispayed());
        mainPage.modalWindowExitButtonClick();
        mainPage.personalAreaClick();
        AccountPage accountPage = open(AccountPage.PROFILE_URL, AccountPage.class);
        accountPage.exitButtonClick();
        assertTrue("Выход из личного кабинета не выпоняется",authorizationPage.toComeInIsDispayed());
        sleep(10);
    }
}
