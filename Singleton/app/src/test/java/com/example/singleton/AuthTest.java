package com.example.singleton;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.Random;

public class AuthTest {

    @Test
    public void testUser(){
        Random random = new Random();
        String id = String.valueOf(random.nextLong());

        Usuario usuario = new Usuario(id, "Mario", "ejemplo@gmail.com" );

        Assert.assertEquals(usuario.getNombre(), "Mario");
        Assert.assertEquals(usuario.getEmail(), "ejemplo@gmail.com");
        Assert.assertNull(usuario.authToken);
    }

    @Test
    public void testTokenExpired(){

        Random random = new Random();
        String id = String.valueOf(random.nextLong());
        String id2 = String.valueOf(random.nextLong());
        Date exp = new Date();

        Usuario usuario = new Usuario(id, "Mario", "ejemplo@gmail.com" );

        Assert.assertEquals(usuario.getNombre(), "Mario");
        Assert.assertEquals(usuario.getEmail(), "ejemplo@gmail.com");
        Assert.assertNotNull(usuario.authToken);
    }

    @Test
    public void testTokenNotExpired(){
        Random random = new Random();
        String id = String.valueOf(random.nextLong());
        Date exp = new Date();

        Usuario usuario = new Usuario(id, "Mario", "ejemplo@gmail.com" );

        Assert.assertEquals(usuario.getNombre(), "Mario");
        Assert.assertEquals(usuario.getEmail(), "ejemplo@gmail.com");
        Assert.assertNotNull(usuario.authToken);
    }

    @Test
    public void testTokenSucces(){

    }

    @Test
    public void testUserIsLogged(){

    }

    @Test
    public void testUserIsNotLogged(){

    }




}
