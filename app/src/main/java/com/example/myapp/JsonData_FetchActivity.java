package com.example.myapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapp.model.Posts;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonData_FetchActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    JsonAdapter jsonAdapter;
    List<Posts> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_data_fetch);

        RecyclerView recyclerView=findViewById(R.id.json_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(JsonData_FetchActivity.this));

        Button button=findViewById(R.id.json_button);

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="https://jsonplaceholder.typicode.com/posts";
                JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                Gson gson = new Gson();
                                Type type = new TypeToken<List<Posts>>() {}.getType();
                                List<Posts> post = gson.fromJson(response.toString(), type);
                                jsonAdapter = new JsonAdapter(JsonData_FetchActivity.this, post);
                                recyclerView.setAdapter(jsonAdapter);
                                jsonAdapter.notifyDataSetChanged();

                                for (int i = 0; i < post.size(); i++) {
                                    Posts post1 = post.get(i);

                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(JsonData_FetchActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

                requestQueue.add(jsonArrayRequest);
            }
        });
    }
}