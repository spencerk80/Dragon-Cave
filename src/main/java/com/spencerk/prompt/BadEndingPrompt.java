package com.spencerk.prompt;

public class BadEndingPrompt implements Prompt {

    @Override
    public Prompt run() {
        System.out.print("You enter the cave and the dragon lift his head and looks at you. ");
        System.out.print("Ah! A tasty treat has entered my lair... ");
        System.out.println("The Dragon pounces and gulps you down in one bite!");

        return PromptFactory.getPlayAgainPrompt();
    }

}
