
package edu.guilford.rockpaperscissor;

import java.util.Random;
import java.util.Scanner;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class RPS {
    private String playerName;
    private String playerTwo;
    private String computerChoice;
    private String userChoice;
    private String winnerChoice;
    
    
    public String playerName() {
        Scanner scan = new Scanner(System.in);
        String playerTwo;
        System.out.print("Enter name here: ");
        playerTwo = scan.nextLine();
        Text playerText = new Text(0, 0, playerTwo);
        Font playerFont = new Font("Arial", 20);
        playerText.setFont(playerFont);
        return playerTwo;
    }
    
    public String computerChoice() {
        // Computer's Decision -- *Random Generator*
        Random rand = new Random();
        int wordNumber;
        wordNumber = rand.nextInt(3) + 1;
        String computerChoice = "";
        
        if (wordNumber == 1) {
            computerChoice = "Rock";
        } else if (wordNumber == 2) {
            computerChoice = "Paper";
        } else if (wordNumber == 3) {
            computerChoice = "Scissor";
        }
        return computerChoice;
    }
    
}
