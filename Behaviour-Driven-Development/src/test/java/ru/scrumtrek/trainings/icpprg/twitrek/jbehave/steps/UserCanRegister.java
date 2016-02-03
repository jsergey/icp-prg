package ru.scrumtrek.trainings.icpprg.twitrek.jbehave.steps;

import org.jbehave.core.annotations.*;
import ru.scrumtrek.trainings.icpprg.twitrek.TwiTrek;
import ru.scrumtrek.trainings.icpprg.twitrek.User;

import static org.fest.assertions.api.Assertions.assertThat;

public class UserCanRegister {

    private TwiTrek twiTrek = new TwiTrek();

    @Given("non authenticated user")
    public void givenNotAuthenticatedUser() {

    }

    @When("$username creates account using $email and $password")
    public void whenCreateAccount(String username, String email, String password) {
        User user = new User(username, password, email);
        twiTrek.registerNewUser(user);
    }

    @Then("account is created")
    public void thenAccountIsCreated() {
        User user = new User("Sergey", "secret", "name@mail.com");
        assertThat(twiTrek.userExists(user)).isTrue();
    }

    @Then("$username can tweet")
    public void thenUserCanTweet(String username) {
        twiTrek.tweet(twiTrek.getUserByName(username),"message");
        assertThat(twiTrek.getMessages(twiTrek.getUserByName(username)).get(0).getMessage()).isEqualTo("message");
    }

}
