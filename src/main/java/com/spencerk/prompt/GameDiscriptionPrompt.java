package com.spencerk.prompt;

public class GameDiscriptionPrompt implements Prompt{
    @Override
    public Prompt run() {
        System.out.print("You are in a land full of dragons. In front of you are two caves. ");
        System.out.print("In one cave is a friendly dragon who will share part of his hoard with you. ");
        System.out.println("In the other cave, the dragon is not friendly and will eat you!");
        return PromptFactory.getPickCavePrompt();
    }
}
