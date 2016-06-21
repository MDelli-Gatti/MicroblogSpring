package com.theironyard;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by michaeldelli-gatti on 6/20/16.
 */
public class User {
    String username;

    public User(String username) {
        this.username = username;
    }
}
