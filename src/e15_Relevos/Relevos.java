package e15_Relevos;

/**
 *
 *  Escribe una clase llamada Relevos que simule una carrera de relevos de la siguiente forma:
 * * Cree 4 threads, que se quedarán a la espera de recibir alguna señal para comenzar a correr. Una vez creados los threads,
 * se indicará que comience la carrera, con lo que uno de los threads deberá empezar a correr.
 * * Cuando un thread termina de correr, pone algún mensaje en pantalla y espera un par de segundos, pasando el testigo a
 * otro de los hilos para que comience a correr, y terminando su ejecución (la suya propia).
 * * Cuando el último thread termine de correr, el padre mostrará un mensaje indicando que todos los hijos han terminado.
 *
 El relevo se transfiere a través del objeto compartido. Existirá un atributo entero con el número del hilo que se ejecuta.
 Hilo termina ejecución, incrementa turno y notifica el cambio.
 Antes de ejecutarse cada hilo, comprueba si es su turno. Si no lo es, espera.
 * */

public class Relevos {
    public static void main(String[] args) {
        Testigo testigo = new Testigo();
        Corredor corredores[] = new Corredor[4];
        for (int i = 0; i < 4; i++) {
            corredores[i] = new Corredor(i + 1, testigo);
            corredores[i].start();
        }
        System.out.println("Todos los hilos creados.");

        testigo.next(1);
        System.out.println("Doy la salida!");

        try {
            for (int i = 0; i < 4; i++) {
                corredores[i].join();
            }
        } catch (InterruptedException ex) {
            System.out.println("Hilo principal interrumpido.");
        }

        System.out.println("Todos los hilos terminaron.");
    }
}
