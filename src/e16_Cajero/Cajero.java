package Sonia.Bol8.Cajero;

public class Cajero {
    int localidades=0;
    String nombre;

    public Cajero(String n){
        nombre=n;
    }

    public synchronized void sumarLocalidades() {
        localidades++;
    }

    public synchronized int mostrarLocalidades() {
        return localidades;
    }
}
