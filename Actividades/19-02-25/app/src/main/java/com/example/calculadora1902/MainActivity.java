package com.example.calculadora1902;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.NumberFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView txvValor, txvTermino;
    Button btnAumentar, btnReinicio, btnAnterior;
    Double a = 1.0;
    ArrayList<Double> fibonacci = new ArrayList<>();
    int contador = 0;
    Context context;

    final NumberFormat entero = NumberFormat.getInstance();


    @SuppressLint("MissingInflatedId")
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
        txvValor = findViewById(R.id.txv_valor);
        txvTermino = findViewById(R.id.txv_termino);

        btnAumentar = findViewById(R.id.btn_increase);
        btnReinicio = findViewById(R.id.btn_restart);
        btnAnterior = findViewById(R.id.btn_anterior);

        btnAumentar.setOnClickListener(this);

        this.fibonacci.add(0.0);
        txvValor.setText(String.valueOf(
                entero.format(this.fibonacci.get(this.fibonacci.size()-1)))
        );
        txvTermino.setText(String.valueOf(contador));

    }

    @Override
    public void onClick(View v) {

        //si la serie esta comenzando, agregar los primeros valores
        if(this.contador <= 1){
            this.fibonacci.add(a);
        } else {
            //agregamos lo que nos devuelva la funcion que incrementa, manzamos el valor del indice
            double n = incrementa(this.fibonacci.size()-1);
            this.fibonacci.add(n);
        }
        //aumentamos el contador o posicion del termino y actualizamos pantalla
        this.contador ++;

        txvValor.setText(entero.format(this.fibonacci.get(this.fibonacci.size() - 1)));
        txvTermino.setText(String.valueOf(this.contador));
    }

    //funcion recursiva, solo recibe el indice actual (el ultimo numero)
    public double incrementa(int index) {
        //valor "nuevo", el que regresaremos
        double nuevo = this.fibonacci.get(index);

        if(index == this.fibonacci.size() - 2){
            //si es igual,no hacemos nada, sale del ciclo para regresar el valor
        } else {
            //buscamos el numero anterior para sumarlo
            nuevo += incrementa(index - 1);
        }
        return nuevo;
    }

    public void reinicia(View v){
        //vaciamos el arreglo y reiniciamos los valores a 1
        this.fibonacci.clear();
        this.fibonacci.add(0.0);
        this.a = 1.0;
        this.contador = 0;

        //mostramos los valores principales
        txvTermino.setText(String.valueOf(this.contador));
        txvValor.setText(
                String.valueOf(
                        entero.format(this.fibonacci.get(0))
                )
        );
    }

    public void anterior(View v) {
        context = this.getApplicationContext();
        try {
            //obtenemos ultimo numero y lo eliminamos
            int index = this.fibonacci.size() - 1;
            this.fibonacci.remove(index);
            this.contador -= 1;
            //mostramos valor del contado y el penultimo numero (ahora ultimo)
            txvTermino.setText(String.valueOf(this.contador));
            txvValor.setText(
                    String.valueOf(
                            entero.format(this.fibonacci.get(index - 1)) // mostramos el penultimo (ahora ultimo)
                    )
            );
            //Si el usuario intenta ir más atras del 0, muestra el error
        } catch (Exception e) {
            Toast.makeText(context, "Error, no puede retroceder más" ,Toast.LENGTH_LONG).show();
        }
    }
}