package fr.nico.ddgame.ui;

public class WindowInitOpponent extends UiBox{
    private static final String TITLE = "Nombre d'adversaire ?";
    private static final String SUCCESS = "Succès lors de la création de ";

    public String header(){
        String header = generateUpperLine("medium")+"\n";
        header += generateContentLine("medium", WindowInitOpponent.TITLE, false) + "\n";
        header += generateFilledLine("slim");
        return header;
    }

    public String footer(int nbOpponents){
        String message = "*** " + WindowInitOpponent.SUCCESS + " " + nbOpponents + " adversaires ***";
        String footer = generateContentLine("medium", message, false) + "\n";
        footer += generateLowerLine("medium")+"\n";
        footer += "\n";
        return footer;
    }
}
