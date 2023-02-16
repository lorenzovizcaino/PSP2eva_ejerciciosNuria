package e12_Clase;

import java.util.Scanner;

/*
 * Se trata de simular el comienzo de una clase. Los alumnos (hilos) llegaran y
 * esperaran hasta que llegue el profesor (hilo) y salude para que comience la clase.
 * Los alumnos y el profesor compartiran un objeto de la clase Bienvenida,
 * con dos metodos sincronizados, uno mediante el cual los alumnos llegan a clase y se
 * ponen en espera mientras el profesor no llega y saluda.
 * El otro metodo es el que invoca el profesor,
 * mediante el cual da su saludo y despierta a los alumnos que se encontraban esperando 
 * para comenzar la clase.
 * */
public class ComienzoClase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Bienvenida b = new Bienvenida();
		
//		System.out.println("Introduzca el numero de alumnos: ");
//		int n_alumnos = sc.nextInt();
		
		for (int i = 0; i<5; i++) {
			new Alumno(b).start();
		}
		
		Profesor profesor = new Profesor("Pepito Perez", b);
		profesor.start();
	}
}
