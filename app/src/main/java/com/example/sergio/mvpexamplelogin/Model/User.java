package com.example.sergio.mvpexamplelogin.Model;

import android.text.TextUtils;
import android.util.Patterns;

import java.security.PrivilegedAction;
import java.util.regex.Pattern;

public class User implements IUser{

    private String email, password;
    private final int EMPTY_EMAIL = 1;
    private final int EMPTY_PASSWORD = 2;
    private final int INVALID_EMAIL = 3;
    private final int INVALID_PASSWORD = 4;
    private final int SUCCESS = 0;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public int isValidated() {

        if (TextUtils.isEmpty(this.email))
            return this.EMPTY_EMAIL;
        else if (TextUtils.isEmpty(this.password))
            return this.EMPTY_PASSWORD;
        else if (!Patterns.EMAIL_ADDRESS.matcher(this.email).matches())
            return this.INVALID_EMAIL;
        else if (this.password.length() < 6)
            return this.INVALID_PASSWORD;
        else
            return this.SUCCESS;
    }
}
