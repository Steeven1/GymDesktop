package org.steevenengracia.gymdesktop.auth.login;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.steevenengracia.gymdesktop.Router;
import org.steevenengracia.gymdesktop.components.toggleButton.FadeAnimation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

  @FXML
  private Pane login;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

  }

  public void login(javafx.event.ActionEvent actionEvent) throws IOException {

    //AuthSession.getInstance().setUsername("username");


    Router.getInstance()
      .navigateTo( "app", null, (Stage) login.getScene().getWindow() );
  }
}
