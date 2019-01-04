package view;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.fxml.FXMLLoader;

public class GUI extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent welcome = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene sceneWelcome = new Scene(welcome);

        primaryStage.setTitle("Nenufar Dance School");
        primaryStage.setScene(sceneWelcome);
        primaryStage.show();
    }
}
