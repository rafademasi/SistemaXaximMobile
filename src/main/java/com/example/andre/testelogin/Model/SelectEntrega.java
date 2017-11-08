/*
package com.example.andre.testelogin.Model;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

*/
/**
 * Created by andre on 07/11/2017.
 *//*


public class SelectEntrega extends AsyncTask<Void, Void, String> {

    private static final String HOST = "http://192.168.0.110/~ulisses/select_data.php";
    private Context context;
    private ListView listView;
    private  String[] fields;
    private  String[] values;

    public SelectPlayer(Context context, ListView listView, String[] fields, String[] values){
        this.context  = context;
        this.listView = listView;
        this.fields   = fields;
        this.values   = values;
    }

    @Override
    protected String doInBackground(Void... objects) {
        HttpURLConnection httpURLConnection = null;
        try {
            */
/*
               Preparando os dados para envio via post
             *//*

            String data =
                    URLEncoder.encode("database","UTF-8")+"="+
                            URLEncoder.encode("ex1","UTF-8")+"&"+
                            URLEncoder.encode("table","UTF-8")+"="+
                            URLEncoder.encode("tbl1","UTF-8");

            for(int i = 0; i < fields.length; i++) {
                data +=  "&" +  URLEncoder.encode(fields[i] , "UTF-8") + "=" +
                        URLEncoder.encode(values[i], "UTF-8");
            }


            */
/*
               Abrindo uma conexão com o servidor
             *//*

            URL url = new URL(HOST);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);

            */
/*
               Enviando os dados via post
             *//*

            OutputStreamWriter wr = new OutputStreamWriter(httpURLConnection.getOutputStream());
            wr.write( data );
            wr.flush();

            */
/*
                Lendo a resposta do servidor
             *//*

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
        */
/*
           Convertendo JSONArray para ArrayList
         *//*


        ArrayList<String> players = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(result);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                players.add(jsonObject.getString("Name"));
            }
        } catch (JSONException exception){
            exception.printStackTrace();
        }

        */
/*
          Adicionando dados na ListView
         *//*


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                context, android.R.layout.simple_list_item_1,players
        );
        listView.setAdapter(adapter);

    }
}

*/
