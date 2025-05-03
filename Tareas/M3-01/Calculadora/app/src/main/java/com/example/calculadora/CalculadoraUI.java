package com.example.calculadora;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class CalculadoraUI implements  ICalculadoraUI {

    Activity activity;
    TextView txv_resultado, txv_solution;
    Button btn_uno, btn_dos, btn_tres, btn_cuatro, btn_cinco, btn_seis, btn_siete, btn_ocho, btn_nueve, btn_cero;
    Button btn_resta, btn_suma, btn_mult, btn_div, btn_sqr, btn_porc, btn_igual;
    Button btn_AC, btn_dot;
    String resulC = "", operaC = "";
    Character opC;
    Double resF, resul, opera;
    Boolean o = false;

    public CalculadoraUI(@NonNull Activity activity) {

        this.activity = activity;

        txv_resultado = activity.findViewById(R.id.txv_resultado);
        txv_solution = activity.findViewById(R.id.txv_solution);

        btn_cero = activity.findViewById(R.id.btn_cero);
        btn_uno =  activity.findViewById(R.id.btn_uno);
        btn_dos = activity.findViewById(R.id.btn_dos);
        btn_tres = activity.findViewById(R.id.btn_tres);
        btn_cuatro = activity.findViewById(R.id.btn_cuatro);
        btn_cinco = activity.findViewById(R.id.btn_cinco);
        btn_seis = activity.findViewById(R.id.btn_seis);
        btn_siete = activity.findViewById(R.id.btn_siete);
        btn_ocho = activity.findViewById(R.id.btn_ocho);
        btn_nueve = activity.findViewById(R.id.btn_nueve);

        btn_resta = activity.findViewById(R.id.btn_resta);
        btn_suma = activity.findViewById(R.id.btn_suma);
        btn_mult = activity.findViewById(R.id.btn_mult);
        btn_div = activity.findViewById(R.id.btn_div);
        btn_sqr = activity.findViewById(R.id.btn_sqr);
        btn_porc = activity.findViewById(R.id.btn_porc);
        btn_igual = activity.findViewById(R.id.btn_igual);

        btn_AC = activity.findViewById(R.id.btn_AC);
        btn_dot = activity.findViewById(R.id.btn_dot);

        btn_cero.setOnClickListener(v -> {
            addDigit('0');
        });

        btn_uno.setOnClickListener(v -> {
            addDigit('1');
        });

        btn_dos.setOnClickListener(v -> {
            addDigit('2');
        });

        btn_tres.setOnClickListener(v -> {
            addDigit('3');
        });

        btn_cuatro.setOnClickListener(v -> {
            addDigit('4');
        });

        btn_cinco.setOnClickListener(v -> {
            addDigit('5');
        });

        btn_seis.setOnClickListener(v -> {
            addDigit('6');
        });

        btn_siete.setOnClickListener(v -> {
            addDigit('7');
        });

        btn_ocho.setOnClickListener(v -> {
            addDigit('8');
        });

        btn_nueve.setOnClickListener(v -> {
            addDigit('9');
        });

        btn_AC.setOnClickListener(v -> {
            clearScreen();
        });

        btn_porc.setOnClickListener(v -> {
            operador(String.valueOf(this.txv_solution.getText()), '%');
        });

        btn_sqr.setOnClickListener(v -> {
            operador(String.valueOf(this.txv_solution.getText()), '²');
        });

        btn_div.setOnClickListener(v -> {
            operador(String.valueOf(this.txv_solution.getText()), '/');
        });

        btn_mult.setOnClickListener(v -> {
            operador(String.valueOf(this.txv_solution.getText()), '*');
        });

        btn_resta.setOnClickListener(v -> {
            operador(String.valueOf(this.txv_solution.getText()), '-');
        });

        btn_suma.setOnClickListener(v -> {
            operador(String.valueOf(this.txv_solution.getText()), '+');
        });

        btn_dot.setOnClickListener(v -> {
            operador(String.valueOf(this.txv_solution.getText()), '.');
        });

        btn_igual.setOnClickListener(v -> {
            showResult();
        });

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void addDigit(Character btnValor){

        String operacion = String.valueOf(txv_solution.getText());
        operacion = operacion + btnValor;
        txv_solution.setText(operacion);

        if((Character.isDigit(btnValor) || btnValor == '.') && !this.o ){
            //Si es un número y no se ha puesto ningun operador, agregar a la primer cadena
            this.resulC = this.resulC + btnValor;
            if (!this.resulC.isEmpty()) {
                try {
                    this.resul = Double.parseDouble(this.resulC);
                } catch (NumberFormatException e) {
                    errores("Error interno");
                    this.resul = 0.0;
                }
            }
        } else if((Character.isDigit(btnValor) || btnValor == '.') && this.o){
            //Si es un número y ya se ha puesto un operador, agregar a la cadena
            this.operaC = this.operaC + btnValor;
            if (!this.operaC.isEmpty()) {
                try {
                    this.opera = Double.parseDouble(this.operaC);
                } catch (NumberFormatException e) {
                    this.opera = 0.0;
                }
            }
        } else if(!Character.isDigit(btnValor) && !this.o){
            //No es un número y es el primer operador
            if (btnValor == '²') {
                if (this.resul != null) {
                    this.resul = Math.pow(this.resul, 2);

                    txv_resultado.setText(String.valueOf(this.resul));
                    txv_solution.setText(this.resulC + "²");
                    this.resulC = String.valueOf(this.resul);

                    this.o = false;
                    this.opC = null;
                } else {
                    errores("Ingresa un número para calcular");
                }
                return;
            } else if  (btnValor == '%') {
                if (this.resul != null) {
                    this.resul /= 100.0;

                    txv_resultado.setText(String.valueOf(this.resul));
                    txv_solution.setText(this.resulC + "%");

                    this.resulC = String.valueOf(this.resul);

                    this.o = false;
                    this.opC = null;
                } else {
                    errores("Ingresa un número para calcular");
                }
                return;
            }

            this.opC = btnValor;
            this.o = true;

            if (!this.resulC.isEmpty()) { // debe haber al menos un numero antes del primer operando
                try {
                    this.resul = Double.parseDouble(this.resulC);
                } catch (NumberFormatException e) {
                    errores("Error interno");
                    this.resul = 0.0;
                }
            }

        } else if(!Character.isDigit(btnValor) && this.o && !this.operaC.isEmpty()){

            //No es un número y es el second operator, hacer la oepración anterior
            Double num2 = Double.parseDouble(this.operaC);

            this.resul = calcular(this.resul, num2, this.opC);
            this.opC = btnValor; // operador que se utilizara
            this.operaC = "";     // reinicia el segundo operando

            txv_resultado.setText(String.valueOf(this.resul)); // mostrar el resultado en pantalla
            txv_solution.setText(this.resul + String.valueOf(btnValor)); // actualizar la operacion que se esta haciendo

        } else if (!Character.isDigit(btnValor) && this.o && this.operaC.isEmpty()) {

            this.opC = btnValor;
            String currentSolution = txv_solution.getText().toString();

            if (!currentSolution.isEmpty() && !Character.isDigit(currentSolution.charAt(currentSolution.length() - 1))) {
                txv_solution.setText(currentSolution.substring(0, currentSolution.length() - 1) + btnValor);
            } else if (!currentSolution.isEmpty()) {
                txv_solution.setText(currentSolution + btnValor);
            }
        }
    }

    @Override
    public void operador(String operacion, Character operador){
        int index = operacion.length()-1;
        if (Character.isDigit(operacion.charAt(index)) || operacion.charAt(index) == '.') {
            addDigit(operador);
        } else {
            String e = "Error:\nNo se puede agregar otro operador en este momento, revise de nuevo la operación.";
            Toast.makeText(activity.getApplicationContext(), e , Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public Double calcular(Double a, Double b, Character op) {
        switch (op){
            case '+':
                return a + b;

            case '-':
                return a - b ;

            case '*':
                return a * b;

            case '/':
                return a / b;
        }
        return 0.0;
    }

    @Override
    public void clearScreen() {
        txv_resultado.setText("0");
        txv_solution.setText("");
        this.operaC = "";
        this.resulC = "";
        this.opera = 0.0;
        this.resul = 0.0;
    }

    @Override
    public void showResult() {
        if (this.opC != null && this.resul != null) {
            Double num2 = 0.0;
            if (!this.operaC.isEmpty()) {
                num2 = Double.parseDouble(this.operaC);
                this.resF = calcular(this.resul, num2, this.opC);
                txv_resultado.setText(String.valueOf(this.resF));
            } else {
                txv_resultado.setText(String.valueOf(this.resul));
            }
        } else if (this.resul != null) {
            txv_resultado.setText(String.valueOf(this.resul));
        } else {
            txv_resultado.setText("0");
        }
    }

    @Override
    public void errores(String error){
        txv_resultado.setText("Error");
        txv_solution.setText(error);
    }
}
