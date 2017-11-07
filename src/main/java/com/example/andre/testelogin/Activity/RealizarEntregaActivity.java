package com.example.andre.testelogin.Activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.example.andre.testelogin.R;

import java.io.File;

/**
 * Created by Rafael on 07/11/2017.
 */

public class RealizarEntregaActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizar_entrega);

        File imgFile = new File("/storage/emulated/0/Android/data/com.example.rafael.sistemaxaximflores/files/pic.jpg");

        if(imgFile.exists()){

            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

            ImageView myImage = (ImageView) findViewById(R.id.imageView3);


            myImage.setImageBitmap(myBitmap);


        }




    }
}

