package com.assmob201.poly.assignment.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.assmob201.poly.assignment.R;
import com.assmob201.poly.assignment.adapter.CourseAdapterFragment;
import com.assmob201.poly.assignment.adapter.IntroCourseAdapter;

public class IntroCourseActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private IntroCourseAdapter adapter;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_course);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("Thông tin khóa học");

        viewPager = findViewById(R.id.viewPage_Intro_Course);
        adapter = new IntroCourseAdapter(this.getSupportFragmentManager());
        tabLayout = findViewById(R.id.tablayout_Intro_Course);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }


}
