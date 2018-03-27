package main.t03;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Created by Ekaterina Semenova on 23.03.2018.
 */
public class App {
    private static final String FILE_INPUT_NAME = "src\\main\\file\\utf8.txt";
    private static final String FILE_OUTPUT_NAME = "src\\main\\file\\utf16.txt";
    private static final File INPUT_FILE = new File(FILE_INPUT_NAME);
    private static final File OUTPUT_FILE = new File(FILE_OUTPUT_NAME);


    private static StringBuilder stringBuilder = new StringBuilder();


    public static void main(String[] args) {
        if (!OUTPUT_FILE.exists()) {
            try {
                new File(FILE_OUTPUT_NAME).createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        if (OUTPUT_FILE.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_INPUT_NAME),
                    StandardCharsets.UTF_8))) {
                int val;
                while ((val = bufferedReader.read()) != -1) {
                    stringBuilder.append((char) val);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(FILE_OUTPUT_NAME), StandardCharsets.UTF_16))) {
                bufferedWriter.write(stringBuilder.toString());
            } catch (IOException exception) {
                exception.printStackTrace();

            }
        }
    }
}

