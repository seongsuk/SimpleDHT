package edu.buffalo.cse.cse486586.simpledht;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class myDatabase  extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "main.db";
    public static int DATABASE_VERSION= 1;
    public static final String TABLE_NAME= "main";
    public static final String KEY_FIELD= "key";
    public static final String VALUE_FIELD = "value";
    public static final String START_SQL = "CREATE TABLE " + TABLE_NAME + " (" +
            KEY_FIELD + " STRING, " +
            VALUE_FIELD + " STRING);";

    public myDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase arg0) {
        arg0.execSQL(START_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        arg0.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(arg0);
    }



}