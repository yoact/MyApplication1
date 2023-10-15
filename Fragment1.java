package com.example.myapplication1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment {

    RecyclerView recyclerView;
    Myadapter myadapter;
    View view1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view1=new View(getContext());

        view1= inflater.inflate(R.layout.fragment1, container, false);
        recyclerView= view1.findViewById(R.id.recyclerview);

        List<String> list=new ArrayList();
        for (int i=1;i<10;i++){
            list.add("这是第"+i+"行：");
        }

        myadapter=new Myadapter(list,view1.getContext());
        recyclerView.setAdapter(myadapter);

        LinearLayoutManager manager=new LinearLayoutManager(view1.getContext());
        manager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(manager);
        return view1;
    }
}