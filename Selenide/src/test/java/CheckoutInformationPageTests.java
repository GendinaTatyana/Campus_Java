import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;

public class CheckoutInformationPageTests extends BaseTest {
    @Test
    void checkCheckoutPossibility() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        HeaderBlock headerBlock = new HeaderBlock();
        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
        authorizationPage
                .loginToSystem(STANDARD_USERNAME, PASSWORD)
                .addAllProducts();
        headerBlock.bucketHeaderLink.click();
        shoppingCartPage.clickToCheckoutButton();
        checkoutInformationPage
                .fillCheckoutInformationPage(FIRST_NAME, LAST_NAME, POST_CODE)
                .overviewProductCatalog
                .filter(visible)
                .shouldHave(size(6));
        /*
         * Проверка что есть возможность заполнить форму и продолжить оформление заказа
         * Нужно заполнить поля формы и выполнить нажатие на кнопку continue
         * Проверить что на странице CheckoutOverviewPage размер списка товаров = 6 (в пререквизите добавьте все 6 товаров)
         * */
    }

    @Test
    void checkErrorDueToBlankFirstNameInForm() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        HeaderBlock headerBlock = new HeaderBlock();
        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
        authorizationPage
                .loginToSystem(STANDARD_USERNAME, PASSWORD)
                .addAllProducts();
        headerBlock.bucketHeaderLink.click();
        shoppingCartPage.clickToCheckoutButton();
        checkoutInformationPage
                .setLastName(LAST_NAME)
                .setPostalCode(POST_CODE)
                .clickToContinueButton()
                .errorCheckoutMessage
                .shouldBe(visible)
                .shouldHave(exactText("Error: First Name is required"));
        /*
         * Проверка что при пустом поле FirstName отдается соответствующая ошибка
         * */
    }

    @Test
    void checkErrorDueToBlankLastNameInForm() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        HeaderBlock headerBlock = new HeaderBlock();
        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
        authorizationPage.loginToSystem(STANDARD_USERNAME, PASSWORD).addAllProducts();
        headerBlock.bucketHeaderLink.click();
        shoppingCartPage.clickToCheckoutButton();
        checkoutInformationPage
                .setFirstName(FIRST_NAME)
                .setPostalCode(POST_CODE)
                .clickToContinueButton()
                .errorCheckoutMessage
                .shouldBe(visible)
                .shouldHave(exactText("Error: Last Name is required"));
        /*
         * Проверка что при пустом поле LastName отдается соответствующая ошибка
         * */
    }

    @Test
    void checkErrorDueToBlankPostalCodeInForm() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        HeaderBlock headerBlock = new HeaderBlock();
        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
        authorizationPage.loginToSystem(STANDARD_USERNAME, PASSWORD).addAllProducts();
        headerBlock.bucketHeaderLink.click();
        shoppingCartPage.clickToCheckoutButton();
        checkoutInformationPage
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .clickToContinueButton()
                .errorCheckoutMessage
                .shouldBe(visible)
                .shouldHave(exactText("Error: Postal Code is required"));
        /*
         * Проверка что при пустом поле PostalCode отдается соответствующая ошибка
         * */
    }
}
