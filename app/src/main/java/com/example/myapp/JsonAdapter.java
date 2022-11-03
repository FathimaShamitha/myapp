package com.example.myapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.model.Posts;

import java.util.List;

public class JsonAdapter extends RecyclerView.Adapter<JsonAdapter.ViewHolder> {

    Context context;
    List<Posts> list;
    int selectedPosition=-1;

    public JsonAdapter(Context context,List<Posts> list){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public JsonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.json_items,parent,false);
        return new JsonAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JsonAdapter.ViewHolder holder, int position) {
        Posts posts=list.get(position);
        if(posts!=null){
            int userId=posts.getUserId();
            int id=posts.getId();
            String title=posts.getTitle();
            String body=posts.getBody();
            String userDetails = posts.getUserId() + "\n" + posts.getId() + "\n" + posts.getTitle() + "\n" + posts.getBody();
            holder.posts.setText(userDetails);

            holder.itemView.setBackgroundColor(Color.parseColor("#ADD8E6"));

            if(selectedPosition==position)
                holder.itemView.setBackgroundColor(Color.parseColor("#ADD8E6"));
            else
                holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"hello",Toast.LENGTH_SHORT).show();
                    selectedPosition=position;
                    notifyDataSetChanged();
                }
            });
        }

    }

    @Override
    public int getItemCount() { return list.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView posts;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            posts=itemView.findViewById(R.id.json_text);
        }
    }
}
