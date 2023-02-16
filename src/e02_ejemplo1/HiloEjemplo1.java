package e02_ejemplo1;
/*
*
* Crea un hilo (clase que extienda de Thread) que reciba por constructor un nombre y realice 5 iteraciones en
* las que muestre por pantalla en cada una de ellas el nombre del hilo y la iteración en la que se encuentra.
* Un fragmento de la ejecución sería la siguiente:
* [nombreHilo]: iteración [numIteración]
* Hilo 1: iteración 0
* Hilo 1: iteración 1
* Hilo 2: iteración 0
* ...
* Además, implementa un main donde se lancen 3 hilos.
*
* */
public class HiloEjemplo1 extends Thread {
	// constructor
	public HiloEjemplo1(String nombre) {
		super(nombre);
		System.out.println("CREANDO HILO:" + getName());
	}

	// metodo run
	public void run() {
		for (int i=0; i<5; i++) 
			System.out.println("Hilo:" + getName() + " C = " + i);
	}

	//
	public static void main(String[] args) {
		HiloEjemplo1 h1 = new HiloEjemplo1("Hilo 1");
		HiloEjemplo1 h2 = new HiloEjemplo1("Hilo 2");
		HiloEjemplo1 h3 = new HiloEjemplo1("Hilo 3");
			
		h1.start();
		h2.start();
		h3.start();
		
		System.out.println("3 HILOS INICIADOS...");
	}// main
	
}// Ejemplos.ejemplo1.HiloEjemplo1
