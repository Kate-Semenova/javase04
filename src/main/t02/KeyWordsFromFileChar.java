package main.t02;

import main.KeyWordsSet;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Ekaterina Semenova on 23.03.2018.
 */
public class KeyWordsFromFileChar {
    private File inPutFile;
    private File outPutFile;
    private Map<String, Integer> map = new HashMap<>();

    public KeyWordsFromFileChar(File inPutFile){
        this.inPutFile = inPutFile;
        outPutFile = new File(inPutFile.getParent() + "\\outPut");
        if (outPutFile.exists()) {
            try (BufferedWriter outputWriter = new BufferedWriter(new FileWriter(outPutFile))) {
                outputWriter.write("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                if (outPutFile.createNewFile()) {
                    System.out.println("success");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        try {
            initializeMap();
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }
    private void initializeMap()throws IOException{
        try (Reader reader = new BufferedReader(new FileReader(inPutFile))) {
            int val;
            StringBuilder word = new StringBuilder();
            while ((val = reader.read()) != -1) {
                char character = (char) val;
                if (!Character.isAlphabetic(character)) {
                    String stringWord = word.toString();
                    if (KeyWordsSet.contains(stringWord)) {
                        if (map.containsKey(stringWord)) {
                            map.put(word.toString(), map.get(stringWord) + 1);
                        } else {
                            map.put(stringWord, 1);
                        }
                    }

                    word = new StringBuilder();
                    word.append("");
                    continue;
                }
                word.append(character);
            }
        }}
    public Map<String, Integer> getKeyWords() {
        return map;
    }

    public void putWordsInFile(){
        StringBuilder stringBuilder = new StringBuilder();


        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            stringBuilder.append("Key word \"")
                    .append(entry.getKey())
                    .append("\"")
                    .append(" shown up ")
                    .append(entry.getValue())
                    .append(" time");
            if (entry.getValue() != 1) {
                stringBuilder.append("s");
            }

            stringBuilder.append("\n");
        }
        try (Writer writer = new BufferedWriter(new FileWriter(outPutFile))) {
            writer.write(stringBuilder.toString());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    public static void main(String[] args) {
        KeyWordsFromFileChar keyWordsFromFileChar = new KeyWordsFromFileChar(new File("src\\main\\resources\\javaCode"));
        System.out.println(keyWordsFromFileChar.getKeyWords());
        keyWordsFromFileChar.putWordsInFile();
    }
}
