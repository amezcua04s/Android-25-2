package com.example.calculadora;


public interface ICalculadoraUI {

    void clearScreen();

    void showResult();

    void addDigit(Character btnValor);

    void operador(String operacion, Character operador);

    Double calcular(Double a, Double b, Character op);
    void errores(String error);

}
