package e15_Relevos;

public class Corredor extends Thread {
    private static final int MAX_DELAY = 1000;
    private int id;
    private Testigo testigo;

    Corredor(int id, Testigo t) {
        this.id = id;
        this.testigo = t;
    }

    public void run() {
        try {
            // Comprueba si es su turno, si no lo es, se bloquea
            testigo.check(id);

            System.out.println("Soy el thread " + id + " corriendo . . .");
            Thread.sleep((int) Math.random() * MAX_DELAY);
            if (id != 4) { // Si aún no llegó al final, paso el testigo al siguiente hilo
                int receptor = id + 1;
                System.out.println("Terminé. Paso el testigo al hilo " + receptor);
                testigo.next(receptor);
            } else {
                System.out.println("Terminé! Y soy el último...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
