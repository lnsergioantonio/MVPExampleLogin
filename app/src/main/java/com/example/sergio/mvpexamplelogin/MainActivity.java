package com.example.sergio.mvpexamplelogin;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sergio.mvpexamplelogin.Presenter.ILoginPresenter;
import com.example.sergio.mvpexamplelogin.Presenter.LoginPresenter;
import com.example.sergio.mvpexamplelogin.View.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {

    ILoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextInputEditText emailText = findViewById(R.id.email);
        final TextInputEditText passwordText = findViewById(R.id.password);
        Button btnLogin = findViewById(R.id.btnlogin);

        loginPresenter = new LoginPresenter(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.onLogin(emailText.getText().toString(),passwordText.getText().toString());
            }
        });
    }

    @Override
    public void loginError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
