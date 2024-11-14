public class Emisora {
    private double frecuencia;
    private String nombre;

    public Emisora(double frecuencia, String nombre) {
        this.frecuencia = frecuencia;
        this.nombre = nombre;
    }

    public double getFrecuencia() {
        return frecuencia;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Emisora{" +
                "frecuencia=" + frecuencia +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
