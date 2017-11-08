package com.example.andre.testelogin.Model;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.andre.testelogin.Activity.MenuAdmActivity;
import com.example.andre.testelogin.Activity.MenuFuncActivity;
import com.example.andre.testelogin.R;

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
import java.util.StringTokenizer;

/**
 * Created by andre on 07/11/2017.
 */

public class SelectCliente extends AsyncTask <Void, Void, String> {

    private static final String HOST = "http://es.ft.unicamp.br/ulisses/si700/select_data.php";
    private Context context;
    private Spinner spinner;

    ArrayList<String> clientes = new ArrayList<>();
    String[] fields = new String[0];
    String[] values = new String[0];

    public SelectCliente(Context context, Spinner spinner){
        this.context = context;
        this.spinner = spinner;
    }
    @Override
    protected String doInBackground(Void... objects) {
        HttpURLConnection httpURLConnection = null;
        try {
            /*
               Preparando os dados para envio via post
             */
            String data =
                    URLEncoder.encode("database","UTF-8")+"="+
                            URLEncoder.encode("ra158352","UTF-8")+"&"+
                            URLEncoder.encode("table","UTF-8")+"="+
                            URLEncoder.encode("cliente","UTF-8");

            for(int i = 0; i < fields.length; i++) {
                data +=  "&" +  URLEncoder.encode(fields[i] , "UTF-8") + "=" +
                        URLEncoder.encode(values[i], "UTF-8");
            }


            /*
               Abrindo uma conexão com o servidor
             */
            URL url = new URL(HOST);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);

            /*
               Enviando os dados via post
             */
            OutputStreamWriter wr = new OutputStreamWriter(httpURLConnection.getOutputStream());
            wr.write(data);
            wr.flush();

            /*
                Lendo a resposta do servidor
             */
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
                clientes.add(jsonObject.getString("nome"));
            }
        } catch (JSONException exception){
            exception.printStackTrace();
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(context, R.layout.spinner_item, clientes);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        }

}
