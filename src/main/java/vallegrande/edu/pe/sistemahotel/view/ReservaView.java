package vallegrande.edu.pe.sistemahotel.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import vallegrande.edu.pe.sistemahotel.model.Reserva;

import java.time.LocalDate;

public class ReservaView extends BorderPane {

    public TextField txtId = new TextField();
    public TextField txtHuesped = new TextField();
    public TextField txtDni = new TextField();
    public TextField txtTelefono = new TextField();
    public ComboBox<String> cbTipoHabitacion = new ComboBox<>();
    public DatePicker dpIngreso = new DatePicker();
    public DatePicker dpSalida = new DatePicker();
    public ComboBox<String> cbEstado = new ComboBox<>();

    public Button btnRegistrar = new Button("Registrar");
    public Button btnActualizar = new Button("Actualizar");
    public Button btnEliminar = new Button("Eliminar");
    public Button btnLimpiar = new Button("Limpiar");

    public TableView<Reserva> tablaReservas = new TableView<>();

    public ReservaView() {
        setPadding(new Insets(15));
        setTop(crearEncabezado());
        setLeft(crearFormulario());
        setCenter(crearTabla());
    }

    private VBox crearEncabezado() {
        Label titulo = new Label("SISTEMA DE GESTIÓN DE RESERVAS - HOTEL");
        titulo.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #1e3a8a;");
        VBox box = new VBox(titulo);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(0, 0, 15, 0));
        return box;
    }

    private VBox crearFormulario() {
        VBox form = new VBox(10);
        form.setPadding(new Insets(15));
        form.setPrefWidth(320);
        form.setStyle("-fx-background-color: #f8fafc; -fx-border-color: #cbd5e1; -fx-border-radius: 5;");

        txtId.setEditable(false);
        txtId.setPromptText("Automático");

        txtHuesped.setPromptText("Nombre completo del huésped");
        txtDni.setPromptText("DNI (8 dígitos)");
        txtTelefono.setPromptText("Teléfono de contacto");

        cbTipoHabitacion.getItems().addAll("Simple", "Doble", "Matrimonial", "Suite");
        cbTipoHabitacion.setMaxWidth(Double.MAX_VALUE);

        dpIngreso.setMaxWidth(Double.MAX_VALUE);
        dpSalida.setMaxWidth(Double.MAX_VALUE);

        cbEstado.getItems().addAll("Confirmada", "Pendiente", "Cancelada", "Finalizada");
        cbEstado.setMaxWidth(Double.MAX_VALUE);

        HBox botones1 = new HBox(10, btnRegistrar, btnActualizar);
        HBox botones2 = new HBox(10, btnEliminar, btnLimpiar);
        btnRegistrar.setMaxWidth(Double.MAX_VALUE);
        btnActualizar.setMaxWidth(Double.MAX_VALUE);
        btnEliminar.setMaxWidth(Double.MAX_VALUE);
        btnLimpiar.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(btnRegistrar, Priority.ALWAYS);
        HBox.setHgrow(btnActualizar, Priority.ALWAYS);
        HBox.setHgrow(btnEliminar, Priority.ALWAYS);
        HBox.setHgrow(btnLimpiar, Priority.ALWAYS);

        btnRegistrar.setStyle("-fx-background-color: #16a34a; -fx-text-fill: white; -fx-font-weight: bold;");
        btnActualizar.setStyle("-fx-background-color: #2563eb; -fx-text-fill: white; -fx-font-weight: bold;");
        btnEliminar.setStyle("-fx-background-color: #dc2626; -fx-text-fill: white; -fx-font-weight: bold;");

        form.getChildren().addAll(
                new Label("ID Reserva:"), txtId,
                new Label("Nombre Huésped:"), txtHuesped,
                new Label("DNI:"), txtDni,
                new Label("Teléfono:"), txtTelefono,
                new Label("Tipo de Habitación:"), cbTipoHabitacion,
                new Label("Fecha Ingreso:"), dpIngreso,
                new Label("Fecha Salida:"), dpSalida,
                new Label("Estado:"), cbEstado,
                new Separator(),
                botones1, botones2
        );
        return form;
    }

    @SuppressWarnings("unchecked")
    private VBox crearTabla() {
        TableColumn<Reserva, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("idReserva"));

        TableColumn<Reserva, String> colHuesped = new TableColumn<>("Huésped");
        colHuesped.setCellValueFactory(new PropertyValueFactory<>("nombreHuesped"));

        TableColumn<Reserva, String> colDni = new TableColumn<>("DNI");
        colDni.setCellValueFactory(new PropertyValueFactory<>("dni"));

        TableColumn<Reserva, String> colTel = new TableColumn<>("Teléfono");
        colTel.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        TableColumn<Reserva, String> colHab = new TableColumn<>("Habitación");
        colHab.setCellValueFactory(new PropertyValueFactory<>("tipoHabitacion"));

        TableColumn<Reserva, LocalDate> colIng = new TableColumn<>("Ingreso");
        colIng.setCellValueFactory(new PropertyValueFactory<>("fechaIngreso"));

        TableColumn<Reserva, LocalDate> colSal = new TableColumn<>("Salida");
        colSal.setCellValueFactory(new PropertyValueFactory<>("fechaSalida"));

        TableColumn<Reserva, String> colEst = new TableColumn<>("Estado");
        colEst.setCellValueFactory(new PropertyValueFactory<>("estado"));

        tablaReservas.getColumns().addAll(colId, colHuesped, colDni, colTel, colHab, colIng, colSal, colEst);
        tablaReservas.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        VBox contenedorTabla = new VBox(tablaReservas);
        contenedorTabla.setPadding(new Insets(0, 0, 0, 15));
        VBox.setVgrow(tablaReservas, Priority.ALWAYS);
        return contenedorTabla;
    }
}
