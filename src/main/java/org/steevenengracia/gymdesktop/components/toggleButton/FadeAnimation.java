package org.steevenengracia.gymdesktop.components.toggleButton;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class FadeAnimation {
private final double toTranslateFromY;
private final double toTranslateToY;

public FadeAnimation(double toTranslateFromY, double toTranslateToY){
  this.toTranslateFromY = toTranslateFromY;
  this.toTranslateToY = toTranslateToY;
}
  public void animate(
    Pane container,
    Node node
  ){
    out( container, () -> {
      container.getChildren().clear();
      container.getChildren().setAll( node );

      // Animación de entrada
      in( container );
    });
  }

  public void in(Node to){
    TranslateTransition translateIn = new TranslateTransition(Duration.seconds(0.3), to);
    translateIn.setFromY( - this.toTranslateToY );
    translateIn.setToY( this.toTranslateFromY );

    FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.3), to);
    fadeIn.setFromValue(0.0);
    fadeIn.setToValue(1.0);

    ParallelTransition inTransition = new ParallelTransition(translateIn, fadeIn);
    inTransition.play();
  }



  public void out(Node from, Runnable onComplete){
    TranslateTransition translateOut = new TranslateTransition(Duration.seconds(0.3), from);
    translateOut.setFromY( this.toTranslateFromY );
    translateOut.setToY( this.toTranslateToY );

    FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.3), from);
    fadeOut.setFromValue(1.0);
    fadeOut.setToValue(0.0);

    ParallelTransition outTransition = new ParallelTransition(translateOut, fadeOut);
    outTransition.setOnFinished(event -> onComplete.run());
    outTransition.play();
  }
}
