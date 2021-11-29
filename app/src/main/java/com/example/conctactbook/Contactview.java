package com.example.conctactbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Contactview extends AppCompatActivity {
     ArrayList<ContactModel>contactModelArrayList;
     DBHandler dbHandler;
    ContactviewAdapter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactview);
        recyclerView= findViewById(R.id.contactView);
        contactModelArrayList=new ArrayList<>();
        dbHandler= new DBHandler(Contactview.this);
        contactModelArrayList= dbHandler.readContact();
        adapter=new ContactviewAdapter(contactModelArrayList,Contactview.this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(Contactview.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
