package org.steevenengracia.gymdesktop;

import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppRouter implements Initializable {
  @FXML
  private StackPane main;

  private ToggleGroup btnGroup;

  @FXML
  private ToggleButton home;

  @FXML
  private ToggleButton membership;

  private HashMap<String, String> routes;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    routes = new HashMap<String, String>();
    routes.put("home", "/home/Home.fxml");
    routes.put("membership", "/membership/Membership.fxml");

    btnGroup = new ToggleGroup();
    home.setToggleGroup(btnGroup);
    membership.setToggleGroup(btnGroup);

    PseudoClass selected = PseudoClass.getPseudoClass("active");
    btnGroup.selectedToggleProperty()
      .addListener((observable, oldValue, newValue) -> {
        if (oldValue != null) {
          ((ToggleButton) oldValue).pseudoClassStateChanged(selected, false); // Desactivar pseudo-clase
        }
        if (newValue != null) {
          ((ToggleButton) newValue).pseudoClassStateChanged(selected, true); // Activar pseudo-clase
        }
    });

    try {

      FXMLLoader loader = new FXMLLoader(getClass().getResource("/home/Home.fxml"));
      main.getChildren().removeAll();
      main.getChildren().setAll( (Parent) loader.load());

    } catch (IOException e) {
      Logger.getLogger(
        AppRouter.class.getName()
      ).log(Level.SEVERE, null, e);
    }
  }

  public void route(
    javafx.event.ActionEvent actionEv
  ) throws IOException {

    Control ctrl = (Control) actionEv.getSource();
    System.out.println(ctrl.getId());
    load(ctrl.getId());

  }
  public void load(String navigateTo) throws IOException {
    FXMLLoader loader = new FXMLLoader(
      getClass()
        .getResource(
          routes.get(navigateTo)
        )
    );
    main.getChildren().clear();
    main.getChildren().setAll( (Parent) loader.load());
  }

  public void activeLink(javafx.scene.input.MouseEvent actionEv){


  }
}