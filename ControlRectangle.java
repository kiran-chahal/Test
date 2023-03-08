package com.example.examples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ControlRectangle extends Application {
    private RectanglePane rectanglePane = new RectanglePane();

    @Override
    public void start(Stage primaryStage) {
        // Hold two buttons in an HBox
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button btEnlarge = new Button("Enlarge");
        Button btShrink = new Button("Shrink");
        hBox.getChildren().add(btEnlarge);
        hBox.getChildren().add(btShrink);

        // Create and register the handler
        btEnlarge.setOnAction(new RectangleEnlargeHandler());
        btShrink.setOnAction(new RectangleShrinkHandler());

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(rectanglePane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 300, 250);
        primaryStage.setTitle("ControlRectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class RectangleEnlargeHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            rectanglePane.enlarge();
        }
    }
    class RectangleShrinkHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            rectanglePane.Shrink();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class RectanglePane extends StackPane {
    private Rectangle rectangle = new Rectangle(200, 150);

    public RectanglePane() {
        getChildren().add(rectangle);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);
    }

    public void enlarge() {
        rectangle.setWidth(rectangle.getWidth() + 10);
        rectangle.setHeight(rectangle.getHeight() + 10);
    }

    public void Shrink() {
        rectangle.setWidth(rectangle.getWidth() > 10 ? rectangle.getWidth() - 10 : rectangle.getWidth());
        rectangle.setHeight(rectangle.getHeight() > 10 ? rectangle.getHeight() - 10 : rectangle.getHeight());
    }
}
