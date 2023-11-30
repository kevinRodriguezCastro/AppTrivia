package com.example.apptrivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ResultadoActivity extends AppCompatActivity {
    private ListView lista;
    Adapter adapter;
    Button btnVolver;
    ArrayList<Pregunta> preguntas;
    boolean respuestas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        SharedPreferences prefs = getSharedPreferences("MiPreferencia", MODE_PRIVATE);
        respuestas = prefs.getBoolean("respuestas", false);

        Intent extra = getIntent();
        preguntas =  (ArrayList<Pregunta>) extra.getSerializableExtra("preguntas");

        adapter = new Adapter(this,preguntas,respuestas);

        lista = (ListView) findViewById(R.id.lista);
        lista.setAdapter(adapter);

        btnVolver = (Button) findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}