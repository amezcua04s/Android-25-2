package com.example.gato;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Ganador{

    public final List<int[]> ganadores = new ArrayList<>();

    public Ganador() {

        ganadores.add(new int[]{1, 2, 3});
        ganadores.add(new int[]{4, 5, 6});
        ganadores.add(new int[]{7, 8, 9});

        ganadores.add(new int[]{1, 4, 7});
        ganadores.add(new int[]{2, 5, 8});
        ganadores.add(new int[]{3, 6, 9});

        ganadores.add(new int[]{1, 5, 9});
        ganadores.add(new int[]{3, 5, 7});


    }

    public List<int[]> setGanadores() {
        return this.ganadores;
    }

    public List<int[]> getGanadores() {
        return this.ganadores;
    }

}
