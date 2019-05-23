package fr.nico.ddgame.ui;

import java.util.HashMap;

public class WindowInitPlayer extends UiBox {

    private static final String TITLE = "Nombres de joueurs ? ";
    private static final String QUESTION_NAME = "Renseigner le nom du combattant";
    private static final String QUESTION_TYPE = "Selection du type";
    private static final HashMap<String, String> icons = new HashMap<>();
    private static final String WARRIOR_ICON = "⚒";
    private static final String WIZARD_ICON = "⚚";

    public WindowInitPlayer(){
        icons.put("Warrior", WARRIOR_ICON);
        icons.put("Wizard", WIZARD_ICON);
    }

    public String emptyLine(){
        String line = generateEmptyLine("medium");
        return line;
    }

    public String header(){
        String header = generateUpperLine("medium")+"\n";
        header += generateContentLine("medium", WindowInitPlayer.TITLE, false) + "\n";
        header += generateFilledLine("slim");
        return header;
    }

    public String askPlayerName(int numberP){
        String question = WindowInitPlayer.QUESTION_NAME + " " + numberP;
        String line = generateContentLine("medium", question, false);
        return line;
    }

    public String askPlayerType(){
        String question = WindowInitPlayer.QUESTION_TYPE;
        String line = generateContentLine("medium", question, false);
        return line;
    }
    public String typeOptions(int iter, String label){
        String option = "["+ iter +"] " + WindowInitPlayer.icons.get(label) + " " + label;
        option = generateContentLine("medium", option, true);
        return option;
    }
    public String footer(){
        String footer = generateLowerLine("medium")+"\n";
        footer += "\n";
        return footer;
    }

}
