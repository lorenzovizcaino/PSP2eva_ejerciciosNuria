package e11_ContarApp;

/**
 * Escribe un programa que conste de las dos clases que se describen a continuación:
 * Una de las clases, de nombre ContarThread, que se va a ejecutar en paralelo, tiene :
 *     • un atributo entero de carácter privado de nombre maxContar
 *     • un constructor que recibe un entero y lo asigna al atributo maxContar
 *
 * Esta clase repite un número de veces igual a maxContar lo siguiente:
 *     • muestra en que repetición va  “Repeticion: xx”
 *     • muestra el nombre del Thread
 *     • ejecuta el método sleep durante 2000 milisegundos
 * La clase ContarApp tiene el método main, que hará lo siguiente:
 *     • crea un objeto de la clase ContarThread y ordénale que se ejecute
 *     • Detén el método 3000 milisegundos.
 *     • Crea otro objeto de la clase ContarThread y ordénale que se ejecute
 *     • mientras no hayan terminado los dos hilos anteriores muestra por  pantalla “Sigo contando…”
 *     y ejecuta sleep pasándole 1000 como parámetro sucesivamente hasta que deje de cumplirse la
 *     condición.
 * */


public class ContarApp {
    public static void main(String[] args) {
        ContarThread hilo1 = new ContarThread(5);
        hilo1.start();
        try {
            hilo1.sleep(3000);
        } catch (InterruptedException e){}
        ContarThread hilo2 = new ContarThread(4);
        hilo2.start();
        while (hilo1.isAlive() && hilo2.isAlive()) {
            try {
                hilo1.sleep(1000);
            } catch (InterruptedException e) {}
            System.out.println("Sigo contando...");
        }
    }
}
