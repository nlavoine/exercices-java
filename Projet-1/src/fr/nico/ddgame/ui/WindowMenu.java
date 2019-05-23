package fr.nico.ddgame.ui;

public class WindowMenu extends UiBox {
    private static final String TITLE = "[  MENU  ]";

    public String header(){
        String header = generateUpperLine("medium")+"\n";
        header += generateContentLine("medium", WindowMenu.TITLE, false) + "\n";
        header += generateFilledLine("slim");
        return header;
    }

    public String option(int iter, String label){
        String option = "["+ iter +"] " + label;
        option = generateContentLine("medium", option, true);
        return option;
    }

    public String footer(){
        String footer = generateLowerLine("medium")+"\n";
        footer += "\n";
        return footer;
    }
}
