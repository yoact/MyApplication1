package com.example.myapplication1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fragment1 extends Fragment {
    RecyclerView recyclerView;
    Myadapter myadapter;
    View view1;
    Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view1=new View(getContext());

        view1= inflater.inflate(R.layout.fragment1, container, false);
        recyclerView= view1.findViewById(R.id.recyclerview);

        //聊天页面展示
        String[] friends = {"叶苏","白榆","胡杨","林竹","江叙","陈冀","楚安","许然","邱望","白景"};
        String[] info = { "你好。","再见。","谢谢。","早上好。","今天天气真好。",
                "你吃饭了吗？","明天见。","是真的吗？","原来如此。","你说得对。",};
        int[] images={R.drawable.girl1,R.drawable.girl2,R.drawable.man1,R.drawable.girl3,R.drawable.man2,
                R.drawable.man3,R.drawable.man4,R.drawable.girl4,R.drawable.girl5,R.drawable.man5};

        List<Map<String,Object>> talk2=new ArrayList<Map<String,Object>>();
        for(int i=0;i<friends.length;i++) {
            Map<String,Object> it=new HashMap<String,Object>();
            it.put("friend",friends[i]);
            it.put("message",info[i]);
            it.put("image",images[i]);
            talk2.add(it);
        }

        context=getContext();
        myadapter=new Myadapter(talk2,context);
        recyclerView.setAdapter(myadapter);
        LinearLayoutManager manager=new LinearLayoutManager(view1.getContext());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);

        return view1;
    }
}