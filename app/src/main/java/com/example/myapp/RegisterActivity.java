package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText username,email,password,repassword;
    Button b3;
    String gender;
    DatabaseActivity myDB;
    RadioButton rmale,rfemale;
    Spinner country;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        country=findViewById(R.id.spinner);
        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this,R.array.country,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        country.setAdapter(adapter);
        country.setOnItemSelectedListener(this);

        username=(EditText)findViewById(R.id.editText3);
        email=(EditText)findViewById(R.id.editText4);
        password=(EditText)findViewById(R.id.editText5);
        repassword=(EditText)findViewById(R.id.editText6);

        rmale=findViewById(R.id.radioButton2);
        rfemale=findViewById(R.id.radioButton1);
        myDB=new DatabaseActivity(this);

        b3=findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String users=username.getText().toString();
                String mail=email.getText().toString();
                String pass=password.getText().toString();
                String repass=repassword.getText().toString();
                String count=country.getSelectedItem().toString();

                 if(rmale.isChecked()){
                     gender=rmale.getText().toString();
                 }
                 else if(rfemale.isChecked()){
                     gender=rfemale.getText().toString();
                 }
                if(users.equals("") || mail.equals("") || pass.equals("") || repass.equals("")){
                    Toast.makeText(RegisterActivity.this,"Fill all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(pass.equals(repass)){
                        Boolean usercheckResult=myDB.checkusername(users);
                        if(usercheckResult==false){
                            Boolean regResult=myDB.insertData(users,mail,gender,pass,count);
                            if (regResult==true){
                                Toast.makeText(RegisterActivity.this,"Registration succesful",Toast.LENGTH_SHORT).show();
                                Intent intreg=new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intreg);
                            }
                            else{
                                Toast.makeText(RegisterActivity.this,"Registration failed",Toast.LENGTH_SHORT).show();
                            }
                        } else{
                            Toast.makeText(RegisterActivity.this,"User already exists",Toast.LENGTH_SHORT).show();
                        }
                    } else{
                        Toast.makeText(RegisterActivity.this,"password not matching",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}