package e16_Cajero;

public class Terminal extends Thread {
    String nombre;
    Cajero obj;
    int loc = 0;//Localidades por Terminal


    public Terminal(String nombre, Cajero c) {
        this.nombre = nombre;
        obj = c;
    }

    public void run() {
        for (int i = 0; i < 20000; i++) {
            obj.sumarLocalidades();//Suma en el total
            loc++;//Suma en el parcial
        }
        System.out.println("Terminal: " + this.nombre + " vendió " + loc);

    }
}
