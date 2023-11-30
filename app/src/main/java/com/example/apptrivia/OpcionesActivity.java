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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        btnVolver = (Button) findViewById(R.id.btnVolverOpciones);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                SharedPreferences.Editor editor = getSharedPreferences("MiPreferencia", MODE_PRIVATE).edit();
                editor.putBoolean("random", random.isActivated());
                editor.putBoolean("respuestas", respuestas.isSelected());
                Log.d("OpcionesActivity",""+respuestas.isSelected());
                editor.putBoolean("tiempo", tiempo.isSelected());
                editor.apply();
                startActivity(i);
            }
        });

        random = (Switch) findViewById(R.id.switch1);
        respuestas = (Switch) findViewById(R.id.switch2);
        tiempo = (Switch) findViewById(R.id.switch3);
    }
}