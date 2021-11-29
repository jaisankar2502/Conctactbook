package com.example.conctactbook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactviewAdapter extends RecyclerView.Adapter<ContactviewAdapter.Holder> {
Context context;
public ArrayList<ContactModel>contactModelArrayList;
    ContactModel model;

    public ContactviewAdapter(ArrayList<ContactModel> contactModelArrayList, Contactview contactview) {
        this.contactModelArrayList=contactModelArrayList;
        this.context=contactview;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from( parent.getContext()).inflate(R.layout.contact_list,parent,false);
        Holder holder= new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
     model  =contactModelArrayList.get(position);
        holder.contactname.setText(model.getContactName());
        holder.contactnumber.setText(model.getContactNumber());
        holder.contactemail.setText(model.getContactEmail());

    }

    @Override
    public int getItemCount() {
        return contactModelArrayList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView contactname,contactnumber,contactemail;

        public Holder(View itemView) {
            super(itemView);
            contactname=itemView.findViewById(R.id.nameView);
            contactnumber=itemView.findViewById(R.id.numberView);
            contactemail=itemView.findViewById(R.id.emailView);
        }
    }
}
