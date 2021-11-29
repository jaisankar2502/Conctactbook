package com.example.conctactbook;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    private static  final String DB_NAME = "contactdb";
    private static  final int DB_VERSION =1;
    private static  final String TABLE_NAME ="mynumber";
    // table for register
    private static  final String TABLE_NAME2 ="myregister";
    // field for mycontact
    private static  final String ID_COL ="id";
    private static  final String NAME_COL ="name";
    private static  final String NUMBER_COL ="number";
    private static  final String EMAIL_COL ="email";
    // field for registe
    private static  final String ID_COLREG ="id";
    private static  final String USER_NAME ="uname";
    private static  final String PASSORD ="password";
    private static  final String EMAIL2_COL="email";


    Context context;

    public DBHandler(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME_COL + " TEXT, " + NUMBER_COL + " TEXT, " + EMAIL_COL + " TEXT" + "); ";
        String query2= "CREATE TABLE " + TABLE_NAME2 + " (" + ID_COLREG + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USER_NAME + " TEXT, " + PASSORD + " TEXT, " + EMAIL2_COL + " TEXT" + ");";
        db.execSQL(query);
        db.execSQL(query2);


    }
    public void contactadd(String contactName, String contactNumber, String contactEmail) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(NAME_COL,contactName);
        values.put(NUMBER_COL,contactNumber);
        values.put(EMAIL_COL,contactEmail);
        db.insert(TABLE_NAME,null,values);

    }
    public void addregister( String regusername,String regpass, String regemail){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values2 =new ContentValues();
        values2.put(USER_NAME,regusername);
        values2.put(PASSORD,regpass);
        values2.put(EMAIL_COL,regemail);
        db.insert(TABLE_NAME2,null,values2);

    }

    public ArrayList<ContactModel> readContact(){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM " +TABLE_NAME,null);
        ArrayList<ContactModel>contactModelArrayList= new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                contactModelArrayList.add( new ContactModel(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)));
            }while (cursor.moveToNext());
        }
       cursor.close();
        return contactModelArrayList;
    }

    public  boolean passwordcheck(String username,String password){
        SQLiteDatabase db=this.getReadableDatabase();Cursor cursor=db.rawQuery("SELECT * FROM " +TABLE_NAME2 + " WHERE " + USER_NAME + "=?" + "AND " + PASSORD + "=?",new String[]{username,password});
        if (cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);

    }


}
