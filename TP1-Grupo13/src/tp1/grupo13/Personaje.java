package tp1.grupo13;

public class Personaje {
    private String nombre;
    private String camisa;
    private String pantalon;
    private String gorro;
    private char inicial;
    private Posicion posicion;
    private String orientacion;

    public Personaje(String nombre, String camisa, String pantalon, String gorro, char inicial) {
        this.nombre = nombre;
        this.camisa = camisa;
        this.pantalon = pantalon;
        this.gorro = gorro;
        this.inicial = inicial;
        this.posicion = new Posicion(0, 0);
        this.orientacion = "Derecha";
    }

    public Personaje(String nombre, String camisa, String pantalon, String gorro, char inicial, int posicionX, int posicionY, String orientacion) {
        this.nombre = nombre;
        this.camisa = camisa;
        this.pantalon = pantalon;
        this.gorro = gorro;
        this.inicial = inicial;
        this.posicion = new Posicion(posicionX, posicionY);
        this.orientacion = orientacion;
    }
    
    public Personaje(String nombre, int posicionX, int posicionY, String orientacion) {
        this.nombre = nombre;
        this.posicion = new Posicion(posicionX, posicionY);
        this.orientacion = orientacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCamisa() {
        return camisa;
    }

    public void setCamisa(String camisa) {
        this.camisa = camisa;
    }

    public String getPantalon() {
        return pantalon;
    }

    public void setPantalon(String pantalon) {
        this.pantalon = pantalon;
    }

    public String getGorro() {
        return gorro;
    }

    public void setGorro(String gorro) {
        this.gorro = gorro;
    }

    public char getInicial() {
        return inicial;
    }

    public void setInicial(char inicial) {
        this.inicial = inicial;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public String getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }

    public String saludar() {
        return "Hola, soy " + this.getNombre() + "!";
    }

    public void caminar() {
        if (this.orientacion.equals("Derecha")) {
            this.posicion.avanzar();
        } else {
            this.posicion.retroceder();
        }
    }

    public void girar() {
        if (this.orientacion.equals("Derecha")) {
            this.orientacion = "Izquierda";
        } else {
            this.orientacion = "Derecha";
        }
    }

    public String indicarUbicacion() {
        return this.getNombre() + " se encuentra en la posición " + this.posicion.toString();
    }
}
