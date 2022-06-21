package com.spencerk.inventory;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InMemPlayerInventoryTest {

    private final PrintStream OG_OUT = System.out;
    private final ByteArrayOutputStream TEST_OUT = new ByteArrayOutputStream();
    private final String TEST_ITEM = "10 Gold Pieces";

    @BeforeAll
    public void setTestStream() {
        //Capture the Sys-out of the print statement from the printInventory call
        System.setOut(new PrintStream(TEST_OUT));
    }

    @AfterAll
    public void restoreOriginalOutStream() {
        //Restore sys-out to original state
        System.setOut(new PrintStream(OG_OUT));
    }

    //Allows that each test can expect the inventory to start out empty.
    //This assumption allows these tests to just execute in any order without messing with each other
    @AfterEach
    public void clearInventory() {
        PlayerInventory.inventory.clearInventory();
    }

    @Test void addItem() {
        PlayerInventory.inventory.addItem(TEST_ITEM);
        assertTrue(PlayerInventory.inventory.size() == 1);
    }

    @Test void removeItem() {
        PlayerInventory.inventory.addItem(TEST_ITEM);
        PlayerInventory.inventory.clearInventory();
        assertTrue(PlayerInventory.inventory.size() == 0);
    }

    @Test void printInventory() {

        String[] output = null;
        String   outputLastLine = "";

        PlayerInventory.inventory.addItem(TEST_ITEM);
        PlayerInventory.inventory.printInventory();

        //Add item prints a line that this test needs to discard
        output = TEST_OUT.toString().split("\n");
        outputLastLine = output[output.length - 1];

        assertEquals(String.format("In your inventory, you have: [%s]", TEST_ITEM), outputLastLine);
    }

}
