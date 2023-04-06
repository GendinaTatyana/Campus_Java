import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;

public class AuthorizationTests extends BaseTest {
    @Test
    void checkSuccessLogin() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        ProductsPage productsPage = authorizationPage.loginToSystem(STANDARD_USERNAME, PASSWORD);
        productsPage
                .productCatalog
                .filter(visible)
                .shouldHave(size(6));
        /*
         * Проверка успешной авторизации
         * После авторизации под пользователем standard_user проверить что на странице ProductPage размер списка товаров = 6
         * */
    }

    @Test
    void checkFailedLogin() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.loginToSystem(LOCKED_OUT_USERNAME, PASSWORD);
        authorizationPage
                .errorMessage
                .shouldBe(visible)
                .shouldHave(exactText("Epic sadface: Sorry, this user has been locked out."));
        /*
         * Проверка неуспешной авторизации
         * Здесь два пути:
         * 1. Ввести несуществующие данные и попробовать авторизоваться
         * 2. Взять заблокированного пользователя и попробовать авторизоваться
         * В любом случае проверка заключается в том что в нотификации о неуспешной авторизации выводится соответствующий текст
         * */
    }
}
