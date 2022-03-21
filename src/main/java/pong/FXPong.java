package pong;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FXPong extends Application {
    double cxv = -1;
    double cyv = -1;

    public static void run(){
        FXPong.launch();
    }
    @Override
    public void start(Stage stage){
        Rectangle rectangle = new Rectangle(10,10,10,200);
        Circle circle = new Circle(300,400,10);
        Pane pane = new Pane();
        pane.getChildren().addAll(rectangle, circle);

        Scene scene = new Scene(pane,800,600);
        scene.setOnKeyPressed(e->{
            System.out.println(e.getCode());
            switch (e.getCode()){
                case UP -> rectangle.setY(rectangle.getY()-10);
                case DOWN -> rectangle.setY(rectangle.getY()+10);
            }
        });
        stage.setScene(scene);
        stage.show();
        new Thread(() -> {
            while(true) {
                double cx = circle.getCenterX();
                double cy = circle.getCenterY();
                if (cx < rectangle.getX()+20 && Math.abs(rectangle.getY()+100-cy) < 100){
                    System.out.println("collision!");
                    cxv=1;
                }
                circle.setCenterX(cx + cxv);
                circle.setCenterY(cy + cyv);
                try {
                    //noinspection BusyWait
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }
}
