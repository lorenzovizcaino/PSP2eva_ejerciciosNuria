package Factorial2;


/**
 * Hacer un programa que calcule los factoriales del 5 al 14 modificando la clase Factorial del ejercicio anterior,
 * para que se visualicen los mensajes:
 * empieza el proceso … cálculo del factorial de: XX
 * acabó el proceso ….. el factorial de: XX es XXXX
 * en el método main declarar un vector o array de 10 hilos y lanzarlos a ejecución.
 * */

public class Principal2 {
    public static void main(String[] args) {
        Factorial2[] hilosFact = new Factorial2[10];
        int x = 0;

        for (int i = 5; i <= 14; i++) {
            hilosFact[x] = new Factorial2(i);
            hilosFact[x].start();
            x++;
        }
        System.out.println("Fin");
    }
}
