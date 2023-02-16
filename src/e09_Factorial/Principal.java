package e09_Factorial;

/**
 * Hacer un programa que calcule el factorial. Cada uno de los cálculos tiene que ser realizado por un hilo
 * independiente. Implementar los procesos de 2 maneras diferentes:
 *        a) Heredando de la clase Thread
 *        b) Implementando la interface Runnable
 * */

public class Principal {
    public static void main(String[] args) {
        Factorial f1 = new Factorial(4);
        Factorial f2 = new Factorial(6);

        f1.start();
        f2.start();

        f1.mostrarFactorial();
        f2.mostrarFactorial();
    }
}
