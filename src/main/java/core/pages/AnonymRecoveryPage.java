package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AnonymRecoveryPage extends BasePage {

    private SelenideElement recoveryByPhoneButton = $("[data-l='t,phone']");
    private SelenideElement recoveryByEmailButton = $("[data-l='t,email']");
    private SelenideElement goToSupportButton = $("[data-l='t,support']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления пароля")
    private void verifyPageElements(){
        recoveryByPhoneButton.shouldBe(visible);
        recoveryByEmailButton.shouldBe(visible);
        goToSupportButton.shouldBe(visible);
    }

    @Step("Нажимаем на кнопку восстановления пароля через телефон")
    public void goToRecoveryByPhone(){
        recoveryByPhoneButton.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку восстановления пароля через почту")
    public void goToRecoveryByEmail(){
        recoveryByEmailButton.shouldBe(visible).click();
    }

    @Step("Переход в техническую поддержку")
    public void goToSupport(){
       goToSupportButton.shouldBe(visible).click();
    }

}
