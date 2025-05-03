package com.example.gato;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.List;

public class Gato extends Ganador implements IGato {

    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private ImageView img5;
    private ImageView img6;
    private ImageView img7;
    private ImageView img8;
    private ImageView img9;
    private Button btnReinicia;
    private Boolean im1 = false;
    private Boolean im2 = false;
    private Boolean im3 = false;
    private Boolean im4 = false;
    private Boolean im5 = false;
    private Boolean im6 = false;
    private Boolean im7 = false;
    private Boolean im8 = false;
    private Boolean im9 = false;
    public int[] jugador1 = new int[5];
    public int[] jugador2 = new int[5] ;
    public int i = 0;
    private int i2 = 0;
    Ganador gana = new Ganador();
    Boolean turno = false;
    Boolean ganador = false;
    Context context;


    public Gato(@NonNull Activity activity){

        context = activity.getApplicationContext();

        img1 = activity.findViewById(R.id.img1);
        img1.setOnClickListener(v -> {
            if(!im1 && !ganador){
                if(!turno){
                    img1.setImageResource(R.drawable.baseline_ac_unit_24);
                    i = turno(jugador1, 1, i);

                } else {
                    img1.setImageResource(R.drawable.baseline_access_time_filled_24);
                    i2 = turno(jugador2, 1, i2);

                }
                turno = !turno;
                im1 = true;
            }
        });

        img2 = activity.findViewById(R.id.img2);
        img2.setOnClickListener(v -> {
            if(!im2 && !ganador){
                if(!turno){
                    img2.setImageResource(R.drawable.baseline_ac_unit_24);
                    i = turno(jugador1, 2, i);

                } else {
                    img2.setImageResource(R.drawable.baseline_access_time_filled_24);
                    i2 = turno(jugador2, 2, i2);

                }
                turno = !turno;
                im2 = true;
            }
        });

        img3 = activity.findViewById(R.id.img3);
        img3.setOnClickListener(v -> {
            if(!im3 && !ganador){
                if(!turno){
                    img3.setImageResource(R.drawable.baseline_ac_unit_24);
                    i = turno(jugador1, 3, i);

                } else {
                    img3.setImageResource(R.drawable.baseline_access_time_filled_24);
                    i2 = turno(jugador2, 3, i2);


                }
                turno = !turno;
                im3 = true;
            }
        });

        img4 = activity.findViewById(R.id.img4);
        img4.setOnClickListener(v -> {
            if(!im4 && !ganador){
                if(!turno){
                    img4.setImageResource(R.drawable.baseline_ac_unit_24);
                    i = turno(jugador1, 4, i);

                } else {
                    img4.setImageResource(R.drawable.baseline_access_time_filled_24);
                    i2 = turno(jugador2, 4, i2);

                }
                turno = !turno;
                im4 = true;
            }
        });

        img5 = activity.findViewById(R.id.img5);
        img5.setOnClickListener(v -> {
            if(!im5 && !ganador){
                if(!turno){
                    img5.setImageResource(R.drawable.baseline_ac_unit_24);
                    i = turno(jugador1, 5, i);

                } else {
                    img5.setImageResource(R.drawable.baseline_access_time_filled_24);
                    i2 = turno(jugador2, 5, i2);

                }
                turno = !turno;
                im5 = true;
            }
        });

        img6 = activity.findViewById(R.id.img6);
        img6.setOnClickListener(v -> {
            if(!im6 && !ganador){
                if(!turno){
                    img6.setImageResource(R.drawable.baseline_ac_unit_24);
                    i = turno(jugador1, 6, i);

                } else {
                    img6.setImageResource(R.drawable.baseline_access_time_filled_24);
                    i2 = turno(jugador2, 6, i2);

                }
                turno = !turno;
                im6 = true;
            }
        });

        img7 = activity.findViewById(R.id.img7);
        img7.setOnClickListener(v -> {
            if(!im7 && !ganador){
                if(!turno){
                    img7.setImageResource(R.drawable.baseline_ac_unit_24);
                    i = turno(jugador1, 7, i);

                } else {
                    img7.setImageResource(R.drawable.baseline_access_time_filled_24);
                    i2 = turno(jugador2, 7, i2);

                }
                turno = !turno;
                im7 = true;
            }
        });

        img8 = activity.findViewById(R.id.img8);
        img8.setOnClickListener(v -> {
            if(!im8 && !ganador){
                if(!turno){
                    img8.setImageResource(R.drawable.baseline_ac_unit_24);
                    i = turno(jugador1, 8, i);
                } else {

                    img8.setImageResource(R.drawable.baseline_access_time_filled_24);
                    i = turno(jugador2, 8, i);

                }
                turno = !turno;
                im8 = true;
            }
        });

        img9 = activity.findViewById(R.id.img9);
        img9.setOnClickListener(v -> {
            if(!im9 && !ganador){
                if(!turno){
                    img9.setImageResource(R.drawable.baseline_ac_unit_24);
                    i = turno(jugador1, 9, i);

                } else {

                    img9.setImageResource(R.drawable.baseline_access_time_filled_24);
                    i2 = turno(jugador2, 9, i);

                }
                turno = !turno;
                im9 = true;
            }
        });

        btnReinicia = activity.findViewById(R.id.restart);
        btnReinicia.setOnClickListener(v -> restart());

    }

    @Override
    public void restart() {
        img1.setImageDrawable(null);
        img2.setImageDrawable(null);
        img3.setImageDrawable(null);
        img4.setImageDrawable(null);
        img5.setImageDrawable(null);
        img6.setImageDrawable(null);
        img7.setImageDrawable(null);
        img8.setImageDrawable(null);
        img9.setImageDrawable(null);

        i = 0;
        i2 = 0;

        jugador1 = new int[5];
        jugador2 = new int[5];

        Arrays.fill(jugador1, 0);
        Arrays.fill(jugador2,0);

        ganador = false;

        im1 = false;
        im2 = false;
        im3 = false;
        im4  = false;
        im5 = false;
        im6 = false;
        im7 = false;
        im8 = false;
        im9 = false;

    }

    @Override
    public void ganador(Boolean jugador) {
        if(jugador){
            Toast.makeText(context, "El ganador es: Jugador 1" , Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "El ganador es: Jugador 2" , Toast.LENGTH_LONG).show();
        }
    }

    public int turno(int[] jugador, int pos, int contador){
        jugador[contador] = pos;
        eval();
        return contador += 1;
    }

    @Override
    public void eval(){
        if(i + i2 >= 4) {
            if (combina(jugador1, gana.getGanadores()) || combina(jugador2, gana.getGanadores()) )  {
                ganador(turno);
            } else if(i+i2 == 8 && !ganador) {
                Toast.makeText(context, "NO HUBO GANADOR" , Toast.LENGTH_LONG).show();
            }
        }
    }

    public boolean combina(int[] jugador, List<int[]> combinacionesGanadoras) {
        for (int[] combinacion : combinacionesGanadoras) {
            //Log.i("COMB", Arrays.toString(combinacion));
            if (ganador(jugador, combinacion)) {
                Log.i("WIN", "ganador");
                return true;
            }
        }
        return false;
    }

    public boolean ganador(int[] arreglo, int[] combinacion) {
        for (int elemento : combinacion) {
            boolean encontrado = false;
            for (int pos : arreglo) {
                if (elemento == pos) {
                    //Log.i("POS", pos +"");
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                return false;
            }
        }
        return true;
    }

}