package dlsu.module7;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FormulaCalculator extends Application {
    private Scene scene;
    private VBox root;
    @Override
    public void start(Stage stage) throws Exception {
        mainMenu();

        stage.setScene(scene);
        stage.setTitle("Formula Calculator");
        stage.show();
    }
    private void mainMenu(){
        int selectionInteger = 0;

        Button buttonOne = new Button("Formula 1");
        Button buttonTwo = new Button("Formula 2");

        root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(buttonOne,buttonTwo);
        root.setSpacing(15);

        scene = new Scene(root);
    }
}
