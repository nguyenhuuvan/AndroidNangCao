package com.assmob201.poly.assignment.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.assmob201.poly.assignment.R;
import com.assmob201.poly.assignment.model.Course;
import com.assmob201.poly.assignment.model.IntroCourse;

import java.util.List;

public class AdapterIntroCourse  extends RecyclerView.Adapter<AdapterIntroCourse.ViewHolder> {
    private List<IntroCourse> introCourseList;

    public AdapterIntroCourse(List<IntroCourse> introCourseList) {
        this.introCourseList = introCourseList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_intro_course, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        IntroCourse introCourse = introCourseList.get(position);
        holder.tvName.setText(introCourse.getCorseID());
        holder.tvPhong.setText("Phòng: "+ introCourse.getPhong());
        holder.tvLop.setText("Lớp: "+ introCourse.getClasss());
        holder.tvThoiGian.setText(introCourse.getDate());
        holder.tvCa.setText("SLOT "+ introCourse.getCa());

    }

    @Override
    public int getItemCount() {
        if (introCourseList == null) return 0;
        return introCourseList.size();
    }

    public void changeDataset(List<IntroCourse> items) {
        this.introCourseList = items;
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName, tvCa,tvPhong,tvLop,tvThoiGian;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvTen);
            tvCa = itemView.findViewById(R.id.tvca);
            tvPhong = itemView.findViewById(R.id.tvPhong);
            tvLop = itemView.findViewById(R.id.tvLop);
            tvThoiGian = itemView.findViewById(R.id.tvthoigian);
        }

    }
}
