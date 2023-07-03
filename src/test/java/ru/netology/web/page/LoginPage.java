package ru.netology.web.test;

import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        Selenide.$("[data-test-id=login] input").setValue(info.getLogin());
        Selenide.$("[data-test-id=password] input").setValue(info.getPassword());
        Selenide.$("[data-test-id=action-login]").click();
        return new VerificationPage();
    }
}
