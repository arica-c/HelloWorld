package com.example.helloworld;


import com.example.helloworld.Models.TwitterPost;
import com.example.helloworld.Resources.TwitterController;
import com.example.helloworld.Services.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import twitter4j.TwitterException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
class HelloWorldApplicationTests {

    @Test
   public void TweetTest() throws TwitterException, IOException {
        TwitterController twitterTest= new TwitterController();
       assertEquals("Good Morning", twitterTest.addingTweet("Good Morning"));
         List<List<String>> list= (List<List<String>>) twitterTest.getTweets();
         assertTrue(list.get(0) instanceof ArrayList);
    }

    //test for the exceptions
}
