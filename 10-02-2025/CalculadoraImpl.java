import java.io.*;

class CalculadoraImlp implements ICalculadora{

	Double calcular(Operation operacion){
		switch (operacion.getOperando()){
			case SUMMA:
				return operacion.getx1() + operacion.getx2					
			break;
		
		}
					

	return 0.0;	

	}

}
