package com.example.andre.testelogin.Model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.andre.testelogin.Activity.GerenciarActivity;
import com.example.andre.testelogin.Activity.MenuAdmActivity;
import com.example.andre.testelogin.Activity.MenuFuncActivity;
import com.example.andre.testelogin.Adapter.AdapterEntrega;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;


public class SelectEntrega extends AsyncTask<Void, Void, String> {

    private static final String HOST = "http://es.ft.unicamp.br/ulisses/si700/select_data.php";
    private Context context;
    private ListView listView;
    private  String[] fields;
    private  String[] values;

    ArrayList<Entrega> entregas = new ArrayList<>();

    public SelectEntrega(Context context, ListView listView, String[] fields, String[] values){
        this.context  = context;
        this.listView = listView;
        this.fields   = fields;
        this.values   = values;
    }

    @Override
    protected String doInBackground(Void... objects) {
        HttpURLConnection httpURLConnection = null;
        try {


            String data =
                    URLEncoder.encode("database","UTF-8")+"="+
                            URLEncoder.encode("ra158352","UTF-8")+"&"+
                            URLEncoder.encode("table","UTF-8")+"="+
                            URLEncoder.encode("entrega","UTF-8");

            for(int i = 0; i < fields.length; i++) {
                data +=  "&" +  URLEncoder.encode(fields[i] , "UTF-8") + "=" +
                        URLEncoder.encode(values[i], "UTF-8");
            }


            URL url = new URL(HOST);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);


            OutputStreamWriter wr = new OutputStreamWriter(httpURLConnection.getOutputStream());
            wr.write( data );
            wr.flush();

            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(httpURLConnection.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null) {
                sb.append(line);
                break;
            }
            return sb.toString();

        }

        catch (IOException exception){
            exception.printStackTrace();
            return "Exception: " + exception.getMessage();
        }

        finally {
            if (httpURLConnection != null){
                httpURLConnection.disconnect();
            }
        }
    }


    @Override
    protected  void onPostExecute(String result){
        /*
           Convertendo JSONArray para ArrayList
         */

        try {
            JSONArray jsonArray = new JSONArray(result);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Entrega entrega = new Entrega(jsonObject.getInt("id_cliente"),jsonObject.getString("img"),jsonObject.getString("valor"),jsonObject.getString("data"),jsonObject.getInt("tipo"));
                entregas.add(entrega);
            }
        } catch (JSONException exception){
            exception.printStackTrace();
        }

        AdapterEntrega adapterEntrega = new AdapterEntrega(entregas, (Activity) context);
        listView.setAdapter(adapterEntrega);

    }
}

