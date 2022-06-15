package com.spencerk.prompt;

import com.spencerk.inventory.PlayerInventory;

import java.util.Random;
import java.util.Scanner;

public class PickCavePrompt implements Prompt{

    private Random random;

    public PickCavePrompt() {
        this.random = new Random();
    }

    @Override
    public Prompt run() {

        Scanner scanner = new Scanner(System.in);
        int playerChoice = -1;

        //Print prompt

        System.out.println("Pick wisely... Enter 1 or 2 to pick a cave. Enter 3 to see your items.");

        //Get player choice and return next prompt based on that choice
        while(true) {
            String input;

            try {
                input = scanner.next();
                playerChoice = Integer.parseInt(input);
            } catch(Exception e) {}

            if(playerChoice < 1 || playerChoice > 3) {
                System.err.println("Invalid choice. Please enter 1, 2 or 3");
            } else if(playerChoice == 3) {
                PlayerInventory.inventory.printInventory();
            } else {
                //Adjusted odds to 1/4 being a bad ending
                final int OODS = 4;
                Prompt  p1 = random.nextInt(OODS) > 0 ?
                                PromptFactory.getGoodEndingPrompt() : PromptFactory.getBadEndingPrompt(),
                        p2 = random.nextInt(OODS) > 0 ?
                                PromptFactory.getGoodEndingPrompt() : PromptFactory.getBadEndingPrompt();

                //P1 and P2 are both random and can both either be good or bad endings
                switch(playerChoice) {
                    case 1: return p1;
                    case 2: return p2;

                }
            }

        }

    }

}
