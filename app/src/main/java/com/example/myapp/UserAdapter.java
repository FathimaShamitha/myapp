package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.model.Address;
import com.example.myapp.model.Company;
import com.example.myapp.model.Geo;
import com.example.myapp.model.User;

import java.util.List;
import java.util.Objects;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    Context context;
    List<User> list;
    int selectedPosition=-1;


    public UserAdapter(Context context,List<User> list){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.user_deatails,parent,false);
        return new UserAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.MyViewHolder holder, int position) {

        User user=list.get(position);

        String userDetails= user.getId() + "\n" + user.getName() + "\n" + user.getUsername() + "\n" +user.getEmail();

        Address address=user.getAddress();
        if(address!=null){
            String street=address.getStreet();
            String suite=address.getSuite();
            String city=address.getCity();
            String zipcode=address.getZipcode();
            String addressDetails=address.getStreet() + "\n" + address.getSuite() + "\n" + address.getCity() + "\n" + address.getZipcode();
            holder.address.setText(addressDetails);

            Geo geo=address.getGeo();
            if(geo!=null){
                String lat=geo.getLat();
                String lng=geo.getLng();
                String geoDetails=geo.getLat() + "\n" + geo.getLng();
                holder.geo.setText(geoDetails);
            }
        }

        Company company=user.getCompany();
        if(company!=null){
            String name=company.getName();
            String catchPhrase=company.getCatchPhrase();
            String bs=company.getBs();
            String companyDetails=company.getName() + "\n" + company.getCatchPhrase() + "\n" + company.getBs();
            holder.company.setText(companyDetails);
        }
        holder.user.setText(userDetails);


        holder.itemView.setBackgroundColor(Color.parseColor("#ADD8E6"));

        if(selectedPosition==position)
            holder.itemView.setBackgroundColor(Color.parseColor("#ADD8E6"));
        else
            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,user.getName(), Toast.LENGTH_SHORT).show();
                selectedPosition=position;
                notifyDataSetChanged();
            }

        });

    }

    @Override
    public int getItemCount() { return list.size(); }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView user,address,geo,company;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            user=itemView.findViewById(R.id.user);
            address=itemView.findViewById(R.id.address);
            geo=itemView.findViewById(R.id.geo);
            company=itemView.findViewById(R.id.company);

//            itemView.setOnTouchListener(new View.OnTouchListener() {
//                @Override
//                public boolean onTouch(View view, MotionEvent motionEvent) {
//                    if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
//                        view.setBackgroundColor(Color.parseColor("#ADD8E6"));
//                    }
//                    if(motionEvent.getAction() == MotionEvent.ACTION_UP || motionEvent.getAction() == MotionEvent.ACTION_CANCEL ){
//                        view.setBackgroundColor(Color.TRANSPARENT);
//                    }
//                    return false;
//                }
//            });
        }
    }
}



