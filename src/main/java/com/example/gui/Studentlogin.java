package com.example.gui;

import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.awt.*;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Studentlogin extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane, 500, 500);
        Image image = new Image(this.getClass().getResource("/img.png").toExternalForm());
        ImageView imageview = new ImageView(image);
        Label username = new Label("Username");
        TextField name = new TextField();
        Label passward = new Label("Passward");
        TextField pass = new TextField();
        Button login = new Button("Login");
        Button exit = new Button("Exit");
        Button signin = new Button("Sign in");
        pane.add(imageview, 4, 0, 1, 1);
        pane.add(username, 2, 2);
        pane.add(name, 3, 2);
        pane.add(passward, 2, 3);
        pane.add(pass, 3, 3);
        pane.add(login, 3, 4);
        pane.add(exit, 4, 4);
        pane.add(signin, 5, 4);
        stage.setScene(scene);
        stage.show();
        F
    }

        public static void main (String[] args){
            launch();
        }
    }
