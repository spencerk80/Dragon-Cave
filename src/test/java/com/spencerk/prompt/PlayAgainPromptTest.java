package com.spencerk.prompt;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlayAgainPromptTest {

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
    public void badInput() {
        //Enter bad input word, then next line good input to return from the prompt
        System.setIn(new ByteArrayInputStream("Fox\nno".getBytes()));
        PromptFactory.getPlayAgainPrompt().run();

        System.setOut(new PrintStream(OG_OUT));
        System.out.println(TEST_ERR.toString());

        assertEquals("Invalid input. Please enter yes or no. Would you like to play again?\n",
                        TEST_ERR.toString());

    }

    @Test
    public void noInput() {
        System.setIn(new ByteArrayInputStream("nO".getBytes()));
        Prompt returnedPrompt = PromptFactory.getPlayAgainPrompt().run();

        assertTrue(returnedPrompt == null);
    }

    @Test
    public void yesInput() {
        System.setIn(new ByteArrayInputStream("yEs".getBytes()));
        Prompt returnedPrompt = PromptFactory.getPlayAgainPrompt().run();

        assertTrue(returnedPrompt.getClass() == PromptFactory.getPickCavePrompt().getClass());
    }

}
