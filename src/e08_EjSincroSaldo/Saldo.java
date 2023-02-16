package e08_EjSincroSaldo;

public class Saldo {
    private int saldo;

    Saldo(int saldo) {
        this.saldo = saldo;

    }

    public int getSaldo() {
        try {
            Thread.sleep((long) (Math.random() * 40 + 1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
        try {
            Thread.sleep((long) (Math.random() * 40 + 1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void ingresaSaldo(int cantidad, String nombre) {
        int actual = getSaldo();
        System.out.printf("%s Deposita %d, El saldo actual es: %d %n", nombre, cantidad, actual);
        setSaldo(actual + cantidad);
        System.out.printf("%s El nuevo saldo es: %d  %n", nombre, getSaldo());
    }
}// Saldo


