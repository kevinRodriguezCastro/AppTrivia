package com.example.apptrivia;

import java.util.ArrayList;

public class Pregunta {
    private String pregunta;
    private ArrayList<Respuesta> respuestas;
    private boolean acertada;
    public Pregunta(String pregunta, ArrayList<Respuesta> respuestas) {
        this.pregunta = pregunta;
        this.respuestas = respuestas;
    }

    public void responder(Respuesta r){
        if (r.isCorrecta()){
            acertada = true;
        }
        acertada = false;
    }
    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public ArrayList<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ArrayList<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public boolean isAcertada() {
        return acertada;
    }

    public void setAcertada(boolean acertada) {
        this.acertada = acertada;
    }
}
