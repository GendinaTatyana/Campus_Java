import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class HeaderBlockTests extends BaseTest {
    @Test
    void checkMenuOpening() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        HeaderBlock headerBlock = new HeaderBlock();
        authorizationPage.loginToSystem(STANDARD_USERNAME,PASSWORD);
        headerBlock.clickToOpenMenuButton().menu.filter(visible).shouldHave(size(4));
    }
    /*
     * Проверка что Menu отображается на странице при нажатии на кнопку OpenMenu и меню содержит 4 раздела.
     * Необходимо для того, чтобы получить доступ к фнукционалу, доступному только в этом меню.
     * */

    @Test
    void checkSuccessLogout() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        HeaderBlock headerBlock = new HeaderBlock();
        authorizationPage.loginToSystem(STANDARD_USERNAME,PASSWORD);
        headerBlock.clickToOpenMenuButton().clickToLogoutButton();
        webdriver().shouldHave(url("https://www.saucedemo.com/"));
    }
    /*
     * Проверка логаута
     * Проверить что после нажатия на кнопку Logout мы переходим на стартовую страницу
     * */
}
