package com.example.tugas7_sqlite_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_rumahsakit";
    private static final String tb_pasien = "tb_pasien";
    private static final String tb_pasien_id = "id";
    private static final String tb_pasien_nama = "nama";
    private static final String tb_pasien_alamat = "alamat";
    private static final String tb_pasien_tindakan = "tindakan";
    private static final String CREATE_TABLE_PASIEN= "CREATE TABLE " + tb_pasien +"("
            + tb_pasien_id + " INTEGER PRIMARY KEY ,"
            + tb_pasien_nama + " TEXT ,"
            + tb_pasien_alamat + " TEXT ,"
            +tb_pasien_tindakan+ "TEXT" + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PASIEN);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreatePasien(Pasien data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_pasien_id, data.get_id());
        values.put(tb_pasien_nama, data.get_nama());
        values.put(tb_pasien_alamat, data.get_alamat());
        values.put(tb_pasien_tindakan, data.get_tindakan());
        db.insert(tb_pasien, null, values);
        db.close();
    }
    public List<Pasien> ReadPasien() {
        List<Pasien> Listpasien = new ArrayList<Pasien>();
        String selectQuery = "SELECT * FROM " + tb_pasien;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Pasien data = new Pasien();
                data.set_id(cursor.getString(0));
                data.set_nama(cursor.getString(1));
                data.set_alamat(cursor.getString(2));
                data.set_tindakan(cursor.getString(3));
                Listpasien.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return Listpasien;}
    public int UpdatePasien (Pasien data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_pasien_nama, data.get_nama());
        values.put(tb_pasien_alamat, data.get_alamat());
        values.put(tb_pasien_tindakan, data.get_tindakan());
        return db.update(tb_pasien, values, tb_pasien_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeletePasien (Pasien data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_pasien,tb_pasien_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
