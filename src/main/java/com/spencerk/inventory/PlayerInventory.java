package com.spencerk.inventory;

public interface PlayerInventory {

    static PlayerInventory inventory = InMemPlayerInventory.getInstance();

    void addItem(String item);
    void printInventory();
    void clearInventory();

}
