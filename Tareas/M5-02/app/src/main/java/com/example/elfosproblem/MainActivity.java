package com.example.elfosproblem;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ICalculos calculo;

    TextView txv_nombre, txv_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        calculo = new Calculos(this);
        calculo.leer();

        Log.i("MAIN", "Entro en main");
        txv_nombre = this.findViewById(R.id.txv_nombre);
        txv_total = this.findViewById(R.id.txv_total);
        Log.i("MAIN", "Encontro todo en main del layout");

        ArrayList<Integer> elfo = calculo.getElfos();
        int mayor = calculo.getMayor();

        txv_nombre.setText("El elfo con mayor número de calorias es: " + elfo.indexOf(mayor));
        txv_total.setText("Su total de calorísa son:" + mayor);

    }
}