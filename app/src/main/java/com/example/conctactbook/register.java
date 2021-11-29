package com.example.conctactbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    EditText username,pass,email;
    Button register;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username= findViewById(R.id.login_user);
        pass= findViewById(R.id.login_password);
        email=findViewById(R.id.editTextTextEmailAddress);
        register=findViewById(R.id.button2);
        dbHandler= new DBHandler(register.this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String regusername= username.getText().toString();
                String regpass= pass.getText().toString();
                String regemail=email.getText().toString();
                if (regusername.isEmpty() && regpass.isEmpty() && regemail.isEmpty())
                {
                    Toast.makeText(register.this, "Please enter all", Toast.LENGTH_SHORT).show();
                }

                else
                    {
                    dbHandler.addregister(regusername,regpass,regemail);
                    Toast.makeText(register.this, "register successfully", Toast.LENGTH_SHORT).show();
                    username.getText().clear();
                    pass.getText().clear();
                    email.getText().clear();

                }

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                      Intent i=new Intent(getApplicationContext(),login.class);
                      startActivity(i);
                    }
                }, 3000);



            }
        });
    }
}