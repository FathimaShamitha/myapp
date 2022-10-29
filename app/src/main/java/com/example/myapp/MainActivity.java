package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button b1,b2;
    DatabaseActivity myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText) findViewById(R.id.editText1);
        password=(EditText) findViewById(R.id.editText2);
        b1 = findViewById(R.id.logbutton);
        b2 = findViewById(R.id.regbutton);

        myDB=new DatabaseActivity(this);


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
                        Intent inten = new Intent(MainActivity.this, NavigationActivity.class);
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

    }
}