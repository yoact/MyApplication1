package com.example.myapplication1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class Myadapter extends RecyclerView.Adapter<Myadapter.Myholder> {
    List<Map<String,Object>> talk1;
    Context context1;

    // 构造函数，传入数据源和内容
    public Myadapter(List<Map<String,Object>> list, Context context){
        talk1=list;
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
        //holder.textView1.setText(talk1.get(position).get("friend").toString());
        String name=talk1.get(position).get("friend").toString();
        String info=talk1.get(position).get("message").toString();
        int image=Integer.parseInt(talk1.get(position).get("image").toString());
        //获取聊天页面中某个消息详情

        holder.textView1.setText(name);
        holder.imageView1.setImageResource(image);
        //添加点击事件
        holder.textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击后跳转到联系人详情页
                Intent intent=new Intent(context1,Activity_talk.class);
                //向intent传值
                intent.putExtra("friend",name);
                intent.putExtra("message",info);
                intent.putExtra("image",image);

                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //开始跳转
                context1.startActivity(intent);
            }
        });
    }

    // 返回数据源的大小
    @Override
    public int getItemCount() {
        return talk1.size();
    }

    // ViewHolder 类，用于保存 item 中的控件对象
    class Myholder extends RecyclerView.ViewHolder{
        TextView textView1;
        ImageView imageView1;

        public Myholder(@NonNull View itemView) {

            super(itemView);
            // 找到 item 中的 TextView 控件
            textView1=itemView.findViewById(R.id.textView9);
            imageView1=itemView.findViewById(R.id.imageView5);
        }
    }

}