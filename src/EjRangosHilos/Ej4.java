package EjRangosHilos;

public class Ej4 extends Thread {
    private int inicio, fin;
    private String nombre;

    public Ej4(int inicio, int fin, String nombre) {
        super(nombre);
        this.inicio = inicio;
        this.fin = fin;
        this.nombre = nombre;
    }

    public void run() {
        for (int i = inicio; i <= fin ; i++) {
            System.out.println(nombre + " dice: " + i + ".");
        }
        System.out.println(nombre + " acaba");
    }
}

class Principal4 {
    public static void main(String[] args) {
        Ej4 h1 = new Ej4(1, 10, "Hilo1");
        Ej4 h2 = new Ej4(20, 30, "Hilo2");

        System.out.println("INICIO");

        h1.start();
        h2.start();

        try {
            h1.join();
            h2.join();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        System.out.println("FIN");
    }
}
