module aplicacion.prioridadenautobus {
    requires javafx.controls;
    requires javafx.fxml;


    opens aplicacion.prioridadenautobus to javafx.fxml;
    exports aplicacion.prioridadenautobus;
    exports aplicacion.prioridadenautobus.controller;
    opens aplicacion.prioridadenautobus.controller to javafx.fxml;
}