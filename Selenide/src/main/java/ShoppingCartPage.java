import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ShoppingCartPage {
    public ElementsCollection productsInBasket= $$x("//div[@class='cart_item']");
    public ElementsCollection removeProductsButtons = $$x("//button[contains(text(),'Remove')]");
    public SelenideElement checkoutButton = $x("//button[@id='checkout']");

    public ShoppingCartPage removeAllProducts(){
        for (SelenideElement removeProductButton : removeProductsButtons)
          removeProductButton.click();
        return this;
    }

    public ShoppingCartPage clickToCheckoutButton(){
        checkoutButton.click();
        return this;
    }
}
