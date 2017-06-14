package com.example.gil.omegaa;

/**
 * Created by GiL on 2017-06-09.
 */

public class Friend {
    public String email;
    public String photo;

    public Friend() {
        // Default constructor required for calls to DataSnapshot.getValue(Comment.class)
    }

    public Friend(String email) {
        this.email = email;
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
