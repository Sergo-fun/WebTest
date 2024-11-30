package tests;

import core.base.BaseTest;
import core.pages.AnonymRecoveryPage;
import core.pages.LoginPage;
import core.pages.RecoveryPageByEmail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class RecoveryByEmailTest extends BaseTest {

    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private static RecoveryPageByEmail recoveryPageByEmail;

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
        anonymRecoveryPage.goToRecoveryByEmail();

        recoveryPageByEmail = new RecoveryPageByEmail();
        recoveryPageByEmail.goToRecoveryMailButton();
        recoveryPageByEmail.setMail("svino@mail.ru");
        recoveryPageByEmail.goToGettingCodeByEmail();


    }


}
