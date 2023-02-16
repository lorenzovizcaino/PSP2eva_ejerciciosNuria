package Garceta.Ejercicio10;
/**
 * Usando el modelo productor-consumidor, crea un productor que lea caracteres de un fichero de texto cuyo nombre
 * recibirá a través de su constructor.
 * El consumidor obtendrá los datos que produzca el productor y los mostrará por pantalla.
 * Muestra al final del proceso del productor y del consumidor un mensaje indicando que el proceso ha finalizado.
 * */
public class Principal {
    public static void main(String[] args) {

        Compartido cola = new Compartido();

        Productor p = new Productor(cola, "Fichero.txt");
        Consumidor c = new Consumidor(cola, 1);
        Consumidor c2 = new Consumidor(cola, 2);
        Consumidor c3 = new Consumidor(cola, 3);

        p.start();
        c.start();
        c2.start();
        c3.start();

        try {
            p.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Estado Consumidor 1: "+c.getState());
        System.out.println("Estado Consumidor 2: "+c2.getState());
        System.out.println("Estado Consumidor 3: "+c3.getState());

        //cuando termina el productor hemos de finalizar los consumidores
        if(c.isAlive()) {cola.put(-1);c.interrupt();}
        if(c2.isAlive()) {cola.put(-1);c2.interrupt();}
        if(c3.isAlive()) {cola.put(-1);c3.interrupt();}
    }
}
