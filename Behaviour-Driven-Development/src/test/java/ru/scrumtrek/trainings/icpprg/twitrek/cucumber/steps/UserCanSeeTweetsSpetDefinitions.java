package ru.scrumtrek.trainings.icpprg.twitrek.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ru.scrumtrek.trainings.icpprg.twitrek.Tweet;
import ru.scrumtrek.trainings.icpprg.twitrek.TwiTrek;
import ru.scrumtrek.trainings.icpprg.twitrek.User;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class UserCanSeeTweetsSpetDefinitions {

    private TwiTrek twiTrek = new TwiTrek();

    @Given("^non authenticated user$")
    public void givenNonAuthenticatedUser() {

    }

    @When("^I open profile page and there some tweets of an AU$")
    public void whenThereSomeTweets() {
        User user = new User("name", "pass", "mail");
        twiTrek.registerNewUser(user);
        twiTrek.tweet(user, "msg1");
        twiTrek.tweet(user, "msg2");
    }

    @Then("^I can see those tweets$")
    public void thenICanSeeThoseTweets() {
        User user = new User("name", "pass", "mail");
        List<Tweet> tweets = twiTrek.getMessages(user);
        assertThat("msg1").isEqualTo(tweets.get(0).getMessage());
        assertThat("msg2").isEqualTo(tweets.get(1).getMessage());

    }


}
