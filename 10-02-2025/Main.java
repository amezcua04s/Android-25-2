import java.io.*
class Main{

	public static void main(string[] main){

		Operacion op = new Operacion(10.0, 10.0, Operando.SUMA);
		ICalculadora calculadora = new CalculadoraImpl();
		Double resultado = Calculadora.calcular(op);
			
		System.out.println("Tu resultado es: " + resultado);
	}

}
