package org.steevenengracia.gymdesktop;

import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.HashMap;

public class Router {
  private static Router instance;
  // HashMap para registrar rutas
  public final HashMap<String, String> routes = new HashMap<>();

  private Router(  ) {
    registerRoute("app", "/App.fxml");
    registerRoute("home", "/home/Home.fxml");
    registerRoute("login", "/auth/login/Login.fxml");
    registerRoute("membership", "/membership/Membership.fxml");
  }

  public static Router getInstance() {
    if (instance == null) {
      instance = new Router();
    }
    return instance;
  }

  // Registrar una nueva ruta
  public void registerRoute(String routeName, String fxmlPath) {
    routes.put( routeName, fxmlPath );
  }

  public void navigateTo(String routeName, Node node, Stage stage) throws IOException {

      FXMLLoader loader = new FXMLLoader( getClass().getResource( routes.get( routeName) ) );
      Parent root = loader.load();
      if (stage != null) {

        // 3. Crear la nueva Scene con el contenido de la página principal
        //Scene scene = new Scene( root );

        // 4. Mostrar la nueva Scene en la ventana
        //stage.setScene( scene );
        //stage.show();
        Scene currentScene = stage.getScene();
        if (currentScene != null) {
          // Crear una animación de desvanecimiento para la vista actual
          FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), currentScene.getRoot());
          fadeOut.setFromValue( 1 );
          fadeOut.setToValue( 0 );
          fadeOut.setOnFinished(event -> {
            // Cambiar la escena después de la animación
            Scene newScene = new Scene( root );
            stage.setScene( newScene );

            // Animación de entrada para la nueva vista
            FadeTransition fadeIn = new FadeTransition( Duration.seconds(0.5 ), newScene.getRoot());
            fadeIn.setFromValue( 0 );
            fadeIn.setToValue( 1 );
            fadeIn.play();
          });
          fadeOut.play();
        }

        if (node instanceof Pane pane) {
          pane.getChildren().clear();
          pane.getChildren().setAll( root );
        }
     }
    }

}
