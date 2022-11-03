package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Myholder>{

    String data[];
    Context context;

    public RecyclerAdapter(String[] data){
        this.data=data;
        this.context=context;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.subjects,parent,false);
        Myholder myholder=new Myholder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.Myholder holder, int position) {
        holder.textView.setText(data[position]);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked on", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class Myholder extends RecyclerView.ViewHolder{
        TextView textView;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.subject);
        }
    }
}

