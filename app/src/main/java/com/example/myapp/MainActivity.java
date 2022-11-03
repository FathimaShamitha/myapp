package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button b1,b2;
    CheckBox remember;
    DatabaseActivity myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.editText1);
        password = (EditText) findViewById(R.id.editText2);
        remember = findViewById(R.id.checkBox);
        b1 = findViewById(R.id.logbutton);
        b2 = findViewById(R.id.regbutton);

        myDB=new DatabaseActivity(this);

        SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
        String checkbox = preferences.getString("remember","");

        if(checkbox.equals("true")){
            Intent logintent=new Intent(MainActivity.this,NavigationDrawerActivity.class);
            startActivity(logintent);
       }
//        else if(checkbox.equals("false")){
//            Toast.makeText(this, "Sign in", Toast.LENGTH_SHORT).show();
//        }

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                String users = username.getText().toString();
                String pass = password.getText().toString();

                if (users.equals("") || pass.equals("")) {
                    Toast.makeText(MainActivity.this, "please enter all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean result = myDB.checkusernamepassword(users, pass);
                    if (result == true) {
                        Intent inten = new Intent(MainActivity.this, NavigationDrawerActivity.class);
                        startActivity(inten);
                    } else {
                        Toast.makeText(MainActivity.this, "Invalid username and password", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(compoundButton.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember","true");
                    editor.apply();
                } else if(!compoundButton.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember","false");
                    editor.apply();
                }
            }
        });

    }
}