package com.assmob201.poly.assignment.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.assmob201.poly.assignment.Constant;
import com.assmob201.poly.assignment.model.IntroCourse;

import java.util.ArrayList;
import java.util.List;

public class LichHocDAO implements Constant{
    private final DatabaseHelper databaseHelper;
    public LichHocDAO(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }
    public long insertLichHoc(String ID,String corseID,String classs,String date,String phong,String ca) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_SCHEDULE_ID, ID);
        contentValues.put(COLUMN_COURSEID, corseID);
        contentValues.put(COLUMN_DATE, date);
        contentValues.put(COLUMN_PHONG, phong);
        contentValues.put(COLUMN_CA, ca);
        contentValues.put(COLUMN_CLASS, classs);
        long result = db.insert(SCHEDULE_TABLE, null, contentValues);
        if (Constant.isDEBUG) Log.e("insertLichHoc", "insertLichHoc ID : " +result);
        db.close();
        return result;
    }
    public List<IntroCourse> getLichHocByCouserID(String ID) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        List<IntroCourse> introCourses = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + SCHEDULE_TABLE+" WHERE "+COLUMN_COURSEID+ " = ?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{ID});
        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndex(COLUMN_SCHEDULE_ID));
                String courseID = cursor.getString(cursor.getColumnIndex(COLUMN_COURSEID));
                String classs = cursor.getString(cursor.getColumnIndex(COLUMN_CLASS));
                String date= cursor.getString(cursor.getColumnIndex(COLUMN_DATE));
                String phong= cursor.getString(cursor.getColumnIndex(COLUMN_PHONG));
                String ca= cursor.getString(cursor.getColumnIndex(COLUMN_CA));
                IntroCourse course = new IntroCourse();
                course.setCa(ca);
                course.setClasss(classs);
                course.setCorseID(courseID);
                course.setDate(date);
                course.setID(id);
                course.setPhong(phong);
                introCourses.add(course);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return introCourses;
    }
    public List<IntroCourse> getLichHoc() {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        List<IntroCourse> introCourses = new ArrayList<>();
        String selectQuery = "SELECT  * FROM SCHEDULES INNER JOIN Courses ON Courses.CourseID = SCHEDULES.CourseID where Description like 'Đang học' order by DATE";
        Cursor cursor = db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndex(COLUMN_SCHEDULE_ID));
                String courseID = cursor.getString(cursor.getColumnIndex(COLUMN_COURSEID));
                String classs = cursor.getString(cursor.getColumnIndex(COLUMN_CLASS));
                String date= cursor.getString(cursor.getColumnIndex(COLUMN_DATE));
                String phong= cursor.getString(cursor.getColumnIndex(COLUMN_PHONG));
                String ca= cursor.getString(cursor.getColumnIndex(COLUMN_CA));
                IntroCourse course = new IntroCourse();
                course.setCa(ca);
                course.setClasss(classs);
                course.setCorseID(courseID);
                course.setDate(date);
                course.setID(id);
                course.setPhong(phong);
                introCourses.add(course);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return introCourses;
    }
}
