package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private static EditText username;
    private static EditText password;
    private static TextView attempts;
    private static Button login_btn;
    int attempts_counter = 5;

    public void LoginMethod(){
        username = (EditText) findViewById(R.id.personName);
        password = (EditText) findViewById(R.id.password);
        attempts = (TextView) findViewById(R.id.attempts);
        login_btn = (Button) findViewById(R.id.login_button);
        attempts.setText(Integer.toString(attempts_counter));
        login_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (username.getText().toString().equals("user")&& password.getText().toString().equals("pass")){
                    Toast.makeText(login.this, "User name and password is correct",Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(intent);
                    startActivity(new Intent(login.this, user.class));
                }else{
                    Toast.makeText(login.this, "User name or password is incorrect",Toast.LENGTH_SHORT).show();
                    attempts_counter--;
                    attempts.setText(Integer.toString(attempts_counter));
                    if(attempts_counter==0){
                        login_btn.setEnabled(false);
                    }
                }
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginMethod();
    }
}