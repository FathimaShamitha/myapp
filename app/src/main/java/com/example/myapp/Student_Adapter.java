package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Student_Adapter extends RecyclerView.Adapter<Student_Adapter.MyViewHolder> {

    Context context;
    ArrayList<Student>list;
    int images[];

    public Student_Adapter(Context context,ArrayList<Student> list,int img[]){
        this.context=context;
        this.list=list;
        images=img;
    }

    @NonNull
    @Override
    public Student_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.student_details,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Student student=list.get(position);
        holder.myimage.setImageResource(images[position]);
        holder.name.setText(student.getName());
        holder.course.setText(student.getCourse());
        holder.email.setText(student.getEmail());
        holder.age.setText(String.valueOf(student.getAge()));
        holder.percent.setText(String.valueOf(student.getPercentage()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,course,email,age,percent;
        ImageView myimage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.nametext);
            course=itemView.findViewById(R.id.course);
            email=itemView.findViewById(R.id.email);
            age=itemView.findViewById(R.id.age);
            percent=itemView.findViewById(R.id.percentage);
            myimage=itemView.findViewById(R.id.image1);

        }
    }
}
