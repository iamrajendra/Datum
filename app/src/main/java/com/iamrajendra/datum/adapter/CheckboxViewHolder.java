package com.iamrajendra.datum.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iamrajendra.datum.R;
import com.iamrajendra.datum.pojo.CheckModel;

public class CheckboxViewHolder extends RecyclerView.ViewHolder {
    public CheckBox checkBox;
    public TextView title;

    public CheckboxViewHolder(@NonNull View itemView) {
        super(itemView);
        checkBox = itemView.findViewById(R.id.checkbox);
        title = itemView.findViewById(R.id.title);
    }


    public void build(CheckModel checkModel, int position) {
        checkBox.setChecked(checkModel.isState());
        title.setText(checkModel.getName());

    }

    public static View createViewFromLayout(ViewGroup group) {
        View view = LayoutInflater.from(group.getContext()).inflate(R.layout.checkbox_adapter, group, false);
        return view;
    }

}
