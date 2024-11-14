import java.util.ArrayList;
import java.util.List;

public class RadioClaseA implements RadioUniversal {
    private boolean encendido;
    private int volumen;
    private String banda; // "AM" o "FM"
    private double frecuencia;
    private List<Emisora> emisorasGuardadas;
    private ListaReproduccion listaReproduccionActual;
    private List<ListaReproduccion> listasReproduccion;
    private int indiceCancionActual;
    private boolean telefonoConectado;
    private List<Contacto> contactos;
    private boolean enLlamada;
    private boolean enSpeaker;

    public RadioClaseA() {
        this.encendido = false;
        this.volumen = 5;
        this.banda = "FM";
        this.frecuencia = 88.0;
        this.emisorasGuardadas = new ArrayList<>();
        this.listasReproduccion = new ArrayList<>();
        this.indiceCancionActual = 0;
        this.telefonoConectado = false;
        this.contactos = new ArrayList<>();
        this.enLlamada = false;
        this.enSpeaker = false;
    }

    public void agregarListaReproduccion(ListaReproduccion lista) {
        listasReproduccion.add(lista);
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    @Override
    public void encender() {
        encendido = true;
        mostrarEstado();
    }

    @Override
    public void apagar() {
        encendido = false;
        mostrarEstado();
    }

    @Override
    public void subirVolumen() {
        if (encendido) {
            volumen = Math.min(volumen + 1, 10);
            mostrarEstado();
        } else {
            System.out.println("El radio está apagado.");
        }
    }

    @Override
    public void bajarVolumen() {
        if (encendido) {
            volumen = Math.max(volumen - 1, 0);
            mostrarEstado();
        } else {
            System.out.println("El radio está apagado.");
        }
    }

    @Override
    public void cambiarBanda() {
        if (encendido) {
            banda = banda.equals("FM") ? "AM" : "FM";
            mostrarEstado();
        } else {
            System.out.println("El radio está apagado.");
        }
    }

    @Override
    public void siguienteEstacion() {
        if (encendido) {
            frecuencia += 0.5;
            mostrarEstado();
        } else {
            System.out.println("El radio está apagado.");
        }
    }

    @Override
    public void anteriorEstacion() {
        if (encendido) {
            frecuencia -= 0.5;
            mostrarEstado();
        } else {
            System.out.println("El radio está apagado.");
        }
    }

    @Override
    public void guardarEstacion(double frecuencia) {
        if (encendido) {
            if (emisorasGuardadas.size() < 50) {
                emisorasGuardadas.add(new Emisora(frecuencia, "Emisora " + (emisorasGuardadas.size() + 1)));
                mostrarEstado();
            } else {
                System.out.println("No se pueden guardar más emisoras.");
            }
        } else {
            System.out.println("El radio está apagado.");
        }
    }

    @Override
    public void cargarEstacion(int posicion) {
        if (encendido) {
            if (posicion >= 0 && posicion < emisorasGuardadas.size()) {
                frecuencia = emisorasGuardadas.get(posicion).getFrecuencia();
                mostrarEstado();
            } else {
                System.out.println("Posición de emisora no válida.");
            }
        } else {
            System.out.println("El radio está apagado.");
        }
    }

    @Override
    public void seleccionarListaReproduccion(String nombreLista) {
        if (encendido) {
            for (ListaReproduccion lista : listasReproduccion) {
                if (lista.getNombre().equals(nombreLista)) {
                    listaReproduccionActual = lista;
                    indiceCancionActual = 0;
                    mostrarEstado();
                    return;
                }
            }
            System.out.println("Lista de reproducción no encontrada.");
        } else {
            System.out.println("El radio está apagado.");
        }
    }

    @Override
    public void siguienteCancion() {
        if (encendido && listaReproduccionActual != null) {
            indiceCancionActual = (indiceCancionActual + 1) % listaReproduccionActual.getCanciones().size();
            mostrarEstado();
        } else {
            System.out.println("El radio está apagado o no hay lista de reproducción seleccionada.");
        }
    }

    @Override
    public void anteriorCancion() {
        if (encendido && listaReproduccionActual != null) {
            indiceCancionActual = (indiceCancionActual - 1 + listaReproduccionActual.getCanciones().size()) % listaReproduccionActual.getCanciones().size();
            mostrarEstado();
        } else {
            System.out.println("El radio está apagado o no hay lista de reproducción seleccionada.");
        }
    }

    @Override
    public void reproducirCancion() {
        if (encendido && listaReproduccionActual != null) {
            mostrarEstado();
        } else {
            System.out.println("El radio está apagado o no hay lista de reproducción seleccionada.");
        }
    }

    @Override
    public void mostrarInformacionCancionActual() {
        if (encendido && listaReproduccionActual != null) {
            Cancion cancion = listaReproduccionActual.getCanciones().get(indiceCancionActual);
            System.out.println(cancion);
        } else {
            System.out.println("El radio está apagado o no hay lista de reproducción seleccionada.");
        }
    }

    @Override
    public void conectarTelefono() {
        if (encendido) {
            telefonoConectado = true;
            mostrarEstado();
        } else {
            System.out.println("El radio está apagado.");
        }
    }

    @Override
    public void desconectarTelefono() {
        if (encendido) {
            telefonoConectado = false;
            mostrarEstado();
        } else {
            System.out.println("El radio está apagado.");
        }
    }

    @Override
    public void mostrarContactos() {
        if (encendido && telefonoConectado) {
            for (Contacto contacto : contactos) {
                System.out.println(contacto);
            }
        } else {
            System.out.println("El radio está apagado o el teléfono no está conectado.");
        }
    }

    @Override
    public void llamarContacto(String nombreContacto) {
        if (encendido && telefonoConectado) {
            for (Contacto contacto : contactos) {
                if (contacto.getNombre().equals(nombreContacto)) {
                    enLlamada = true;
                    mostrarEstado();
                    return;
                }
            }
            System.out.println("Contacto no encontrado.");
        } else {
            System.out.println("El radio está apagado o el teléfono no está conectado.");
        }
    }

    @Override
    public void finalizarLlamada() {
        if (encendido && enLlamada) {
            enLlamada = false;
            mostrarEstado();
        } else {
            System.out.println("El radio está apagado o no hay llamada en curso.");
        }
    }

    @Override
    public void cambiarAuriculares() {
        if (encendido && telefonoConectado) {
            enSpeaker = !enSpeaker;
            mostrarEstado();
        } else {
            System.out.println("El radio está apagado o el teléfono no está conectado.");
        }
    }

    @Override
    public void planificarViaje() {
        if (encendido) {
            System.out.println("Planificando viaje...");
            mostrarEstado();
        } else {
            System.out.println("El radio está apagado.");
        }
    }

    @Override
    public void mostrarEstado() {
        if (encendido) {
            System.out.println("Radio encendido");
            System.out.println("Volumen: " + volumen);
            System.out.println("Banda: " + banda);
            System.out.println("Frecuencia: " + frecuencia);
            if (listaReproduccionActual != null) {
                Cancion cancion = listaReproduccionActual.getCanciones().get(indiceCancionActual);
                System.out.println("Reproduciendo: " + cancion);
            }
            if (telefonoConectado) {
                System.out.println("Teléfono conectado");
                if (enLlamada) {
                    System.out.println("En llamada");
                }
                System.out.println("Modo: " + (enSpeaker ? "Altavoz" : "Auriculares"));
            }
        } else {
            System.out.println("Radio apagado");
        }
    }
}
