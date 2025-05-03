package com.example.gato;

import android.content.Context;

import java.util.List;

public interface IGato {

    void restart();

    void ganador(Boolean jugador);

    public int turno(int[] jugador, int pos, int contador);
    public void eval();
    public boolean combina(int[] jugador, List<int[]> combinacionesGanadoras);
    public boolean ganador(int[] arreglo, int[] combinacion);
}
