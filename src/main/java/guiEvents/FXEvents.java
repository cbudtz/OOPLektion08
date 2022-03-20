package guiEvents;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FXEvents extends Application {
    DoubleProperty number = new SimpleDoubleProperty(0);

    public static void run(){
        FXEvents.launch();
    }
    @Override
    public void start(Stage stage) {
        Button button = new Button("Push Me!");
        Label label = new Label();
        Label counter = new Label(number.toString());
        FlowPane pane = new FlowPane();
        pane.getChildren().addAll(label,button,counter);
        Scene scene = new Scene(pane, 800,600);
        stage.setScene(scene);
        stage.show();
        button.setOnMouseClicked(mouseEvent -> {
            label.setText(mouseEvent.toString());
            number.set(number.get()+1);
        });
        number.addListener(num-> counter.setText(String.valueOf(number.get())));
        pane.setOnKeyPressed(keyEvent -> label.setText(keyEvent.getCode().toString()));

    }
}
