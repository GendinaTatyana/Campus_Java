import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;

public class ProductsPageTests extends BaseTest{
    @Test
    void checkAddToCartAllProductsPossibility() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        HeaderBlock headerBlock = new HeaderBlock();
        authorizationPage
                .loginToSystem(STANDARD_USERNAME,PASSWORD)
                .addAllProducts();
        headerBlock
                .bucketHeaderCounter
                .shouldBe(visible)
                .shouldBe(exactText("6"));
        /*
         * Проверка что добавленные товары отображаются в счетчике корзины
         * Нужно добавить все товары в корзину и проверить что счетчик корзины = 6
         * */
    }

    @Test
    void checkRemoveAllAddedProductsPossibility() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        HeaderBlock headerBlock = new HeaderBlock();
        authorizationPage
                .loginToSystem(STANDARD_USERNAME,PASSWORD)
                .addAllProducts()
                .removeAllProducts();
        headerBlock
                .bucketHeaderCounter
                .shouldBe(not(visible));
        /*
         * Проверка что добавленные товары можно удалить на странице продуктов
         * Нужно удалить все товары на странице продуктов и проверить что счетчик корзины не отображается
         * */
    }
}
