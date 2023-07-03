package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

class MoneyTransferTest {

    @BeforeEach
    public void openPage() {

        open( "http://localhost:7777" );

        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin( authInfo );
        var verificationCode = DataHelper.getVerificationCodeFor( authInfo );
        verificationPage.validVerify( verificationCode );
    }


    @Test
    void shouldTransferMoneyBetweenOwnCards1() {

        var dashboardPage = new DashboardPage();

        int balanceFirstCard = dashboardPage.getFirstCardBalance();
        int balanceSecondCard = dashboardPage.getSecondCardBalance();
        var moneyTransfer = dashboardPage.firstCardButton();
        var infoCard = DataHelper.getSecondCardNumber();
        String sum = "100";
        moneyTransfer.transferForm( sum, infoCard );

        assertEquals( balanceFirstCard + Integer.parseInt( sum ), dashboardPage.getFirstCardBalance() );
        assertEquals( balanceSecondCard - Integer.parseInt( sum ), dashboardPage.getSecondCardBalance() );
    }

    @Test
    void shouldTransferMoneyBetweenOwnCards2() {

        var dashboardPage = new DashboardPage();

        int balanceFirstCard = dashboardPage.getFirstCardBalance();
        int balanceSecondCard = dashboardPage.getSecondCardBalance();
        var moneyTransfer = dashboardPage.secondCardButton();
        var infoCard = DataHelper.getFirstCardNumber();
        String sum = "1500";
        moneyTransfer.transferForm( sum, infoCard );

        assertEquals( balanceFirstCard - Integer.parseInt( sum ), dashboardPage.getFirstCardBalance() );
        assertEquals( balanceSecondCard + Integer.parseInt( sum ), dashboardPage.getSecondCardBalance() );
    }

    @Test
    void shouldCancellationOfMoneyTransfer() {

        var dashboardPage = new DashboardPage();

        var moneyTransfer = dashboardPage.firstCardButton();
        moneyTransfer.cancelButton();
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsError() {

        var dashboardPage = new DashboardPage();

        var moneyTransfer = dashboardPage.secondCardButton();
        var infoCard = DataHelper.getFirstCardNumber();
        String sum = "20000";
        moneyTransfer.transferForm( sum, infoCard );
        moneyTransfer.getError();
    }
}


