package com.spencerk.prompt;

public interface Prompt {

    //All prompts will run and return the next prompt to be run
    Prompt run();

}
