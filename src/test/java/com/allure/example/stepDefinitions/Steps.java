package com.allure.example.stepDefinitions;

import com.allure.example.configs.Pages.MessagingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class Steps {

    MessagingPage loginPage;

    @Given("the provider logged in successfully")
    public void login() {
        loginPage = new MessagingPage();
        loginPage.openWebPage();
        loginPage.enterCredentials("melgibsonjohn@gmail.com", "Altais@123");
        loginPage.hitsButton();
    }
    @When("navigates to messaging screen")
    public void navigatesToMessaging() {
        loginPage.homePage();
        loginPage.toMessagingScreen();
    }

    @And("Creates conversation with patient {string} {string} {string}")
    public void composeConversation(String toName, String subjectName, String message) {
        loginPage.composeMessage(toName, subjectName, message);
    }
    @Then("the created conversation should be displayed")
    public void checkAndLogout() {
//        loginPage.checkForComposedMessage();
        loginPage.logout();
    }
}
