public class CarreraDeCoches {
    public static void main(String[] args) {
        Thread[] coches = new Thread[5];

        for (int i = 0; i < coches.length; i++) {
            String nombreCoche = "Coche " + (i + 1);
            Coche coche = new Coche(nombreCoche);
            coches[i] = new Thread(coche);
            coches[i].start();
        }

        for (int i = 0; i < coches.length; i++) {
            try {
                coches[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("La carrera ha terminado.");
    }
}
