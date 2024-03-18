package no.ntnu.idatx2003.oblig3.sivertsu;

import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import no.ntnu.idatx2003.oblig3.sivertsu.ButtonController;
import no.ntnu.idatx2003.oblig3.sivertsu.DeckOfCards;

public class TableTop extends Application {

  private ButtonController controller;
  private Label hand;

  @Override
  public void start(Stage stage) throws Exception {

    BorderPane rootNode = new BorderPane();

    //call the bottom container
    FlowPane bottomContainer = bottomContainer();
    rootNode.setBottom(bottomContainer);
    //call the right container
    VBox rightContainer = rightContainer();
    rootNode.setRight(rightContainer);
    //call the center container
    FlowPane centerContainer = centerContainer();
    rootNode.setCenter(centerContainer);

    //set the minimum size of the window
    stage.setMinWidth(500);
    stage.setMinHeight(300);

    //sett the stage
    stage.setScene(new Scene(rootNode, 400, 300));
    stage.setTitle("CardGame");
    stage.show();
  }

  public FlowPane bottomContainer() {
    FlowPane bottomContainer = new FlowPane();

    //organising the bottom container
    bottomContainer.setAlignment(Pos.CENTER);
    bottomContainer.setHgap(20);
    bottomContainer.setPadding(new Insets(40));

    //text box and function display for bottom container
    Label sum = new Label("sum of faces:");
    Label hearts = new Label("cards of hearts:");
    Label flush = new Label("flush:");
    Label queenOfSpades = new Label("Queen of spades:");
    bottomContainer.getChildren().addAll(sum, hearts, flush, queenOfSpades);

    return bottomContainer;
  }

  public VBox rightContainer() {
    this.controller = new ButtonController(this);

    VBox rightContainer = new VBox();

    //organising the right container
    rightContainer.setAlignment(Pos.CENTER);
    rightContainer.setSpacing(30);
    rightContainer.setPadding(new Insets(40));

    // button for right container
    Button dealHand = new Button("Deal Hand");
    Button checkButton = new Button("Check Hand");

    //get the buttons
    rightContainer.getChildren().addAll(dealHand, checkButton);

    //set the function for the buttons
    dealHand.setOnAction(event ->
        controller.dealHand()
        );

    return rightContainer;
  }

  public FlowPane centerContainer() {
    FlowPane centerContainer = new FlowPane();

    //organising the center container
    centerContainer.setStyle("-fx-background-color: green");

    //display the cards on the hand
    this.hand = new Label("hand");
    centerContainer.getChildren().add(hand);

    //center the hand
    centerContainer.setAlignment(Pos.CENTER);



    return centerContainer;
  }

  public void setHand(String hand) {
    this.hand.setText(hand);
  }

  public static void appMain(String[] args) {
    launch(args);
  }

}
