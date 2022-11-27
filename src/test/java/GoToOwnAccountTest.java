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

public class GoToOwnAccountTest {

    @Before
    public void setUp() {
        open("https://stellarburgers.nomoreparties.site/");
    }

    @AfterClass
    public static void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }

    @DisplayName("Переход в личный кабинет после авторизации")
    @Description("Проверка просмотра личного кабинета после авторизации")
    @Step("Проверка возможности вхождения в личный кабинет после авторизации")
    @Test
    public void goToPersonalAreaAfterAuthorizationTest() throws InterruptedException {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.logInButtonClick();
        AuthorizationPage authorizationPage = open(AuthorizationPage.LOGIN_PAGE, AuthorizationPage.class);
        sleep(55);
        authorizationPage.setEmail("MariaZel@yandex.ru");
        authorizationPage.setPassword("Mari123321");
        authorizationPage.logInButtonClick();
        mainPage.modalWindowExitButtonClick();
        mainPage.personalAreaClick();
        AccountPage accountPage = open(AccountPage.PROFILE_URL, AccountPage.class);
        assertTrue("Переход в личный кабиент с авторизаций не выполняется ",AccountPage.isProfileFieldTextVisible());
        mainPage.personalAreaClick();
        accountPage.exitButtonClick();
        sleep(10);
    }
}
