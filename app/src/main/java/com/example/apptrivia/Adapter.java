package com.example.apptrivia;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Pregunta> {
    private Activity context;
    private ArrayList<Pregunta> preguntas;
    boolean respuestas;
    public Adapter(Activity c,ArrayList<Pregunta> lenguajes, boolean respuestas){
        super(c,R.layout.layout_preguntas,lenguajes);
        context = c;
        this.preguntas = lenguajes;
        this.respuestas = respuestas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View fila =  inflater.inflate(R.layout.layout_preguntas,parent,false);



        Pregunta p = preguntas.get(position);
        TextView texto;
        LinearLayout fondo;

        fondo = (LinearLayout) fila.findViewById(R.id.fondo);
        texto = (TextView) fila.findViewById(R.id.texto);

        if (p.isAcertada()){
            //fondo.setBackgroundColor(Color.GREEN);
            fondo.setBackgroundColor(fila.getResources().getColor(R.color.acierto));
        }else {
            //fondo.setBackgroundColor(Color.RED);
            fondo.setBackgroundColor(fila.getResources().getColor(R.color.fallo));
        }

        if (respuestas){
            texto.setText(p.getPregunta()+" Respuesta: "+p.getRespuestaCorrecta());
        }else {
            texto.setText(p.getPregunta());
        }
        return fila;
    }
    public void actualizar(){
        this.notifyDataSetChanged();
    }

    public void setLenguajes(ArrayList<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
}
