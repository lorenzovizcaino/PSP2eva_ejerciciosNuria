package e10_Factorial2;

public class Factorial2 extends Thread{
    int numero;
    int factorial = 1;

    public Factorial2(int numero) {
        this.numero = numero;
    }

    public void run() {
        System.out.println("Empieza el proceso... Cálculo del factorial de: " + numero);
        for (int i = 1; i <= numero; i++) {
            factorial = factorial * i;
        }
        System.out.println("Acabó el proceso... El factorial de: " + numero + " es: " + factorial);
    }

    public void mostrarFactorial() {
        System.out.println("El factorial de: " + numero + " es " + factorial);
    }
}
