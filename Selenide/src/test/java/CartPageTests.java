import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;

public class CartPageTests extends BaseTest {
    @Test
    void checkGoodsAddedIsPresentInCart() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        HeaderBlock headerBlock = new HeaderBlock();
        authorizationPage
                .loginToSystem(STANDARD_USERNAME, PASSWORD)
                .addAllProducts();
        headerBlock.bucketHeaderLink.click();
        shoppingCartPage
                .productsInBasket
                .filter(visible)
                .shouldHave(size(6));
        /*
         * Проверка что добавленные товары отображаются в корзине
         * Нужно добавить все товары в корзину и проверить что на странице корзины размер списка товаров = 6
         * */
    }

    @Test
    void checkDeleteGoodsFromCartPossibility() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        HeaderBlock headerBlock = new HeaderBlock();
        authorizationPage
                .loginToSystem(STANDARD_USERNAME, PASSWORD)
                .addAllProducts();
        headerBlock.bucketHeaderLink.click();
        shoppingCartPage.removeAllProducts();
        headerBlock
                .bucketHeaderCounter
                .shouldBe(not(visible));
        /*
         * Проверка что есть возможность удалить добавленные товары из корзины
         * Удалить добавленные товары (пререквизит к тесту - товары должны быть добавлены в корзину) и проверить что счетчик в блоке
         * HeaderBlock не отображается
         * */
    }
}
