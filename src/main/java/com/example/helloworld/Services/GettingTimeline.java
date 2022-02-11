package com.example.helloworld.Services;

import com.example.helloworld.Models.TwitterPost;
import com.example.helloworld.YMLConfig;
import org.springframework.cache.annotation.Cacheable;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class GettingTimeline {

    @Cacheable("tweets")
    public List<List<String>> getTweets() throws IOException {

        YMLConfig pv = new YMLConfig();
        String[] result = pv.getPropValues();
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true).setOAuthConsumerKey(result[0])
                .setOAuthConsumerSecret(result[1])
                .setOAuthAccessToken(result[2])
                .setOAuthAccessTokenSecret(result[3]);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        try {
            List<TwitterPost> list = twitter.getHomeTimeline().stream()
                    .map(item -> {

                        TwitterPost tp = new TwitterPost();
                        tp.setmessage(item.getText());
                        tp.setTwitterHandle(item.getUser().getName());
                        tp.setProfileImageURL(item.getUser().getProfileImageURL());
                        tp.setCreatedAt(item.getCreatedAt().toString());
                        return tp;
                    })
                    .collect(Collectors.toList());


            List<List<String>> twitterPost = new ArrayList<>();
            for (TwitterPost tp : list) {
                List<String> str = new ArrayList<>();
                str.add(tp.getMessage());
                str.add(tp.getTwitterHandle());
                str.add(tp.getProfileImageURL());
                str.add(tp.getCreatedAt());
                twitterPost.add(str);
            }


            return twitterPost;
        }
        catch(TwitterException te){
            List<List<String>> lst = new ArrayList<List<String>>();
            List<String> list= new ArrayList<String>(Collections.singleton("Access Token not working"));
            lst.add(list);
            return lst;
        }
    }



}
