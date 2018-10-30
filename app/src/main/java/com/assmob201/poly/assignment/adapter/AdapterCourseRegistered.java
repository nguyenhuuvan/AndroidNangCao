package com.assmob201.poly.assignment.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.assmob201.poly.assignment.R;
import com.assmob201.poly.assignment.listener.DeleteCourse;
import com.assmob201.poly.assignment.model.Course;

import java.util.List;

public class AdapterCourseRegistered extends RecyclerView.Adapter<AdapterCourseRegistered.ViewHolder> {
    private List<Course> courseList;
    private DeleteCourse deleteCourse;

    public AdapterCourseRegistered(List<Course> courseList, DeleteCourse deleteCourse) {
        this.courseList = courseList;
        this.deleteCourse = deleteCourse;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_course_registered, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Course course = courseList.get(position);
        holder.tvName.setText("Tên khóa học: " + course.getName());
        holder.tvDes.setText("Trạng thái: " + course.getDes());
        holder.tvID.setText("Mã khóa học: " + course.getID());
        holder.tvDes.setTextColor(Color.BLUE);
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               deleteCourse.deleteCourse(position);
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
        ImageView imgDelete;

        ViewHolder(View itemView) {
            super(itemView);
            imgDelete = itemView.findViewById(R.id.imgDeleteCourse);
            tvID = itemView.findViewById(R.id.tvCourseID_regis);
            tvDes = itemView.findViewById(R.id.tvCourseDes_regis);
            tvName = itemView.findViewById(R.id.tvCourseName_regis);
        }

    }
}
