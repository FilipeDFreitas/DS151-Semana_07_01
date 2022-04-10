package com.example.semana07_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView output;
    TextView input;
    String cep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.output);
        input = findViewById(R.id.cep);

    }
    public void getData (View view){
         cep= input.getText().toString();
        //String cep ="80250200";
        String urlBlockChain = "https://viacep.com.br/ws/"+ cep +"/json/";
        Mytask task = new Mytask(output);
        task.execute(urlBlockChain);
    }
}