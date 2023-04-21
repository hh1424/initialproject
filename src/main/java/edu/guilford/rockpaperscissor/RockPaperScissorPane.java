package edu.guilford.rockpaperscissor;

import java.util.Random;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class RockPaperScissorPane extends Pane {
    private RPS RockPaperScissors;
    private int roundIndex;
    private Font labelFont;
    private Label sentenceLabel;
    private Rectangle[] rec;
    private int nWon;
    private int nLost;
    private int nTied;
    private Alert alert;
//    private ButtonType buttonCancel;
//    private ButtonType buttonNew;
    private Label compLabel;
    private Label computerLabel;
    private RadioButton rockButton;
    private Label rockLabel;
    private RadioButton paperButton;
    private Label paperLabel;
    private RadioButton scissorsButton;
    private Label scissorsLabel;
    private Label resultLabel;
    private String computerChoice;
    private Button resetButton;
    private ToggleGroup toggleGroup;
    private Button newButton;

    public RockPaperScissorPane(RPS RockPaperScissors) {
        this.RockPaperScissors = RockPaperScissors;
        roundIndex = 0;
        nWon = 0;
        nLost = 0;
        nTied = 0;
        rec = new Rectangle[11];
        rec[0] = new Rectangle(30, 5, 100, 125);
        rec[1] = new Rectangle(133, 5, 100, 125);
        rec[2] = new Rectangle(236, 5, 100, 125);
        rec[3] = new Rectangle(339, 5, 100, 125);
        rec[4] = new Rectangle(442, 5, 100, 125);
        rec[5] = new Rectangle(545, 5, 100, 125);
        rec[6] = new Rectangle(648, 5, 100, 125);
        rec[7] = new Rectangle(751, 5, 100, 125);
        rec[8] = new Rectangle(854, 5, 100, 125);
        rec[9] = new Rectangle(957, 5, 100, 125);
        rec[10] = new Rectangle(1060, 5, 100, 125);
        for (Rectangle theRec : rec) {
            theRec.setStroke(Color.BLACK);
            theRec.setStrokeWidth(2);
            theRec.setVisible(false);
        }
        computerLabel = new Label("Computer has made its choice!");
        computerLabel.setTranslateX(450);
        computerLabel.setTranslateY(260);
        computerLabel.setFont(Font.font("MS Reference Sans Serif", 20));
        sentenceLabel = new Label("Choose between Rock, Paper, or Scissors");
        sentenceLabel.setTranslateX(450);
        sentenceLabel.setTranslateY(300);
        labelFont = Font.font("MS Reference Sans Serif", FontWeight.BOLD, 15);
        sentenceLabel.setFont(labelFont);
        Image rock = new Image("file:rock.png");
        ImageView viewR = new ImageView(rock);
        Image paper = new Image("file:paper.png");
        ImageView viewP = new ImageView(paper);
        Image scissors = new Image("file:scissors.png");
        ImageView viewS = new ImageView(scissors);
        toggleGroup = new ToggleGroup();
        rockButton = new RadioButton("");
        paperButton = new RadioButton("");
        scissorsButton = new RadioButton("");
        rockButton.setToggleGroup(toggleGroup);
        paperButton.setToggleGroup(toggleGroup);
        scissorsButton.setToggleGroup(toggleGroup);
        rockButton.setGraphic(viewR);
        paperButton.setGraphic(viewP);
        scissorsButton.setGraphic(viewS);
        viewR.setFitHeight(80);
        viewP.setFitHeight(80);
        viewS.setFitHeight(80);
        viewR.setPreserveRatio(true);
        viewP.setPreserveRatio(true);
        viewS.setPreserveRatio(true);
        rockButton.setPrefSize(80, 80);
        paperButton.setPrefSize(80, 80);
        scissorsButton.setPrefSize(80, 80);
        rockButton.setTranslateX(150);
        rockButton.setTranslateY(365);
        paperButton.setTranslateX(550);
        paperButton.setTranslateY(365);
        scissorsButton.setTranslateX(950);
        scissorsButton.setTranslateY(365);
        resetButton = new Button("Press for New Round!");
        resetButton.setTranslateX(543);
        resetButton.setTranslateY(575);
        rockButton.setOnAction(this::processButtonPress);
        paperButton.setOnAction(this::processButtonPress);
        scissorsButton.setOnAction(this::processButtonPress);
        resetButton.setOnAction(this::processNewRound);
        resultLabel = new Label("");
        resultLabel.setTranslateX(565);
        resultLabel.setTranslateY(500);
        resultLabel.setFont(Font.font("MS Reference Sans Serif", 20));
        getChildren().addAll(computerLabel, sentenceLabel, rockButton, paperButton, scissorsButton, resultLabel,
                resetButton, rec[0], rec[1], rec[2], rec[3], rec[4], rec[5], rec[6], rec[7], rec[8], rec[9], rec[10]);
    }

    public String computerChoice() {
        // Computer's Decision -- *Random Generator*
//        if (rockButton.isPressed() || paperButton.isPressed() || scissorsButton.isPressed()) {
        Random rand = new Random();
        int wordNumber;
        wordNumber = rand.nextInt(3) + 1;
        String computerChoice = "";

        if (wordNumber == 1) {
            computerChoice = new String("Rock");
        } else if (wordNumber == 2) {
            computerChoice = new String("Paper");
        } else if (wordNumber == 3) {
            computerChoice = new String("Scissor");
        }
//        }
        return computerChoice;
    }

    public void processButtonPress(ActionEvent event) {
//        if (event.getSource() == rockButton) {
//            rockLabel = new Label("Rock");
//            getChildren().add(rockLabel);
//        }
//        if (event.getSource() == paperButton) {
//            paperLabel = new Label("Paper");
//        }
//        if (event.getSource() == scissorsButton) {
//            scissorsLabel = new Label("Scissors");
//        }
        rockButton.setDisable(true);
        paperButton.setDisable(true);
        scissorsButton.setDisable(true);
        resultLabel();
        ScoreColor();
        gameDecision();
        // put conditional here
        roundIndex = roundIndex + 1;
    }

    public void processNewRound(ActionEvent event) {
        rockButton.setSelected(false);
        paperButton.setSelected(false);
        scissorsButton.setSelected(false);
        rockButton.setDisable(false);
        paperButton.setDisable(false);
        scissorsButton.setDisable(false);
        resultLabel.setVisible(false);
    }

    public void resultLabel() {
        computerChoice = computerChoice();
        System.out.println("Computer Choice: " + computerChoice);
        resultLabel.setVisible(true);
//        System.out.println(toggleGroup.getSelectedToggle());
        if (toggleGroup.getSelectedToggle() == rockButton && computerChoice.equals("Rock")) {
            resultLabel.setText("You Tied");
            nTied = nTied + 1;
        }
        if (toggleGroup.getSelectedToggle() == rockButton && computerChoice.equals("Paper")) {
            resultLabel.setText("You Lost");
            nLost = nLost + 1;
        }
        if (toggleGroup.getSelectedToggle() == rockButton && computerChoice.equals("Scissor")) {
            resultLabel.setText("You Won");
            nWon = nWon + 1;
        }
        if (toggleGroup.getSelectedToggle() == paperButton && computerChoice.equals("Paper")) {
            resultLabel.setText("You Tied");
            nTied = nTied + 1;
        }
        if (toggleGroup.getSelectedToggle() == paperButton && computerChoice.equals("Scissor")) {
            resultLabel.setText("You Lost");
            nLost = nLost + 1;
        }
        if (toggleGroup.getSelectedToggle() == paperButton && computerChoice.equals("Rock")) {
            resultLabel.setText("You Won");
            nWon = nWon + 1;
        }
        if (toggleGroup.getSelectedToggle() == scissorsButton && computerChoice.equals("Scissor")) {
            resultLabel.setText("You Tied");
            nTied = nTied + 1;
        }
        if (toggleGroup.getSelectedToggle() == scissorsButton && computerChoice.equals("Rock")) {
            resultLabel.setText("You Lost");
            nLost = nLost + 1;
        }
        if (toggleGroup.getSelectedToggle() == scissorsButton && computerChoice.equals("Paper")) {
            resultLabel.setText("You Won");
            nWon = nWon + 1;
        }
        for (Rectangle theRec : rec) {
            theRec.setVisible(true);
        }
    }

    public void ScoreColor() {
        String result = resultLabel.getText();
        if (result.equals("You Won")) {
            rec[roundIndex].setFill(Color.GREENYELLOW);
        } else if (result.equals("You Lost")) {
            rec[roundIndex].setFill(Color.RED);
        } else if (result.equals("You Tied")) {
            rec[roundIndex].setFill(null);
        }
    }
    
    public void processNewGame(ActionEvent event) {
        rockButton.setSelected(false);
        paperButton.setSelected(false);
        scissorsButton.setSelected(false);
        rockButton.setDisable(false);
        paperButton.setDisable(false);
        scissorsButton.setDisable(false);
        resultLabel.setVisible(false);
        for (Rectangle theRec : rec) {
            theRec.setVisible(true);
            theRec.setFill(null);
        }
    }
    
    public void gameDecision() {
        if (nWon == 3) {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("GAME DECISION");
            alert.setHeaderText("Congratulations! You Won!");
            alert.setContentText("Choose your option:");
            newButton = new Button("New Game");
//            newButton.setOnAction(this::processNewGame);
//            getChildren().addAll(newButton);
            alert.showAndWait();
        } else if (nLost == 3) {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("GAME DECISION");
            alert.setHeaderText("Oh No! You Lost!");
            alert.setContentText("Choose your option:");
            newButton = new Button("New Game");
//            newButton.setOnAction(this::processNewGame);
//            getChildren().addAll(newButton);
            alert.showAndWait();
        }
    }
}
