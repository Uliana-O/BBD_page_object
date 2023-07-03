package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;


public class MoneyTransfer {

    private SelenideElement heading = Selenide.$(Selectors.withText("Пополнение карты"));
    private final SelenideElement amount = Selenide.$("[data-test-id=amount] input");
    private final SelenideElement from = Selenide.$("[data-test-id=from] input");
    private final SelenideElement button = Selenide.$("[data-test-id=action-transfer]");
    private final SelenideElement cancelButton = Selenide.$("[data-test-id=action-cancel]");
    private final SelenideElement error = Selenide.$("[data-test-id=error-notification]");

    public MoneyTransfer() {
        heading.shouldBe(Condition.visible);
    }

    public DashboardPage transferForm(String sum, DataHelper.CardNumber cardNumber) {
        amount.setValue(sum);
        from.setValue(String.valueOf(cardNumber));
        button.click();
        return new DashboardPage();

    }

    public void getError() {
        Selenide.$(Selectors.byText("Ошибка!")).shouldBe(Condition.visible);
    }

    public DashboardPage cancelButton() {
        cancelButton.click();
        return new DashboardPage();
    }


}



