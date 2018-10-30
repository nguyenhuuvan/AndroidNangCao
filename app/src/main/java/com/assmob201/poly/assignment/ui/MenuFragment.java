package com.assmob201.poly.assignment.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.assmob201.poly.assignment.FacebookActivity;
import com.assmob201.poly.assignment.R;

public class MenuFragment extends Fragment {
    private ImageView imgCourse;
    private ImageView imgMap;
    private ImageView imgNews;
    private ImageView imgFb;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        imgCourse = view.findViewById(R.id.imgCourse);
        imgMap = view.findViewById(R.id.imgMap);
        imgNews = view.findViewById(R.id.imgNews);
        imgFb = view.findViewById(R.id.imgFb);
        imgNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),NewsActivity.class));
            }
        });
        imgMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),MapsActivity.class));
            }
        });
        imgCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),CourseActivity.class));
            }
        });
        imgFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),FacebookActivity.class));
            }
        });
        return view;
    }

}