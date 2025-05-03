package com.example.proyecto26022025;

import java.math.BigDecimal;

public class Calculadora implements ICalculadora{
    @Override
    public BigDecimal calculate(Operacion operacion, BigDecimal x, BigDecimal y) {
        switch (operacion){
            case SUMA:
                return x.add(y);
            case RESTA:
                return x.subtract(y);
            case MULT:
                return x.multiply(y);
            case DIV:
                return x.divide(y);
            case PORC:
                return BigDecimal.ZERO;
        }
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal calculate(Object operacion, Object x, Object y) {
        return null;
    }
}
