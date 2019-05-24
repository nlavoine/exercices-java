package fr.nico.ddgame.ui;

public class WindowFighterSelectEdit extends UiBox {

    private static final String TITLE = "Quel combattant souhaitez-vous éditer ?";

    public String header(){
        String header = generateUpperLine("medium")+"\n";
        header += generateContentLine("medium", WindowFighterSelectEdit.TITLE, false) + "\n";
        header += generateFilledLine("slim");
        return header;
    }
    public String options(int iter, String label){
        String option = "[" + iter + "] " + label;
        option = generateContentLine("medium", option, true);
        return option;
    }
    public String footer(){
        String footer = generateLowerLine("medium")+"\n";
        footer += "\n";
        return footer;
    }


}
