package aplicacion.prioridadenautobus.controller;

import aplicacion.prioridadenautobus.model.Empresa;
import aplicacion.prioridadenautobus.model.Pasajero;
import aplicacion.prioridadenautobus.model.PasajeroTipo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.HashMap;
import java.util.Map;

public class ControllerBus {

    @FXML
    private Button abordarButton;

    @FXML
    private RadioButton adultoMayorRadio;

    @FXML
    private Button agregarButton;

    @FXML
    private Label availableSeatsLabel;

    @FXML
    private ListView<String> boardedListView;

    @FXML
    private GridPane busGridPane;

    @FXML
    private RadioButton comunRadio;

    @FXML
    private RadioButton discapacidadRadio;

    @FXML
    private RadioButton embarazadaRadio;

    @FXML
    private TextField nombreField;

    @FXML
    private ListView<String> queueListView;

    @FXML
    private TabPane tabPane;

    private Empresa empresa;
    private ToggleGroup tipoPasajeroGroup;

    private Map<Integer, Label> mapaAsientos;

    @FXML
    void initialize() {
        empresa = new Empresa();
        mapaAsientos = new HashMap<>();

        tipoPasajeroGroup = new ToggleGroup();
        discapacidadRadio.setToggleGroup(tipoPasajeroGroup);
        embarazadaRadio.setToggleGroup(tipoPasajeroGroup);
        adultoMayorRadio.setToggleGroup(tipoPasajeroGroup);
        comunRadio.setToggleGroup(tipoPasajeroGroup);

        inicializarBus();
        actualizarCola();
        actualizarAsientosDisponibles();
    }

    private void inicializarBus() {
        busGridPane.setHgap(10);
        busGridPane.setVgap(10);

        int asientoNumero = 1;


        Label volante = new Label("VOLANTE");
        volante.setPrefSize(80, 80);
        volante.setAlignment(Pos.CENTER);
        volante.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-background-color: gray;");
        busGridPane.add(volante, 0, 0);
        GridPane.setColumnSpan(volante, 2);



        agregarAsiento(asientoNumero++, 3, 0);
        agregarAsiento(asientoNumero++, 4, 0);


        agregarAsiento(asientoNumero++, 0, 1);
        agregarAsiento(asientoNumero++, 1, 1);

        agregarAsiento(asientoNumero++, 3, 1);
        agregarAsiento(asientoNumero++, 4, 1);


        agregarAsiento(asientoNumero++, 0, 2);
        agregarAsiento(asientoNumero++, 1, 2);

        agregarAsiento(asientoNumero++, 3, 2);
        agregarAsiento(asientoNumero++, 4, 2);


        agregarAsiento(asientoNumero++, 0, 3);
        agregarAsiento(asientoNumero++, 1, 3);

        agregarAsiento(asientoNumero++, 3, 3);
        agregarAsiento(asientoNumero++, 4, 3);


        agregarAsiento(asientoNumero++, 0, 4);
        agregarAsiento(asientoNumero++, 1, 4);
        agregarAsiento(asientoNumero++, 2, 4);
        agregarAsiento(asientoNumero++, 3, 4);
        agregarAsiento(asientoNumero++, 4, 4);

        actualizarBus();
    }

    private void agregarAsiento(int numero, int columna, int fila) {
        Label asiento = new Label(String.valueOf(numero));
        asiento.setPrefSize(40, 60);
        asiento.setAlignment(Pos.CENTER);
        asiento.getStyleClass().add("asiento");
        busGridPane.add(asiento, columna, fila);
        mapaAsientos.put(numero, asiento);
    }

    @FXML
    void onAgregarPasajero(ActionEvent event) {
        String nombre = nombreField.getText().trim();
        if (nombre.isEmpty() || tipoPasajeroGroup.getSelectedToggle() == null) {
            mostrarAlerta("Error", "Debe ingresar el nombre y seleccionar el tipo de pasajero.");
            return;
        }

        PasajeroTipo tipo = obtenerTipoSeleccionado();
        empresa.agregarPasajero(nombre, tipo);
        actualizarCola();

        nombreField.clear();
        tipoPasajeroGroup.selectToggle(null);
    }

    @FXML
    void onAbordarPasajero(ActionEvent event) {
        if (!empresa.hayAsientosDisponibles()) {
            mostrarAlerta("Autobús lleno", "No hay asientos disponibles.");
            return;
        }

        Pasajero pasajero = empresa.abordarPasajero();
        if (pasajero == null) {
            mostrarAlerta("Cola vacía", "No hay pasajeros en la cola.");
            return;
        }

        actualizarBus();
        actualizarAbordados();
        actualizarCola();
        actualizarAsientosDisponibles();
    }

    private void actualizarBus() {
        for (int i = 0; i < empresa.getAsientos().length; i++) {
            Pasajero pasajero = empresa.getAsientos()[i];
            Label asiento = mapaAsientos.get(i + 1); // Asientos empiezan en 1

            if (asiento != null) {
                if (pasajero == null) {
                    asiento.setText(String.valueOf(i + 1));
                    asiento.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-background-color: lightgreen; -fx-background-radius: 20 20 0 0; -fx-border-radius: 20 20 0 0;");
                } else {
                    asiento.setText(pasajero.getNombre());
                    asiento.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-background-color: lightcoral; -fx-background-radius: 20 20 0 0; -fx-border-radius: 20 20 0 0;");
                }
            }
        }
    }

    private void actualizarCola() {
        queueListView.getItems().clear();
        for (Pasajero p : empresa.obtenerCola()) {
            queueListView.getItems().add(p.toString());
        }
    }

    private void actualizarAbordados() {
        boardedListView.getItems().clear();
        for (Pasajero p : empresa.getPasajerosAbordados()) {
            boardedListView.getItems().add(p.toString() + " - Asiento " + p.getAsiento());
        }
    }

    private void actualizarAsientosDisponibles() {
        int libres = 0;
        for (Pasajero p : empresa.getAsientos()) {
            if (p == null) libres++;
        }
        availableSeatsLabel.setText("Asientos disponibles: " + libres);
    }

    private PasajeroTipo obtenerTipoSeleccionado() {
        if (discapacidadRadio.isSelected()) return PasajeroTipo.DISCAPACIDAD;
        if (embarazadaRadio.isSelected()) return PasajeroTipo.EMBARAZADA;
        if (adultoMayorRadio.isSelected()) return PasajeroTipo.ADULTO_MAYOR;
        if (comunRadio.isSelected()) return PasajeroTipo.COMUN;
        return null;
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
