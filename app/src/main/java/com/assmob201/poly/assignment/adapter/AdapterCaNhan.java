package com.assmob201.poly.assignment.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.assmob201.poly.assignment.R;
import com.assmob201.poly.assignment.model.Canhan;

import java.util.List;

public class AdapterCaNhan extends RecyclerView.Adapter<AdapterCaNhan.ViewHolder> {
    private List<Canhan> canhanList;

    public AdapterCaNhan(List<Canhan> canhanList) {
        this.canhanList = canhanList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_gioithieu, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Canhan canhan = canhanList.get(position);
        holder.tvName.setText(canhan.getName());
        holder.tvMota.setText(canhan.getMota());
    }

    @Override
    public int getItemCount() {
        if (canhanList == null) return 0;
        return canhanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName, tvMota;

        public ViewHolder(View itemView) {
            super(itemView);
            tvMota = itemView.findViewById(R.id.tvMota);
            tvName = itemView.findViewById(R.id.tvName);
        }

    }
}
