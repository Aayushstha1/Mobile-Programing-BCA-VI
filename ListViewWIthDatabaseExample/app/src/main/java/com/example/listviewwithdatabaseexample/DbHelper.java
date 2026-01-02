package com.example.listviewwithdatabaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context) {
        super(context, "productDb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE product (" +
                        "pCode INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name TEXT NOT NULL UNIQUE, " +
                        "quantity INTEGER NOT NULL)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS product");
        onCreate(db);
    }

    public ArrayList<Product> getProducts() {

        ArrayList<Product> products = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM product", null);

        while (c.moveToNext()) {
            Product p = new Product();
            p.setpCode(c.getInt(0));
            p.setName(c.getString(1));
            p.setQuantity(c.getInt(2));
            products.add(p);
        }

        c.close();
        db.close();

        return products;
    }
    public boolean addProduct(Product p) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("pCode", p.getpCode());
        values.put("name", p.getName());
        values.put("quantity", p.getQuantity());
       long id=db.insert("product", null, values);
       return id >0;


    }
    public boolean updateProduct(Product p) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", p.getName());
        values.put("quantity", p.getQuantity());
        int count = db.update("product", values, "pCode=?", new String[]{String.valueOf(p.getpCode())});
        return count ==1;

    }
    public boolean removeProduct(int pCode) {
        SQLiteDatabase db = this.getWritableDatabase();
        int count = db.delete("product", "pCode=?", new String[]{String.valueOf(pCode)});
        return count == 1;
    }

    }




