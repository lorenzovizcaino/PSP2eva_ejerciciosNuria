package Garceta.Ejercicio10;

public class Consumidor extends Thread {
    private Compartido comp;
    private int n;

    public Consumidor(Compartido c, int n) {
        comp = c;
        this.n = n;
    }

    public void run() {
        char valor;
        int i  = comp.get();
        while(i!= -1 ) {
            System.out.printf("%c [%d] %n",(char) i,n);
            i = comp.get(); //recoge el valor
        }
        System.out.println("\nFin consumidor "+n);
    }
}
