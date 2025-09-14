package org.steevenengracia.gymdesktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(
      Main.class.getResource(
        Router.getInstance().routes.get( "login" )
      ) );
    Parent root = fxmlLoader.load();
    Scene scene = new Scene( root, 780, 550);
    stage.setScene(scene);
    stage.setTitle( "GymDesktop" );
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}