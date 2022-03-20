package guiLists;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FXLists extends Application {
    public static void run(){
        FXLists.launch();
    }
    @Override
    public void start(Stage stage) {
        String[] fruits = {"banana","apple","lemon"};
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(fruits);
        FlowPane flowPane = new FlowPane(comboBox);
        Scene scene = new Scene(flowPane, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
}
