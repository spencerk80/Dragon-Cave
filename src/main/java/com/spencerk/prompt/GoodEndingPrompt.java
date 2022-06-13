package com.spencerk.prompt;

public class GoodEndingPrompt implements Prompt{

    @Override
    public Prompt run() {

        System.out.print("You enter the cave and the dragon lift his head and looks at you. ");
        System.out.print("\"Ah. A visitor. Nice to meet you, please take a piece of treasure as a token");
        System.out.println("of our new friend ship\"");

        return PromptFactory.getPlayAgainPrompt();

    }

}
