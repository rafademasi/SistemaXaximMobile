package com.example.andre.testelogin.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.andre.testelogin.Adapter.AdapterEntrega;
import com.example.andre.testelogin.Model.Entrega;
/*
import com.example.andre.testelogin.Model.SelectEntrega;
*/
import com.example.andre.testelogin.Model.SelectEntrega;
import com.example.andre.testelogin.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GerenciarActivity extends AppCompatActivity {

    ListView listView;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenciar);

        listView = (ListView) findViewById(R.id.listView);

        String[] fields = new String[0];
        String[] values = new String[0];
        ListView listView = (ListView)findViewById(R.id.listView);
        SelectEntrega selectEntrega = new SelectEntrega(this, listView, fields,values);
        selectEntrega.execute();

    }


}
