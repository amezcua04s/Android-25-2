package com.example.activittylife;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnReinicio;
    TextView txvMiTexto;
    String cadena = "";

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

        txvMiTexto = findViewById(R.id.txv_main);
        btnReinicio = findViewById(R.id.btn_reinicio);

        btnReinicio.setOnClickListener(this);

        cadena += "\n| onCreate(savedInstanceState)";
        txvMiTexto.setText(cadena);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        cadena += "\n| onCreate(savedInstanceState, persistentState)";
        txvMiTexto.setText(cadena);
    }

    @Override
    protected void onStart() {
        super.onStart();
        cadena += "\n| onStart()";
        txvMiTexto.setText(cadena);
    }

    @Override
    protected void onPause() {
        super.onPause();
        cadena += "\n| onPause()";
        txvMiTexto.setText(cadena);
    }

    @Override
    protected void onStop() {
        super.onStop();
        cadena += "\n| onStop()";
        txvMiTexto.setText(cadena);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cadena += "\n| onDestroy()";
        txvMiTexto.setText(cadena);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        cadena += "\n| onRestart()";
        txvMiTexto.setText(cadena);
    }

    @Override
    public void onClick(View v) {
        cadena = "Reinicio";
        txvMiTexto.setText(cadena);
    }
}