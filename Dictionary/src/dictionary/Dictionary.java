package dictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Dictionary {

    public static String findWord(String path, String word) {
        String translation = "Brak słowa w słowniku / No word in dictionary / Kein Wort im Wörterbuch";
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String textLine = null;
        try {
            textLine = bufferedReader.readLine();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        try {
            do {
                if (textLine.length() >= word.length() + 1) {
                    if (textLine.substring(0, word.length() + 1).equals(word + ";")) {
                        translation = textLine.substring(word.length() + 1);
                        return translation;
                    }
                }
                textLine = bufferedReader.readLine();
            } while (textLine != null);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        return translation;
    }

    public static ArrayList<ArrayList<String>> findArrays(String path) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String textLine = null;
        try {
            textLine = bufferedReader.readLine();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        try {
            do {
                list1.add(textLine.substring(0, textLine.indexOf(";")));
                list2.add(textLine.substring(textLine.indexOf(";") + 1));
                textLine = bufferedReader.readLine();
            } while (textLine != null);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                list.add(list1);
                list.add(list2);
                bufferedReader.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        return list;
    }

    public static String polish2English(String polish2EnglishDictionaryPath, String polishExpression) throws FileNotFoundException, IOException {

        String translation = findWord(polish2EnglishDictionaryPath, polishExpression);
        return translation;
    }

    public static String polishToGerman(String polish2EnglishDictionaryPath, String english2GermanDictionaryPath,
            String polishExpression) {

        String translation = findWord(polish2EnglishDictionaryPath, polishExpression);
        String translation2 = findWord(english2GermanDictionaryPath, translation);
        return translation2;
    }

    public static String generateGermanToPolishTranslationFile(String polish2EnglishDictionaryPath,
            String english2GermanDictionaryPath) {

        ArrayList<ArrayList<String>> listPLEN = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> listENGR = new ArrayList<ArrayList<String>>();
        ArrayList<String> listPL = new ArrayList<String>();
        ArrayList<String> listGR = new ArrayList<String>();
        String path = "GER2POL.txt";
        listPLEN = findArrays(polish2EnglishDictionaryPath);
        listENGR = findArrays(english2GermanDictionaryPath);
        for (int i = 0; i < listPLEN.get(0).size(); i++) {
            for (int y = 0; y < listPLEN.get(1).size(); y++) {
                if (listPLEN.get(1).get(i).equals(listENGR.get(0).get(y))) {
                    listPL.add(listPLEN.get(0).get(i));
                    listGR.add(listENGR.get(1).get(y));
                    break;
                }
            }
        }
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(path, "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.out.println(ex);
        }
        for (int i = 0; i < listPL.size(); i++) {
            writer.println(listGR.get(i) + ";" + listPL.get(i));
        }
        writer.close();
        return path;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(polish2English("POL2ENG.txt", "rower"));
        System.out.println(polishToGerman("POL2ENG.txt", "ENG2GER.txt", "rower"));
        System.out.println(generateGermanToPolishTranslationFile("POL2ENG.txt", "ENG2GER.txt"));
    }

}
