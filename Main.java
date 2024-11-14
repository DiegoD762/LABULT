import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RadioClaseA radio = new RadioClaseA();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // Hardcodear algunos elementos
        ListaReproduccion lista = new ListaReproduccion("Favoritas");
        lista.agregarCancion(new Cancion("Cancion 1", "Autor 1", "Genero 1", 180));
        lista.agregarCancion(new Cancion("Cancion 2", "Autor 2", "Genero 2", 200));
        radio.agregarListaReproduccion(lista);

        radio.agregarContacto(new Contacto("Contacto 1", "123456789"));
        radio.agregarContacto(new Contacto("Contacto 2", "987654321"));

        while (!exit) {
            System.out.println("\nMenú:");
            System.out.println("1. Encender radio");
            System.out.println("2. Apagar radio");
            System.out.println("3. Subir volumen");
            System.out.println("4. Bajar volumen");
            System.out.println("5. Cambiar banda");
            System.out.println("6. Siguiente estación");
            System.out.println("7. Anterior estación");
            System.out.println("8. Guardar estación");
            System.out.println("9. Cargar estación");
            System.out.println("10. Seleccionar lista de reproducción");
            System.out.println("11. Siguiente canción");
            System.out.println("12. Anterior canción");
            System.out.println("13. Reproducir canción");
            System.out.println("14. Mostrar información de la canción actual");
            System.out.println("15. Conectar teléfono");
            System.out.println("16. Desconectar teléfono");
            System.out.println("17. Mostrar contactos");
            System.out.println("18. Llamar a contacto");
            System.out.println("19. Finalizar llamada");
            System.out.println("20. Cambiar a altavoz/auriculares");
            System.out.println("21. Planificar viaje");
            System.out.println("22. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    radio.encender();
                    break;
                case 2:
                    radio.apagar();
                    break;
                case 3:
                    radio.subirVolumen();
                    break;
                case 4:
                    radio.bajarVolumen();
                    break;
                case 5:
                    radio.cambiarBanda();
                    break;
                case 6:
                    radio.siguienteEstacion();
                    break;
                case 7:
                    radio.anteriorEstacion();
                    break;
                case 8:
                    System.out.print("Ingrese la frecuencia a guardar: ");
                    double frecuencia = scanner.nextDouble();
                    radio.guardarEstacion(frecuencia);
                    break;
                case 9:
                    System.out.print("Ingrese la posición de la estación a cargar: ");
                    int posicion = scanner.nextInt();
                    radio.cargarEstacion(posicion);
                    break;
                case 10:
                    System.out.print("Ingrese el nombre de la lista de reproducción: ");
                    String nombreLista = scanner.nextLine();
                    radio.seleccionarListaReproduccion(nombreLista);
                    break;
                case 11:
                    radio.siguienteCancion();
                    break;
                case 12:
                    radio.anteriorCancion();
                    break;
                case 13:
                    radio.reproducirCancion();
                    break;
                case 14:
                    radio.mostrarInformacionCancionActual();
                    break;
                case 15:
                    radio.conectarTelefono();
                    break;
                case 16:
                    radio.desconectarTelefono();
                    break;
                case 17:
                    radio.mostrarContactos();
                    break;
                case 18:
                    System.out.print("Ingrese el nombre del contacto a llamar: ");
                    String nombreContacto = scanner.nextLine();
                    radio.llamarContacto(nombreContacto);
                    break;
                case 19:
                    radio.finalizarLlamada();
                    break;
                case 20:
                    radio.cambiarAuriculares();
                    break;
                case 21:
                    radio.planificarViaje();
                    break;
                case 22:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}
