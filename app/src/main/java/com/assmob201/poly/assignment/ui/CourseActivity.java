package com.assmob201.poly.assignment.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.assmob201.poly.assignment.R;
import com.assmob201.poly.assignment.adapter.CourseAdapterFragment;
import com.assmob201.poly.assignment.sqlite.CourseDAO;
import com.assmob201.poly.assignment.sqlite.LichHocDAO;
import com.assmob201.poly.assignment.sqlite.LichThiDAO;

public class CourseActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private CourseAdapterFragment adapter;
    private TabLayout tabLayout;
    LichHocDAO lichHocDAO;
    LichThiDAO lichThiDAO;
    CourseDAO courseDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("Khóa học");

        viewPager = findViewById(R.id.viewPagerCourse);
        adapter = new CourseAdapterFragment(this.getSupportFragmentManager());
        tabLayout = findViewById(R.id.tablayoutCourse);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        courseDAO = new CourseDAO(this);
        lichHocDAO = new LichHocDAO(this);
        lichThiDAO= new LichThiDAO(this);
       /* data();*/

    }
    private void data() {
        courseDAO.insertCourse("ENT2212", "Tiếng Anh 2.2", "Chưa học");
        lichHocDAO.insertLichHoc("1","ENT2212","ENT2212.15","01-10-2018","201","1");
        lichHocDAO.insertLichHoc("11","ENT2212","ENT2212.15","10-10-2018","201","1");
        lichHocDAO.insertLichHoc("21","ENT2212","ENT2212.15","20-10-2018","201","1");
        lichHocDAO.insertLichHoc("31","ENT2212","ENT2212.15","30-10-2018","201","1");

        lichThiDAO.insertLichThi("1","ENT2212","ENT2212.15","01-12-2018","401","5");
        lichThiDAO.insertLichThi("11","ENT2212","ENT2212.15","11-12-2018","401","5");

        courseDAO.insertCourse("MOB201", "Lập trình Android nâng cao", "Chưa học");
        lichHocDAO.insertLichHoc("2","MOB201","PT13355-MOB","02-10-2018","202","2");
        lichHocDAO.insertLichHoc("12","MOB201","PT13355-MOB","11-10-2018","202","2");
        lichHocDAO.insertLichHoc("22","MOB201","PT13355-MOB","21-10-2018","202","2");
        lichHocDAO.insertLichHoc("32","MOB201","PT13355-MOB","31-10-2018","202","2");

        lichThiDAO.insertLichThi("2","MOB201","PT13355-MOB","02-12-2018","402","4");
        lichThiDAO.insertLichThi("12","MOB201","PT13355-MOB","12-12-2018","402","4");


        courseDAO.insertCourse("COM1024", "Tin học văn phòng", "Chưa học");
        lichHocDAO.insertLichHoc("3","COM1024","PT13355-MOB","03-10-2018","203","3");
        lichHocDAO.insertLichHoc("13","COM1024","PT13355-MOB","13-10-2018","203","3");
        lichHocDAO.insertLichHoc("23","COM1024","PT13355-MOB","23-10-2018","203","3");
        lichHocDAO.insertLichHoc("33","COM1024","PT13355-MOB","03-11-2018","203","3");

        lichThiDAO.insertLichThi("3","COM1024","PT13355-MOB","03-12-2018","403","3");
        lichThiDAO.insertLichThi("13","COM1024","PT13355-MOB","13-12-2018","403","3");

        courseDAO.insertCourse("COM1032", "Thiết lập và quản trị mạng máy tính", "Chưa học");
        lichHocDAO.insertLichHoc("4","COM1032","PT13355-MOB","04-10-2018","204","4");
        lichHocDAO.insertLichHoc("14","COM1032","PT13355-MOB","14-10-2018","204","4");
        lichHocDAO.insertLichHoc("24","COM1032","PT13355-MOB","24-10-2018","204","4");
        lichHocDAO.insertLichHoc("34","COM1032","PT13355-MOB","04-11-2018","204","4");

        lichThiDAO.insertLichThi("4","COM1032","PT13355-MOB","04-12-2018","404","2");
        lichThiDAO.insertLichThi("14","COM1032","PT13355-MOB","14-12-2018","404","2");

        courseDAO.insertCourse("COM2012", "Cơ sở dữ liệu", "Chưa học");
        lichHocDAO.insertLichHoc("5","COM2012","PT13355-MOB","05-10-2018","205","5");
        lichHocDAO.insertLichHoc("15","COM2012","PT13355-MOB","15-10-2018","205","5");
        lichHocDAO.insertLichHoc("25","COM2012","PT13355-MOB","25-10-2018","205","5");
        lichHocDAO.insertLichHoc("35","COM2012","PT13355-MOB","05-11-2018","205","5");

        lichThiDAO.insertLichThi("5","COM2012","PT13355-MOB","05-12-2018","405","1");
        lichThiDAO.insertLichThi("15","COM2012","PT13355-MOB","15-12-2018","405","1");

        courseDAO.insertCourse("COM2032", "Quản trị cơ sở dữ liệu với SQL Server", "Chưa học");
        lichHocDAO.insertLichHoc("6","COM2032","PT13355-MOB","06-10-2018","206","1");
        lichHocDAO.insertLichHoc("16","COM2032","PT13355-MOB","16-10-2018","206","1");
        lichHocDAO.insertLichHoc("26","COM2032","PT13355-MOB","26-10-2018","206","1");
        lichHocDAO.insertLichHoc("36","COM2032","PT13355-MOB","06-11-2018","206","1");

        lichThiDAO.insertLichThi("6","COM2032","PT13355-MOB","06-12-2018","406","5");
        lichThiDAO.insertLichThi("16","COM2032","PT13355-MOB","16-12-2018","406","5");

        courseDAO.insertCourse("COM2043", "Quản trị server", "Chưa học");
        lichHocDAO.insertLichHoc("7","COM2043","PT13355-MOB","07-10-2018","207","2");
        lichHocDAO.insertLichHoc("17","COM2043","PT13355-MOB","17-10-2018","207","2");
        lichHocDAO.insertLichHoc("27","COM2043","PT13355-MOB","27-10-2018","207","2");
        lichHocDAO.insertLichHoc("37","COM2043","PT13355-MOB","07-11-2018","207","2");

        lichThiDAO.insertLichThi("7","COM2043","PT13355-MOB","07-12-2018","407","4");
        lichThiDAO.insertLichThi("17","COM2043","PT13355-MOB","17-12-2018","407","4");

        courseDAO.insertCourse("MOB1013", "Lập trình Java 1", "Chưa học");
        lichHocDAO.insertLichHoc("8","MOB1013","PT13355-MOB","08-10-2018","208","3");
        lichHocDAO.insertLichHoc("18","MOB1013","PT13355-MOB","18-10-2018","208","3");
        lichHocDAO.insertLichHoc("28","MOB1013","PT13355-MOB","28-10-2018","208","3");
        lichHocDAO.insertLichHoc("38","MOB1013","PT13355-MOB","08-11-2018","208","3");

        lichThiDAO.insertLichThi("8","MOB1013","PT13355-MOB","08-12-2018","408","3");
        lichThiDAO.insertLichThi("18","MOB1013","PT13355-MOB","18-12-2018","408","3");

        courseDAO.insertCourse("MOB1022", "Lập trình Java 2", "Chưa học");
        lichHocDAO.insertLichHoc("9","MOB1022","PT13355-MOB","09-10-2018","209","4");
        lichHocDAO.insertLichHoc("19","MOB1022","PT13355-MOB","19-10-2018","209","4");
        lichHocDAO.insertLichHoc("29","MOB1022","PT13355-MOB","29-10-2018","209","4");
        lichHocDAO.insertLichHoc("39","MOB1022","PT13355-MOB","09-11-2018","209","4");

        lichThiDAO.insertLichThi("9","MOB1022","PT13355-MOB","09-12-2018","409","2");
        lichThiDAO.insertLichThi("19","MOB1022","PT13355-MOB","19-12-2018","409","2");

    }
}
