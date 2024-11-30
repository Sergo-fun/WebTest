package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    private SelenideElement usernameField = $("[name='st.email']");
    private SelenideElement passwordField = $("[name='st.password']");
    private SelenideElement loginButton = $("[data-l='t,sign_in']");
    private SelenideElement forgotPasswordLink = $("[data-l='t,restore']");
    private SelenideElement registrationButton =$x("//div[@class='external-oauth-login-footer']/a[@data-l='t,register']");
    private SelenideElement qrCodeButton = $(".qr-button-label");


    private SelenideElement vkButton = $("[data-l='t,vkc']");
    private SelenideElement mailButton =$("[data-l='t,mailru']");
    private SelenideElement googleButton =$("[data-l='t,google']");
    private SelenideElement yandexButton =$("[data-l='t,yandex']");
    private SelenideElement appleButton =$("[data-l='t,apple']");

    private SelenideElement errorMessage =$("[class='input-e login_error']");

    private SelenideElement goToRecoveryButton = $("[value='st.go_to_recovery']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    private void verifyPageElements(){
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
        registrationButton.shouldBe(visible);
        qrCodeButton.shouldBe(visible);
        vkButton.shouldBe(visible);
        mailButton.shouldBe(visible);
        googleButton.shouldBe(visible);
        yandexButton.shouldBe(visible);
        appleButton.shouldBe(visible);
    }

    @Step("Проверяем видимость сообщения об ошибке входа")
    public boolean isErrorMessageVisible(){
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMessageText(){
        return errorMessage.shouldBe(visible).getText();
    }

    @Step("Входим на сайт с логином: {username} и паролем: {password}")
    public void login(String username, String password){
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Вход на сайт с логином: {username}")
    public void onlyLogin(String username){
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        loginButton.shouldBe(visible).click();
    }

    @Step("Восстановить профиль")
    public void goToRecovery(){
        goToRecoveryButton.shouldBe(visible).click();
    }

    @Step("Нажатие кнопки войти")
    public void clickLogin(){
        loginButton.shouldBe(visible).click();
    }

    @Step("Вход на сайт с паролем: {password}")
        public void onlyPassword(String password){
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Вход на сайт с паролем: {password}")
    public void setPassword(String password){
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
    }

    @Step("Переходим на страницу восстановления пароля")
    public void openForgotPasswordPage(){
        forgotPasswordLink.shouldBe(visible).click();
    }

    @Step("Переходим на страницу регистрации")
    public void openRegistrationPage(){
        registrationButton.shouldBe(visible).click();
    }

    @Step("Переходим на страницу QR-кода")
    public void openQrPage(){
        qrCodeButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через ВК")
    public void loginWithVk(){
        vkButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Мэйл почту")
    public void loginWithMail(){
        mailButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Гугл")
    public void loginWithGoogle(){
        googleButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Яндекс")
    public void loginWithYandex(){
        yandexButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Эппл")
    public void loginWithApple(){
        appleButton.shouldBe(visible).click();
    }
}
