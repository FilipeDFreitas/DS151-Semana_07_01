package com.example.semana07_01;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Mytask extends AsyncTask<String,Void,String> {

    TextView output;

    public Mytask(TextView output) {
        this.output = output;
    }

    @Override
    protected String doInBackground(String... strings) {
        String stringURL = strings[0];
        InputStream inputStream =null;
        InputStreamReader inputStreamReader=null;
        StringBuffer buffer = null;
        try{
            URL url = new URL(stringURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            inputStream =conn.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            buffer = new StringBuffer();
            String line ="";
            while((line = reader.readLine())!=null){
                buffer.append(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }
    @Override
    protected void onPostExecute(String s){
        super.onPostExecute(s);
        String logradouro = null;
        String complemento = null;
        String bairro = null;
        String localidade = null;
        String uf = null;
        String cep = null;
        try {
            JSONObject jsonObject = new JSONObject(s);
            logradouro = jsonObject.getString("logradouro");
            complemento = jsonObject.getString("complemento");
            bairro = jsonObject.getString("bairro");
            localidade = jsonObject.getString("localidade");
            uf = jsonObject.getString("uf");
            cep = jsonObject.getString("cep");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        output.setText(logradouro + " - "+complemento+"\n"+bairro+"\n"+localidade+"-"+uf+"\n"+cep);
    }
}
