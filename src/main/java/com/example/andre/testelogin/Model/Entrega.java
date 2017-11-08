package com.example.andre.testelogin.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by andre on 03/09/2017.
 */

public class Entrega {

    private int cliente;
    private String data;
    private int tipo;
    private String img;
    private String valor;

    public Entrega(int cliente, String img, String valor, String data,int tipo) {

        this.cliente = cliente;
        this.img = img;
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;

    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
