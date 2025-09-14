package org.steevenengracia.gymdesktop;

import javafx.geometry.Pos;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.awt.*;

public class VMenu {
  private VBox vBox;
  private Pane layout;
  public VMenu(){

  }

  private void buildVMenu(){
    this.vBox = new VBox();
    this.vBox.setAlignment( Pos.BASELINE_CENTER );
    this.vBox.setLayoutX( 8 );
    this.vBox.setLayoutY( 7 );
    this.vBox.prefHeight(236 );
    this.vBox.prefWidth(152 );
    this.vBox.setSpacing( 10 );
    this.vBox.getStylesheets().setAll( "components/toggleButton/toggleButton.css" );

  }

  private void buildImageView(){

  }

  private void buildLayout(){
    this.layout.setPrefHeight(472);
    this.layout.setPrefWidth(171);
    this.layout.setStyle("-fx-background-color: #939190;");

  }
}
