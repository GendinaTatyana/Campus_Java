import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class AuthorizationPage {
    public SelenideElement usernameInput = $x("//input[@id='user-name']");
    public SelenideElement passwordInput = $x("//input[@id='password']");
    public SelenideElement loginButton = $x("//input[@id='login-button']");
    public SelenideElement errorMessage = $x("//h3[@data-test = 'error']");

    private AuthorizationPage setUsername(String username) {
        usernameInput.setValue(username);
        return this;
    }

    private AuthorizationPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    private AuthorizationPage clickToLoginButton() {
        loginButton.click();
        return this;
    }

    public ProductsPage loginToSystem(String username, String password) {
        this.setUsername(username)
                .setPassword(password)
                .clickToLoginButton();
        return new ProductsPage();
    }
}