package gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FXEvents extends Application {

    public static void run(){
        FXEvents.launch();
    }
    @Override
    public void start(Stage stage) {
        Button button = new Button("Push Me!");
        Label label = new Label();
        FlowPane pane = new FlowPane();
        pane.getChildren().addAll(label,button);
        Scene scene = new Scene(pane, 800,600);
        stage.setScene(scene);
        stage.show();

    }
}
