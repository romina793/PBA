package tp1.grupo13;

import java.util.Random;

public class Moneda {

    private String lado;

    public Moneda() {
    }

    public String getLado() {
        return lado;
    }

    public void setLado(String lado) {
        this.lado = lado;
    }

    public void lanzar() {
        Random random = new Random();
        int lado = random.nextInt(2);

        if (lado == 0) {
            this.lado = "Cara";
        } else if (lado == 1) {
            this.lado = "Cruz";
        }
    }
}
