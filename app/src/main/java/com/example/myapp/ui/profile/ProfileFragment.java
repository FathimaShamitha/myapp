package com.example.myapp.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.Student;
import com.example.myapp.Student_Adapter;
import com.example.myapp.databinding.FragmentGalleryBinding;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    RecyclerView recyclerView;
    Student_Adapter adapter;
    ArrayList<Student> list=new ArrayList<>();
    int images[]={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5};

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel galleryViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView=root.findViewById(R.id.recyler_student);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        list=new ArrayList<>();
        addStudent();
        adapter=new Student_Adapter(getActivity(),list,images);
        recyclerView.setAdapter(adapter);

        return root;
    }

    private void addStudent()
    {
        Student stud1=new Student();
        stud1.setName("Jenny");
        stud1.setCourse("Computer Science");
        stud1.setEmail("jenny@gmail.com");
        stud1.setAge(24);
        stud1.setPercentage(89);
        list.add(stud1);

        Student stud2=new Student();
        stud2.setName("Vincent");
        stud2.setCourse("Commerce");
        stud2.setEmail("vin@gmail.com");
        stud2.setAge(24);
        stud2.setPercentage(97);
        list.add(stud2);

        Student stud3=new Student();
        stud3.setName("Ruby");
        stud3.setCourse("Ecnomics");
        stud3.setEmail("ruby@gmail.com");
        stud3.setAge(23);
        stud3.setPercentage(85);
        list.add(stud3);

        Student stud4=new Student();
        stud4.setName("Jane");
        stud4.setCourse("Computer Science");
        stud4.setEmail("jane@gmail.com");
        stud4.setAge(22);
        stud4.setPercentage(77);
        list.add(stud4);

        Student stud5=new Student();
        stud5.setName("Lucas");
        stud5.setCourse("Literature");
        stud5.setEmail("lucas@gmail.com");
        stud5.setAge(23);
        stud5.setPercentage(99);
        list.add(stud5);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}