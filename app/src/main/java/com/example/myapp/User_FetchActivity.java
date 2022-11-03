package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapp.model.Address;
import com.example.myapp.model.Company;
import com.example.myapp.model.Geo;
import com.example.myapp.model.User;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class User_FetchActivity extends AppCompatActivity {
    private static final String TAG ="FetchData";
    RecyclerView recyclerView;
    UserAdapter userAdapter;
    List<User> list= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_fetch);

        RecyclerView recyclerView=findViewById(R.id.user_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(User_FetchActivity.this));

        Button button=findViewById(R.id.fetchbutton);

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url="https://jsonplaceholder.typicode.com/users";
                JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, url, null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                Gson gson = new Gson();
                                Type type = new TypeToken<List<User>>() {
                                }.getType();
                                List<User> userList = gson.fromJson(response.toString(), type);
                                userAdapter = new UserAdapter(User_FetchActivity.this, userList);
                                recyclerView.setAdapter(userAdapter);
                                userAdapter.notifyDataSetChanged();

                                for (int i = 0; i < userList.size(); i++) {
                                    User user = userList.get(i);
                                    Address address = user.getAddress();
                                    Geo geo = address.getGeo();
                                    Company company = user.getCompany();
                                }
                                Log.d(TAG, "onResponse: " + userList.toString());
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(User_FetchActivity.this,error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            requestQueue.add(jsonArrayRequest);
            }
        });
    }
}