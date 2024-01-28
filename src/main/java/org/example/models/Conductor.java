package org.example.models;

import java.time.LocalDate;

public class Conductor {
    //Atributos
    private String nombre;
    private String clave;
    private String provincia;
    private int tlf;
    private Envio envio1;
    private Envio envio2;
    private int contadorPaquetes = 0;

    //Getters y Setters
    public int getContadorPaquetes() {
        return contadorPaquetes;
    }

    public void setContadorPaquetes(int contadorPaquetes) {
        this.contadorPaquetes = contadorPaquetes;
    }

    public int getTlf() {
        return tlf;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    public Envio getEnvio1() {
        return envio1;
    }

    public void setEnvio1(Envio envio1) {
        this.envio1 = envio1;
    }

    public Envio getEnvio2() {
        return envio2;
    }

    public void setEnvio2(Envio envio2) {
        this.envio2 = envio2;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    //Constructor
    public Conductor(String nombre, String clave, String provincia, int tlf) {
        this.nombre = nombre;
        this.clave = clave;
        this.provincia = provincia;
        this.tlf = tlf;
    }

    //toString

    @Override
    public String toString() {
        return "=== " + getNombre() + " ===" + "\n" +
                "- " + getProvincia() + "\n" +
                "- " + getTlf() + "\n";
    }

    public String infoConductor() {
        return getNombre() + " - " + getProvincia() + " - " + getTlf() + "\n";
    }

    public boolean validaConductor(String nombreTeclado) {
        if (getNombre().equals(nombreTeclado)) return true;
        return false;
    }

    public int historicoPaquetes() {
        if (envio1 != null && envio1.getEstado().equals("Entregado")) contadorPaquetes++;
        if (envio2 != null && envio1.getEstado().equals("Entregado")) contadorPaquetes++;
        return getContadorPaquetes();
    }
}
