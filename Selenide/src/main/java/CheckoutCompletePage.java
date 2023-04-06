import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class CheckoutCompletePage {
    public SelenideElement completeHeader = $x("//h2[@class = 'complete-header']");
}
