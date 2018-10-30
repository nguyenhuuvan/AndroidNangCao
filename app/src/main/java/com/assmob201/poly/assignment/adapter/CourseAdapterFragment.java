package com.assmob201.poly.assignment.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.assmob201.poly.assignment.ui.CourseFragment;
import com.assmob201.poly.assignment.ui.CourseRegisteredFragment;
import com.assmob201.poly.assignment.ui.ScheduleFragment;
import com.assmob201.poly.assignment.ui.TestScheduleFragment;

public class CourseAdapterFragment extends FragmentPagerAdapter {

    public CourseAdapterFragment(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CourseFragment();
            case 1:
                return new CourseRegisteredFragment();
            case 2:
                return new ScheduleFragment();
            case 3:
                return new TestScheduleFragment();
            default:
                return new CourseFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Danh sách";
            case 1:
                return "Đã đăng kí";
            case 2:
                return "Lịch học";
            case 3:
                return "Lịch thi";
            default:
                return "Danh sách";
        }
    }
}
