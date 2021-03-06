package Gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Gui.Numberfield;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListResourceBundle;

public class MainGui extends Application {
    Numberfield input;
     int selectetunter = 0;
    LinkedList<Integer> list = new LinkedList<Integer>();
    XYChart.Series series ;
    int count = 0;
    ObservableList<Integer> unterEinArray = FXCollections.observableArrayList(0, 0, 0, 0);
    @Override
    public void start(Stage primaryStage){
        BorderPane mainpaPane = new BorderPane();
       //TODO mainpaPane.setTop(buldTopPane);
        mainpaPane.setCenter(buldCenterPane());
        Scene mainScene = new Scene(mainpaPane);
        //TODO CSS
        primaryStage.setScene(mainScene);
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
        borderPane.setCenter(buildBankmonyGraph());
        borderPane.setLeft(buldLeftborderpane());
        return borderPane;
    }

    private Node buildBankmonyGraph() {
        NumberAxis xAxis = new NumberAxis(1,365,28);
        xAxis.setLabel("Day's");

        NumberAxis yAxis = new NumberAxis(0,10000,1000);
        yAxis.setLabel("Mony in K Staps");

        LineChart lineChart = new LineChart(xAxis,yAxis);
        series = new XYChart.Series();
        series.setName("Mony in day in one year");
        series.getData().add(new XYChart.Data(1,1000));
        series.getData().add(new XYChart.Data(2,100));
        series.getData().add(new XYChart.Data(3,400));
        list.add(1000);
        list.add(100);
        list.add(400);

        lineChart.getData().add(series);
        return lineChart;
    }

    private Node buldLeftborderpane() {
        VBox vBox = new VBox(15);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(buidinputfildUnternemen(),buildInputFild(),buildHinzuf??genbutton());
        return vBox;
    }

    private Node buidinputfildUnternemen() {
        ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.setTooltip(new Tooltip("Selcet the Comperny"));
        ObservableList unternemen = FXCollections.observableArrayList(
                "Uggel",
                "Flappel",
                "Potstar",
                "Ohter"
        );

        comboBox.setOnAction(event -> {
            selectetunter = comboBox.getSelectionModel().getSelectedIndex();
        });

        comboBox.setItems(unternemen);
        return comboBox;
    }

    private Node buildInputFild() {
        input = new Numberfield();
        input.setPromptText("geben sie ihren betragein");
        input.setAlignment(Pos.CENTER);
        return input;
    }

    private Node buildHinzuf??genbutton() {
        Button btn = new Button("Add");
        btn.setOnAction(event -> {

                int tmp = Integer.parseInt(input.getText());

                if (list.getLast() != tmp) {
                    if (count>0){
                        series.getData().add(new XYChart.Data(list.size(),list.getLast()));
                    }
                    series.getData().add(new XYChart.Data(list.size() + 1, tmp));
                }else {
                    count++;
                }

                if (list.getLast() < tmp){
                    unterEinArray.set(selectetunter, Integer.parseInt(input.getText())-list.getLast());

                }
                list.add(tmp);

                input.setText("");

        });
        return btn;
    }

    private Tab buildUnternemenTab() {
        Tab tab = new Tab("Untenemen");
        tab.setTooltip(new Tooltip("Shares of companies"));
        tab.setContent(buildUnternemenTabConten());
        tab.setClosable(false);
        return tab;
    }

    private Node buildUnternemenTabConten() {
        BorderPane unterPane = new BorderPane();
        unterPane.setLeft(buldLeftUnterPane());
       //TODO unterPane.setRight();
        return unterPane;
    }

    private Node buldLeftUnterPane() {
        VBox vBox = new VBox(15);
        vBox.getChildren().add(buildUntenemensGraph());
        return vBox;

    }

    private Node buildUntenemensGraph() {
        ObservableList UntenemenDatern =
                FXCollections.observableArrayList(
                    new PieChart.Data("Uggel",unterEinArray.get(0)),
                    new PieChart.Data("flappel",unterEinArray.get(1)),
                    new PieChart.Data("Potstar",unterEinArray.get(2)),
                    new PieChart.Data("other",unterEinArray.get(3))
                );
        PieChart pieChart = new PieChart(UntenemenDatern);
        pieChart.setTitle("untermens anteile");
        return pieChart;
    }

    private Tab buildWieTab() {
        Tab tab = new Tab("How");
        tab.setTooltip(new Tooltip("HOW"));
         tab.setClosable(false);
        //TODO  tab.setContent();
        return tab;
    }

}
