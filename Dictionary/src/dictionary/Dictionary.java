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

    public static void licz(int i, int k) { // Liczenie rekurencyjne - x*3A x*5B x*15AB
        if (i <= k) {
            if (i % 5 == 0 && i % 3 == 0) {
                System.out.println("AB");
                licz(++i, k);
                return;
            }
            if (i % 5 == 0) {
                System.out.println("A");
                licz(++i, k);
                return;
            }
            if (i % 3 == 0) {
                System.out.println("B");
                licz(++i, k);
                return;
            }
            System.out.println(i);
            licz(++i, k);
        }
    }

    public static void liczfor(int i, int k) { // Liczenie iteracyjne x*3A x*5B x*15AB
        for (int x = i; i <= k; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                System.out.println("AB");
            } else if (i % 5 == 0) {
                System.out.println("A");
            } else if (i % 3 == 0) {
                System.out.println("B");
            } else {
                System.out.println(i);
            }
        }
    }

    public static void fibo(int n) { // Fibonacci 
        if (n <= 0 || n >= 48) {
            System.out.println("zla liczba");
        } else {
            if (n == 1) {
                System.out.println(n + " liczba = " + n);
            } else {
                int tab[] = new int[n];
                tab[0] = 1;
                tab[1] = 1;
                for (int i = 2; i < n; i++) {
                    tab[i] = tab[i - 2] + tab[i - 1];
                }
                for (int i = 0; i < n; i++) {
                    System.out.println(i + 1 + " liczba = " + tab[i]);
                }
            }
        }
    }

    public static String testMotorola(String s) {
        String lines[] = s.split("\\r?\\n");
        int byteMusic = 0, byteImage = 0, byteMovie = 0, byteOther = 0;
        for (String line : lines) {
            if (line.substring(line.lastIndexOf(".") + 1).substring(0, 3).equals("mp3") || line.substring(line.lastIndexOf(".")).substring(0, 4).equals("flat")) {
                try {
                    byteMusic += Integer.parseInt(line.substring(line.lastIndexOf(" "), line.lastIndexOf("b")).trim());
                } catch (NumberFormatException e) {
                    byteMusic += 0;
                }
            }
            if (line.substring(line.lastIndexOf(".") + 1).substring(0, 3).equals("mp4") || line.substring(line.lastIndexOf(".")).substring(0, 3).equals("avi")) {
                try {
                    byteImage += Integer.parseInt(line.substring(line.lastIndexOf(" "), line.lastIndexOf("b")).trim());
                } catch (NumberFormatException e) {
                    byteImage += 0;
                }
            }
            if (line.substring(line.lastIndexOf(".") + 1).substring(0, 3).equals("jpg") || line.substring(line.lastIndexOf(".")).substring(0, 3).equals("png")) {
                try {
                    byteMovie += Integer.parseInt(line.substring(line.lastIndexOf(" "), line.lastIndexOf("b")).trim());
                } catch (NumberFormatException e) {
                    byteMovie += 0;
                }
            }
            if (line.substring(line.lastIndexOf(".") + 1).substring(0, 3).equals("zip") || line.substring(line.lastIndexOf(".")).substring(0, 2).equals("7z")) {
                try {
                    byteOther += Integer.parseInt(line.substring(line.lastIndexOf(" "), line.lastIndexOf("b")).trim());
                } catch (NumberFormatException e) {
                    byteOther += 0;
                }
            }
        }
        s = "Music " + byteMusic + "b \n" + "Image " + byteImage + "b \n" + "Movie " + byteMovie + "b \n" + "Other " + byteOther + "b \n";
        return s;
    }
   
    public static void main(String[] args) throws IOException {
        //System.out.println(polish2English("POL2ENG.txt", "rower"));
        //System.out.println(polishToGerman("POL2ENG.txt", "ENG2GER.txt", "rower"));
        //System.out.println(generateGermanToPolishTranslationFile("POL2ENG.txt", "ENG2GER.txt"));
        //licz(0, 100);
        //liczfor(0, 100);
        //fibo(10);
       // String S = "Muzyka.mp3 1101b\nMuzyka2.flat 101b\nMuzyka3.version2.mp3 1121b\nImage1.jpg 10b\nothers.ver2.zip 1906b\n";
        //System.out.println(S);
       // System.out.println(testMotorola(S));
       
    }

}
