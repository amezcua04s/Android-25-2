package com.example.cdigo;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    final NumberFormat entero = NumberFormat.getInstance();
    long tInicio = System.currentTimeMillis();
    final int eLength = 1000000;
    TextView txv_primero, txv_ultimo, txv_mitad;
    String cPrimero = "", cUltimo = "", cMitad = "";
    Random eNumero = new Random();

    int[] arreglo = new int[eLength];

    @RequiresApi(api = Build.VERSION_CODES.VANILLA_ICE_CREAM)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        for(int eIndice= 0; eIndice < eLength-1; eIndice++){
           arreglo[eIndice] = eNumero.nextInt(1,1000000);
        }
        Log.i("EXITO","Arreglo creado "+ arreglo[0] + " ; " + arreglo[eLength-1]);

        Sort.quickSort(arreglo, 0, eLength-1);

        txv_primero = findViewById(R.id.txv_primero);
        txv_ultimo = findViewById(R.id.txv_ultimo);
        txv_mitad = findViewById(R.id.txv_mitad);

        long tFinal = System.currentTimeMillis();

        Log.i("M03", "El tiempo de ejecución fue: " + (tFinal-tInicio) + " milisegundos.");

        cPrimero = "El primer número del arreglo es:\n"+arreglo[1];
        cMitad = "El valor en la posición " + entero.format(eLength/2) + " es:\n " + entero.format(arreglo[(eLength/2)]);
        cUltimo = "El último número del arreglo es:\n"+entero.format(arreglo[eLength-1]);


        txv_primero.setText(cPrimero);
        txv_mitad.setText(cMitad);
        txv_ultimo.setText(cUltimo);
    }


}