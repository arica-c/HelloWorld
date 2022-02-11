package com.example.helloworld.Services;

import com.example.helloworld.YMLConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class FilterTimeline {
    public static List<String> searchtweets(String filter) throws TwitterException, IOException {

        YMLConfig pv = new YMLConfig();
        String[] result = pv.getPropValues();
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true).setOAuthConsumerKey(result[0])
                .setOAuthConsumerSecret(result[1])
                .setOAuthAccessToken(result[2])
                .setOAuthAccessTokenSecret(result[3]);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        return twitter.getUserTimeline().stream()
                .map(item -> item.getText()).filter(item -> item.contains(filter)).collect(Collectors.toList());



    }
}
