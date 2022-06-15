package com.spencerk.prompt;

public class PromptFactory {

    //Singletons of all the prompts. No need to create objects over and over for these. Just reuse
    private static PickCavePrompt   pickCave;
    private static GoodEndingPrompt goodEndingPrompt;
    private static BadEndingPrompt  badEndingPrompt;
    private static PlayAgainPrompt playAgainPrompt;
    private static GameDiscriptionPrompt gameDiscriptionPrompt;

    public static PickCavePrompt getPickCavePrompt() {
        if(pickCave == null) pickCave = new PickCavePrompt();
        return pickCave;
    }

    public static GoodEndingPrompt getGoodEndingPrompt() {
        if(goodEndingPrompt == null) goodEndingPrompt = new GoodEndingPrompt();
        return goodEndingPrompt;
    }

    public static BadEndingPrompt getBadEndingPrompt() {
        if(badEndingPrompt == null) badEndingPrompt = new BadEndingPrompt();
        return badEndingPrompt;
    }

    public static PlayAgainPrompt getPlayAgainPrompt() {
        if(playAgainPrompt == null) playAgainPrompt = new PlayAgainPrompt();
        return playAgainPrompt;
    }

    public static GameDiscriptionPrompt getGameDiscriptionPrompt() {
        if(gameDiscriptionPrompt == null) gameDiscriptionPrompt = new GameDiscriptionPrompt();
        return gameDiscriptionPrompt;
    }

}