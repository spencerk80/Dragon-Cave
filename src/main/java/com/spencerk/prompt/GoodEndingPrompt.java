package com.spencerk.prompt;

import com.spencerk.inventory.PlayerInventory;

import java.util.Random;

public class GoodEndingPrompt implements Prompt {

    private static String[] items = {"10 gold coins", "golden goblet", "silver sword", "ruby amulet"};
    private static final Random random = new Random();

    @Override
    public Prompt run() {

        String item = items[random.nextInt(items.length)];

        System.out.print("You enter the cave and the dragon lift his head and looks at you. ");
        System.out.printf("\"Ah. A visitor. Nice to meet you. Please take %s as a token ", item);
        System.out.println("of our new friendship\"");

        PlayerInventory.inventory.addItem(item);

        return PromptFactory.getPlayAgainPrompt();

    }

}
