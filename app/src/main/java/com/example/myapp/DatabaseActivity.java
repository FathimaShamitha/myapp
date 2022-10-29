package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.strictmode.SqliteObjectLeakedViolation;

public class DatabaseActivity extends SQLiteOpenHelper {

    public DatabaseActivity(Context context){ super(context,"Login.db",null,1);}

    @Override
    public void onCreate(SQLiteDatabase myDB){
        myDB.execSQL("create table user(username Text primary key,email Text,gender text,password text,country text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB,int oldVersion,int newVersion)
    {
        myDB.execSQL("drop Table if exists user");
    }
    public Boolean insertData(String username,String email,String gender,String password,String country) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("gender", gender);
        contentValues.put("password", password);
        contentValues.put("country", country);
        long result = myDB.insert("user", null, contentValues);

        if (result == -1) {
            return false;
        }
        else{
            return true;
        }
    }
    public Boolean checkusername(String username){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor=myDB.rawQuery("select * from user where username=?",new String[] {username});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean checkusernamepassword(String username,String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor=myDB.rawQuery("select * from user where username=? and password=?",new String[] {username,password});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
}
