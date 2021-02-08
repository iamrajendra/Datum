package com.iamrajendra.datum;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iamrajendra.datum.adapter.CheckBoxAdapter;
import com.iamrajendra.datum.pojo.CheckModel;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {
    private RecyclerView recyclerView;
    private String TAG = FirstFragment.class.getSimpleName();
    private List<CheckModel> checkModels = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.checkboxList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<CheckModel> list = new ArrayList<>();
        list.add(new CheckModel().setName("Rajendra Verma "));
        list.add(new CheckModel().setName("Jitendra  Verma "));
        list.add(new CheckModel().setName("Sharmista Paliwal "));
        list.add(new CheckModel().setName("Raksa Barjatiya "));
        list.add(new CheckModel().setName("Lakhan Verma "));
        CheckBoxAdapter checkBoxAdapter = new CheckBoxAdapter(list);
        recyclerView.setAdapter(checkBoxAdapter);
        checkBoxAdapter.setRunnable(new Runnable() {
            @Override
            public void run() {
                checkModels.clear();
                for (int i = 0; i < checkBoxAdapter.getCheckList().size(); i++) {
                    if (checkBoxAdapter.getCheckList().get(i).isState()) {
                        try {
                            checkModels.add((CheckModel) checkBoxAdapter.getCheckList().get(i).clone());
                        } catch (CloneNotSupportedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            checkModels.remove((CheckModel) checkBoxAdapter.getCheckList().get(i).clone());
                        } catch (CloneNotSupportedException e) {
                            e.printStackTrace();
                        }

                    }
                }
                if (checkModels.size()>=2) {
                    checkBoxAdapter.disable(true);
                }else {
                    checkBoxAdapter.disable(false);
                }
                Log.i(TAG, "Selected size" + checkModels.size());
            }
        });


    }
}