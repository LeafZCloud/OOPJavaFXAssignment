package edu.farmingdale.csc325_oopjavafxassignment;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

       // Build the Menu
        MenuBar menuBar = new MenuBar();
        menuBar.getStyleClass().add("top-menu");

        Menu file = new Menu("File");
        file.getItems().addAll(
                new MenuItem("New"),
                new MenuItem("Open"),
                new SeparatorMenuItem(),
                new MenuItem("Exit")
        );

        Menu edit = new Menu("Edit");
        edit.getItems().addAll(new MenuItem("Copy"), new MenuItem("Paste"));

        Menu theme = new Menu("Theme");
        theme.getItems().add(new MenuItem("Default"));

        Menu help = new Menu("Help");
        help.getItems().add(new MenuItem("About"));

        menuBar.getMenus().addAll(file, edit, theme, help);

        // Build Left Panel

        VBox left = new VBox();
        left.getStyleClass().add("left-sidebar");
        left.setPrefWidth(160);
        left.setAlignment(Pos.TOP_CENTER);
        left.setPadding(new Insets(25, 10, 10, 10));

        StackPane avatarCard = new StackPane();
        avatarCard.getStyleClass().add("avatar-card");
        avatarCard.setPrefSize(140, 140); // bigger

        Label avatar = new Label("👤"); // icon is an emoji
        avatar.getStyleClass().add("avatar-placeholder");

        avatarCard.getChildren().add(avatar);
        left.getChildren().add(avatarCard);

        // Table
        TableView<Student> table = new TableView<>();
        table.getStyleClass().add("main-table");
        table.setItems(FXCollections.observableArrayList());

        TableColumn<Student, Integer> c1 = new TableColumn<>("ID");
        c1.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Student, String> c2 = new TableColumn<>("First Name");
        c2.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Student, String> c3 = new TableColumn<>("Last Name");
        c3.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Student, String> c4 = new TableColumn<>("Department");
        c4.setCellValueFactory(new PropertyValueFactory<>("department"));

        TableColumn<Student, String> c5 = new TableColumn<>("Major");
        c5.setCellValueFactory(new PropertyValueFactory<>("major"));

        TableColumn<Student, String> c6 = new TableColumn<>("Email");
        c6.setCellValueFactory(new PropertyValueFactory<>("email"));

        table.getColumns().addAll(c1, c2, c3, c4, c5, c6);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        StackPane center = new StackPane(table);

        // Build Right Panel
        VBox right = new VBox(12);
        right.getStyleClass().add("right-panel");
        right.setPrefWidth(260);
        right.setPadding(new Insets(18));

        TextField f1 = new TextField(); f1.setPromptText("ID");
        TextField f2 = new TextField(); f2.setPromptText("First Name");
        TextField f3 = new TextField(); f3.setPromptText("Last Name");
        TextField f4 = new TextField(); f4.setPromptText("Department");
        TextField f5 = new TextField(); f5.setPromptText("Major");
        TextField f6 = new TextField(); f6.setPromptText("Email");
        TextField f7 = new TextField(); f7.setPromptText("imageURL");

        Button b1 = new Button("Clear");
        Button b2 = new Button("Add");
        Button b3 = new Button("Delete");
        Button b4 = new Button("Edit");

        b1.getStyleClass().add("action-button");
        b2.getStyleClass().add("action-button");
        b3.getStyleClass().add("action-button");
        b4.getStyleClass().add("action-button");

        b1.setPrefHeight(55);
        b2.setPrefHeight(55);
        b3.setPrefHeight(55);
        b4.setPrefHeight(55);

        b1.setMaxWidth(Double.MAX_VALUE);
        b2.setMaxWidth(Double.MAX_VALUE);
        b3.setMaxWidth(Double.MAX_VALUE);
        b4.setMaxWidth(Double.MAX_VALUE);

        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

        right.getChildren().addAll(
                f1,f2,f3,f4,f5,f6,f7,
                spacer,
                b1,b2,b3,b4
        );


        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setLeft(left);
        root.setCenter(center);
        root.setRight(right);

        Scene scene = new Scene(root, 1000, 600);

        var css = Main.class.getResource("styles.css");
        if (css != null) {
            scene.getStylesheets().add(css.toExternalForm());
        }

        stage.setTitle("FSC CSC325 - Full Stack Project");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}