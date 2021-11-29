package com.example.conctactbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    EditText name,number,email;
    Button addContact;
    DBHandler dbHandler;
    FloatingActionButton viewcontact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name= findViewById(R.id.editTextTextPersonName);
        number=findViewById(R.id.editTextTextPersonName2);
        email=findViewById(R.id.editTextTextPersonName3);
        addContact= findViewById(R.id.button);
        viewcontact=findViewById(R.id.floatingActionButton2);
        dbHandler= new DBHandler(MainActivity.this);
        viewcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),Contactview.class);
                startActivity(intent);

            }
        });
        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String contactName= name.getText().toString();
                String contactNumber=number.getText().toString();
                String contactEmail= email.getText().toString();
                if (contactName.isEmpty()&&contactNumber.isEmpty()&&contactEmail.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter all", Toast.LENGTH_SHORT).show();
                }else {
                    dbHandler.contactadd(contactName,contactNumber,contactEmail);
                    Toast.makeText(MainActivity.this, "Added Successful", Toast.LENGTH_SHORT).show();
                    name.getText().clear();
                    number.getText().clear();
                    email.getText().clear();

                }


            }
        });

    }
}