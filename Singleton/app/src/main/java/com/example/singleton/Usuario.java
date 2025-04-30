package com.example.singleton;

import androidx.annotation.Nullable;

public class Usuario {

    private String id;
    private String nombre;
    private String email;

    AuthToken authToken = null;

    public Usuario(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAuthToken(@Nullable AuthToken newToken){
        this.authToken = newToken;
    }

}
