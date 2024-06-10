package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Fechaycolores extends Application {

    private Label dateLabel;
    private DatePicker datePicker;
    private Label colorLabel;
    private ColorPicker colorPicker;
    private Button confirmButton;
    private Text resultText;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initializeControls();
        configureButtonAction();
        VBox vbox = createLayout();

        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setTitle("Picker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeControls() {
        dateLabel = new Label("Selecciona una fecha:");
        datePicker = new DatePicker();
        colorLabel = new Label("Selecciona un color:");
        colorPicker = new ColorPicker();
        confirmButton = new Button("Confirmar");
        resultText = new Text();
    }

    private void configureButtonAction() {
        confirmButton.setOnAction(e -> {
            String selectedDate = (datePicker.getValue() != null) ? datePicker.getValue().toString() : "No seleccionada";
            Color selectedColor = (colorPicker.getValue() != null) ? colorPicker.getValue() : Color.BLACK;
            resultText.setText("Fecha seleccionada: " + selectedDate + "\nColor seleccionado: " + selectedColor);
            resultText.setFill(selectedColor);
        });
    }

    private VBox createLayout() {
        VBox vbox = new VBox(10, dateLabel, datePicker, colorLabel, colorPicker, confirmButton, resultText);
        vbox.setSpacing(10);
        return vbox;
    }
}
