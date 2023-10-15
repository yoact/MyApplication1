package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity1 extends AppCompatActivity implements View.OnClickListener {
    Fragment fragment1,fragment2,fragment3,fragment4;
    LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4;
    static final int l1=R.id.linearLayout1;
    static final int l2=R.id.linearLayout2;
    static final int l3=R.id.linearLayout3;
    static final int l4=R.id.linearLayout4;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        linearLayout1=findViewById(R.id.linearLayout1);
        linearLayout2=findViewById(R.id.linearLayout2);
        linearLayout3=findViewById(R.id.linearLayout3);
        linearLayout4=findViewById(R.id.linearLayout4);

        fm=getSupportFragmentManager();
        fragment1=new Fragment1();
        fragment2=new Fragment2();
        fragment3=new Fragment3();
        fragment4=new Fragment4();

        innitial();
        fragmentHide();
        fragmentshow(fragment1);
        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);

    }

    private void fragmentHide() {
        FragmentTransaction ft=fm.beginTransaction()
                .hide(fragment1)
                .hide(fragment2)
                .hide(fragment3)
                .hide(fragment4);
        ft.commit();
    }

    private void  fragmentshow(Fragment fragment){
        fragmentHide();
        FragmentTransaction ft=fm.beginTransaction()
                .show(fragment);
        ft.commit();
    }

    private void innitial() {
        FragmentTransaction ft=fm.beginTransaction()
                .add(R.id.content,fragment1)
                .add(R.id.content,fragment2)
                .add(R.id.content,fragment3)
                .add(R.id.content,fragment4);
        ft.commit();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == l1) {
            fragmentshow(fragment1);
        }
        else if (view.getId() == l2) {
            fragmentshow(fragment2);
        }
        else if (view.getId() == l3) {
            fragmentshow(fragment3);
        }
        else if (view.getId() == l4) {
            fragmentshow(fragment4);
        }

    }

}