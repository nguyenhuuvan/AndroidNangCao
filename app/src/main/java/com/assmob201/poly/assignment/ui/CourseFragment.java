package com.assmob201.poly.assignment.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.assmob201.poly.assignment.R;
import com.assmob201.poly.assignment.adapter.AdapterCourse;
import com.assmob201.poly.assignment.listener.AddCourse;
import com.assmob201.poly.assignment.listener.OnClick;
import com.assmob201.poly.assignment.model.Course;
import com.assmob201.poly.assignment.sqlite.CourseDAO;
import com.assmob201.poly.assignment.sqlite.LichHocDAO;

import java.util.ArrayList;
import java.util.List;


public class CourseFragment extends Fragment implements AddCourse,OnClick {
    private RecyclerView lvListCourse;
    CourseDAO courseDAO;
    AdapterCourse adapterCourse;
    List<Course> courses;
    LichHocDAO lichHocDAO;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course, container, false);
        lvListCourse = view.findViewById(R.id.lvListCourse);

        courseDAO = new CourseDAO(getActivity());
        lichHocDAO = new LichHocDAO(getActivity());
        courses = courseDAO.getAllCouser();
        adapterCourse = new AdapterCourse(courses, this,this);
        lvListCourse.setAdapter(adapterCourse);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        lvListCourse.setLayoutManager(manager);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (getView() != null) {
                courses = courseDAO.getAllCouser();
                adapterCourse.changeDataset(courses);
            }
        }
    }

    @Override
    public void addCourse(final int postion) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage(getString(R.string.add_course_message));
        builder.setNegativeButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (courses.get(postion).getDes().equalsIgnoreCase("đang học")) {
                    Toast.makeText(getActivity(), "Bạn đã đăng kí khóa học này rồi", Toast.LENGTH_SHORT).show();
                } else {
                    long result = courseDAO.updateCourse(courses.get(postion).getID(), courses.get(postion).getName(), "Đang học");
                    if (result > 0) {
                        courses = courseDAO.getAllCouser();
                        adapterCourse.changeDataset(courses);
                    } else {
                        Toast.makeText(getActivity(), getString(R.string.add_failed), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        builder.setPositiveButton(

                getString(R.string.no), new DialogInterface.OnClickListener()

                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.show();
    }

    @Override
    public void onClick(String ID) {
        Intent intent = new Intent(getActivity(), IntroCourseActivity.class);
        intent.putExtra("ID", ID);
        startActivity(intent);
    }
}
