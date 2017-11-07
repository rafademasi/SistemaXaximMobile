package com.example.andre.testelogin.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.andre.testelogin.Adapter.AdapterEntrega;
import com.example.andre.testelogin.Model.Entrega;
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

        List<Entrega> entregas = setEntregas();
        listView = (ListView) findViewById(R.id.listView);
        textView1 = (TextView) findViewById(R.id.textView1);
        AdapterEntrega adapter = new AdapterEntrega(entregas, this);
        listView.setAdapter(adapter);

        setUser();
    }

    public List<Entrega> setEntregas(){

        return new ArrayList<>(Arrays.asList(
                new Entrega("John Deere","10/10/2012","Arranjo Floral"),
                new Entrega("Thomson Reuters","10/10/2013","Arranjo Floral"),
                new Entrega("Faculdade de Tecnologia","10/10/2014","Vaso Ornamental"),
                new Entrega("John Deere","10/10/2015","Vaso Ornamental"),
                new Entrega("Faculdade de Tecnologia","10/10/2016","Arranjo Floral"),
                new Entrega("Thomson Reuters","10/10/2017","Vaso Ornamental")));
    }

    public void setUser(){

        Intent intent = getIntent();
        String nome = intent.getStringExtra(Intent.EXTRA_TEXT);

        textView1.setText(nome);

    }

}
