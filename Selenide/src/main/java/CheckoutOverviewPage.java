import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CheckoutOverviewPage {
    public ElementsCollection overviewProductCatalog = $$x("//div[@class='cart_item']");
    public SelenideElement finishButton = $x("//button[@id = 'finish']");

    public CheckoutOverviewPage clickToFinishButton() {
        finishButton.click();
        return this;
    }
}
