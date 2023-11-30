package com.example.apptrivia;

import java.io.Serializable;
import java.util.ArrayList;

public class Pregunta implements Serializable {
    private String pregunta;
    private ArrayList<Respuesta> respuestas;
    private boolean acertada;
    private int imagen;
    public Pregunta(String pregunta, ArrayList<Respuesta> respuestas,int imagen) {
        this.pregunta = pregunta;
        this.respuestas = respuestas;
        this.imagen = imagen;
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

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
    public String getRespuestaCorrecta(){
        for (Respuesta tmp:respuestas){
            if (tmp.isCorrecta()){
                return tmp.getRepuesta();
            }
        }
        return null;
    }
}
