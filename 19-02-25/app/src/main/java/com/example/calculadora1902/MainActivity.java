package com.example.calculadora1902;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.util.LogPrinter;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView txvMitexto;
    Button btnReinicio;
    //String cadena = "";
    Double a = 1.0;
    Double b = 0.0;


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
        //Log.println(Log.INFO, null, "onCreate savedInstanceState");

        txvMitexto = findViewById(R.id.txv_main);
        btnReinicio = findViewById(R.id.btn_reinicio);

        btnReinicio.setOnClickListener(this);

        //Copiar y pegar las dos lineas en los metodos del ciclo de vida de una activity
        //cadena += "\n| onCreate(savedInstanceState, persistentState)";
        //txvMitexto.setText(cadena);

    }
/*
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
         super.onCreate(savedInstanceState, persistentState);
        Log.println(Log.INFO, null, "onCreate");
        cadena += "\n| onCreate(savedInstanceState, persistentState)";
        txvMitexto.setText(cadena);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.println(Log.INFO, null, "onStart");
        cadena += "\n| onStart()";
        txvMitexto.setText(cadena);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.println(Log.INFO, null, "onPause");
        cadena += "\n| onPause()";
        txvMitexto.setText(cadena);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.println(Log.INFO, null, "onStop");
        cadena += "\n| onStop()";
        txvMitexto.setText(cadena);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.println(Log.INFO, null, "onDestroy");
        cadena += "\n| onDestroy()";
        txvMitexto.setText(cadena);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.println(Log.INFO, null, "onRestart");
        cadena += "\n| onRestart";
        txvMitexto.setText(cadena);
    }

    @Override
    public void onClick(View v) {
        cadena = "Reinicio";
        txvMitexto.setText(cadena);
    }*/

    @Override
    public void onClick(View v) {

        this.a += this.b;
        txvMitexto.setText("Serie Fibonnaci\n" + this.a.toString());
        this.b = this.a;

    }



}