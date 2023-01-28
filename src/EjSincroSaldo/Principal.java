package EjSincroSaldo;
/**
 * Crea una clase Saldo, con un atributo que indique el saldo, y el constructor en el que se dará un valor inicial
 * al saldo. Contendrá también varios métodos:
 * * Uno para obtener el saldo (incluir sleep)
 * * Otro para modificarlo (incluir sleep)
 * * Otro que realice un ingreso. Recibe una cantidad y se la añade, informando por pantalla de quién ha realizado
 * ese ingreso y la cantidad resultante después del ingreso.
 *
 * Crear otra clase Thread, que realice ingresos de saldo desde el run.
 *
 * En el main, crear un objeto compartido Saldo por todos los hilos. Crear 3 hilos, cada uno con un nombre. Esperar
 * a la finalización de todos los hilos para mostrar el valor final del saldo.
 *
 * */
public class Principal {
    public static void main(String[] args) {
        Saldo saldo = new Saldo(1000);
        System.out.println("***** Saldo Inicial: " + saldo.getSaldo());

        IngresoSaldo UNO, DOS, TRES, CUATRO;
        UNO = new IngresoSaldo(saldo, 1000, "#1");
        DOS = new IngresoSaldo(saldo, 1000, "\t#2");
        TRES = new IngresoSaldo(saldo, 1000, "\t\t#3");
        CUATRO = new IngresoSaldo(saldo, 1000, "\t\t\t#4");

        UNO.start();
        DOS.start();
        TRES.start();
        CUATRO.start();
        try {
            UNO.join();
            DOS.join();
            TRES.join();
            CUATRO.join();

        } catch (InterruptedException e) {
        }

        System.out.println("***** Saldo Final: " + saldo.getSaldo());

    }// main

}
