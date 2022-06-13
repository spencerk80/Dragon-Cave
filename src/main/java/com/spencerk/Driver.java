package com.spencerk;

import com.spencerk.prompt.Prompt;
import com.spencerk.prompt.PromptFactory;

public class Driver {

    public static void main(String[] args) {

        Prompt  prompt = PromptFactory.getPickCavePrompt();

        while(prompt != null) prompt = prompt.run();

    }

}
