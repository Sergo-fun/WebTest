package tests;

import core.base.BaseTest;
import core.pages.AnonymRecoveryPage;
import core.pages.LoginPage;
import core.pages.RecoveryPageByPhone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecoveryByPhoneTest extends BaseTest {
    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private static RecoveryPageByPhone recoveryPageByPhone;

    @BeforeEach
    public void prepare(){
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void recoveryByEmailTest(){
        loginPage.login("IncorrectUser","IncorrectPassword");

        for(int i=0;i<2;i++){
            loginPage.setPassword("1");
            loginPage.clickLogin();
        }
        loginPage.goToRecovery();

        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByPhone();

        recoveryPageByPhone = new RecoveryPageByPhone();
        recoveryPageByPhone.goToRecoveryPhoneField();
        recoveryPageByPhone.setPhone("+375291392222");
        String countryCode = recoveryPageByPhone.selectCountryByName("Беларусь");
        assertEquals("+375",countryCode,"Код страны не совпадает с ожидаемым");
        recoveryPageByPhone.goToCodeButton();

    }
}
