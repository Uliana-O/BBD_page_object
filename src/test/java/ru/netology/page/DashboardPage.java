package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


public class DashboardPage {
    private SelenideElement heading = Selenide.$( "[data-test-id=dashboard]" );
    private SelenideElement firstCard = Selenide.$$( ".list__item" ).first();
    private SelenideElement secondCard = Selenide.$$( ".list__item" ).last();
    private SelenideElement reload = Selenide.$( "[data-test-id=''action-reload']" );
    private SelenideElement firstCardButton = Selenide.$$( "[data-test-id='action-deposit']" ).first();
    private SelenideElement secondCardButton = Selenide.$$( "[data-test-id='action-deposit']" ).last();
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";


    public DashboardPage() {
        heading.shouldBe( Condition.visible );
    }

    public MoneyTransfer firstCardButton() {
        firstCardButton.click();
        return new MoneyTransfer();

    }

    public MoneyTransfer secondCardButton() {
        secondCardButton.click();
        return new MoneyTransfer();
    }

    public int getFirstCardBalance() {
        var text = firstCard.text();
        return extractBalanceFirstCard(text);
    }

    private int extractBalanceFirstCard(String text) {
        var start = text.indexOf(balanceStart);
        var finish = text.indexOf(balanceFinish);
        var value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public int getSecondCardBalance() {
        var text = secondCard.text();
        return extractBalanceSecondCard(text);
    }

    private int extractBalanceSecondCard(String text) {
        var start = text.indexOf(balanceStart);
        var finish = text.indexOf(balanceFinish);
        var value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }


}