package com.business.misc;

import android.webkit.JavascriptInterface;

/**
 * Created by User on 25/09/2015.
 */
public class UserCookie {
    private char[] user;
    private char[] pass;

    public UserCookie(String user,String pass) {

        this.user =  user.toCharArray();
        this.pass =  pass.toCharArray();
    }

    @JavascriptInterface
    public char[] getUser()
    {
        return this.user;
    }

    @JavascriptInterface
    public char[] getPass()
    {
        return this.pass;
    }
}
