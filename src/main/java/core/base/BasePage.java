package core.base;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {

    // Примеры общих элементов, которые могут использоваться на разных страницах
    protected SelenideElement headerLogo = $("[tsid='toolbar_logo']");
    protected SelenideElement searchField = $("[name='st.query']");
    protected SelenideElement notificationsIcon = $("[data-l='t,vk_ecosystem']");

    @Step("Выполняем поиск по сайту с запросом: {query}")
    public void search(String query){
        searchField.shouldBe(visible).setValue(query).pressEnter();
    }

    @Step("Открываем VK Services")
    public void openVkServices(){
        notificationsIcon.shouldBe(visible).click();
    }

    @Step("Кликаем на логотип ОК")
    public void clickLogo(){
        headerLogo.shouldBe(visible).click();
    }







}
