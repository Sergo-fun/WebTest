package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RecoveryPageByEmail extends BasePage {

    private SelenideElement recoveryMailField = $x("//*[@class='it' and @name='email']");
    private SelenideElement gettingCodeByEmail = $("[data-l='t,submit']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления по почте")
    private void verifyPageElements() {
        recoveryMailField.shouldBe(visible);
        gettingCodeByEmail.shouldBe(visible);
    }

    @Step("Нажимаем на поле ввода почты")
    public void goToRecoveryMailButton() {
        recoveryMailField.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку получения кода")
    public void goToGettingCodeByEmail() {
        gettingCodeByEmail.shouldBe(visible).click();
    }

    @Step("Устанавливаем mail для восстановления")
    public void setMail(String mail) {
        recoveryMailField.shouldBe(visible).click();
        recoveryMailField.shouldBe(visible).setValue(mail);
    }
}