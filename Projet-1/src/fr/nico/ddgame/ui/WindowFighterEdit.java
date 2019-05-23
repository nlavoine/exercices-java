package fr.nico.ddgame.ui;

public class WindowFighterEdit extends UiBox {

    private static final String TITLE = "Edition de";
    private static final String NAME_MESSAGE = "Le combattant s'appel";
    private static final String NAME_QUESTION = "*** Quel est son nouveau nom ?";
    private static final String LIFE_QUESTION = "*** Combien de points de vie voulez-vous lui affecter ?";
    private static final String POWER_QUESTION = "*** Combien de points de puissance voulez-vous lui affecter ?";
    private static final String STUFF_QUESTION = "*** Quelle arme voulez-vous lui équiper ?";
    private static final String SUCCESS = "Succès lors de la mise à jour de ";

    public String filledLine() {
        String line = generateFilledLine("dotted");
        return line;
    }

    public String contentLine(String data){
        String line = generateUpperLine("medium")+"\n";
        line += generateContentLine("medium", data, false) + "\n";
        return line;
    }

    public String header(String name){
        String message = WindowFighterEdit.TITLE + " " + name;
        String header = generateUpperLine("medium")+"\n";
        header += generateContentLine("medium", message, false) + "\n";
        header += generateFilledLine("slim");
        return header;
    }

    public String askFighterName(String name){
        String message = WindowFighterEdit.NAME_MESSAGE + " " + name;
        String question = WindowFighterEdit.NAME_QUESTION;
        String content = generateContentLine("medium", message, false) + "\n";
        content += generateContentLine("medium", question, false) + "\n";
        content += generateEmptyLine("medium");
        return content;
    }

    public String askFighterLife(String name, int life){
        String message = name + " a " + life + " points de vie";
        String question = WindowFighterEdit.LIFE_QUESTION;
        String content = generateContentLine("medium", message, false) + "\n";
        content += generateContentLine("medium", question, false) + "\n";
        content += generateEmptyLine("medium");
        return content;
    }

    public String askFighterPower(String name, int power){
        String message = name + " a " + power + " points de puissance";
        String question = WindowFighterEdit.POWER_QUESTION;
        String content = generateContentLine("medium", message, false) + "\n";
        content += generateContentLine("medium", question, false) + "\n";
        content += generateEmptyLine("medium") + "\n";
        content += generateFilledLine("dotted") + "\n";

        return content;
    }

    public String askFighterStuff(String name, String stuff){
        String message = name + " est équipé de " + stuff + " en attaque";
        String question = WindowFighterEdit.STUFF_QUESTION;
        String content = generateContentLine("medium", message, false) + "\n";
        content += generateContentLine("medium", question, false) + "\n";
        content += generateEmptyLine("medium") + "\n";

        return content;
    }

    public String stuffOption(int iter, String label, int power){
        String option = "[" + iter + "] " + label + "([" + power + "])";
        option = generateContentLine("medium", option, true);
        return option;
    }

    public String footer(String name){
        String message = "*** " + WindowFighterEdit.SUCCESS + " " + name + "  ***";
        String footer = generateContentLine("medium", message, false) + "\n";
        footer += generateLowerLine("medium")+"\n";
        footer += "\n";
        return footer;
    }


}
