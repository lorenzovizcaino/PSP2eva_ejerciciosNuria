package EjerciciosGarceta;

public class E02_Hilo implements Runnable {
	String cadena;

	E02_Hilo(String cadena) {
		this.cadena = cadena;
	}

	public void run() {
		try {
			Thread.sleep(Thread.currentThread().getId() * 10);
		} catch (InterruptedException e) {

		}

		System.out.println("Hola Mundo " + cadena + " " + Thread.currentThread().getId());
	}

}
