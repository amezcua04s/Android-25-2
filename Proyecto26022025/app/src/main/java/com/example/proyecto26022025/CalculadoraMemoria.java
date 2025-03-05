package com.example.proyecto26022025;

public class CalculadoraMemoria implements  ICalculadoraMemoria{

    String display = "";

    Operacion operacion;

    @Override
    public String concat(String numero) {
        return display + numero;
    }

    @Override
    public String concat(Operacion operacion) {
        this.operacion = operacion;
        return Operacion.convert(operacion);
    }

    @Override
    public void clear() {
        display = "";
        operacion = null;
    }
}
