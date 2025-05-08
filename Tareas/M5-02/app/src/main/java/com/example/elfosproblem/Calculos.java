package com.example.elfosproblem;

import android.app.Activity;
import android.content.res.Resources;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Calculos implements ICalculos{

    public int cals = 0;
    public int mayor = 0;
    public int posMayor = 0;
    InputStream archivo;
    private BufferedReader lector;
    Activity activity;
    ArrayList<Integer> elfos;
    TextView txv_nombre, txv_total;

    public Calculos(Activity activity) {
        this.activity = activity;
        //Obtener el archivo
        this.archivo = activity.getResources().openRawResource(R.raw.elfos_infor);
        this.elfos = new ArrayList<>();
    }

    @Override
    public void leer() {
        try (BufferedReader lector = new BufferedReader(new InputStreamReader(archivo))) {
            //Si se encuentra ahora se aloja en lector
            //Calorias en el renglon
            String renglonCal;

            //Leer linea por linea
            while((renglonCal = lector.readLine()) != null){

                if(renglonCal.isEmpty() || renglonCal.isBlank()){
                    //Si esta vacio vamos a agregar los ultimos valores que obtuvimos y vamos a buscar un nuevo elfo

                    this.elfos.add(this.cals); //Agrego las calorias del último elfo

                    if(this.elfos.size() - 1 == 0){
                        this.mayor = this.cals;
                    } else if(this.elfos.size() - 1 >= 1){
                        this.mayor = compara(this.mayor, this.cals);
                    }
                    //reseteamos a 0 las calorías para el proximo elfo
                    this.cals = 0;
                } else{
                    this.cals += Integer.valueOf(renglonCal);
                }

            }
            Log.i("FINAL", "El elfo con mayor número de calorias es el:\nElfo numero: " + elfos.indexOf(mayor) + "Con un total de");

        } catch (Resources.NotFoundException e) {
            Log.i("NOOOOO", "No se encontro el archivo");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int compara(int mayor, int segundo) {
        //Si el "mayor" sigue siendo mayor, regresa el mayor, de lo contrario regresa el nuevo
        return mayor > segundo ? mayor : segundo;
    }

    @Override
    public int getMayor() {
        return this.mayor;
    }

    @Override
    public ArrayList<Integer> getElfos(){
        return this.elfos;
    }

}
