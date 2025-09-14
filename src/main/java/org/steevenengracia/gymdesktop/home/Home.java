package org.steevenengracia.gymdesktop.home;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import org.steevenengracia.gymdesktop.auth.login.AuthSession;

import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {

  @FXML
  private Pane navigatable;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    String u = AuthSession.getInstance().getUsername();
    System.out.print( u );
  }
}
