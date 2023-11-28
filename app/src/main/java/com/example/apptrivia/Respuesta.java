package com.example.apptrivia;

public class Respuesta {
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
