package com.example.sergio.mvpexamplelogin.Model;

public interface IUser {
    String getEmail();
    String getPassword();

    int isValidated();
}
