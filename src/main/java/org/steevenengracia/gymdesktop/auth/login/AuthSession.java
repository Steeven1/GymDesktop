package org.steevenengracia.gymdesktop.auth.login;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AuthSession {
  private static final AuthSession instance = new AuthSession();
  private StringProperty username = new SimpleStringProperty();


  private AuthSession() {}

  public static AuthSession getInstance() {
    return instance;
  }

  public String getUsername() {
    return username.get();
  }



  public void setUsername(String value) {
    username.set(value);
  }

  public StringProperty usernameProperty() {
    return username;
  }
}
