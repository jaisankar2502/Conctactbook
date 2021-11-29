package com.example.conctactbook;

public class ContactModel {
    private  String contactName1;
    private String contactNumber1;
    private  String contactEmail1;
    private  int id;
    ContactModel(String contactName,String contactNumber,String contactEmail){
        this.contactName1=contactName;
        this.contactNumber1=contactNumber;
        this.contactEmail1=contactEmail;
    }
    public  String getContactName(){
        return contactName1;
    }
    public  String getContactNumber(){
        return contactNumber1;

    }
    public  String getContactEmail(){
        return contactEmail1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
