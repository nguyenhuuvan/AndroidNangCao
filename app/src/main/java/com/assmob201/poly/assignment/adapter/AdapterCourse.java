package com.assmob201.poly.assignment.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.assmob201.poly.assignment.R;
import com.assmob201.poly.assignment.listener.AddCourse;
import com.assmob201.poly.assignment.listener.OnClick;
import com.assmob201.poly.assignment.model.Course;
import com.assmob201.poly.assignment.ui.IntroCourseActivity;

import java.util.List;

public class AdapterCourse extends RecyclerView.Adapter<AdapterCourse.ViewHolder> {
    private List<Course> courseList;
    private AddCourse addCourse;
    OnClick onClick;
    public AdapterCourse(List<Course> courseList,AddCourse addCourse,OnClick onClick) {
        this.courseList = courseList;
        this.addCourse=addCourse;
        this.onClick=onClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_course, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Course course = courseList.get(position);
        holder.tvName.setText("Tên khóa học: "+course.getName());
        holder.tvDes.setText("Trạng thái: "+course.getDes());
        holder.tvID.setText("Mã khóa học: "+course.getID());
        if(course.getDes().equalsIgnoreCase("chưa học"))
        holder.tvDes.setTextColor(Color.RED);
        if(course.getDes().equalsIgnoreCase("đang học"))
            holder.tvDes.setTextColor(Color.BLUE);
        holder.imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCourse.addCourse(position);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onClick(course.getID());
            }
        });

    }
    public void changeDataset(List<Course> items) {
        this.courseList = items;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if (courseList == null) return 0;
        return courseList.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder {
         TextView tvName, tvID, tvDes;
            ImageView imgAdd;
         ViewHolder(View itemView) {
            super(itemView);
            imgAdd = itemView.findViewById(R.id.imgAddCourse);
            tvID = itemView.findViewById(R.id.tvCourseID);
            tvDes = itemView.findViewById(R.id.tvCourseDes);
            tvName = itemView.findViewById(R.id.tvCourseName);
        }

    }
}
