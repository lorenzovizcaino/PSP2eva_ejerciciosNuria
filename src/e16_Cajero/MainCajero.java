package Sonia.Bol8.Cajero;

/**
 * Diseña un programa que simule la gestión de un punto de venta con tres terminales que acceden a un
 * objeto Cajero que mantiene la cuenta de las localidades vendidas.
 * Clase Cajero → es el recurso compartido por los terminales (sección crítica)
 *  Un atributo localidades que contiene la cuenta de las localidades vendidas
 *  un método sumarLocalidades que irá contando las localidades vendidas
 *  un método mostrarLocalidades que nos dirá cuantas localidades se vendieron
 *  el constructor simplemente inicializa el cajero dándole un nombre.
 * Clase Terminal → (que es un hilo), en su constructor se le pasará un objeto Cajero, que será al que
 * accederá y su nombre. El número máximo de localidades que puede vender cada terminal es de 20000.
 * En su método run(): mientras tenga localidades las irá vendiendo y anotando la venta general de
 * localidades y la suya propia.
 * Cuando acabe mostrará cuantas localidades vendió.
 * MainCajero → es el programa principal desde el que creamos un cajero, 3 terminales que trabajen con
 * ese cajero, ponemos en funcionamiento los 3 terminales y cuando terminen mostramos un mensaje que
 * nos indique cuántas localidades han vendido (debería mostrar 60000, en ejecución sincronizada).
 * */

public class MainCajero {
    public static void main(String args[]) {
        int Total;
        Cajero compartido = new Cajero("Cajero Alameda");

        //Creo los 3 hilos que usarán el objeto compartido anterior
        Terminal dibujo1 = new Terminal("terminal1", compartido);
        Terminal dibujo2 = new Terminal("terminal2", compartido);
        Terminal dibujo3 = new Terminal("terminal3", compartido);


        //Lanzo los hilos
        dibujo1.start();
        dibujo2.start();
        dibujo3.start();
        try{
            dibujo1.join();
            dibujo2.join();
            dibujo3.join();
        }	catch (InterruptedException ex) {
            System.out.printf("Interrupcion");
        }

        //Es necesario esperar a que acaben de vender todos los
        //terminales para calcular el total de localidades vendidas.

        Total=compartido.mostrarLocalidades();

        System.out.println("En total se vendieron "+Total+" localidades");

    }
}
