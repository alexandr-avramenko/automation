package org.automation.tests;

import org.automation.common.BaseTest;
import org.automation.model.User;
import org.automation.pages.elements.TextBoxPage;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class TextBotTest extends BaseTest {
    @Test
    public void isCorrectOutputDataTest() {
        TextBoxPage page = new TextBoxPage();
        User user = User.builder()
                .username("John")
                .email("johnDear@gmail.com")
                .currentAddress("NY")
                .permanentAddress("UK")
                .build();
        page.open().fillForm(user).submitForm();
        assertThat(page.isOutputFormDisplayed()).isTrue();
        assertThat(page.getDataFromOutput()).containsExactly(
                user.getUsername(), user.getEmail(), user.getCurrentAddress(), user.getPermanentAddress()
        );
    }

}
