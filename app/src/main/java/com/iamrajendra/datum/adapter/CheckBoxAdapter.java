package com.iamrajendra.datum.adapter;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iamrajendra.datum.pojo.CheckModel;

import java.util.ArrayList;
import java.util.List;

public class CheckBoxAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private String TAG = CheckBoxAdapter.class.getSimpleName();
    private List<CheckModel> checkList;
    private  Runnable runnable;
    private boolean checkDisable;

    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    public CheckBoxAdapter(List<CheckModel> checkList) {
        this.checkList = checkList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CheckboxViewHolder(CheckboxViewHolder.createViewFromLayout(parent));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CheckboxViewHolder checkboxViewHolder = (CheckboxViewHolder) holder;
        checkboxViewHolder.build(checkList.get(position), position);
        CheckModel checkModel = checkList.get(position);


        checkboxViewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkDisable){
                    checkList.get(position).setState(false);
                    checkboxViewHolder.checkBox.setChecked(false);
                }

                    checkList.get(position).setState(checkboxViewHolder.checkBox.isChecked());

                Handler h = new Handler();
                h.postDelayed(runnable,500);
            }
        });


    }

    public List<CheckModel> getCheckList() {
        return checkList;
    }

    @Override
    public int getItemCount() {
        return checkList.size();
    }

    public void disable(boolean b) {
        checkDisable =b;
    }
}
