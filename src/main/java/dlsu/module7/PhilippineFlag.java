package dlsu.module7;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class PhilippineFlag extends Application {
    private Canvas canvas = new Canvas(800, 400);
    private final double flagWidth = 800;
    private final double flagHeight = 400;
    private Rectangle blueRect;
    private Rectangle redRect;
    private Polygon whiteTriangle;
    private Circle sun;

    public void start(Stage primaryStage) {
        flagRender(0,0);
        Group root = new Group(blueRect,redRect,whiteTriangle,sun);
        Scene scene = new Scene(root,800,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Flag");
        primaryStage.show();
    }
    public void flagRender(double x, double y){
        redWhiteBlue(x,y);
        starsAndSun(x,y);
    }
    public void starsAndSun(double xInput, double yInput){
        double x = (redRect.getWidth() + blueRect.getWidth()) / 6.5;
        double y = (redRect.getHeight() + blueRect.getHeight()) / 2;
        sun = new Circle(x,y,45);
        sun.setFill(Color.YELLOW);
        Line sunRay = new Line(x,y,x,x);
    }
    public void redWhiteBlue(double x, double y){
        double rectWidth = flagWidth;
        double rectHeight = flagHeight/2;
        // Blue Side
        blueRect = new Rectangle(x,y,rectWidth,rectHeight);
        blueRect.setFill(Color.BLUE);
        // Red Side
        redRect = new Rectangle(x, flagHeight/2, rectWidth,rectHeight);
        redRect.setFill(Color.RED);
        // White Triangle
        Double[] points = {x,y,x, flagHeight, flagWidth/2.5, flagHeight/2};
        whiteTriangle = new Polygon();
        whiteTriangle.getPoints().addAll(points);
        whiteTriangle.setFill(Color.WHITE);
    }
}