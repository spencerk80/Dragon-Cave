package com.spencerk.prompt;

import com.spencerk.inventory.PlayerInventory;

public class BadEndingPrompt implements Prompt {

    @Override
    public Prompt run() {
        System.out.print("You enter the cave and the dragon lift his head and looks at you. ");
        System.out.print("Ah! A tasty treat has entered my lair... ");
        System.out.print("The Dragon pounces and gulps you down in one bite!");
        System.out.println("Your items are added to its hoard of treasure");

        //Clear player inventory for new game
        PlayerInventory.inventory.clearInventory();

        return PromptFactory.getPlayAgainPrompt();
    }

}
