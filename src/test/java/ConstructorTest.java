import com.MainPage;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class ConstructorTest {
    @Before
    public void setUp() {
        open("https://stellarburgers.nomoreparties.site/");
    }

    @AfterClass
    public static void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }

    @DisplayName("Переход в раздел Начинки")
    @Description("Проверка перехода в раздел Начинки")
    @Step("Проверка скролла на странице элементов начинкиб при нажатии на раздел Начинки")
    @Test
    public void isTransitionFillingSectionWorksTest() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.fillingsButtonClick();
        assertTrue(mainPage.isBeefMeteoriteChopVisible());
    }

    @DisplayName("Переход в раздел Булки")
    @Description("Проверка перехода в раздел Булки")
    @Step("Проверка скролла на странице элементов Булок, при нажатии на раздел Булки")
    @Test
    public void isTransitionToBunSectionWorksTest() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.fillingsButtonClick();
        mainPage.bunsButtonClick();
        assertTrue(mainPage.isFluorescentBunVisible());
    }

    @DisplayName("Переход в раздел Соусы")
    @Description("Проверка перехода в раздел Соусы")
    @Step("Проверка скролла на странице элементов Соусов, при нажатии на раздел Соусы")
    @Test
    public void isTransitionToSauceSectionWorksTest() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.saucesButtonClick();
        assertTrue(mainPage.isSauceSpicyXVisible());
    }
}
