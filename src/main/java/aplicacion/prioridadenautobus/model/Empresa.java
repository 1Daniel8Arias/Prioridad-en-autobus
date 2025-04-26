package aplicacion.prioridadenautobus.model;



import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private final ColaPrioridad cola;
    private final Pasajero[] asientos;
    private final List<Pasajero> abordados;

    public List<Pasajero> getAbordados() {
        return abordados;
    }

    public ColaPrioridad getCola() {
        return cola;
    }



    public Empresa() {
        cola = new ColaPrioridad();
        asientos = new Pasajero[19];
        abordados = new ArrayList<>();
    }

    public void registrarPasajero(String nombre, PasajeroTipo tipo) {
        cola.encolar(new Pasajero(nombre, tipo));
    }

    public Pasajero abordarPasajero() {
        if (cola.estaVacia()) return null;

        for (int i = 0; i < asientos.length; i++) {
            if (asientos[i] == null) {
                Pasajero pasajero = cola.desencolar();
                pasajero.setAsiento(i + 1);
                asientos[i] = pasajero;
                abordados.add(pasajero);
                return pasajero;
            }
        }
        return null; // Autobús lleno
    }

    public String[] getColaAbordaje() {
        return cola.listarPasajeros();
    }

    public Pasajero[] getAsientos() {
        return asientos;
    }

    public List<Pasajero> getPasajerosAbordados() {
        return abordados;
    }

    public boolean hayAsientosDisponibles() {
        for (Pasajero asiento : asientos) {
            if (asiento == null) return true;
        }
        return false;
    }
    public void agregarPasajero(String nombre, PasajeroTipo tipo) {
        cola.encolar(new Pasajero(nombre, tipo));
    }

    public List<Pasajero> obtenerCola() {
        return cola.obtenerComoLista();
    }
}
