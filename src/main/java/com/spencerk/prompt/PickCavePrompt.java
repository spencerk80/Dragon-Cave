package com.spencerk.prompt;

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
        System.out.print("You are in a land full of dragons. In front of you are two caves. ");
        System.out.print("In one cave is a friendly dragon who will share part of his hoard with you. ");
        System.out.println("In the other cave, the dragon is not friendly and will eat you!");
        System.out.println("Pick wisely... Enter 1 or 2");

        //Get player choice and return next prompt based on that choice
        while(true) {
            String input;

            try {
                input = scanner.next();
                playerChoice = Integer.parseInt(input);
            } catch(Exception e) {}

            if(playerChoice != 1 && playerChoice != 2) {
                System.err.println("Invalid choice. Please enter 1 or 2");
            } else {
                switch(this.random.nextInt(2) + 1) {
                    case 1: return PromptFactory.getGoodEndingPrompt();
                    case 2: return PromptFactory.getBadEndingPrompt();
                }
            }

        }

    }

}
