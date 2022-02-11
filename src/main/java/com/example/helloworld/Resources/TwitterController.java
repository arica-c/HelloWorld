package com.example.helloworld.Resources;

import com.example.helloworld.Services.AddingTweet;
import com.example.helloworld.Services.FilterTimeline;
import com.example.helloworld.Services.GettingTimeline;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
import twitter4j.TwitterException;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path= "/api/1.0/twitter")
public class TwitterController {
    ApplicationContext applicationContext= new ClassPathXmlApplicationContext("beans.xml");

//    //use beans to create objects
//    @Autowired
//    AddingTweet ad;
//
//    @Autowired
//    GettingTimeline gt;
//
//    @Autowired
//    FilterTimeline ft;
    //POST method to post the tweet
    @PostMapping(path="/tweet")
    public String addingTweet(@RequestBody String args) throws IOException {

        AddingTweet ad= applicationContext.getBean("addingTweet", AddingTweet.class);
        String msg= ad.addingTweet(args);
        if(msg.equals("Check your access tokens")){
//            HttpHeaders header = new HttpHeaders();
//            header.add("Desc", "Access Tokens are wrong");
//            return new ResponseEntity<String>(msg, header, HttpStatus.INTERNAL_SERVER_ERROR);
            return msg;
        }
        else {
//            HttpHeaders header = new HttpHeaders();
//            header.add("Desc", "Adding a Tweet");
//            return new ResponseEntity<String>(msg, header, HttpStatus.OK);
            return msg;
        }
    }


    //Get request to get the timeline
    @GetMapping(path="/timeline")
    public List<List<String>> getTweets() throws IOException {
        GettingTimeline gt= applicationContext.getBean("gettingTimeline", GettingTimeline.class);
        List<List<String>> msg= gt.getTweets();
        if(msg.get(0).equals("Access Token not working")) {

//            HttpHeaders header = new HttpHeaders();
//            header.add("desc", "Access token isn't working");
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(header).body(msg);
            return msg;

        }
        else
        {
//            HttpHeaders header = new HttpHeaders();
//            header.add("desc", "Getting the homeTimeline");
//            return ResponseEntity.status(HttpStatus.OK).headers(header).body(msg);
            return msg;
        }

    }

    @GetMapping(path="/timeline/{filter}")
    public  List<String> searchtweets(@PathVariable("filter") String filter) throws IOException, TwitterException {
        FilterTimeline ft= applicationContext.getBean("filterTimeline", FilterTimeline.class);
        return ft.searchtweets(filter);

    }
//    @GetMapping(path="/timeline/{filter}")
//    public  List<String> searchtweets(String filter) throws TwitterException {
//
//        ConfigurationBuilder cb = new ConfigurationBuilder();
//        cb.setDebugEnabled(true).setOAuthConsumerKey(apiKey)
//                .setOAuthConsumerSecret(apiSecret)
//                .setOAuthAccessToken(accessToken)
//                .setOAuthAccessTokenSecret(accessSecret);
//        TwitterFactory tf = new TwitterFactory(cb.build());
//        Twitter twitter = tf.getInstance();
//
//        return twitter.getUserTimeline().stream()
//                .map(item -> item.getText()).filter(item -> item.contains(filter)).collect(Collectors.toList());
//
//
//
//    }

}
