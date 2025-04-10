package com.example.proyect24032025;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.widget.GridLayout.VERTICAL;


import android.os.Bundle;
import android.view.Gravity;
import android.view.inputmethod.SelectGesture;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    LinearLayout root, segundo, primero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        root = findViewById(R.id.lytMain);

        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(v -> {
            agrega();
        });

        generaLayout();
    }

    void agrega() {
        ImageView img = new ImageView(this);
        ImageView img2 = new ImageView(this);

        //Aquí se genera la imagen
        img.setImageResource(R.mipmap.ic_launcher);
        img.setMinimumHeight(100);
        img.setMinimumWidth(WRAP_CONTENT);

        img2.setImageResource(R.mipmap.ic_launcher);
        img2.setMinimumHeight(100);
        img2.setMinimumWidth(MATCH_PARENT);

        primero.addView(img);
        segundo.addView(img2);

    }
    void generaLayout(){
        //Aquí se genera el inflado de vista
        LinearLayout primero = (LinearLayout) LinearLayout.inflate(this, R.layout.item_prueba, null);
        LinearLayout segundo = (LinearLayout) LinearLayout.inflate(this, R.layout.item_prueba, null);


        this.segundo = segundo;
        this.primero = primero;
        root.addView(primero);
        root.addView(segundo);

        //Aquí se agrega la imagen al layout inflado
        primero.setGravity(Gravity.CENTER);
        primero.setOrientation(LinearLayout.VERTICAL);

        segundo.setGravity(Gravity.CENTER);
        segundo.setOrientation(LinearLayout.VERTICAL);

        //Aquí se agrega el layout inflado a la vista root

        segundo.setMinimumWidth(MATCH_PARENT);
        segundo.setMinimumHeight(WRAP_CONTENT);
        segundo.setBackgroundColor(getResources().getColor(R.color.fondo, getTheme()));

        segundo.setMinimumWidth(MATCH_PARENT);
        segundo.setMinimumHeight(WRAP_CONTENT);
        segundo.setBackgroundColor(getResources().getColor(R.color.white, getTheme()));

    }
}