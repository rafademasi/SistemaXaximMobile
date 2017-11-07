package com.example.andre.testelogin.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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

        cliente.setText(entrega.getCliente());
        data.setText(entrega.getData().toString());
        tipo.setText(entrega.getTipo());

        if(entrega.getTipo().equals("Arranjo Floral")){
            imagem.setImageResource(R.drawable.arranjo);
        }
        else{
            imagem.setImageResource(R.drawable.vaso);
        }

        return view;
    }
}
