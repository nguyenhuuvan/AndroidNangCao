package com.assmob201.poly.assignment.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.NavigationView;
import android.util.Log;

import com.assmob201.poly.assignment.Constant;
import com.assmob201.poly.assignment.model.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseDAO implements Constant {
    private final DatabaseHelper databaseHelper;
    public CourseDAO(Context context) {
       databaseHelper = new DatabaseHelper(context);
    }
    public long insertCourse(String ID, String Name, String Des) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_COURSEID, ID);
        contentValues.put(COLUMN_COURSENAME, Name);
        contentValues.put(COLUMN_DESCRIPTION, Des);
        long result = db.insert(COURSE_TABLE, null, contentValues);
        if (Constant.isDEBUG) Log.e("insertCourse", "insertCourse ID : " +result);
        db.close();
        return result;
    }

    public long deleteCourse(int ID) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        long result = db.delete(COURSE_TABLE, COLUMN_COURSEID + " = ?",
                new String[]{String.valueOf(ID)});
        db.close();
        return result;

    }
    public long updateCourse(String ID, String Name, String Des) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_COURSENAME, Name);
        contentValues.put(COLUMN_DESCRIPTION, Des);
        return db.update(COURSE_TABLE, contentValues, COLUMN_COURSEID + " = ?",
                new String[]{String.valueOf(ID)});
    }
    public List<Course> getAllCouserByDes(String des) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        List<Course> courses = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + COURSE_TABLE+" WHERE "+COLUMN_DESCRIPTION+ " = ?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{des});
        if (cursor.moveToFirst()) {
            do {
                String ID = cursor.getString(cursor.getColumnIndex(COLUMN_COURSEID));
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_COURSENAME));
                String descrip = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION));
                Course course = new Course();
                course.setID(ID);
                course.setName(name);
                course.setDes(descrip);
                courses.add(course);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return courses;
    }
    public List<Course> getAllCouser() {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        List<Course> courses = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + COURSE_TABLE;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                String ID = cursor.getString(cursor.getColumnIndex(COLUMN_COURSEID));
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_COURSENAME));
                String descrip = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION));
                Course course = new Course();
                course.setID(ID);
                course.setName(name);
                course.setDes(descrip);
                courses.add(course);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return courses;
    }
}
