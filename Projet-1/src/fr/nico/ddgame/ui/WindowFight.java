package fr.nico.ddgame.ui;

public class WindowFight extends UiBox {

    private static final String TITLE = "DEBUT DU COMBAT";
    private static final String DISPLAY_ROUND = "Round";
    private static final String OPPONENT_QUESTION = "**** Choissez un adversaire ****";
    private static final String PRESS_ENTER = "**** (Appuyer sur entrer pour continuer) ****";
    private static final String ATTACK_RAW = "a paré le coup. Echec de l'attaque";

    public String emptyLine(){
        String line = generateEmptyLine("bold");
        return line;
    }
    public String header(){
        String message = WindowFight.TITLE;
        String header = generateUpperLine("bold")+"\n";
        header += generateContentLine("bold", message, false) + "\n";
        header += generateFilledLine("dottedBold");
        return header;
    }
    public String displayRound(int round){
        String line = generateContentLine("bold", "[[" + WindowFight.DISPLAY_ROUND + " : " + round + " ]]", false) + "\n";
        line += generateEmptyLine("bold");
        return line;
    }
    public String playerTurn(String name){
        String line = generateContentLine("bold", "==[ A " + name + " de jouer ! ]==", false);
        return line;
    }
    public String opponentQuestion(){
        String line = generateContentLine("bold", WindowFight.OPPONENT_QUESTION, false) + "\n";
        line += generateEmptyLine("bold");
        return line;
    }

    public String opponentOption(int iter, String name, String type, int life, int power, int secondaryPower){
        String option1 = "[" + iter + "] " + name + " (" + type+ ")";
        String option2 = "[ Vie : " + life + " ] [  Puissance : " + power + " ] [ Points de défense : " + secondaryPower + " ]";
        String option = generateContentLine("bold", option1, true) + "\n";
        option += generateContentLine("bold", option2, true) + "\n";
        option += generateEmptyLine("bold");

        return option;
    }
    public String separateFights(){
        String line = generateEmptyLine("bold") + "\n";
        line += generateFilledLine("dottedBold") + "\n";
        line += generateEmptyLine("bold");
        return line;
    }
    public String pressEnter(){
        String line = generateContentLine("bold", WindowFight.PRESS_ENTER, false);
        return line;
    }
    public String opponentAttack(String oppName, String playerName){
        String line = generateContentLine("bold", oppName + " attaque " + playerName, true);
        return line;
    }
    public String footer(){
        String footer = generateLowerLine("bold")+"\n";
        footer += "\n";
        return footer;
    }
    public String finalWindows(String message){
        String window = generateUpperLine("doubled")+"\n";
        window += generateEmptyLine("doubled")+"\n";
        window += generateContentLine("doubled", message, false)+"\n";
        window += generateContentLine("doubled", "- FIN DU COMBAT -", false)+"\n";
        window += generateEmptyLine("doubled") +"\n";
        window += generateLowerLine("doubled") + "\n";
        return window;

    }

    public String showLife(String name, int life){
        String message = name + " => ️ " + life;
        String line = generateContentLine("bold", message, true);
        return line ;
    }

    public String attackStep1(String name, String stuffName, int attackPower){
        String message = name + " attaque avec " + stuffName + ". || Puissance d'attaque : " + attackPower;
        String line = generateContentLine("bold", message, false);
        return line;
    }
    public String attackStep2(String name, String stuffName, int defensePower){
        String message = name + " se défend avec " + stuffName + ". || Puissance de défense: " + defensePower;
        String line = generateContentLine("bold", message, false);
        return line;
    }

    public String attackFailed(String name){
        String message = name + " " + WindowFight.ATTACK_RAW;
        String line = generateContentLine("bold", message, false);
        return line;
    }
    public String attackSuccess(String offenseName, String defenseName){
        String message = offenseName + " a attaqué " + defenseName;
        String line = generateContentLine("bold", message, false);
        return line;
    }
    public String fighterDied(String defenseName){
        String message = defenseName + " a été vaincu.";
        String line = generateContentLine("bold", message, false);
        return line;
    }
    public String fighterRemainingPoints(String defenseName, int damage, int life){
        String message = defenseName + " a perdu " + damage + " points de vie. \u2764 " + life;
        String line = generateContentLine("bold", message, false);
        return line;
    }


}
