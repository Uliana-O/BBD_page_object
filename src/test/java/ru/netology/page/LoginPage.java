package ru.netology.page;

import com.codeborne.selenide.Selenide;
import ru.netology.data.DataHelper;

public class LoginPage {
    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        Selenide.$("[data-test-id=login] input").setValue(info.getLogin());
        Selenide.$("[data-test-id=password] input").setValue(info.getPassword());
        Selenide.$("[data-test-id=action-login]").click();
        return new VerificationPage();
    }
}
