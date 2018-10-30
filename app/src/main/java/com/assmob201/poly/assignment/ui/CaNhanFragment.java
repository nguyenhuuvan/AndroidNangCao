package com.assmob201.poly.assignment.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.assmob201.poly.assignment.adapter.AdapterCaNhan;
import com.assmob201.poly.assignment.model.Canhan;

import java.util.ArrayList;
import java.util.List;
import com.assmob201.poly.assignment.R;

public class CaNhanFragment extends Fragment {
    RecyclerView recyclerView;
    AdapterCaNhan adapterCaNhan;
    List<Canhan> canhans;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_canhan,container,false);
        recyclerView = view.findViewById(R.id.lvListcaNhan);
        canhans = new ArrayList<>();
        fakeDate();
        adapterCaNhan = new AdapterCaNhan(canhans);
        recyclerView.setAdapter(adapterCaNhan);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        return view;
    }
    public void fakeDate(){
        Canhan canhan = new Canhan("vannhph06247","Tên đăng nhập");
        canhans.add(canhan);
        Canhan canhan2 = new Canhan("Nguyễn Hữu Văn","Họ tên");
        canhans.add(canhan2);
        Canhan canhan3 = new Canhan("PH06247","Mã sinh viên");
        canhans.add(canhan3);
        Canhan canhan4 = new Canhan("Nam","Giới tính");
        canhans.add(canhan4);
        Canhan canhan5 = new Canhan("19/10/1998","Sinh ngày");
        canhans.add(canhan5);
        Canhan canhan6 = new Canhan("vannhph06247@fpt.edu.vn","Email");
        canhans.add(canhan6);
        Canhan canhan7 = new Canhan("13.3","Khóa");
        canhans.add(canhan7);
        Canhan canhan8 = new Canhan("Công nghệ thông tin","Chuyên ngành");
        canhans.add(canhan8);
        Canhan canhan9 = new Canhan("Lập trình máy tính thiết bị di động","Nội dung đào tạo");
        canhans.add(canhan9);
        Canhan canhan10 = new Canhan("175043235","CMND/Hộ chiếu");
        canhans.add(canhan10);
        Canhan canhan11 = new Canhan("26/12/2015","Ngày cấp");
        canhans.add(canhan11);
        Canhan canhan12 = new Canhan("Thanh Hóa","Nơi cấp");
        canhans.add(canhan12);
        Canhan canhan13 = new Canhan("Cao Đẳng","Hệ đào tạo");
        canhans.add(canhan13);
        Canhan canhan14 = new Canhan("Học đi","Trạng thái");
        canhans.add(canhan14);
        Canhan canhan15 = new Canhan("3","Kì");
        canhans.add(canhan15);
    }
}
