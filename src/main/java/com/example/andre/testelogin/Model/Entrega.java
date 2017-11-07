package com.example.andre.testelogin.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by andre on 03/09/2017.
 */

public class Entrega {

    private String cliente;
    private String data;
    private String tipo;

    public Entrega(String cliente, String data, String tipo) {

        this.cliente = cliente;
        this.data = data;
        this.tipo = tipo;

    }


    public String getCliente() {
        return cliente;
    }

    public String getData() {
        return data;
    }

    public String getTipo() {
        return tipo;
    }


}
