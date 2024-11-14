public interface RadioUniversal {
    // Controles de encendido
    void encender();
    void apagar();

    // Controles de volumen
    void subirVolumen();
    void bajarVolumen();

    // Modo Radio
    void cambiarBanda(); // Cambiar entre FM y AM
    void siguienteEstacion();
    void anteriorEstacion();
    void guardarEstacion(double frecuencia);
    void cargarEstacion(int posicion);

    // Modo Reproducción (CD, MP3, Spotify)
    void seleccionarListaReproduccion(String nombreLista);
    void siguienteCancion();
    void anteriorCancion();
    void reproducirCancion();
    void mostrarInformacionCancionActual();

    // Modo Teléfono
    void conectarTelefono();
    void desconectarTelefono();
    void mostrarContactos();
    void llamarContacto(String nombreContacto);
    void finalizarLlamada();
    void cambiarAuriculares(); // Cambiar entre altavoz y auriculares (Funcionalidad Clase A)

    // Modo Productividad (Clase A)
    void planificarViaje();

    // Mostrar estado
    void mostrarEstado();
}
