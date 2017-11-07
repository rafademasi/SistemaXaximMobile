package com.example.andre.testelogin.Model;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.andre.testelogin.Activity.MenuAdmActivity;
import com.example.andre.testelogin.Activity.MenuFuncActivity;

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

public class SelectUser extends AsyncTask <Void, Void, String> {

    private static final String HOST = "http://es.ft.unicamp.br/ulisses/si700/select_data.php";
    private  Context context;
    private String user;
    private String senha;


    ArrayList<Usuario> users = new ArrayList<>();
    String[] fields = new String[0];
    String[] values = new String[0];


    public SelectUser(Context context, String user, String senha){
        this.context = context;
        this.user = user;
        this.senha = senha;
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
                            URLEncoder.encode("usuario","UTF-8");

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
                Usuario usuario = new Usuario(jsonObject.getString("user"),jsonObject.getString("senha"),jsonObject.getInt("tipoUser"));
                users.add(usuario);
            }
        } catch (JSONException exception){
            exception.printStackTrace();
        }

        int i = 0;
        for (i = 0; i < users.size(); i++) {
            Usuario usuario = users.get(i);

            if((usuario.getUser().toString().equals(user))&&(usuario.getSenha().toString().equals(senha))){
                if(usuario.getTipoUser()==0){
                    Intent intent = new Intent(context, MenuAdmActivity.class);
                    intent.putExtra(Intent.EXTRA_TEXT, user);
                    context.startActivity(intent);
                    break;
                }
                else{
                    Intent intent = new Intent(context, MenuFuncActivity.class);
                    intent.putExtra(Intent.EXTRA_TEXT, user);
                    context.startActivity(intent);
                    break;
                }
            }
        }

        if(i == users.size()){
            CharSequence text = "Usuário ou Senha inválidos";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }


    }
}