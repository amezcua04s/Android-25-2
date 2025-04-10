package com.example.proyecto24032025;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearSmoothScroller;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    LinearLayout root;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        root = findViewById(R.id.lytMain);

        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(v -> {
            generaImagen();
        });


    }

    void generaImagen(){
        //Aquí se genera el inflado de vista
        LinearLayout lytItemPrueba = (LinearLayout) LinearLayout.inflate(this, R.layout.item_prueba, null);
        ImageView img = new ImageView(this);

        //Aquí se genera la imagen
        img.setImageResource(R.mipmap.ic_launcher);
        img.setMinimumHeight(100);
        img.setMinimumWidth(100);

        //Aquí se agrega la imagen al layout inflado
        lytItemPrueba.addView(img);

        //Aquí se agrega el layout inflado a la vista root
        root.addView(lytItemPrueba);

    }
}