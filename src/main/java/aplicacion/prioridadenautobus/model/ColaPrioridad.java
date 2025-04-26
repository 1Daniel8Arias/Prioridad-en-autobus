package aplicacion.prioridadenautobus.model;


import java.util.ArrayList;
import java.util.List;

public class ColaPrioridad {
    private NodoPasajero frente;

    public void encolar(Pasajero pasajero) {
        NodoPasajero nuevo = new NodoPasajero(pasajero);

        if (frente == null || pasajero.getTipo().getPriority() < frente.pasajero.getTipo().getPriority()) {
            nuevo.siguiente = frente;
            frente = nuevo;
        } else {
            NodoPasajero actual = frente;
            while (actual.siguiente != null && pasajero.getTipo().getPriority() >= actual.siguiente.pasajero.getTipo().getPriority()) {
                actual = actual.siguiente;
            }
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
        }
    }

    public Pasajero desencolar() {
        if (frente == null) return null;
        Pasajero pasajero = frente.pasajero;
        frente = frente.siguiente;
        return pasajero;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public String[] listarPasajeros() {
        NodoPasajero actual = frente;
        java.util.List<String> lista = new java.util.ArrayList<>();
        while (actual != null) {
            lista.add(actual.pasajero.toString());
            actual = actual.siguiente;
        }
        return lista.toArray(new String[0]);
    }



    public List<Pasajero> obtenerComoLista() {
        List<Pasajero> lista = new ArrayList<>();
        NodoPasajero actual = frente;
        while (actual != null) {
            lista.add(actual.pasajero);
            actual = actual.siguiente;
        }
        return lista;
    }
}
