package com.example.andre.testelogin.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.andre.testelogin.R;


public class MenuFuncActivity extends AppCompatActivity {

    TextView textView1;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_func);

        textView1 = (TextView) findViewById(R.id.textView1);
        button1 = (Button) findViewById(R.id.button1) ;

        setUser();
    }

    public void onClick(View view){
        Intent intent = new Intent(this, GerenciarActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, getIntent().getStringExtra(Intent.EXTRA_TEXT).toString());
        startActivity(intent);
    }

    public void setUser(){

        Intent intent = getIntent();
        String nome = intent.getStringExtra(Intent.EXTRA_TEXT);

        textView1.setText("Olá, "+nome);

    }
}
