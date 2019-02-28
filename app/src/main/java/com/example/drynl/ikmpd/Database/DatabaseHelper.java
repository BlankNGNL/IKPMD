package com.example.drynl.ikmpd.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by drynl on 6-12-2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static SQLiteDatabase MysqlDB;
    private static DatabaseHelper dbHelperInstance;
    public static final String dbName = "FBI.db";
    public static final  int dbVersion = 3;

    public DatabaseHelper(Context context) {
        super(context,dbName,null,dbVersion);
    }

    public static synchronized DatabaseHelper getHelper(Context context){
        if(dbHelperInstance == null){
            dbHelperInstance = new DatabaseHelper(context);
            MysqlDB = dbHelperInstance.getWritableDatabase();
        }
        return dbHelperInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + DatabaseInfo.GebruikerTables.GEBRUIKER +"" +
                " ("+ BaseColumns._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                DatabaseInfo.GebruikerKolom.NAAM + " TEXT," + DatabaseInfo.GebruikerKolom.WACHTWOORD +" TEXT);") ;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS"+DatabaseInfo.GebruikerTables.GEBRUIKER);
        onCreate(sqLiteDatabase);
    }


    public void insert(String table, String nullColumnHack, ContentValues values){
        MysqlDB.insert(table, nullColumnHack, values);
    }

    public Cursor query(String table, String[] columns, String selection, String[] selectArgs, String groupBy, String having, String orderBy){
        return MysqlDB.query(table, columns, selection, selectArgs, groupBy, having, orderBy);
    }

}
