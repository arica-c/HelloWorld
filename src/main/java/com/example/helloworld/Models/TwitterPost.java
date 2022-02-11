package com.example.helloworld.Models;

import org.springframework.stereotype.Component;

import java.util.Date;


public class TwitterPost {
    private String message;
    private String twitterHandle;
    private String profileImageURL;
    private String createdAt;


    public void setmessage(String message){
        this.message= message;
    }
    public void setTwitterHandle(String twitterHandle){
        this.twitterHandle= twitterHandle;
    }
    public void setProfileImageURL(String profileImageURL){
        this.profileImageURL= profileImageURL;
    }
    public void setCreatedAt(String createdAt){
        this.createdAt= createdAt;
    }

    public String getMessage(){
        return this.message;
    }

    public String getTwitterHandle(){
        return this.twitterHandle;
    }

    public String getProfileImageURL(){
        return this.profileImageURL;
    }

    public String getCreatedAt(){
        return this.createdAt;
    }


}
