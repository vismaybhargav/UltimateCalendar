package org.vini.ultcal.core;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.vini.ultcal.util.ColorsKt;

/**
 * The main class of the application.
 */
public class App extends Application {
    /**
     * The entry point of the application gui.
     * @param stage The primary stage for the application.
     * @throws Exception If an error occurs.
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Application");
        stage.setWidth(800);
        stage.setHeight(640);

        // Create the root layout
        var root = new BorderPane();
        root.setBackground(Background.fill(ColorsKt.color(30, 31, 34)));

        var sidebar = new VBox();
        sidebar.setBackground(Background.fill(ColorsKt.color(43, 45, 48)));
        sidebar.setPrefSize(200, 640);
        root.setLeft(sidebar);

        VBox todoView = new VBox();
        todoView.setSpacing(10);
        todoView.getChildren().addAll(
                createTodoView("Todo 1"),
                createTodoView("Todo 2"),
                createTodoView("Todo 3"),
                new Button("+")
        );

        root.setCenter(todoView);

        // Create the scene
        var scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private HBox createTodoView(
            String title
    ) {
        HBox todoView = new HBox(10);
        Label label = new Label(title);
        label.setFont(Font.font(20));
        label.setTextFill(ColorsKt.color(188, 190, 196));

        CheckBox checkBox = new CheckBox();
        todoView.setAlignment(Pos.CENTER_LEFT);
        checkBox.getStyleClass().add("custom-checkbox");
        checkBox.getStylesheets().add(getClass().getResource("/styles/checkbox-style.css").toExternalForm());

        todoView.getChildren().addAll(checkBox, label);
        return todoView;
    }
}
