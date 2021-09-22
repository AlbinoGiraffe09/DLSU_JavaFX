package dlsu.module7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage){
        Circle circle = new Circle(60);
        circle.setFill(Color.BLUE);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(5.0);
        Rectangle rect = new Rectangle(160, 80);
        rect.setFill(Color.GREEN);
// Create a line
        Line line = new Line(0, 40, 120, 0);
        line.setStrokeWidth(5.0);
        line.setStroke(Color.AQUAMARINE);
// Create a parallelogram
        Polygon parallelogram = new Polygon();
        parallelogram.getPoints().addAll(30.0, 0.0,
                150.0, 0.0,
                120.00, 50.0,
                0.0, 50.0);
        parallelogram.setFill(Color.RED);
        parallelogram.setStroke(Color.BLACK);
        parallelogram.setStrokeWidth(5.0);
// A Chord arc with no fill and a stroke
        Arc arc = new Arc(0, 0, 100, 100, 0, 90);
        arc.setFill(Color.TRANSPARENT);
        arc.setStroke(Color.BLACK);
        arc.setType(ArcType.CHORD);
        arc.setStrokeWidth(5.0);
// Add all shapes to a VBox
        VBox root = new VBox(circle, rect, line, parallelogram, arc);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 4;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Shapes");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}