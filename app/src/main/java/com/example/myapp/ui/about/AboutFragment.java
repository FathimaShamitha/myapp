package com.example.myapp.ui.about;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapp.JsonData_FetchActivity;
import com.example.myapp.R;
import com.example.myapp.RegisterActivity;
import com.example.myapp.User_FetchActivity;
import com.example.myapp.databinding.FragmentAboutBinding;
import com.example.myapp.databinding.FragmentHomeBinding;
import com.example.myapp.databinding.FragmentSlideshowBinding;
import com.example.myapp.ui.home.HomeViewModel;

public class AboutFragment extends Fragment {

    Button sbutton;
    Button fbutton;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View root=inflater.inflate(R.layout.fragment_about,container,false);
        sbutton=root.findViewById(R.id.jbutton);
        fbutton=root.findViewById(R.id.ubutton);
        sbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchintent=new Intent(AboutFragment.this.getActivity(),JsonData_FetchActivity.class);
                startActivity(searchintent);

            }
        });

        fbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fetchintent=new Intent(AboutFragment.this.getActivity(), User_FetchActivity.class);
                startActivity(fetchintent);
            }
        });

     return  root;


    }

}