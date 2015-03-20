package com.example.SQLiteInit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2015-3-20.
 */
public class SQLiteInit_Book extends SQLiteOpenHelper {
    public static final String DBNAME="Books.db";
    public static final String TABLENAME="books";

    public SQLiteInit_Book(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLENAME+"(" +
                "id integer primary key autoincrement," +
                "isbn varchar(30)," +
                "bookName varchar(255)," +
                "auther varchar(255)," +
                "inDay varchar(30)," +
                "outDay varchar(30)," +
                "status integer(1))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
