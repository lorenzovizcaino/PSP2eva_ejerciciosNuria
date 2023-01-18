package EjerciciosGarceta;

public class E02_Main {
	public static void main(String[] args) {

		new Thread(new E02_Hilo("uno")).start();
		new Thread(new E02_Hilo("dos")).start();
		new Thread(new E02_Hilo("tres")).start();
		new Thread(new E02_Hilo("cuatro")).start();
		new Thread(new E02_Hilo("cinco")).start();
		
	}
}
