package tp1.grupo13;

public class Moneda {
    private String lado;

    public Moneda(String lado) {
        this.lado = lado;
    }

    public String getLado() {
        return lado;
    }

    public void setLado(String lado) {
        this.lado = lado;
    }

    public void lanzar() {
        if (this.lado.equals("Cara")) {
            this.lado = "Cruz";
        } else {
            this.lado = "Cara";
        }
    }
}
