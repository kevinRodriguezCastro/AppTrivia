package com.example.apptrivia;

import java.io.Serializable;

public class Respuesta implements Serializable {
    private String repuesta;
    private boolean correcta;

    public Respuesta(String repuesta, boolean correcta) {
        this.repuesta = repuesta;
        this.correcta = correcta;
    }

    public String getRepuesta() {
        return repuesta;
    }

    public boolean isCorrecta() {
        return correcta;
    }
}
