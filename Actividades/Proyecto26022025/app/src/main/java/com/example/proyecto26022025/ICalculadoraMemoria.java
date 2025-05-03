package com.example.proyecto26022025;

import java.math.BigDecimal;

public interface ICalculadoraMemoria {

    String concat(String numero);

    String concat(Operacion operacion);

    Operacion getOperacion();

    BigDecimal getX();

    BigDecimal getY();

    void clear();

    void igual();

}
