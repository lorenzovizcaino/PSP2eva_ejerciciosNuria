package Factorial;

public class Factorial extends Thread{
    int numero;
    int factorial = 1;

    public Factorial(int numero) {
        this.numero = numero;
    }

    public void run() {
        for (int i = 1; i <= numero; i++) {
            factorial = factorial * i;
        }
    }

    public void mostrarFactorial() {
        System.out.println("El factorial de: " + numero + " es " + factorial);
    }
}
