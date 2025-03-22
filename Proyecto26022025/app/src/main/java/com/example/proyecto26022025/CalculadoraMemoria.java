package com.example.proyecto26022025;

import android.view.View;

import java.math.BigDecimal;

public class CalculadoraMemoria implements  ICalculadoraMemoria{

    private String display = "0";

    private BigDecimal x,y;

    private Operacion operacion;

    @Override
    public String concat(String numero) {
        display += numero;
        return display ;
    }

    @Override
    public String concat(Operacion operacion) {
        this.operacion = operacion;
        this.x = BigDecimal.valueOf(Long.parseLong(display));
        this.display = "";
        return "";//Operacion.convert(operacion);
    }

    @Override
    public Operacion getOperacion() {
        return operacion;
    }

    @Override
    public BigDecimal getX() {
        return x;
    }

    @Override
    public BigDecimal getY() {
        return y;
    }

    @Override
    public void clear() {
        display = "";
        x = BigDecimal.ZERO;
        y = BigDecimal.ZERO;
        operacion = Operacion.NONE;
    }

    @Override
    public void igual() {
        this.y = BigDecimal.valueOf(Long.parseLong(display));
    }


}
