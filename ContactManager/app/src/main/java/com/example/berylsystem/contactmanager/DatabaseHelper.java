package com.example.berylsystem.contactmanager;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DTATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";

    public DatabaseHelper(Context context) {
        super(context, DTATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTERGER PRIMARY KEY,NAME TEXT,MOBILE_NUMBER INTEGER,EMAIL_ID TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, int mobile_number, String email_id) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("MOBILE_NUMBER", mobile_number);
        contentValues.put("EMAIL_ID", email_id);

        long result = db.insert(TABLE_NAME,null,contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getData(String mobile_number){
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT *FROM" + TABLE_NAME + "WHERE MOBILE_NUMBER = '" +mobile_number+ "'";

        Cursor cursor = db.rawQuery(query,null);

        return cursor;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " +TABLE_NAME,null);
        return res;
    }

    public void deleteData(String mobile_number)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME,"MOBILE_NUMBER = '"+mobile_number+"'",null);
        db.close();

    }

    public void updateData(String mobile_number,String name,String email_id){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("EMAIL_ID", email_id);
        db.update(TABLE_NAME,contentValues,"MOBILE_NUMBER = '"+mobile_number+"'",null);
    }
}