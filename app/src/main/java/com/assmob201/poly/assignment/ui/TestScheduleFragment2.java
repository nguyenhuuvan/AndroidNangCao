package com.assmob201.poly.assignment.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.assmob201.poly.assignment.R;
import com.assmob201.poly.assignment.adapter.AdapterIntroCourse;
import com.assmob201.poly.assignment.model.IntroCourse;
import com.assmob201.poly.assignment.sqlite.LichThiDAO;

import java.util.List;

public class TestScheduleFragment2 extends Fragment {
    private RecyclerView lvListLichThi;
    LichThiDAO lichThiDAO;
    AdapterIntroCourse adapterIntroCourse;
    List<IntroCourse> introCourses;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_schedule, container, false);
        String ID = getActivity().getIntent().getStringExtra("ID");

        lvListLichThi = view.findViewById(R.id.lvListLichThi);
        lichThiDAO = new LichThiDAO(getActivity());
        introCourses = lichThiDAO.getLichThiByCouserID(ID);
        adapterIntroCourse = new AdapterIntroCourse(introCourses);
        lvListLichThi.setAdapter(adapterIntroCourse);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        lvListLichThi.setLayoutManager(manager);
        return view;
    }
}
