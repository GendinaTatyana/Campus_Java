import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.visible;

public class CheckoutOverviewPageTests extends BaseTest {
    @Test
    void checkFinishCheckoutPossibility() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        HeaderBlock headerBlock = new HeaderBlock();
        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();
        authorizationPage
                .loginToSystem(STANDARD_USERNAME, PASSWORD)
                .addAllProducts();
        headerBlock.bucketHeaderLink.click();
        shoppingCartPage.clickToCheckoutButton();
        checkoutInformationPage.fillCheckoutInformationPage(FIRST_NAME, LAST_NAME, POST_CODE);
        checkoutOverviewPage.clickToFinishButton();
        checkoutCompletePage
                .completeHeader
                .shouldBe(visible)
                .shouldHave(Condition.text("THANK YOU FOR YOUR ORDER"));
        /*
         * Проверка что есть возможность нажать на кнопку FINISH
         * Проверить что после нажатия на кнопку заголовок на странице CheckoutCompletePage = THANK YOU FOR YOUR ORDER
         * */
    }
}
