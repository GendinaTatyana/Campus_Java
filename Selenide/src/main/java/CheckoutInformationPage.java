import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class CheckoutInformationPage {
    public SelenideElement firstNameInput = $x("//input[@id='first-name']");
    public SelenideElement lastNameInput = $x("//input[@id='last-name']");
    public SelenideElement postalCodeInput = $x("//input[@id='postal-code']");
    public SelenideElement continueButton = $x("//input[@id='continue']");
    public SelenideElement errorCheckoutMessage = $x("//h3[@data-test = 'error']");

    public CheckoutInformationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public CheckoutInformationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public CheckoutInformationPage setPostalCode(String postalCode) {
        postalCodeInput.setValue(postalCode);
        return this;
    }

    public CheckoutInformationPage clickToContinueButton() {
        continueButton.click();
        return this;
    }

    public CheckoutOverviewPage fillCheckoutInformationPage(String firstName, String lastName, String postCode) {
        this.setFirstName(firstName)
                .setLastName(lastName)
                .setPostalCode(postCode)
                .clickToContinueButton();
        return new CheckoutOverviewPage();
    }
}
