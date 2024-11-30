package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BaseTest;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RecoveryPageByPhone extends BaseTest {

    private SelenideElement recoveryPhoneField = $("#field_phone");;
    private SelenideElement regionField = $x("//div[@data-l='t,country']");
    private SelenideElement getCode = $("[data-l='t,submit']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления по почте")
    private void verifyPageElements() {
        recoveryPhoneField.shouldBe(visible);
        getCode.shouldBe(visible);
    }

    @Step("Нажимаем на поле ввода телефона")
    public void goToRecoveryPhoneField() {
        recoveryPhoneField.shouldBe(visible).click();
    }

    @Step("Устанавливаем телефон для восстановления")
    public void setPhone(String phone) {
        recoveryPhoneField.shouldBe(visible).click();
        recoveryPhoneField.shouldBe(visible).setValue(phone);
    }

    @Step("Нажимаем на кнопку получить код")
    public void goToCodeButton() {
        getCode.shouldBe(visible).click();
    }

    @Step("Выбираем код страны по названию")
    public String selectCountryByName(String countryName){
        regionField.click();
        SelenideElement countryItem = $(String.format(".country-select_i[data-name='%s']",countryName));
        countryItem.scrollTo();
        String countryCode = countryItem.find(".country-select_code").text();
        countryItem.click();
        return countryCode;
    }

}
