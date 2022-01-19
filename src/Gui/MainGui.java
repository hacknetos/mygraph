package Gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainGui extends Application {
    @Override
    public void start(Stage primaryStage){
        Group grupe = new Group();
        grupe.getChildren().addAll(buildMenuBar(),buildNewScene());

        primaryStage.sizeToScene();
        primaryStage.setTitle("graphs");
        primaryStage.setScene(new Scene(grupe));
        primaryStage.show();
    }

    private Node buildMenuBar() {
        MenuBar menuBar =new MenuBar();
        return menuBar;
    }

    private Node buildNewScene() {
        TabPane tabPane = new TabPane();
        return tabPane;
    }
}
