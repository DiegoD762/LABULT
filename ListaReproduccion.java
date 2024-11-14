import java.util.ArrayList;
import java.util.List;

public class ListaReproduccion {
    private String nombre;
    private List<Cancion> canciones;

    public ListaReproduccion(String nombre) {
        this.nombre = nombre;
        this.canciones = new ArrayList<>();
    }

    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public String getNombre() {
        return nombre;
    }
}
