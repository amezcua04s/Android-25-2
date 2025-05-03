package com.example.singleton;

import java.util.Date;

public class Authenticator {

    private static Authenticator instance = null;

    private Authenticator (){

    }

    public static Authenticator getInstance() {
        if (instance == null){
            instance = new Authenticator();
        }
        return instance;
    }

    public Boolean isLogged(Usuario usuario) {
        return usuario.authToken == null;
    }

}
