package com.example.andre.testelogin.Model;

/**
 * Created by andre on 07/11/2017.
 */

public class Usuario {
    String user;
    String senha;
    int tipoUser;

    public Usuario(String user, String senha, int tipoUser) {
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
}
