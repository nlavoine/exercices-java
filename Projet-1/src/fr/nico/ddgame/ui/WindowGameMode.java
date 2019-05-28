package fr.nico.ddgame.ui;

public class WindowGameMode extends UiBox {
    private static final String TITLE = "[  MODE DE JEU  ]";

    public String header(){
        String header = generateUpperLine("medium")+"\n";
        header += generateContentLine("medium", WindowGameMode.TITLE, false) + "\n";
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
