package Gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class MainGui extends Application {
    @Override
    public void start(Stage primaryStage){
        BorderPane mainpaPane = new BorderPane();
       //TODO mainpaPane.setTop(buldTopPane);
        mainpaPane.setCenter(buldCenterPane());

        primaryStage.setScene(new Scene(mainpaPane));
        primaryStage.sizeToScene();
        primaryStage.show();

    }

    private Node buldCenterPane() {
        TabPane tabPane = new TabPane();
        tabPane.getTabs().addAll(buildBankTab(),buildUnternemenTab(),buildWieTab());
        return tabPane;
    }

    private Tab buildBankTab() {
        Tab tab = new Tab("Bank");
        tab.setClosable(false);
        tab.setTooltip(new Tooltip("Bank Mony Graph"));
        tab.setContent(buildBankmonyTapContent());
        return tab;
    }

    private Node buildBankmonyTapContent() {
        BorderPane borderPane = new BorderPane();
    }

    private Tab buildUnternemenTab() {
        Tab tab = new Tab("Untenemen");
        tab.setTooltip(new Tooltip("Shares of companies"));
      //TODO  tab.setContent();
        tab.setClosable(false);
        return tab;
    }

    private Tab buildWieTab() {
        Tab tab = new Tab("How");
        tab.setTooltip(new Tooltip("HOW"));
         tab.setClosable(false);
        //TODO  tab.setContent();
        return tab;
    }

}
