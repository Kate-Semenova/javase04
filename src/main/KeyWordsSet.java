package main;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Ekaterina Semenova on 17.03.2018.
 */
public class KeyWordsSet {
    private static final Set<String> keyWordsSet = new HashSet<>();
    private static final String keywordsFile = "src\\main\\resources\\keywords.txt";

    static {
        try {
            Scanner scanner = new Scanner(new File(keywordsFile));
            while (scanner.hasNext()) {
                keyWordsSet.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Set<String> getKeyWordsSet() {
        return keyWordsSet;
    }

    public static boolean contains(String word) {
        return keyWordsSet.contains(word);
    }

}
