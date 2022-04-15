package com.example.careshipapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivityLoginPage extends AppCompatActivity {

    EditText username, password;
    MaterialButton loginButton, createAccountButton2;
    DBHelperClass database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login_page);

        username = (EditText) findViewById(R.id.Username2);
        password = (EditText) findViewById(R.id.password2);
        loginButton = (MaterialButton) findViewById(R.id.LoginButton);
        createAccountButton2 = (MaterialButton) findViewById(R.id.CreateAccountButton2);
        database = new DBHelperClass(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = username.getText().toString();
                String passwrd = password.getText().toString();

                if(email.isEmpty() || passwrd.isEmpty()){
                    Toast.makeText(MainActivityLoginPage.this, "Please enter valid credentials.", Toast.LENGTH_SHORT).show();
                }
                Boolean userCheck = database.userExistsCheck(email, passwrd);


                if(userCheck == true){
                    Toast.makeText(MainActivityLoginPage.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), CustomerItemVerify.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivityLoginPage.this, "Login failed, incorrect username or password, please try again.", Toast.LENGTH_SHORT).show();
                }

            }
        });
        createAccountButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivityCreateAccount.class);
                startActivity(intent);
            }
        });
    }
}