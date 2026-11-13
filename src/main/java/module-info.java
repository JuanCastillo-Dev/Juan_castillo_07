module vallegrande.edu.pe.sistemahotel {
    requires javafx.controls;
    requires java.sql;

    opens vallegrande.edu.pe.sistemahotel.model to javafx.base;
    exports vallegrande.edu.pe.sistemahotel;
}
