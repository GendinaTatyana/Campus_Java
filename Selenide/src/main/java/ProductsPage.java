import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;

public class ProductsPage {
    public ElementsCollection productCatalog = $$x("//div[@class='inventory_item']");
    public ElementsCollection productAddButtons = $$x("//button[contains(text(),'Add to cart')]");
    public ElementsCollection productRemoveButtons = $$x("//button[contains(text(),'Remove')]");

    public ProductsPage addAllProducts() {
        for (SelenideElement button : productAddButtons)
            button.click();
        return this;
    }

    public ProductsPage removeAllProducts() {
        for (SelenideElement button : productRemoveButtons)
            button.click();
        return this;
    }
 }
