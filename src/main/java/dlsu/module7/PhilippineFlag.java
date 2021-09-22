package dlsu.module7;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class PhilippineFlag extends Application {
    private final double flagWidth = 200;
    private final double flagHeight = 100;
    private Rectangle blueRect;
    private Rectangle redRect;
    private Polygon whiteTriangle;
    private Line sunRay0;
    private Line sunRay1;
    private Line sunRay2;
    private Line sunRay3;
    private Line sunRay4;
    private Line sunRay5;
    private Line sunRay6;
    private Line sunRay7;
    private Circle sun;

    public void start(Stage primaryStage) {
        flagRender(0,0);
        AnchorPane anchorPane = new AnchorPane(blueRect,redRect,whiteTriangle,sun,
                sunRay0,sunRay1,sunRay2,sunRay3,sunRay4,sunRay5,sunRay6,sunRay7);
        anchorPane.setLayoutX(0); anchorPane.setLayoutY(0);
        Group root = new Group(anchorPane);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Flag");
        primaryStage.show();
    }
    public void flagRender(double x, double y){
        redWhiteBlue(x,y);
        starsAndSun(x,y);
    }
    public void starsAndSun(double xInput, double yInput){
        double x = xInput + (redRect.getWidth() + blueRect.getWidth()) / 13.5;
        double y = yInput + (redRect.getHeight() + blueRect.getHeight()) / 2;
        sun = new Circle(x,y,flagWidth/15);
        sun.setFill(Color.YELLOW);
        double rayStroke = 2;
        sunRay0 = new Line(x,y,x,y+20);
        sunRay0.setStroke(Color.YELLOW);
        sunRay0.setStrokeWidth(rayStroke);
        sunRay1 = new Line(x,y,x,y-20);
        sunRay1.setStroke(Color.YELLOW);
        sunRay1.setStrokeWidth(rayStroke);
        sunRay2 = new Line(x,y,x+20,y);
        sunRay2.setStroke(Color.YELLOW);
        sunRay2.setStrokeWidth(rayStroke);
        sunRay3 = new Line(x,y,x-20,y);
        sunRay3.setStroke(Color.YELLOW);
        sunRay3.setStrokeWidth(rayStroke);
        sunRay4 = new Line(x,y,x-12.5,y-12.5);
        sunRay4.setStroke(Color.YELLOW);
        sunRay4.setStrokeWidth(rayStroke);
        sunRay5 = new Line(x,y,x+12.5,y+12.5);
        sunRay5.setStroke(Color.YELLOW);
        sunRay5.setStrokeWidth(rayStroke);
        sunRay6 = new Line(x,y,x-12.5,y+12.5);
        sunRay6.setStroke(Color.YELLOW);
        sunRay6.setStrokeWidth(rayStroke);
        sunRay7 = new Line(x,y,x+12.5,y-12.5);
        sunRay7.setStroke(Color.YELLOW);
        sunRay7.setStrokeWidth(rayStroke);
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