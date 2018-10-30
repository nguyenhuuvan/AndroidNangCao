package com.assmob201.poly.assignment.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.assmob201.poly.assignment.R;
import com.assmob201.poly.assignment.adapter.AdapterCourseRegistered;
import com.assmob201.poly.assignment.listener.DeleteCourse;
import com.assmob201.poly.assignment.model.Course;
import com.assmob201.poly.assignment.sqlite.CourseDAO;

import java.util.List;

public class CourseRegisteredFragment extends Fragment implements DeleteCourse {
    private RecyclerView lvListCourse;
    CourseDAO courseDAO;
    AdapterCourseRegistered adapterCourseRegistered;
    List<Course> courses;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_registered, container, false);

        lvListCourse = view.findViewById(R.id.lvListCourse_regis);
        courseDAO = new CourseDAO(getActivity());
        courses = courseDAO.getAllCouserByDes("Đang học");
        adapterCourseRegistered = new AdapterCourseRegistered(courses, this);
        lvListCourse.setAdapter(adapterCourseRegistered);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        lvListCourse.setLayoutManager(manager);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
                courses = courseDAO.getAllCouserByDes("Đang học");
                adapterCourseRegistered.changeDataset(courses);
        }
    }

    @Override
    public void deleteCourse(final int postion) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage(getString(R.string.delete_course_message));
        builder.setNegativeButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                long result = courseDAO.updateCourse(courses.get(postion).getID(), courses.get(postion).getName(), "Chưa học");
                if (result > 0) {
                    courses = courseDAO.getAllCouserByDes("Đang học");
                    adapterCourseRegistered.changeDataset(courses);
                } else {
                    Toast.makeText(getActivity(), getString(R.string.delete_failed), Toast.LENGTH_SHORT).show();
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
}
