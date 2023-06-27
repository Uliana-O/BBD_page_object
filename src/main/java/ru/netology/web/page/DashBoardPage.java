package ru.netology.web.page;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class DashboardPage {
    private SelenideElement heading = $( "[data-test-id=dashboard]" );
    private SelenideElement firstCard = $$( ".list__item" ).first();
    private SelenideElement secondCard = $$( ".list__item" ).last();
    private SelenideElement reload = $( "[data-test-id=''action-reload']" );
    private SelenideElement firstCardButton = $$( "[data-test-id='action-deposit']" ).first();
    private SelenideElement secondCardButton = $$( "[data-test-id='action-deposit']" ).last();
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";


    public DashboardPage() {
        heading.shouldBe( visible );
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