package com.example.gui;

import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.awt.*;
import java.io.*;
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
        stage.setTitle("Student login");
        GridPane pane = new GridPane();
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
        pane.add(signin, 5, 4);
        try {
            File file = new File("userlogin.abc");
            if (!file.exists()) {  // Check if file exists
                file.createNewFile();  // Create new file if it doesn't exist
                System.out.println("File created successfully.");
            }
            // Writing to the file
            FileWriter writer = new FileWriter(file);
            writer.write("Samar Samar123");
            writer.flush();  // Ensure content is written to the file
            System.out.println("File written successfully.");
        login.setOnAction(e->{
            boolean temp = false;
            try {
                String enteredUserName = name.getText();
                String enteredPassword = pass.getText();
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String userDetails = "";
                while ((userDetails = bufferedReader.readLine()) != null) {
                    String user[] = userDetails.split(" ");

                    if (user[0].equals(enteredUserName) && user[1].equals(enteredPassword))  {
                        temp = true;
                        break;
                    }
                }
                bufferedReader.close();
                if(temp==true){
                    open_next(enteredUserName,stage);
                } else if (temp==false) {
                    Label errorLabel = new Label("Incorrect username or password!");
                    errorLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
                    pane.add(errorLabel, 1, 4);
                }
            }
            catch(IOException io){

            }

        });
        login.setStyle("-fx-background-color:green;-fx-font-weight:bold;-fx-text-fill:white");
        pane.add(login,0,5);
        pane.add(exit,1,5);
        exit.setOnAction(e->{
            stage.close();
        });
    }catch (IOException e) {
        e.getMessage();
    }

    Scene scene = new Scene(pane, 800, 800);
        stage.setScene(scene);
        stage.show();
}
private void open_next(String userName, Stage stage) {

    VBox nextPageLayout = new VBox(20);
    nextPageLayout.setAlignment(Pos.CENTER);
    Label welcomeLabel = new Label("Welcome, " + userName);
    nextPageLayout.getChildren().add(welcomeLabel);
    Scene nextPageScene = new Scene(nextPageLayout, 300, 150);
    stage.setTitle("Welcome");
    stage.setScene(nextPageScene);
}
        public static void main (String[] args){
            launch();
        }
    }
