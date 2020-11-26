package com.bridgelabz.greetingapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Greeting {

    @Id
    private long greetingId;
    private String message;

//    public Greeting() {
//        greetingId = 0;
//        message = "";
//    }

    public Greeting(long greetingId, String message) {
        this.greetingId = greetingId;
        this.message = message;
    }

    public Greeting() {
    }

    public long getGreetingId() {
        return greetingId;
    }

    public String getMessage() {
        return message;
    }

    public void setGreetingId(long greetingId) {
        this.greetingId = greetingId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "greetingId=" + greetingId +
                ", message='" + message + '\'' +
                '}';
    }
}