package aplicacion.prioridadenautobus.model;



public class Pasajero {
    private String nombre;
    private PasajeroTipo tipo;
    private int asiento;

    public Pasajero(String nombre, PasajeroTipo tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.asiento = -1;
    }

    public String getNombre() {
        return nombre;
    }

    public PasajeroTipo getTipo() {
        return tipo;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    @Override
    public String toString() {
        return nombre + " - " + tipo.getLabel() ;
    }
}
