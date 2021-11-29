package com.example.conctactbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText user,password;
    Button logincheck;
    String usertext,passwordtext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user= findViewById(R.id.login_user);
        password=findViewById(R.id.login_password);
        logincheck= findViewById(R.id.button2);
        DBHandler handler=new DBHandler(this);
        logincheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usertext=user.getText().toString();
                passwordtext=password.getText().toString();


                boolean val=handler.passwordcheck(usertext,passwordtext);

                if (val==true){
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Login error", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}