import java.util.Random;

public class Coche implements Runnable {
    private String nombre;
    private int distanciaRecorrida;
    private static final int DISTANCIA_META = 100;
    private static boolean carreraFinalizada = false;

    public Coche(String nombre) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (!carreraFinalizada && distanciaRecorrida < DISTANCIA_META) {
            int avance = random.nextInt(10) + 1;
            distanciaRecorrida += avance;

            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(nombre + " ha avanzado a " + distanciaRecorrida + " unidades.");

            if (distanciaRecorrida >= DISTANCIA_META) {
                if (!carreraFinalizada) {
                    carreraFinalizada = true;
                    System.out.println("¡" + nombre + " ha ganado la carrera!");
                } else {
                    System.out.println(nombre + " ha llegado a la meta.");
                }
            }
        }
    }
}
