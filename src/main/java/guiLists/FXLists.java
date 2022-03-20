package guiLists;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class FXLists extends Application {
    public static void run(){
        FXLists.launch();
    }
    @Override
    public void start(Stage stage) {
        String[] fruits = {"banana","apple","lemon"};
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(fruits);
        comboBox.setOnAction((actionEvent -> System.out.println(comboBox.getValue())));
        
        FlowPane flowPane = new FlowPane(comboBox);
        TextField textField = new TextField("");
        textField.textProperty().addListener(observable -> {
            List<String> strings = Arrays.stream(fruits).filter(item -> item.startsWith(textField.getText())).toList();
            System.out.println(strings);
            comboBox.getItems().clear();
            comboBox.getItems().addAll(strings);
        });
        flowPane.getChildren().addAll(textField);
        Scene scene = new Scene(flowPane, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
}
