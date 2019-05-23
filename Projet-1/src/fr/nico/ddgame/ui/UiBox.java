package fr.nico.ddgame.ui;

import java.util.HashMap;

public class UiBox {
    private static int windowWidth = 106;

    private static HashMap<String, String> medium;
    private static HashMap<String, String> slim;
    private static HashMap<String, String> dotted;
    private static HashMap<String, String> bold;
    private static HashMap<String, String> doubled;
    private static HashMap<String, HashMap<String, String>> listSymbols;

    public UiBox(){
        medium = new HashMap<>();
        medium.put("topLeft", "┏");
        medium.put("topRight", "┓");
        medium.put("bottomLeft", "┗");
        medium.put("bottomRight", "┛");
        medium.put("middle", "━");
        medium.put("left", "┃");
        medium.put("right", "┃");

        slim = new HashMap<>();
        slim.put("left", "┠");
        slim.put("right", "┨");
        slim.put("middle", "─");

        dotted = new HashMap<>();
        dotted.put("left", "┠");
        dotted.put("right", "┨");
        dotted.put("middle", "┈");

        bold = new HashMap<>();
        bold.put("topLeft", "▛");
        bold.put("topRight", "▜");
        bold.put("bottomLeft", "▙");
        bold.put("bottomRight", "▟");
        bold.put("middle", "▀");
        bold.put("left", "▌");
        bold.put("right", "▌");

        doubled = new HashMap<>();
        doubled.put("topLeft", "╔");
        doubled.put("topRight", "╗");
        doubled.put("bottomLeft", "╚");
        doubled.put("bottomRight", "╝");
        doubled.put("middle", "═");
        doubled.put("side", "║");
        doubled.put("right", "║");

        listSymbols = new HashMap<>();
        listSymbols.put("medium", medium);
        listSymbols.put("slim", slim);
        listSymbols.put("dotted", dotted);
        listSymbols.put("bold", bold);
        listSymbols.put("doubled", doubled);
    }

    protected String generateUpperLine(String type){
        String line = "";
        line += listSymbols.get(type).get("topLeft");
        line += generateLine(listSymbols.get(type).get("middle"));
        line += listSymbols.get(type).get("topRight");
        return line;
    }

    protected String generateLowerLine(String type){
        String line = "";
        line += listSymbols.get(type).get("bottomLeft");
        line += generateLine(listSymbols.get(type).get("middle"));
        line += listSymbols.get(type).get("bottomRight");
        return line;
    }

    protected String generateFilledLine(String type){
        String line = "";
        line += listSymbols.get(type).get("left");
        line += generateLine(listSymbols.get(type).get("middle"));
        line += listSymbols.get(type).get("right");
        return line;
    }

    protected String generateEmptyLine(String type){
        String line = "";
        line += listSymbols.get(type).get("left");
        line += generateLine(" ");
        line += listSymbols.get(type).get("right");
        return line;
    }

    protected String generateContentLine(String type, String data, Boolean aligned){
        double spaceToGenerate = windowWidth - data.length()-2;
        double halfSpace = spaceToGenerate/2;

        int spaceLeft;
        int spaceRight;
        if(aligned){
            spaceLeft = (int)Math.floor(windowWidth/2.5);
            //spaceLeft = (int) (Math.floor((halfSpace/10))*10);
            spaceRight = (int)spaceToGenerate - spaceLeft;
        }else {
            if (halfSpace == Math.floor(halfSpace)) {
                spaceLeft = (int) halfSpace;
                spaceRight = (int) halfSpace;
            } else {
                spaceLeft = (int) Math.floor(halfSpace);
                spaceRight = (int) Math.ceil(halfSpace);
            }
        }

        StringBuilder filledLine = new StringBuilder();
        filledLine.append(listSymbols.get(type).get("left"));

        for(int i =0; i < spaceLeft; i++){
            filledLine.append(" ");
        }
        filledLine.append(data);
        for(int i =0; i < spaceRight; i++){
            filledLine.append(" ");
        }
        filledLine.append(listSymbols.get(type).get("right"));

        return filledLine.toString();
    }

    protected String generateLine(String symbol){
        StringBuilder filledLine = new StringBuilder();
        for(int i =1; i < (windowWidth - 1); i++){
            filledLine.append(symbol);
        }
        return filledLine.toString();
    }


}
