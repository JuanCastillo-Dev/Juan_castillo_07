package vallegrande.edu.pe.sistemahotel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vallegrande.edu.pe.sistemahotel.controller.ReservaController;
import vallegrande.edu.pe.sistemahotel.view.ReservaView;

public class Launcher extends Application {

    @Override
    public void start(Stage primaryStage) {
        ReservaView view = new ReservaView();
        new ReservaController(view);

        Scene scene = new Scene(view, 1080, 700);
        primaryStage.setTitle("Sistema CRUD Hotel - Juan Jeremy Castillo Rojas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
