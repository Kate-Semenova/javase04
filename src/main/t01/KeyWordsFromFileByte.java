package main.t01;

import main.KeyWordsSet;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Ekaterina Semenova on 23.03.2018.
 */
public class KeyWordsFromFileByte {
    private File inPutFile;
    private File outPutFile;
    private Map<String, Integer> map = new TreeMap<>();

    public KeyWordsFromFileByte(File inPutFile) {
        this.inPutFile = inPutFile;
        outPutFile = new File(inPutFile.getParent() + "\\outPut");
        if (outPutFile.exists()) {
            try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outPutFile))) {
                outputStream.write(0);
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeMap() throws IOException {
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(inPutFile))) {
            int val;
            StringBuilder word = new StringBuilder();
            while ((val = inputStream.read()) != -1) {
                char character = (char) val;
                if (!Character.isAlphabetic(character)) {
                    String stringWord = word.toString();
                    if (KeyWordsSet.getKeyWordsSet().contains(stringWord)) {
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
        }
    }

    public Map<String, Integer> getKeyWords() {
        return map;
    }


    public void putWordsInFile() {
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
        int length = stringBuilder.length();
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outPutFile))) {
            char character;

            for (int i = 0; i < length; i++) {
                character = stringBuilder.charAt(i);
                outputStream.write((int) character);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        KeyWordsFromFileByte keyWordsFromFileByte = new KeyWordsFromFileByte(new File("src\\main\\file\\javaCode"));

        System.out.println(keyWordsFromFileByte.getKeyWords());
        keyWordsFromFileByte.putWordsInFile();

    }

}
