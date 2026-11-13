package vallegrande.edu.pe.sistemahotel.controller;

import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import vallegrande.edu.pe.sistemahotel.model.Reserva;
import vallegrande.edu.pe.sistemahotel.model.ReservaDAO;
import vallegrande.edu.pe.sistemahotel.view.ReservaView;

public class ReservaController {

    private final ReservaView view;
    private final ReservaDAO dao;

    public ReservaController(ReservaView view) {
        this.view = view;
        this.dao = new ReservaDAO();
        inicializarEventos();
        cargarDatos();
    }

    private void inicializarEventos() {
        view.btnRegistrar.setOnAction(e -> registrar());
        view.btnActualizar.setOnAction(e -> actualizar());
        view.btnEliminar.setOnAction(e -> eliminar());
        view.btnLimpiar.setOnAction(e -> limpiarCampos());

        view.tablaReservas.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                view.txtId.setText(String.valueOf(newSel.getIdReserva()));
                view.txtHuesped.setText(newSel.getNombreHuesped());
                view.txtDni.setText(newSel.getDni());
                view.txtTelefono.setText(newSel.getTelefono());
                view.cbTipoHabitacion.setValue(newSel.getTipoHabitacion());
                view.dpIngreso.setValue(newSel.getFechaIngreso());
                view.dpSalida.setValue(newSel.getFechaSalida());
                view.cbEstado.setValue(newSel.getEstado());
            }
        });
    }

    private void cargarDatos() {
        view.tablaReservas.setItems(FXCollections.observableArrayList(dao.listar()));
    }

    private void registrar() {
        if (!validarCampos()) return;
        Reserva r = obtenerDesdeFormulario(0);
        if (dao.registrar(r)) {
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Reserva registrada correctamente.");
            limpiarCampos();
            cargarDatos();
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo registrar la reserva.");
        }
    }

    private void actualizar() {
        if (view.txtId.getText().isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Aviso", "Seleccione una reserva de la tabla para actualizar.");
            return;
        }
        if (!validarCampos()) return;
        int id = Integer.parseInt(view.txtId.getText());
        Reserva r = obtenerDesdeFormulario(id);
        if (dao.actualizar(r)) {
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Reserva actualizada correctamente.");
            limpiarCampos();
            cargarDatos();
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo actualizar la reserva.");
        }
    }

    private void eliminar() {
        if (view.txtId.getText().isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Aviso", "Seleccione una reserva de la tabla para eliminar.");
            return;
        }
        int id = Integer.parseInt(view.txtId.getText());
        if (dao.eliminar(id)) {
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Reserva eliminada correctamente.");
            limpiarCampos();
            cargarDatos();
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo eliminar la reserva.");
        }
    }

    private Reserva obtenerDesdeFormulario(int id) {
        return new Reserva(
                id,
                view.txtHuesped.getText().trim(),
                view.txtDni.getText().trim(),
                view.txtTelefono.getText().trim(),
                view.cbTipoHabitacion.getValue(),
                view.dpIngreso.getValue(),
                view.dpSalida.getValue(),
                view.cbEstado.getValue()
        );
    }

    private boolean validarCampos() {
        if (view.txtHuesped.getText().isEmpty() || view.txtDni.getText().isEmpty() ||
                view.txtTelefono.getText().isEmpty() || view.cbTipoHabitacion.getValue() == null ||
                view.dpIngreso.getValue() == null || view.dpSalida.getValue() == null ||
                view.cbEstado.getValue() == null) {
            mostrarAlerta(Alert.AlertType.WARNING, "Campos vacíos", "Por favor complete todos los campos.");
            return false;
        }
        return true;
    }

    private void limpiarCampos() {
        view.txtId.clear();
        view.txtHuesped.clear();
        view.txtDni.clear();
        view.txtTelefono.clear();
        view.cbTipoHabitacion.setValue(null);
        view.dpIngreso.setValue(null);
        view.dpSalida.setValue(null);
        view.cbEstado.setValue(null);
        view.tablaReservas.getSelectionModel().clearSelection();
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
