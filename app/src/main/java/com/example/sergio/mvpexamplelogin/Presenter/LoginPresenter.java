package com.example.sergio.mvpexamplelogin.Presenter;

import com.example.sergio.mvpexamplelogin.Model.User;
import com.example.sergio.mvpexamplelogin.View.ILoginView;

public class LoginPresenter implements ILoginPresenter{

    ILoginView loginView;

    private final int EMPTY_EMAIL = 1;
    private final int EMPTY_PASSWORD = 2;
    private final int INVALID_EMAIL = 3;
    private final int INVALID_PASSWORD = 4;
    private final int SUCCESS = 0;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email,password);
        int isValid = user.isValidated();

        switch (isValid){
            case EMPTY_EMAIL:
                loginView.loginError("Email vacio");
                break;
            case EMPTY_PASSWORD:
                loginView.loginError("Password vacio");
                break;
            case INVALID_EMAIL:
                loginView.loginError("Email no valido");
                break;
            case INVALID_PASSWORD:
                loginView.loginError("Password no valido");
                break;
            default:
                loginView.loginSuccess("Success");

        }
    }
}
