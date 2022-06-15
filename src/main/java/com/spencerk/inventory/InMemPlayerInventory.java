package com.spencerk.inventory;

import java.util.ArrayList;
import java.util.List;

public class InMemPlayerInventory implements PlayerInventory{

    private final List<String> inventory;
    private static PlayerInventory currentInventory;

    private InMemPlayerInventory() {
        this.inventory = new ArrayList<>();
    }

    public static PlayerInventory getInstance() {
        if(currentInventory == null) currentInventory = new InMemPlayerInventory();
        return currentInventory;
    }

    @Override
    public void addItem(String item) {
        this.inventory.add(item);
        System.out.println(String.format("You added %s to your inventory", item));
    }

    @Override
    public void printInventory() {
        if(inventory.size() > 0) {
            System.out.print("In your inventory, you have:");
            inventory.stream()
                    .forEach(
                            item -> System.out.print(String.format(" [%s]", item))
                    );
            System.out.println();
        } else {
            System.out.println("Your inventory is empty");
        }
    }

    @Override
    public void clearInventory() {
        this.inventory.clear();
    }
}
