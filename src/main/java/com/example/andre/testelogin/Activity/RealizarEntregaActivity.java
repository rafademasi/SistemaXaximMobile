package com.example.andre.testelogin.Activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.andre.testelogin.Model.InsertEntrega;
import com.example.andre.testelogin.Model.SelectCliente;
import com.example.andre.testelogin.R;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

/**
 * Created by Rafael on 07/11/2017.
 */

public class RealizarEntregaActivity extends AppCompatActivity {

    Spinner spinner;
    Spinner spinner1;
    EditText editText;
    EditText editText1;
    Button button;
    byte[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizar_entrega);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner1 = (Spinner) findViewById(R.id.spinner2);
        editText = (EditText) findViewById(R.id.editText3);
        editText1 = (EditText) findViewById(R.id.editText2);


        SelectCliente selectCliente = new SelectCliente(this, spinner);
        selectCliente.execute();

        File imgFile = new File("/storage/emulated/0/Android/data/com.example.andre.xaximflores/files/pic.jpg");

        if(imgFile.exists()){

            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

            ImageView myImage = (ImageView) findViewById(R.id.imageView3);

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            myBitmap.compress( Bitmap.CompressFormat.PNG, 0, out);

            data = out.toByteArray();

            Log.v("Tamanho da Imagem", String.valueOf(myBitmap.getAllocationByteCount()));

            myImage.setImageBitmap(myBitmap);


        }




    }

    public void onClick(View view){

        String[] fields = {"id_user","id_cliente","img", "valor", "data", "tipo"};
        String[] values = {String.valueOf(0), String.valueOf(spinner.getSelectedItemPosition()), data.toString() , editText1.getText().toString(), editText.getText().toString(), String.valueOf(spinner1.getSelectedItemPosition())};

        InsertEntrega insertEntrega = new InsertEntrega(fields,values);
        insertEntrega.execute();

    }
}

