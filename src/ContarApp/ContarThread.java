package ContarApp;

public class ContarThread extends Thread {
    private int maxContar;

    ContarThread(int numero) {
        maxContar = numero;
    }

    @Override
    public void run() {
        for (int i = 1; i<=maxContar; i++) {
            System.out.println("Repetición " + i);
            System.out.println("Nombre del hilo: " + getName());
            try {
                sleep(2000);
            } catch (InterruptedException e){}
        }
    }
}
