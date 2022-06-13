package com.spencerk.prompt;

import java.util.Locale;
import java.util.Scanner;

public class PlayAgainPrompt implements Prompt {

    @Override
    public Prompt run() {
        Scanner scanner = new Scanner(System.in);
        String input;


        System.out.println("Would you like to play again? (yes/no)");

        while(true) {
            input = scanner.next();
            if(input.toLowerCase().equals("yes")) return PromptFactory.getPickCavePrompt();
            if(input.toLowerCase().equals("no")) return null;
            else System.err.println("Invalid input. Please enter yes or no. Would you like to play again?");
        }

    }

}
