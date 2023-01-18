package EjContador_hilos;

public class Ej3 extends Thread {
    private String varSiNo;
    static int contador = 0;

    public Ej3 (String cadena) {
        super();
        varSiNo = cadena;
    }

    public void run () {
        for (int i = 0; i <= 10; i++) {
            System.out.println(++contador+" : "+varSiNo+" ");
        }
    }
}

class Principal3 {
    public static void main(String[] args) throws InterruptedException {
        Ej3 hilo1 = new Ej3("SI");
        Ej3 hilo2 = new Ej3("NO");

        ThreadGroup grupo = new ThreadGroup("Grupo PSP");

        Thread h1 = new Thread(grupo, hilo1, "hilo1");
        Thread h2 = new Thread(grupo, hilo2, "hilo2");

        h1.start();
        h2.start();

        System.out.println("Existen " + grupo.activeCount() + " hilos activos");
        try {
            h1.join();
            h2.join();

            System.out.println("Existen " + grupo.activeCount() + " hilos activos");
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
