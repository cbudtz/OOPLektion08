package gui;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

class MouseLabelEventHandler implements EventHandler<MouseEvent> {
    private final Label label;

    public MouseLabelEventHandler(Label label) {
        this.label = label;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        label.setText(mouseEvent.toString());
    }
}
