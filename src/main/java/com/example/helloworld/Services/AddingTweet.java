package com.example.helloworld.Services;


import com.example.helloworld.YMLConfig;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;


public class AddingTweet {

    public String addingTweet(String args) throws IOException {
        YMLConfig pv= new YMLConfig();
        String[] result= pv.getPropValues();
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true).setOAuthConsumerKey(result[0])
                .setOAuthConsumerSecret(result[1])
                .setOAuthAccessToken(result[2])
                .setOAuthAccessTokenSecret(result[3]);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        try {
            Status status = twitter.updateStatus(args);
            String st = status.getText();
            return st;
        }
        catch (TwitterException te){
            return "Check your access tokens";
        }


    }

}
