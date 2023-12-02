package com.example.apptrivia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    private final int nPreguntas = 10;
    private ArrayList<Pregunta> preguntas = new ArrayList<>();
    //private ArrayList<ArrayList<Respuesta>> respuestas = new ArrayList<>();

    private ArrayList<Pregunta> preguntasSeleccionadas = new ArrayList<>();
    //private ArrayList<ArrayList<Respuesta>> respuestasSeleccionadas = new ArrayList<>();

    private boolean[] aciertos = new boolean[nPreguntas];
    private int contaPregunta = 0;
    private TextView pregunta,tvContador;
    private ImageView img;
    private Button btn1,btn2,btn3,btn4;
    private Toolbar toolbar;
    private CountDownTimer timer;
    private boolean random,respuestas,tiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContador = (TextView) findViewById(R.id.tvContador);

        SharedPreferences prefs = getSharedPreferences("MiPreferencia", MODE_PRIVATE);
        random = prefs.getBoolean("random", false);
        tiempo = prefs.getBoolean("tiempo", false);

        if(tiempo){
            timer = new CountDownTimer(15000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    // Este método se llama cada segundo (1000 milisegundos)
                    long segundosRestantes = millisUntilFinished / 1000;
                    tvContador.setText(""+segundosRestantes);
                }

                @Override
                public void onFinish() {
                    // Este método se llama cuando el temporizador llega a cero
                    preguntasSeleccionadas.get(contaPregunta).setAcertada(false);
                    if(contaPregunta<9){
                        contaPregunta++;
                        pasarPregunta();
                    }else {
                        cambiarActivityRespuestas();
                    }
                }
            };
        }


        rellenaPreguntas();
        seleccionarPregunta();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pregunta = (TextView) findViewById(R.id.tvPregunta);
        img = (ImageView) findViewById(R.id.imagen);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contestar(0);
            }
        });
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contestar(1);
            }
        });
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contestar(2);
            }
        });
        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               contestar(3);
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
        p = new Pregunta("¿En qué año comenzó la Segunda Guerra Mundial?",tmp,R.drawable.cultura);
        preguntas.add(p);


        tmp = new ArrayList<>();
        tmp.add(new Respuesta("Nilo",false));
        tmp.add(new Respuesta("Amazonas",true));
        tmp.add(new Respuesta("Yangtsé",false));
        tmp.add(new Respuesta("Misisipi",false));
        p = new Pregunta("¿Cuál es el río más largo del mundo?",tmp,R.drawable.cultura);
        preguntas.add(p);


        tmp = new ArrayList<>();
        tmp.add(new Respuesta("Asia ",true));
        tmp.add(new Respuesta("Europa",false));
        tmp.add(new Respuesta("África",false));
        tmp.add(new Respuesta("América",false));
        p = new Pregunta("¿En qué continente se encuentra la Gran Muralla China?",tmp,R.drawable.cultura);
        preguntas.add(p);


        tmp = new ArrayList<>();
        tmp.add(new Respuesta("O",false));
        tmp.add(new Respuesta("Au",true));
        tmp.add(new Respuesta("Ag",false));
        tmp.add(new Respuesta("Fe",false));
        p = new Pregunta("¿Cuál es el símbolo químico del oro?",tmp,R.drawable.cultura);
        preguntas.add(p);

        tmp = new ArrayList<>();
        tmp.add(new Respuesta("206",true));
        tmp.add(new Respuesta("150",false));
        tmp.add(new Respuesta("300",false));
        tmp.add(new Respuesta("120",false));
        p = new Pregunta("¿Cuántos huesos tiene el cuerpo humano?",tmp,R.drawable.cultura);
        preguntas.add(p);


        tmp = new ArrayList<>();
        tmp.add(new Respuesta("Un navegador web",false));
        tmp.add(new Respuesta("Un lenguaje de programación",true));
        tmp.add(new Respuesta("Un sistema operativo",false));
        tmp.add(new Respuesta("Un programa de edición de imágenes",false));
        p = new Pregunta("¿Qué es Java?",tmp,R.drawable.java);
        preguntas.add(p);

        tmp = new ArrayList<>();
        tmp.add(new Respuesta("for (;;)",false));
        tmp.add(new Respuesta("for (int i = 0; i < 10; i++)",false));
        tmp.add(new Respuesta("while (true)",true));
        tmp.add(new Respuesta("do {} while (false)",false));
        p = new Pregunta("¿Cómo se inicia un bucle infinito en Java?",tmp,R.drawable.java);
        preguntas.add(p);

        tmp = new ArrayList<>();
        tmp.add(new Respuesta("HelloWorld",true));
        tmp.add(new Respuesta("Hello World",false));
        tmp.add(new Respuesta("\"Hello\" World",false));
        tmp.add(new Respuesta("Hola mundo",false));
        p = new Pregunta("¿Cuál es el resultado de \"Hello\" + \"World\" en Java?",tmp,R.drawable.java);
        preguntas.add(p);

        tmp = new ArrayList<>();
        tmp.add(new Respuesta("Resto de la división",false));
        tmp.add(new Respuesta("Raiz cuadrada",false));
        tmp.add(new Respuesta("Potencia",false));
        tmp.add(new Respuesta("XOR",true));
        p = new Pregunta("¿Qué hace el operador ^ en Java?",tmp,R.drawable.java);
        preguntas.add(p);

        tmp = new ArrayList<>();
        tmp.add(new Respuesta("Encapsulamiento",true));
        tmp.add(new Respuesta("Abstracción",false));
        tmp.add(new Respuesta("Polimorfismo",false));
        tmp.add(new Respuesta("Herencia",false));
        p = new Pregunta("En Java, ¿cómo se llama el proceso de encapsular datos y métodos en una única unidad?",tmp,R.drawable.java);
        preguntas.add(p);


        tmp = new ArrayList<>();
        tmp.add(new Respuesta("Océano Atlántico",false));
        tmp.add(new Respuesta("Océano Índico",false));
        tmp.add(new Respuesta("Océano Ártico",false));
        tmp.add(new Respuesta("Océano Pacífico",true));
        p = new Pregunta("¿Cuál es el océano más grande del mundo?",tmp,R.drawable.cultura);
        preguntas.add(p);

        tmp = new ArrayList<>();
        tmp.add(new Respuesta("1959",false));
        tmp.add(new Respuesta("1969",true));
        tmp.add(new Respuesta("1979",false));
        tmp.add(new Respuesta("1989",false));
        p = new Pregunta(" ¿En qué año llegó el hombre a la luna por primera vez?",tmp,R.drawable.cultura);
        preguntas.add(p);

        tmp = new ArrayList<>();
        tmp.add(new Respuesta("Monte Everest",true));
        tmp.add(new Respuesta("Kilimanjaro",false));
        tmp.add(new Respuesta("Aconcagua",false));
        tmp.add(new Respuesta("Mont Blanc",false));
        p = new Pregunta("¿Cuál es la montaña más alta del mundo?",tmp,R.drawable.cultura);
        preguntas.add(p);

        tmp = new ArrayList<>();
        tmp.add(new Respuesta("6",false));
        tmp.add(new Respuesta("8",true));
        tmp.add(new Respuesta("10",false));
        tmp.add(new Respuesta("12",false));
        p = new Pregunta("¿Cuántas patas tiene una araña?",tmp,R.drawable.cultura);
        preguntas.add(p);

        tmp = new ArrayList<>();
        tmp.add(new Respuesta("Hierro",false));
        tmp.add(new Respuesta("Aluminio",true));
        tmp.add(new Respuesta("Oro",false));
        tmp.add(new Respuesta("Cobre",false));
        p = new Pregunta("¿Cuál es el metal más abundante en la corteza terrestre?",tmp,R.drawable.cultura);
        preguntas.add(p);

        tmp = new ArrayList<>();
        tmp.add(new Respuesta("1400",false));
        tmp.add(new Respuesta("1607",false));
        tmp.add(new Respuesta("1588",false));
        tmp.add(new Respuesta("1492",true));
        p = new Pregunta("¿En qué año se descubrió América?",tmp,R.drawable.cultura);
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
        if(contaPregunta<nPreguntas){
            ArrayList<Respuesta> tmp;
            pregunta.setText(contaPregunta+1 +"- "+ preguntasSeleccionadas.get(contaPregunta).getPregunta());
            tmp = preguntasSeleccionadas.get(contaPregunta).getRespuestas();

            if(random){ // ordena solo las respuestas
                ordenRespuestas(tmp);
            }

            img.setImageResource(preguntasSeleccionadas.get(contaPregunta).getImagen());
            btn1.setText(tmp.get(0).getRepuesta());
            btn2.setText(tmp.get(1).getRepuesta());
            btn3.setText(tmp.get(2).getRepuesta());
            btn4.setText(tmp.get(3).getRepuesta());

            if (tiempo){
                timer.start();
            }
        }
    }
    private void contestar(int indiceBoton){
        timer.cancel();
        if (contaPregunta<10){
            if (preguntasSeleccionadas.get(contaPregunta).getRespuestas().get(indiceBoton).isCorrecta()){

                preguntasSeleccionadas.get(contaPregunta).setAcertada(true);
            }else {

                preguntasSeleccionadas.get(contaPregunta).setAcertada(false);
            }
            if(contaPregunta == 9){
                Intent i = new Intent(this, ResultadoActivity.class);
                i.putExtra("preguntas",preguntasSeleccionadas);
                startActivity(i);
            }
            contaPregunta++;
            pasarPregunta();
        }else {

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.opciones){
            Intent i = new Intent(this, OpcionesActivity.class);
            startActivity(i);
        }
        return true;
    }
    private void cambiarActivityRespuestas(){
        Intent i = new Intent(this, ResultadoActivity.class);
        i.putExtra("preguntas",preguntasSeleccionadas);
        startActivity(i);
    }
}