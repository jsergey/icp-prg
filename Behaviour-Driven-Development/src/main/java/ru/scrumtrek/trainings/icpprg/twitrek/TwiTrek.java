package ru.scrumtrek.trainings.icpprg.twitrek;

import java.util.*;

public class TwiTrek {

    private Map<User, List<Tweet>> tweets = new HashMap<User, List<Tweet>>();

    public void Tweitrek() {

    }

    public List<Tweet> getMessages(User user) {
        return tweets.get(user);
    }

    public void registerNewUser(User user) {
        tweets.put(user, new LinkedList<>());
    }

    public void tweet(User user, String message) {
        tweets.get(user).add(new Tweet(message));
    }

    public boolean userExists(User user) {
       return tweets.containsKey(user);
    }

    public User getUserByName(String name) {
        for(User user : tweets.keySet()) {
            if(name.equals(user.getName())) {
                return user;
            }
        }
        return null;
    }
}
