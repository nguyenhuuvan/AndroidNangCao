package com.assmob201.poly.assignment;

public interface Constant {
    boolean isDEBUG = true;

    String COURSE_TABLE = "Courses";
    String COLUMN_COURSEID = "CourseID";
    String COLUMN_COURSENAME = "CourseName";
    String COLUMN_DESCRIPTION = "Description";

    String CREATE_COURSE_TABLE = "CREATE TABLE IF NOT EXISTS " + COURSE_TABLE + "(" +
            COLUMN_COURSEID + " VARCHAR PRIMARY KEY," +
            COLUMN_COURSENAME + " VARCHAR," +
            COLUMN_DESCRIPTION + " VARCHAR" +
            ")";


    String SCHEDULE_TABLE = "SCHEDULES";
    String COLUMN_SCHEDULE_ID = "SCHEDULE_ID";
    String COLUMN_CLASS = "CLASS";
    String COLUMN_DATE = "DATE";
    String COLUMN_PHONG = "PHONG";
    String COLUMN_CA = "CA";

    String CREATE_SCHEDULE_TABLE = "CREATE TABLE IF NOT EXISTS " + SCHEDULE_TABLE + "(" +
            "" + COLUMN_SCHEDULE_ID + " VARCHAR PRIMARY KEY," +
            "" + COLUMN_COURSEID + " VARCHAR," +
            "" + COLUMN_CLASS + " VARCHAR," +
            "" + COLUMN_PHONG + " VARCHAR," +
            "" + COLUMN_DATE + " VARCHAR," +
            "" + COLUMN_CA + " VARCHAR" +
            ")";

    String TEST_SCHEDULE_TABLE = "TEST_SCHEDULES";
    String COLUMN_TEST_SCHEDULE_ID = "TEST_SCHEDULE_ID";

    String CREATE_TEST_SCHEDULE_TABLE = "CREATE TABLE IF NOT EXISTS " + TEST_SCHEDULE_TABLE + "(" +
            "" + COLUMN_TEST_SCHEDULE_ID + " VARCHAR PRIMARY KEY," +
            "" + COLUMN_COURSEID + " VARCHAR," +
            "" + COLUMN_CLASS + " VARCHAR," +
            "" + COLUMN_PHONG + " VARCHAR," +
            "" + COLUMN_DATE + " VARCHAR," +
            "" + COLUMN_CA + " VARCHAR" +
            ")";
}