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

import com.assmob201.poly.assignment.adapter.AdapterCaNhan;
import com.assmob201.poly.assignment.model.Canhan;

import java.util.ArrayList;
import java.util.List;

public class GioiThieuFragment extends Fragment {
    RecyclerView recyclerView;
    AdapterCaNhan adapterCaNhan;
    List<Canhan> canhans;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gioithieu,container,false);
        recyclerView = view.findViewById(R.id.lvListgioiThieu);
        canhans = new ArrayList<>();
        fakeDate();
        adapterCaNhan = new AdapterCaNhan(canhans);
        recyclerView.setAdapter(adapterCaNhan);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        return view;
    }
    public void fakeDate(){
        Canhan canhan = new Canhan("Hỗ trợ học tập","Tên phần mềm");
        canhans.add(canhan);
        Canhan canhan2 = new Canhan("11/10/2018","Ngày tạo");
        canhans.add(canhan2);
        Canhan canhan3 = new Canhan("Nguyễn Hữu Văn","Tác giả");
        canhans.add(canhan3);
        Canhan canhan4 = new Canhan("13.3","Khóa");
        canhans.add(canhan4);
    }

}
