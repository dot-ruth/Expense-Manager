package com.example.expense_manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseManager extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Expense.db";
    public DatabaseManager(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query1="create table Income(id integer primary key autoincrement, " + "amount integer, " +
                "category text, "  + " date text)";
        String query2="create table Expense(id integer primary key autoincrement, " + "amount integer, " +
                "category text, "  + " date text)";
        db.execSQL(query1);
        db.execSQL(query2);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS student");
        onCreate(db);
    }


    public void populateIncome(int i1, String i2, String i3){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("amount", i1);
        cv.put("category", i2);
        cv.put("date", i3);
        long  res= db.insert("Income", null, cv);
       db.close();
    }


    public void populateExpense(String i1, String i2, String i3, String i4){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("Amount", i1);
        cv.put("Category", i2);
        cv.put("Date", i3);
        long  res= db.insert("Expense", null, cv);
        db.close();
    }

    public Cursor getIncome(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from Income",null);
        return cursor;
    }

    public Cursor getExpense(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from Expense",null);
        return cursor;
    }
}