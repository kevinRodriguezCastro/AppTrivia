package com.example.apptrivia;

import androidx.appcompat.app.AppCompatActivity;

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
    private ArrayList<String> preguntas = new ArrayList<>();
    private ArrayList<ArrayList<Respuesta>> respuestas = new ArrayList<>();

    private ArrayList<String> preguntasSeleccionadas = new ArrayList<>();
    private ArrayList<ArrayList<Respuesta>> respuestasSeleccionadas = new ArrayList<>();
    //private String preguntaActual;
    //private Respuesta[] respuestasActual = new Respuesta[4];
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
                if (respuestasSeleccionadas.get(contaPregunta).get(0).isCorrecta()){
                    aciertos[contaPregunta-1] = true;
                }else {
                    aciertos[contaPregunta-1] = false;
                }
                pasarPregunta();
            }
        });
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (respuestasSeleccionadas.get(contaPregunta).get(1).isCorrecta()){
                    aciertos[contaPregunta-1] = true;
                }else {
                    aciertos[contaPregunta-1] = false;
                }
                pasarPregunta();
            }
        });
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (respuestasSeleccionadas.get(contaPregunta).get(2).isCorrecta()){
                    aciertos[contaPregunta-1] = true;
                }else {
                    aciertos[contaPregunta-1] = false;
                }
                pasarPregunta();
            }
        });
        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (respuestasSeleccionadas.get(contaPregunta).get(3).isCorrecta()){
                    aciertos[contaPregunta-1] = true;
                }else {
                    aciertos[contaPregunta-1] = false;
                }
                pasarPregunta();
            }
        });

        pasarPregunta();
    }

    private void rellenaPreguntas(){
        ArrayList<Respuesta> tmp = new ArrayList<>();

        preguntas.add("¿En qué año comenzó la Segunda Guerra Mundial?");
        tmp.add(new Respuesta("1936",false));
        tmp.add(new Respuesta("1939 ",true));
        tmp.add(new Respuesta("1941 ",false));
        tmp.add(new Respuesta("1945",false));
        respuestas.add(tmp);

        tmp = new ArrayList<>();
        preguntas.add("¿Cuál es el río más largo del mundo?");
        tmp.add(new Respuesta("Nilo",false));
        tmp.add(new Respuesta("Amazonas",true));
        tmp.add(new Respuesta("Yangtsé",false));
        tmp.add(new Respuesta("Misisipi",false));
        respuestas.add(tmp);
        tmp = new ArrayList<>();

        preguntas.add("¿En qué continente se encuentra la Gran Muralla China?");
        tmp.add(new Respuesta("Asia ",true));
        tmp.add(new Respuesta("Europa",false));
        tmp.add(new Respuesta("África",false));
        tmp.add(new Respuesta("América",false));
        respuestas.add(tmp);
        tmp = new ArrayList<>();

        preguntas.add("¿Cuál es el símbolo químico del oro?");
        tmp.add(new Respuesta("O",false));
        tmp.add(new Respuesta("Au",true));
        tmp.add(new Respuesta("Ag",false));
        tmp.add(new Respuesta("Fe",false));
        respuestas.add(tmp);
        tmp = new ArrayList<>();

        preguntas.add("¿Cuántos huesos tiene el cuerpo humano?");
        tmp.add(new Respuesta("206",true));
        tmp.add(new Respuesta("150",false));
        tmp.add(new Respuesta("300",false));
        tmp.add(new Respuesta("120",false));
        respuestas.add(tmp);
        tmp = new ArrayList<>();

        preguntas.add("¿Qué es Java?");
        tmp.add(new Respuesta("Un navegador web",false));
        tmp.add(new Respuesta("Un lenguaje de programación",true));
        tmp.add(new Respuesta("Un sistema operativo",false));
        tmp.add(new Respuesta("Un programa de edición de imágenes",false));
        respuestas.add(tmp);
        tmp = new ArrayList<>();

        preguntas.add("¿Cómo se inicia un bucle infinito en Java?");
        tmp.add(new Respuesta("for (;;)",false));
        tmp.add(new Respuesta("for (int i = 0; i < 10; i++)",false));
        tmp.add(new Respuesta("while (true)",true));
        tmp.add(new Respuesta("do {} while (false)",false));
        respuestas.add(tmp);
        tmp = new ArrayList<>();

        preguntas.add("¿Cuál es el resultado de \"Hello\" + \"World\" en Java?");
        tmp.add(new Respuesta("HelloWorld",true));
        tmp.add(new Respuesta("Hello World",false));
        tmp.add(new Respuesta("\"Hello\" World",false));
        tmp.add(new Respuesta("Hola mundo",false));
        respuestas.add(tmp);
        tmp = new ArrayList<>();

        preguntas.add("¿Qué hace el operador ^ en Java?");
        tmp.add(new Respuesta("Resto de la división",false));
        tmp.add(new Respuesta("Raiz cuadrada",false));
        tmp.add(new Respuesta("Potencia",false));
        tmp.add(new Respuesta("XOR",true));
        respuestas.add(tmp);
        tmp = new ArrayList<>();

        preguntas.add("En Java, ¿cómo se llama el proceso de encapsular datos y métodos en una única unidad?");
        tmp.add(new Respuesta("Encapsulamiento",true));
        tmp.add(new Respuesta("Abstracción",false));
        tmp.add(new Respuesta("Polimorfismo",false));
        tmp.add(new Respuesta("Herencia",false));
        respuestas.add(tmp);
        tmp = new ArrayList<>();

        preguntas.add("¿Cuál es el océano más grande del mundo?");
        tmp.add(new Respuesta("Océano Atlántico",false));
        tmp.add(new Respuesta("Océano Índico",false));
        tmp.add(new Respuesta("Océano Ártico",false));
        tmp.add(new Respuesta("Océano Pacífico",true));
        respuestas.add(tmp);
        tmp = new ArrayList<>();

        preguntas.add(" ¿En qué año llegó el hombre a la luna por primera vez?");
        tmp.add(new Respuesta("1959",false));
        tmp.add(new Respuesta("1969",true));
        tmp.add(new Respuesta("1979",false));
        tmp.add(new Respuesta("1989",false));
        respuestas.add(tmp);
        tmp = new ArrayList<>();

        preguntas.add("¿Cuál es la montaña más alta del mundo?");
        tmp.add(new Respuesta("Monte Everest",true));
        tmp.add(new Respuesta("Kilimanjaro",false));
        tmp.add(new Respuesta("Aconcagua",false));
        tmp.add(new Respuesta("Mont Blanc",false));
        respuestas.add(tmp);
        tmp = new ArrayList<>();

        preguntas.add("¿Cuántas patas tiene una araña?");
        tmp.add(new Respuesta("6",false));
        tmp.add(new Respuesta("8",true));
        tmp.add(new Respuesta("10",false));
        tmp.add(new Respuesta("12",false));
        respuestas.add(tmp);
        tmp = new ArrayList<>();

        preguntas.add("¿Cuál es el metal más abundante en la corteza terrestre?");
        tmp.add(new Respuesta("Hierro",false));
        tmp.add(new Respuesta("Aluminio",true));
        tmp.add(new Respuesta("Oro",false));
        tmp.add(new Respuesta("Cobre",false));
        respuestas.add(tmp);
        tmp = new ArrayList<>();

        preguntas.add("¿En qué año se descubrió América?");
        tmp.add(new Respuesta("1400",false));
        tmp.add(new Respuesta("1607",false));
        tmp.add(new Respuesta("1588",false));
        tmp.add(new Respuesta("1492",true));
        respuestas.add(tmp);
        tmp = new ArrayList<>();

    }
    private void seleccionarPregunta(){
        for (int i =0;i<nPreguntas;i++){
            int r = (int)(preguntas.size() * Math.random());
            preguntasSeleccionadas.add(preguntas.get(r));
            respuestasSeleccionadas.add(respuestas.get(r));
            preguntas.remove(r);
            respuestas.remove(r);
        }
    }

    private void ordenRespuestas(ArrayList<Respuesta> r){
        Collections.shuffle(r);
    }
    private void pasarPregunta(){
        if(contaPregunta<=nPreguntas){
            ArrayList<Respuesta> tmp;
            pregunta.setText(preguntasSeleccionadas.get(contaPregunta));
            tmp = respuestasSeleccionadas.get(contaPregunta);
            ordenRespuestas(tmp);

            btn1.setText(tmp.get(0).getRepuesta());
            btn2.setText(tmp.get(1).getRepuesta());
            btn3.setText(tmp.get(2).getRepuesta());
            btn4.setText(tmp.get(3).getRepuesta());
            contaPregunta++;
        }

    }
}