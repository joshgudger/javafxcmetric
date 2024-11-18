import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Metric Converter");

        // Create components
        Label choiceLabel = new Label("Choose conversion:");
        ComboBox<String> conversionChoice = new ComboBox<>();
        conversionChoice.getItems().addAll("Kg to Lb", "Gram to Ounces", "Mile to Kilometer", "Milimeter to Inch");

        Label inputLabel = new Label("Input value:");
        TextField inputValue = new TextField();

        Button convertButton = new Button("Convert");
        Label resultLabel = new Label("Result: ");
        Label resultValue = new Label();

        // Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(choiceLabel, conversionChoice, inputLabel, inputValue, convertButton, resultLabel, resultValue);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Event handling
        convertButton.setOnAction(e -> {
            try {
                float value = Float.parseFloat(inputValue.getText());
                String choice = conversionChoice.getValue();
                float result = 0;
                if (choice != null) {
                    switch (choice) {
                        case "Kg to Lb":
                            result = value * 2.2046f;
                            break;
                        case "Gram to Ounces":
                            result = value * 0.035274f;
                            break;
                        case "Mile to Kilometer":
                            result = value * 1.60934f;
                            break;
                        case "Milimeter to Inch":
                            result = value * 0.0393701f;
                            break;
                        default:
                            resultLabel.setText("Invalid conversion type.");
                            return;
                    }
                    resultValue.setText(String.valueOf(result));
                } else {
                    resultLabel.setText("Please select a conversion type.");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number.");
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}

