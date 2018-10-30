package com.assmob201.poly.assignment.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.assmob201.poly.assignment.Constant;

public class DatabaseHelper extends SQLiteOpenHelper implements Constant{
    private static final String DATABASE_NAME = "School";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_COURSE_TABLE);
        db.execSQL(CREATE_SCHEDULE_TABLE);
        db.execSQL(CREATE_TEST_SCHEDULE_TABLE);
        if (isDEBUG) Log.e("CREATE_COURSE_TABLE", CREATE_COURSE_TABLE);
        if (isDEBUG) Log.e("CREATE_SCHEDULE_TABLE", CREATE_SCHEDULE_TABLE);
        if (isDEBUG) Log.e("CREATE_TEST_TABLE", CREATE_TEST_SCHEDULE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + COURSE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + SCHEDULE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + TEST_SCHEDULE_TABLE);
    }
}
