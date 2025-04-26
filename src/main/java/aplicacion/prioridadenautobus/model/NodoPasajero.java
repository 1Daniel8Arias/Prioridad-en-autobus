package aplicacion.prioridadenautobus.model;


public class NodoPasajero {
    Pasajero pasajero;
    NodoPasajero siguiente;

    public NodoPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
        this.siguiente = null;
    }
}
