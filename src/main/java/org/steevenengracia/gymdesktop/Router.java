package org.steevenengracia.gymdesktop;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.steevenengracia.gymdesktop.components.toggleButton.FadeAnimation;

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
  private void registerRoute(String routeName, String fxmlPath) {
    routes.put( routeName, fxmlPath );
  }

  public void navigateTo(String routeName, Node navigable, Stage stage) throws IOException {

    FXMLLoader loader = new FXMLLoader(getClass().getResource(routes.get(routeName)));
    Parent to = loader.load();
    if (stage != null) {

      // 3. Crear la nueva Scene con el contenido de la página principal
      //Scene scene = new Scene( root );

      // 4. Mostrar la nueva Scene en la ventana
      //stage.setScene( scene );
      //stage.show();
      Scene currentScene = stage.getScene();
      if (currentScene != null) {
        FadeAnimation fadeAnimation = new FadeAnimation( 0, -30 );
          fadeAnimation.out(
            currentScene.getRoot(), ()->{
              // Cambiar la escena después de la animación
              Scene newScene = new Scene( to );
              stage.setScene(newScene);

              fadeAnimation.in( to );
            }
          );
      }
    }

    if (navigable instanceof StackPane main) {

      FadeAnimation fadeAnimation1 = new FadeAnimation(0, -10 );
      fadeAnimation1.out(
            main, ()->{
              // Cambiar la escena después de la animación
              main.getChildren().clear();
              main.getChildren().setAll( to );

              fadeAnimation1.in( main );
            }
          );

    }
  }

}
