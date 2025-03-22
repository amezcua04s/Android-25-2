package com.example.gato;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;
    ImageView img7;
    ImageView img8;
    ImageView img9;
    Boolean im1 = false;
    Boolean im2 = false;
    Boolean im3 = false;
    Boolean im4  = false;
    Boolean im5 = false;
    Boolean im6 = false;
    Boolean im7 = false;
    Boolean im8 = false;
    Boolean im9 = false;
    Boolean turno = false;
    private final List<int[]> ganadores = new ArrayList<>();
    int[] jugador1 = new int[5];
    int i = 0, i2 = 0;
    int[] jugador2 = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ganadores.add(new int[] {1,2,3});
        ganadores.add(new int[] {4,5,6});
        ganadores.add(new int[] {7,8,9});

        ganadores.add(new int[] {1,4,7});
        ganadores.add(new int[] {2,5,8});
        ganadores.add(new int[] {3,6,9});

        ganadores.add(new int[] {1,5,9});
        ganadores.add(new int[] {3,5,7});

        img1 = findViewById(R.id.img1);
        img1.setOnClickListener(v -> {
            if(!im1){
                if(turno){
                    img1.setImageResource(R.drawable.baseline_ac_unit_24);
                    jugador1[i] = 1;
                    i++;
                } else {
                    img1.setImageResource(R.drawable.baseline_access_time_filled_24);
                    jugador2[i2] = 1;
                    i2++;
                }
                turno = !turno;
                im1 = true;
            }
        });

        img2 = findViewById(R.id.img2);
        img2.setOnClickListener(v -> {
            if(!im2){
                if(turno){
                    img2.setImageResource(R.drawable.baseline_ac_unit_24);
                    jugador1[i] = 2;
                    i++;
                } else {
                    img2.setImageResource(R.drawable.baseline_access_time_filled_24);
                    jugador2[i2] = 2;
                    i2++;
                }
                turno = !turno;
                im2 = true;
            }

        });

        img3 = findViewById(R.id.img3);
        img3.setOnClickListener(v -> {
            if(!im3){
                if(turno){
                    img3.setImageResource(R.drawable.baseline_ac_unit_24);
                    jugador1[i] = 3;
                    i++;
                } else {
                    img3.setImageResource(R.drawable.baseline_access_time_filled_24);
                    jugador2[i2] = 3;
                    i2++;
                }
            }
            turno = !turno;
            im3 = true;
        });

        img4 = findViewById(R.id.img4);
        img4.setOnClickListener(v -> {
            if(!im4){
                if(turno){
                    img4.setImageResource(R.drawable.baseline_ac_unit_24);
                    jugador1[i] = 4;
                    i++;
                } else {
                    img4.setImageResource(R.drawable.baseline_access_time_filled_24);
                    jugador2[i2] = 4;
                    i2++;
                }
                turno = !turno;
                im4 = true;
            }

        });

        img5 = findViewById(R.id.img5);
        img5.setOnClickListener(v -> {
            if(!im5){
                if(turno){
                    img5.setImageResource(R.drawable.baseline_ac_unit_24);
                    jugador1[i] = 5;
                    i++;
                } else {
                    img5.setImageResource(R.drawable.baseline_access_time_filled_24);
                    jugador2[i2] = 5;
                    i2++;
                }
                turno = !turno;
                im5 = true;
            }
        });

        img6 = findViewById(R.id.img6);
        img6.setOnClickListener(v -> {
            if(!im6){
                if(turno){
                    img6.setImageResource(R.drawable.baseline_ac_unit_24);
                    jugador1[i] = 6;
                    i++;
                } else {
                    img6.setImageResource(R.drawable.baseline_access_time_filled_24);
                    jugador2[i2] = 6;
                    i2++;
                }
                turno = !turno;
                im6 = true;
            }

        });

        img7 = findViewById(R.id.img7);
        img7.setOnClickListener(v -> {
            if(!im7){
                if(turno){
                    img7.setImageResource(R.drawable.baseline_ac_unit_24);
                    jugador1[i] = 7;
                    i++;
                } else {
                    img7.setImageResource(R.drawable.baseline_access_time_filled_24);
                    jugador2[i2] = 7;
                    i2++;
                }
                turno = !turno;
                im7 = true;
            }
        });

        img8 = findViewById(R.id.img8);
        img8.setOnClickListener(v -> {
            if(!im8){
                if(turno){
                    img8.setImageResource(R.drawable.baseline_ac_unit_24);
                    jugador1[i] = 8;
                    i++;
                } else {
                    img8.setImageResource(R.drawable.baseline_access_time_filled_24);
                    jugador2[i2] = 8;
                    i2++;
                }
                turno = !turno;
                im8 = true;
            }
        });

        img9 = findViewById(R.id.img9);
        img9.setOnClickListener(v -> {
            if(!im9){
                if(turno){
                    img9.setImageResource(R.drawable.baseline_ac_unit_24);
                    jugador1[i] = 9;
                    i++;
                } else {
                    img9.setImageResource(R.drawable.baseline_access_time_filled_24);
                    jugador2[i2] = 9;
                    i2++;
                }
                turno = !turno;
                im9 = true;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    void restablecre(){
        Boolean im1 = false;
        Boolean im2 = false;
        Boolean im3 = false;
        Boolean im4  = false;
        Boolean im5 = false;
        Boolean im6 = false;
        Boolean im7 = false;
        Boolean im8 = false;
        Boolean im9 = false;
    }

    void ganador(){
        String jugador = "";


        Toast.makeText(this, "El ganador es:" + jugador, Toast.LENGTH_LONG).show();
    }

}