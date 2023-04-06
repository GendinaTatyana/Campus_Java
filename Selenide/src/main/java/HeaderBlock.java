import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class HeaderBlock {
    public SelenideElement bucketHeaderCounter = $x("//span[@class='shopping_cart_badge']");
    public SelenideElement bucketHeaderLink = $x("//a[@class='shopping_cart_link']");
    public SelenideElement openMenuButton = $x("//button[@id='react-burger-menu-btn']");
    public ElementsCollection menu = $$x("//a[@class = 'bm-item menu-item']");
    public SelenideElement logoutButton = $x("//a[@id = 'logout_sidebar_link']");

    public HeaderBlock clickToOpenMenuButton() {
        openMenuButton.click();
        return this;
    }

    public HeaderBlock clickToLogoutButton() {
        logoutButton.click();
        return this;
    }
}
