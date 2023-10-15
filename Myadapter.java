package com.example.myapplication1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.Myholder> {
    List<String> list1;
    Context context1;

    // 构造函数，传入数据源和内容
    public Myadapter(List list, Context context){
        list1=list;
        context1=context;
    }
    //  创建 ViewHolder，即创建 RecyclerView 中 item 的布局
    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // 加载 item 的布局文件
        View view=LayoutInflater.from(context1).inflate(R.layout.item,parent,false);
        // 创建 ViewHolder 对象
        Myholder myholder=new Myholder(view);

        return myholder;
    }
    // 绑定数据到 ViewHolder 上
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.textView.setText(list1.get(position));

    }
    // 返回数据源的大小
    @Override
    public int getItemCount() {
        return list1.size();
    }

    // ViewHolder 类，用于保存 item 中的控件对象
    class Myholder extends RecyclerView.ViewHolder{
        TextView textView;

        public Myholder(@NonNull View itemView) {

            super(itemView);
            // 找到 item 中的 TextView 控件
            textView=itemView.findViewById(R.id.textView9);
        }
    }

}