package e15_Relevos;

public class Testigo {
    private int siguiente;

    Testigo() {
        this.siguiente = 0;
    }

    synchronized public void next(int id) {
        this.siguiente = id;
        // Despierto a todos los threads
        notifyAll();
    }

    synchronized public void check(int id) throws InterruptedException {
        while (siguiente != id) {
            // Me bloqueo hasta que sea mi turno
            wait();
        }
    }
}
