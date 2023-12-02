package com.example.apptrivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class OpcionesActivity extends AppCompatActivity {
    private Button btnVolver;
    private Switch random,respuestas,tiempo;
    private boolean opcRandom,opcRespuestas,opcTiempo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        SharedPreferences prefs = getSharedPreferences("MiPreferencia", MODE_PRIVATE);
        opcRandom = prefs.getBoolean("random", false);
        opcTiempo = prefs.getBoolean("tiempo", true);
        opcRespuestas = prefs.getBoolean("respuestas", false);

        btnVolver = (Button) findViewById(R.id.btnVolverOpciones);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                SharedPreferences.Editor editor = getSharedPreferences("MiPreferencia", MODE_PRIVATE).edit();
                editor.putBoolean("random", random.isChecked());
                editor.putBoolean("respuestas", respuestas.isChecked());
                Log.d("OpcionesActivity",""+respuestas.isChecked());
                editor.putBoolean("tiempo", tiempo.isChecked());
                editor.apply();
                startActivity(i);
            }
        });

        random = (Switch) findViewById(R.id.swRandom);
        if (opcRandom){
            random.setChecked(true);
        }

        respuestas = (Switch) findViewById(R.id.swRespuestas);
        if (opcRespuestas){
            respuestas.setChecked(true);
        }

        tiempo = (Switch) findViewById(R.id.swTiempo);
        if (opcTiempo){
            tiempo.setChecked(true);
        }
    }
}