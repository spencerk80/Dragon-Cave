package com.spencerk.prompt;

import com.spencerk.inventory.PlayerInventory;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PickCavePromptTest {

    InputStream  OG_IN;
    OutputStream OG_OUT;
    OutputStream OG_ERR;
    ByteArrayOutputStream   TEST_OUT    = new ByteArrayOutputStream(),
                            TEST_ERR    = new ByteArrayOutputStream();

    //Change all input and output streams to test ones for IO testing
    @BeforeAll
    public void setUpTestIO() {
        OG_IN = System.in;
        OG_OUT = System.out;
        OG_ERR = System.err;

        System.setOut(new PrintStream(TEST_OUT));
        System.setErr(new PrintStream(TEST_ERR));
    }

    @BeforeEach
    public void clearStreams() {
        TEST_OUT.reset();
        TEST_ERR.reset();
    }

    //Restore the streams to work on the CLI again
    @AfterAll
    public void restoreIO() {
        System.setIn(OG_IN);
        System.setOut(new PrintStream(OG_OUT));
        System.setErr(new PrintStream(OG_ERR));
    }

    @Test
    public void badInputCaveChoice() {
        //Run the prompt. It'll ask for 1, 2, or 3. Put in a word to give bad input
        //Two inputs given, one bad, one good so that the prompt will complete and return
        System.setIn(new ByteArrayInputStream("test\n1".getBytes()));
        PromptFactory.getPickCavePrompt().run();

        //Expect error
        assertEquals("Invalid choice. Please enter 1, 2 or 3\n", TEST_ERR.toString());
    }

    @Test
    public void printInvInputEmpty() {

        //Make sure inventory is clear
        PlayerInventory.inventory.clearInventory();

        //Test empty inventory print. 3 for the print, 1 to move the prompt along and return
        System.setIn(new ByteArrayInputStream("3\n1".getBytes()));
        PromptFactory.getPickCavePrompt().run();

        assertEquals("Your inventory is empty", TEST_OUT.toString().split("\n")[1]);

    }

    @Test
    public void printInvInputSingleItem() {

        //Make sure inventory has one item
        PlayerInventory.inventory.clearInventory();
        PlayerInventory.inventory.addItem("10 Gold Pieces");

        //Test empty inventory print. 3 for the print, 1 to move the prompt along and return
        System.setIn(new ByteArrayInputStream("3\n1".getBytes()));
        PromptFactory.getPickCavePrompt().run();

        //Line 3 on output because the above addItem prints something and the Prompt prints its prompt
        assertEquals("In your inventory, you have: [10 Gold Pieces]",
                        TEST_OUT.toString().split("\n")[2]);

    }

    @Test
    public void pickCave1() {
        Prompt returnedPrompt;

        System.setIn(new ByteArrayInputStream("1".getBytes()));
        returnedPrompt = PromptFactory.getPickCavePrompt().run();

        assertTrue(returnedPrompt.getClass() == PromptFactory.getGoodEndingPrompt().getClass() ||
                    returnedPrompt.getClass() == PromptFactory.getBadEndingPrompt().getClass());
    }

    @Test
    public void pickCave2() {
        Prompt returnedPrompt;

        System.setIn(new ByteArrayInputStream("2".getBytes()));
        returnedPrompt = PromptFactory.getPickCavePrompt().run();

        assertTrue(returnedPrompt.getClass() == PromptFactory.getGoodEndingPrompt().getClass() ||
                returnedPrompt.getClass() == PromptFactory.getBadEndingPrompt().getClass());
    }

}
