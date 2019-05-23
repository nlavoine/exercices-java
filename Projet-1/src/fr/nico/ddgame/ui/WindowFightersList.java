package fr.nico.ddgame.ui;

public class WindowFightersList extends UiBox {

    private static final String TITLE = "Liste des joueurs";

    public String emptyLine(){
        String line = generateEmptyLine("medium");
        return line;
    }
    public String filledLine(){
        String line = generateFilledLine("dotted");
        return line;
    }

    public String header(){
        String header = generateUpperLine("medium")+"\n";
        header += generateContentLine("medium", WindowFightersList.TITLE, false) + "\n";
        header += generateFilledLine("slim");
        return header;
    }

    public String options(String label, String value){
        String option = label + " : " + value;
        option = generateContentLine("medium", option, true);
        return option;
    }
    public String footer(){
        String footer = generateLowerLine("medium")+"\n";
        footer += "\n";
        return footer;
    }

}
