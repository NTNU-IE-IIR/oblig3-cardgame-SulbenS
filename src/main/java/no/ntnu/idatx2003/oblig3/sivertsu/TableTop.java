package no.ntnu.idatx2003.oblig3.sivertsu;

import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableTop extends Application {

  private ButtonController controller;
  private Label hand;
  private Label sum;
  private Label hearts;
  private Label flush;
  private Label queenOfSpades;

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
    stage.setMinWidth(275);
    stage.setMinHeight(300);
    stage.setFullScreen(true);

    //sett the stage
    stage.setScene(new Scene(rootNode, 400, 300));
    stage.setTitle("CardGame");
    stage.show();
  }

  public FlowPane bottomContainer() {
    FlowPane bottomContainer = new FlowPane();

    //organising the bottom container
    bottomContainer.setPadding(new Insets(10));

    //set minimum size for the bottom container
    bottomContainer.setMinHeight(100);
    bottomContainer.setAlignment(Pos.CENTER);
    bottomContainer.setHgap(50);

    //text box and function display for bottom container
    HBox sumIs = sumOfCard();
    HBox heartsIs = cardIsHearts();
    HBox flushIs = cardIsFlush();
    HBox queenOfSpadesIs = queenOfSpades();

    bottomContainer.getChildren().addAll(sumIs, heartsIs, flushIs, queenOfSpadesIs);

    return bottomContainer;
  }

  /**
   * create the sum field for the bottom container
   * @return the sum field
   */
  public HBox sumOfCard () {
    HBox sumOfCard = new HBox();

    sumOfCard.setSpacing(5);

    Label textSum = new Label("sum of faces:");
    sum = new Label("-");

    sumOfCard.getChildren().add(textSum);
    sumOfCard.getChildren().add(sum);

    return sumOfCard;
  }

  /**
   * create the hearts field for the bottom container
   * @return the hearts field
   */
  public HBox cardIsHearts () {
    HBox isHearts = new HBox();

    isHearts.setSpacing(5);

    Label heartsLabel = new Label("cards of hearts:");
    hearts = new Label("-");

    isHearts.getChildren().addAll(heartsLabel, hearts);

    return isHearts;
  }

  /**
   * create the flush field for the bottom container
   * @return flush
   */
  public HBox cardIsFlush() {
    HBox isFlush = new HBox();

    isFlush.setSpacing(5);

    Label flushLabel = new Label("flush:");
    flush = new Label("-");

    isFlush.getChildren().addAll(flushLabel, flush);

    return isFlush;
  }

  /**
   * create the queen of spade field for the bottom container
   * @return true if queen of spade is present
   */
  public HBox queenOfSpades() {
    HBox isQueenOfSpades = new HBox();

    isQueenOfSpades.setSpacing(5);

    Label queenOfSpadesLabel = new Label("Queen of spades:");
    queenOfSpades = new Label("-");

    isQueenOfSpades.getChildren().addAll(queenOfSpadesLabel, queenOfSpades);

    return isQueenOfSpades;
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
    Button exit = new Button("Exit");

    //style the buttons
    dealHand.setStyle("-fx-background-color: #4fa14f");
    checkButton.setStyle("-fx-background-color: #4fa14f");
    exit.setStyle("-fx-background-color: #e74343");



    //get the buttons
    rightContainer.getChildren().addAll(dealHand, checkButton, exit);

    //set the function for the buttons
    dealHand.setOnAction(event ->
        controller.dealHand()
        );
    checkButton.setOnAction(event -> {
      controller.hasFlush();
      controller.sumOfHand();
      controller.numberOfHearts();
      controller.hasQueenOfSpades();
    });
    exit.setOnAction(event -> System.exit(0));


    return rightContainer;
  }

  public FlowPane centerContainer() {
    FlowPane centerContainer = new FlowPane();

    //style the center container
    centerContainer.setStyle("-fx-background-color: #4fa14f");

    //display the cards on the hand
    this.hand = new Label("");
    centerContainer.getChildren().add(hand);

    //center the hand
    centerContainer.setAlignment(Pos.CENTER);

    return centerContainer;
  }

  public void setHand(String hand) {
    this.hand.setText(hand);
  }

  public void setSum(int sum) {
    this.sum.setText(String.valueOf(sum));
  }

  public void setFlush(boolean flush) {
    this.flush.setText(Boolean.toString(flush));
  }

  public void setQueenOfSpades(boolean queenOfSpades) {
    this.queenOfSpades.setText(Boolean.toString(queenOfSpades));
  }

  public void setNumberOfHearts(int numberOfHearts) {
    this.hearts.setText(String.valueOf(numberOfHearts));
  }

  public static void appMain(String[] args) {
    launch(args);
  }

}
