package com.business.misc;

import android.webkit.JavascriptInterface;

/**
 * Created by User on 25/09/2015.
 */
public class UserCookie {
    private String id;
    private char[] user;
    private char[] pass;

    public UserCookie(String id,String user,String pass) {
        this.id = id;
        this.user =  user.toCharArray();
        this.pass =  pass.toCharArray();
    }

    @JavascriptInterface
    public String getUser()
    {
        return String.valueOf(this.user);
    }

    @JavascriptInterface
    public String getPass()
    {
        return String.valueOf(this.pass);
    }
    @JavascriptInterface
    public String getId() {
        return id;
    }
}
