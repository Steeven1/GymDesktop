package org.steevenengracia.gymdesktop;

import javafx.animation.*;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.util.Duration;
import org.steevenengracia.gymdesktop.auth.login.AuthSession;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App implements Initializable {
  @FXML
  private StackPane main;

  private ToggleGroup toggleGroup;
  @FXML
  private VBox vMenu;


  @FXML
  private BorderPane app;
  private HashMap<String, Route> routes;

  private boolean isSignIn = false;
  private Pane vMenu1;
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    //vMenu1 = new Pane( ( Pane ) app.getLeft());
    this.setUpRoutes();
    this.setUpMenu();
    try {
      this.loadRoute("home");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void route(
    javafx.event.ActionEvent actionEv
  ) throws IOException {

    ToggleButton toggleButton = (ToggleButton) actionEv.getSource();
    loadRoute( toggleButton.getId() );

  }

  private void setUpRoutes(){
    routes = new HashMap<String, Route>(
    );
    routes.put("home",
      new Route("home", "/home/Home.fxml", "",
        new ToggleButton( "home" )
        )
    );

    routes.put("membership",
      new Route("membership", "/membership/Membership.fxml", "",
        new ToggleButton( "membership" )
        )
    );

    routes.put("login",
      new Route("login", "/auth/login/Login.fxml", "",
        new ToggleButton( "membership" )
      )
    );


  }

  private void setUpMenu(){

    toggleGroup = new ToggleGroup();
    vMenu.getChildren().stream().forEach( n->{
      if(n instanceof ToggleButton toggleButton){
        toggleButton.setToggleGroup( toggleGroup );
      }
    });

    PseudoClass selected = PseudoClass.getPseudoClass("active");
    toggleGroup.selectedToggleProperty()
      .addListener(
        (observable,
         oldValue, newValue) -> {
        if ( oldValue != null ) {
          ((ToggleButton) oldValue).pseudoClassStateChanged(selected, false); // Desactivar pseudo-clase

        }
        if ( newValue != null) {
          ((ToggleButton) newValue).pseudoClassStateChanged(selected, true); // Activar pseudo-clase

        }
      });
  }

  public void loadRoute(String navigateTo) throws IOException {

    navigateTo = navigateTo.toLowerCase();


    if( !routes.containsKey( navigateTo ) ) {
      System.out.println("Route not found: " + navigateTo);
      return;
    }



    String path = routes.get( navigateTo ).pathRoute();
    FXMLLoader loader = new FXMLLoader( getClass().getResource( path ) );
    Parent newView = loader.load();

    // Animación de salida (translate + fade out)
    TranslateTransition translateOut = new TranslateTransition(Duration.seconds(0.3), main);
    translateOut.setFromX(0);
    translateOut.setToX(-30);

    FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.3), main);
    fadeOut.setFromValue(1.0);
    fadeOut.setToValue(0.0);

    ParallelTransition outTransition = new ParallelTransition(translateOut, fadeOut);

    outTransition.setOnFinished(event -> {
      main.getChildren().clear();
      main.getChildren().setAll( newView );

      // Animación de entrada (translate + fade in)
      TranslateTransition translateIn = new TranslateTransition( Duration.seconds(0.3), main );
      translateIn.setFromX(30);
      translateIn.setToX(0);

      FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.3), main);
      fadeIn.setFromValue(0.0);
      fadeIn.setToValue(1.0);

      ParallelTransition inTransition = new ParallelTransition(translateIn, fadeIn);
      inTransition.play();
    });

    outTransition.play();
  }
  public record Route(String name, String pathRoute, String pathIcon, ToggleButton toggleButton) {

  }
}