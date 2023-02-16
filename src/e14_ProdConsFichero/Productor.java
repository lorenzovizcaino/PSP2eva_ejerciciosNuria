package Garceta.Ejercicio10;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Productor extends Thread {
    private Compartido comp;
    private String nombre;

    public Productor(Compartido c, String nombreFichero) {
        comp = c;
        this.nombre = nombreFichero;
    }

    public void run() {
        File fichero = new File(nombre); // declarar fichero
        if (fichero.exists()) {
            try {
                FileReader fic = new FileReader(fichero);
                int i;
                while ((i = fic.read()) != -1) // se va leyendo un car�cter
                {
                    char c= (char) i;
                    comp.put(i); // pone el car�cter

                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
                comp.put(i);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
        System.out.println("\nFin Productor");
    }//run
}
