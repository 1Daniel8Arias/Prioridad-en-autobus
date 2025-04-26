package aplicacion.prioridadenautobus.model;
public enum PasajeroTipo {

    DISCAPACIDAD(1, "Discapacidad"),
    EMBARAZADA(2, "Embarazada"),
    ADULTO_MAYOR(3, "Adulto Mayor"),
    COMUN(4, "Persona Común");

    private final int priority;
    private final String label;

    PasajeroTipo(int priority, String label) {
        this.priority = priority;
        this.label = label;
    }

    public int getPriority() {
        return priority;
    }

    public String getLabel() {
        return label;
    }
}

