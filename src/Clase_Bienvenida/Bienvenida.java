package Clase_Bienvenida;

/**
 * Se trata de simular el comienzo de una clase.
 *
 * Los alumnos llegarán y esperarán hasta que llegue el profesor y salude para que comience la clase.
 *
 * Los alumnos y el profesor compartirán un objeto de la clase Bienvenida, con dos métodos sincronizados:
 *
 * * Uno donde los alumnos llegan y saludan al profesor (se quedan esperando mientras el profesor no llegue)
 *
 * * Otro donde el profesor llega e indica que la clase puede comenzar, notificándoselo a los alumnos.
 *
 */


public class Bienvenida {
    boolean clase_comenzada;

    public Bienvenida() {
        this.clase_comenzada = false;
    }

    public synchronized void saludarProfesor (int num) {
        try {
            if (!clase_comenzada) {
                wait();
            }
            System.out.println("Alumno " + num + ": Buenos días profesor");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void llegadaProfesor(String nombre) {
        System.out.println("Buenos días a todos. Soy " + nombre);
        this.clase_comenzada = true;
        notifyAll();
    }
}

class Alumno extends Thread {
    Bienvenida saludo;
    int numAlumno;

    public Alumno (Bienvenida bienvenida, int numAlumno) {
        this.saludo = bienvenida;
        this.numAlumno = numAlumno;
    }

    public void run() {
        System.out.println("Alumno " + numAlumno + " llegó");
        try {
            Thread.sleep(1000);
            saludo.saludarProfesor(numAlumno);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Profesor extends Thread {
    Bienvenida saludo;
    String nombre;

    public Profesor (Bienvenida bienvenida, String nombre) {
        this.saludo = bienvenida;
        this.nombre = nombre;
    }

    public void run() {
        System.out.println("Profesor " + nombre + " llegó");
        try {
            Thread.sleep(1000);
            saludo.llegadaProfesor(nombre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ComienzoClase {
    public static void main(String[] args) {
        Bienvenida b = new Bienvenida();
        for (int i = 0; i < 3; i++) {
            new Alumno(b, i).start();
        }
        Profesor p = new Profesor(b, "Pepito Pérez");
        p.start();
    }
}
