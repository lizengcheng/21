package com.example.u.a21.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by U on 2017/12/26.
 */

public class DBOpenHelper extends SQLiteOpenHelper{
    private static final int VERSION=1;                    //定义数据库版本号
    private static final String DBNAME="account.db";       //定义数据库名
    public DBOpenHelper(Context context){                  //定义构造函数
        super(context , DBNAME , null , VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
