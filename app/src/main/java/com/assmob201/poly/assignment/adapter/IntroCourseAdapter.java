package com.assmob201.poly.assignment.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.assmob201.poly.assignment.ui.CourseFragment;
import com.assmob201.poly.assignment.ui.CourseRegisteredFragment;
import com.assmob201.poly.assignment.ui.ScheduleFragment;
import com.assmob201.poly.assignment.ui.ScheduleFragment2;
import com.assmob201.poly.assignment.ui.TestScheduleFragment;
import com.assmob201.poly.assignment.ui.TestScheduleFragment2;

public class IntroCourseAdapter extends FragmentPagerAdapter {

    public IntroCourseAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ScheduleFragment2();
            case 1:
                return new TestScheduleFragment2();
            default:
                return new ScheduleFragment2();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Lịch học";
            case 1:
                return "Lịch thi";
            default:
                return "Lịch học";
        }
    }
}
