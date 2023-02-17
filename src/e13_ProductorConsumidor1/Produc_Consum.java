package e13_ProductorConsumidor1;

/**
 * Implementar una aplicación compuesta por 3 clases:
 * Una Cola, que será el objeto compartido.
 * Un productor y un consumidor.
 * El productor generará 10 números, y los insertará en el objeto Cola, tras hacer un pequeño sleep.
 * El consumidor los leerá, y los mostrará por pantalla.
 *
 * */

public class Produc_Consum {
    public static void main(String[] args) {
        Cola cola = new Cola();

        Productor p = new Productor(cola, 1);
        Consumidor c = new Consumidor(cola, 1);

        p.start();
        c.start();
    }
}
