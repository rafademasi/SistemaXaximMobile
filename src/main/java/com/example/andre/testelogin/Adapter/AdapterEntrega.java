package com.example.andre.testelogin.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.andre.testelogin.Model.Entrega;
import com.example.andre.testelogin.R;

import java.util.List;

/**
 * Created by andre on 03/09/2017.
 */

public class AdapterEntrega extends BaseAdapter {

    private final List<Entrega> entregas;
    private final Activity act;

    public AdapterEntrega(List<Entrega> entregas, Activity act) {
        this.entregas = entregas;
        this.act = act;
    }

    @Override
    public int getCount() {
        return entregas.size();
    }

    @Override
    public Object getItem(int position) {
        return entregas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater()
                .inflate(R.layout.item_layout, parent, false);

        Entrega entrega = entregas.get(position);

        TextView cliente = (TextView)
                view.findViewById(R.id.textView);
        TextView data = (TextView)
                view.findViewById(R.id.textView1);
        TextView tipo = (TextView)
                view.findViewById(R.id.textView2);
        ImageView imagem = (ImageView)
                view.findViewById(R.id.imageView);
        TextView valor = (TextView)
                view.findViewById(R.id.textView3);

        if(entrega.getCliente() == 0){
            cliente.setText("John Deere");}
        else if (entrega.getCliente() == 1){
            cliente.setText("Unimed");}
        else{
            cliente.setText("Hipica");}

        Log.v("SHOW", String.valueOf(entrega.getCliente()));

        data.setText(entrega.getData().toString());

        if(entrega.getTipo() == 0)
            tipo.setText("Arranjo Floral");
        else
            tipo.setText("Vaso ornamental");

        valor.setText(String.valueOf(entrega.getValor()));

        byte[] encondeByte = Base64.decode(entrega.getImg(),Base64.DEFAULT);
/*
        Bitmap bitmap = BitmapFactory.decodeByteArray(encondeByte,0,encondeByte.length);

        imagem.setImageBitmap(bitmap);*/

        Glide.with(act).load(encondeByte).asBitmap().into(imagem);

        return view;
    }
}
