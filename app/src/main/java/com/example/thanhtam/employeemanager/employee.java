package com.example.thanhtam.employeemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class employee extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "employeee";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "employee";
    private static final String KEY_ID = "_id";
    private static final String KEY_MSNV = "Msnv";
    private static final String KEY_NAME = "fullname";
    private static final String KEY_DOB = "NNaysinh";
    private static final String KEY_ROOM = "Room";
    private static final String KEY_NOTES = "note";

    public employee (Context context){
        super (context, DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table " + TABLE_NAME+
                "("+KEY_ID+" integer primary key autoincrement, "
                +KEY_MSNV+" text, "+KEY_NAME+" text, "
                +KEY_DOB+" text, "
                +KEY_ROOM+" text, "
                +KEY_NOTES+" text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }
    public void taosv(String mssv, String ten, String dob, String room, String notes){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues noidung = new ContentValues();
        noidung.put(KEY_MSNV,mssv);
        noidung.put(KEY_NAME, ten);
        noidung.put(KEY_DOB, dob);
        noidung.put(KEY_ROOM, room);
        noidung.put(KEY_NOTES, notes);

        String nullColumnHack = null;
        db.insert(TABLE_NAME, nullColumnHack,noidung);
    }
    public Cursor getAllSv(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor con_tro = db.rawQuery("select * from "+TABLE_NAME,null);
        return con_tro;
    }

    public boolean xoasv(String mssv){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, KEY_MSNV +" = "+"'"+mssv+"'", null)>0;
    }

    public boolean suasv(String mssv, String ten, String dob, String room, String notes){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues noidung = new ContentValues();
        noidung.put(KEY_MSNV,mssv);
        noidung.put(KEY_NAME, ten);
        noidung.put(KEY_DOB, dob);
        noidung.put(KEY_ROOM, room);
        noidung.put(KEY_NOTES, notes);

        return db.update(TABLE_NAME,noidung,KEY_MSNV+" = "+"'"+mssv+"'", null)>0;
    }



}
