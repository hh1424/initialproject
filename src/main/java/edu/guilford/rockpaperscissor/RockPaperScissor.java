
package edu.guilford.rockpaperscissor;

import java.util.Random;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class RockPaperScissor extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        VBox gameBox = new VBox();
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        RPS RockPaperScissor = new RPS();
        RockPaperScissorPane root = new RockPaperScissorPane(RockPaperScissor);
        Button btn = new Button();
        
//        String playerTwo;
//        System.out.print("Enter name here: ");
//        playerTwo = scan.nextLine();
//        Text playerText = new Text(0, 0, playerTwo);
//        Font playerFont = new Font("Arial", 20);
//        playerText.setFont(playerFont);

        
        Scene scene = new Scene(root, 1200, 635);
        
        primaryStage.setTitle("Rock Paper Scissor Shoot!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
