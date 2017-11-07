package com.example.andre.testelogin.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.andre.testelogin.Model.SelectUser;
import com.example.andre.testelogin.R;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText1;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button) ;
        editText = (EditText) findViewById(R.id.editText);
        editText1 = (EditText) findViewById(R.id.editText1);

    }

    public void onClick(View view){

        SelectUser selectUser = new SelectUser(this, editText.getText().toString(),editText1.getText().toString());
        selectUser.execute();

    }
}

