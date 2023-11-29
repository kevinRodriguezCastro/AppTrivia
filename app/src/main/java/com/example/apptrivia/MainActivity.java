package com.example.apptrivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private final int nPreguntas = 10;
    private ArrayList<Pregunta> preguntas = new ArrayList<>();
    //private ArrayList<ArrayList<Respuesta>> respuestas = new ArrayList<>();

    private ArrayList<Pregunta> preguntasSeleccionadas = new ArrayList<>();
    //private ArrayList<ArrayList<Respuesta>> respuestasSeleccionadas = new ArrayList<>();

    private boolean[] aciertos = new boolean[nPreguntas];
    private int contaPregunta = 0;
    private TextView pregunta;
    private ImageView img;
    private Button btn1,btn2,btn3,btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rellenaPreguntas();
        seleccionarPregunta();

        pregunta = (TextView) findViewById(R.id.tvPregunta);
        img = (ImageView) findViewById(R.id.imagen);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contestar();
            }
        });
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contestar();
            }
        });
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contestar();
            }
        });
        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               contestar();
            }
        });

        pasarPregunta();
    }

    private void rellenaPreguntas(){
        ArrayList<Respuesta> tmp = new ArrayList<>();
        Pregunta p;


        tmp.add(new Respuesta("1936",false));
        tmp.add(new Respuesta("1939 ",true));
        tmp.add(new Respuesta("1941 ",false));
        tmp.add(new Respuesta("1945",false));
        p = new Pregunta("¿En qué año comenzó la Segunda Guerra Mundial?",tmp);
        preguntas.add(p);


        tmp = new ArrayList<>();
        tmp.add(new Respuesta("Nilo",false));
        tmp.add(new Respuesta("Amazonas",true));
        tmp.add(new Respuesta("Yangtsé",false));
        tmp.add(new Respuesta("Misisipi",false));
        p = new Pregunta("¿Cuál es el río más largo del mundo?",tmp);
        preguntas.add(p);


        tmp = new ArrayList<>();
        tmp.add(new Respuesta("Asia ",true));
        tmp.add(new Respuesta("Europa",false));
        tmp.add(new Respuesta("África",false));
        tmp.add(new Respuesta("América",false));
        p = new Pregunta("¿En qué continente se encuentra la Gran Muralla China?",tmp);
        preguntas.add(p);


        tmp = new ArrayList<>();
        tmp.add(new Respuesta("O",false));
        tmp.add(new Respuesta("Au",true));
        tmp.add(new Respuesta("Ag",false));
        tmp.add(new Respuesta("Fe",false));
        p = new Pregunta("¿Cuál es el símbolo químico del oro?",tmp);
        preguntas.add(p);

        tmp = new ArrayList<>();
        tmp.add(new Respuesta("206",true));
        tmp.add(new Respuesta("150",false));
        tmp.add(new Respuesta("300",false));
        tmp.add(new Respuesta("120",false));
        p = new Pregunta("¿Cuántos huesos tiene el cuerpo humano?",tmp);
        preguntas.add(p);


        tmp = new ArrayList<>();
        tmp.add(new Respuesta("Un navegador web",false));
        tmp.add(new Respuesta("Un lenguaje de programación",true));
        tmp.add(new Respuesta("Un sistema operativo",false));
        tmp.add(new Respuesta("Un programa de edición de imágenes",false));
        p = new Pregunta("¿Qué es Java?",tmp);
        preguntas.add(p);

        tmp = new ArrayList<>();
        tmp.add(new Respuesta("for (;;)",false));
        tmp.add(new Respuesta("for (int i = 0; i < 10; i++)",false));
        tmp.add(new Respuesta("while (true)",true));
        tmp.add(new Respuesta("do {} while (false)",false));
        p = new Pregunta("¿Cómo se inicia un bucle infinito en Java?",tmp);
        preguntas.add(p);

        tmp = new ArrayList<>();
        tmp.add(new Respuesta("HelloWorld",true));
        tmp.add(new Respuesta("Hello World",false));
        tmp.add(new Respuesta("\"Hello\" World",false));
        tmp.add(new Respuesta("Hola mundo",false));
        p = new Pregunta("¿Cuál es el resultado de \"Hello\" + \"World\" en Java?",tmp);
        preguntas.add(p);

        tmp = new ArrayList<>();
        tmp.add(new Respuesta("Resto de la división",false));
        tmp.add(new Respuesta("Raiz cuadrada",false));
        tmp.add(new Respuesta("Potencia",false));
        tmp.add(new Respuesta("XOR",true));
        p = new Pregunta("¿Qué hace el operador ^ en Java?",tmp);
        preguntas.add(p);

        tmp = new ArrayList<>();
        tmp.add(new Respuesta("Encapsulamiento",true));
        tmp.add(new Respuesta("Abstracción",false));
        tmp.add(new Respuesta("Polimorfismo",false));
        tmp.add(new Respuesta("Herencia",false));
        p = new Pregunta("En Java, ¿cómo se llama el proceso de encapsular datos y métodos en una única unidad?",tmp);
        preguntas.add(p);


        tmp = new ArrayList<>();
        tmp.add(new Respuesta("Océano Atlántico",false));
        tmp.add(new Respuesta("Océano Índico",false));
        tmp.add(new Respuesta("Océano Ártico",false));
        tmp.add(new Respuesta("Océano Pacífico",true));
        p = new Pregunta("¿Cuál es el océano más grande del mundo?",tmp);
        preguntas.add(p);

        tmp = new ArrayList<>();
        tmp.add(new Respuesta("1959",false));
        tmp.add(new Respuesta("1969",true));
        tmp.add(new Respuesta("1979",false));
        tmp.add(new Respuesta("1989",false));
        p = new Pregunta(" ¿En qué año llegó el hombre a la luna por primera vez?",tmp);
        preguntas.add(p);

        tmp = new ArrayList<>();
        tmp.add(new Respuesta("Monte Everest",true));
        tmp.add(new Respuesta("Kilimanjaro",false));
        tmp.add(new Respuesta("Aconcagua",false));
        tmp.add(new Respuesta("Mont Blanc",false));
        p = new Pregunta("¿Cuál es la montaña más alta del mundo?",tmp);
        preguntas.add(p);

        tmp = new ArrayList<>();
        tmp.add(new Respuesta("6",false));
        tmp.add(new Respuesta("8",true));
        tmp.add(new Respuesta("10",false));
        tmp.add(new Respuesta("12",false));
        p = new Pregunta("¿Cuántas patas tiene una araña?",tmp);
        preguntas.add(p);

        tmp = new ArrayList<>();
        tmp.add(new Respuesta("Hierro",false));
        tmp.add(new Respuesta("Aluminio",true));
        tmp.add(new Respuesta("Oro",false));
        tmp.add(new Respuesta("Cobre",false));
        p = new Pregunta("¿Cuál es el metal más abundante en la corteza terrestre?",tmp);
        preguntas.add(p);

        tmp = new ArrayList<>();
        tmp.add(new Respuesta("1400",false));
        tmp.add(new Respuesta("1607",false));
        tmp.add(new Respuesta("1588",false));
        tmp.add(new Respuesta("1492",true));
        p = new Pregunta("¿En qué año se descubrió América?",tmp);
        preguntas.add(p);
        tmp = new ArrayList<>();

    }
    private void seleccionarPregunta(){
        for (int i =0;i<nPreguntas;i++){
            int r = (int)(preguntas.size() * Math.random());
            preguntasSeleccionadas.add(preguntas.get(r));
            //respuestasSeleccionadas.add(respuestas.get(r));
            preguntas.remove(r);
            //respuestas.remove(r);
        }
    }

    private void ordenRespuestas(ArrayList<Respuesta> r){
        Collections.shuffle(r);
    }
    private void pasarPregunta(){
        if(contaPregunta<=nPreguntas){
            ArrayList<Respuesta> tmp;
            pregunta.setText(preguntasSeleccionadas.get(contaPregunta).getPregunta());
            tmp = preguntasSeleccionadas.get(contaPregunta).getRespuestas();
            ordenRespuestas(tmp);

            btn1.setText(tmp.get(0).getRepuesta());
            btn2.setText(tmp.get(1).getRepuesta());
            btn3.setText(tmp.get(2).getRepuesta());
            btn4.setText(tmp.get(3).getRepuesta());
            contaPregunta++;
        }
    }
    private void contestar(){
        if (contaPregunta<10){
            if (preguntasSeleccionadas.get(contaPregunta).getRespuestas().get(0).isCorrecta()){
                aciertos[contaPregunta-1] = true;
            }else {
                aciertos[contaPregunta-1] = false;
            }
            pasarPregunta();
        }else {
            Intent i = new Intent(this, ResultadoActivity.class);
            i.putExtra("preguntas",preguntasSeleccionadas);
            startActivity(i);
        }

    }
}