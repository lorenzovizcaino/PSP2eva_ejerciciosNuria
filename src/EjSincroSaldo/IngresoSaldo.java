package EjSincroSaldo;

// hilo
class IngresoSaldo extends Thread {
    Saldo saldo;
    int importe;
    String nombre;

    IngresoSaldo(Saldo saldo, int cantidad, String nombre) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.importe = cantidad;
    }

    public void run() {
        saldo.ingresaSaldo(importe, nombre);

    }
}// hilo