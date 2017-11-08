package com.example.andre.testelogin.Model;

/**
 * Created by andre on 07/11/2017.
 */

public class Usuario {
    int id;
    String user;
    String senha;
    int tipoUser;

    public Usuario(int id, String user, String senha, int tipoUser) {
        this.id = id;
        this.user = user;
        this.senha = senha;
        this.tipoUser = tipoUser;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(int tipoUser) {
        this.tipoUser = tipoUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
