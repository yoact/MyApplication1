package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_talk extends AppCompatActivity {
    TextView textView1,textView2;
    ImageView imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk);
        textView1 = findViewById(R.id.name);
        textView2 = findViewById(R.id.info);
        imageView1 = findViewById(R.id.imageView);

        //获取上一个Fragment1传过来的intent
        Intent intent=getIntent();

        //根据intent获取得到的数据设置item控件的值
        imageView1.setImageResource(intent.getIntExtra("image",R.drawable.girl1));
        textView1.setText(intent.getStringExtra("friend"));
        textView2.setText(intent.getStringExtra("message"));


    }
}