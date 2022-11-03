package com.example.myapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.RecyclerAdapter;
import com.example.myapp.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    Button sbutton;

    String[] subjects={"ENGLISH","HINDI","MATHEMATICS","MALAYALAM","COMPUTER SCIENCE","PHYSICS","CHEMISTRY"};

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView=root.findViewById(R.id.recycler_subject);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecyclerAdapter adapter = new RecyclerAdapter(this.subjects);
        recyclerView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}