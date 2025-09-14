package org.steevenengracia.gymdesktop.components.toggleButton;

import javafx.css.PseudoClass;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class ToggleButton extends javafx.scene.control.ToggleButton  {

  private ToggleGroup toggleGroup;
  ToggleButton(
    String text,
    EventHandler<Event> eventHandler
  ){
    this.setText( text );
    this.getStyleClass().add( "toggleButton.css" );
    this.setPrefHeight( 26 );
    this.setPrefWidth( 163 );
    this.setEventHandler( MouseEvent.MOUSE_CLICKED, eventHandler );
    this.initToggleGroup();

  }

  private void initToggleGroup(){
    this.toggleGroup = new ToggleGroup();
    PseudoClass selected = PseudoClass.getPseudoClass("active");
    this.toggleGroup.selectedToggleProperty()
      .addListener((observable, oldValue, newValue) -> {
        if (oldValue != null) {
          ((javafx.scene.control.ToggleButton) oldValue).pseudoClassStateChanged(selected, false); // Desactivar pseudo-clase
        }
        if (newValue != null) {
          ((javafx.scene.control.ToggleButton) newValue).pseudoClassStateChanged(selected, true); // Activar pseudo-clase
        }
      });
  }

}
