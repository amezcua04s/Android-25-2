package com.example.proyecto26022025;

import java.math.BigDecimal;

public interface ICalculadora {

    BigDecimal calculate(Operacion operacion, BigDecimal x, BigDecimal y);

    BigDecimal calculate(Object operacion, Object x, Object y);

}
