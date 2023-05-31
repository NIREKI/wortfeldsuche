package main;

import java.util.*;
import java.io.*;

/*
 * In this class, the values are put into an Array and all the values are scanned for english words.
 */
public class Solve {
    private static Set<String> wordSet;
    private static ArrayList<String> words = new ArrayList<String>();

    public static void main(String[] args) {
        wordSet = new HashSet<>();
        words = new ArrayList<String>();
        words.add("sEXbJJeNZbVDLUvFBppvh");
        words.add("mZsGyHvSsWTFABMlScFye");
        words.add("wovxtvWRqUddahluDbcfS");
        words.add("lZJCneJgdLmTVnmiSSFSY");
        words.add("vWiDJwNDfnAkUmnlHJDNd");
        words.add("hrXAHZRyGMEHeKuCwpeMA");
        words.add("xFxWrecgXFNrlKbwPRCjs");
        words.add("KERpOanIXdCWoGphykuFl");
        words.add("YQDNQgAPmZuJnyFoyKNfu");
        words.add("NSOpoPxiIwmyNis0qHlcr");
        words.add("CcKqeRnEsgppHQJkwSrtK");
        words.add("HdZoLgXwWVrKBbHKdhiPU");
        words.add("CsrPWGbjvLxRAHfdKYSPR");
        words.add("TyuwwIgVLCaNRGclCqUix");
        words.add("PQDNsxynvUfxYybhRvaKI");

        char[][] chars = new char[words.size()][words.get(0).length()];

        for (int i = 0; i < words.size(); i++) {
            String a = words.get(i);
            chars[i] = a.toCharArray();
        }

        // This part goes through the dictionary txt and saves it in a ArrayList
        File f = new File("en_US.txt");
        Scanner sc;
        try {
            sc = new Scanner(f);
            while (sc.hasNext()) {
                String a = sc.next();
                if (a.contains("/")) {
                    a = a.substring(0, a.indexOf("/", 0)).toLowerCase();

                }
                if (a.length() > 2)
                    wordSet.add(a);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        horizontal(wordSet, chars);
        vertical(wordSet, chars);
        /*
         * Idea:
         * the array now needs to also be checked from top to bottom and from bottom to
         * top. The algorithm
         * can probably be pretty comparable to the one used form left to right and
         * right to left
         * 
         * -also the array needs to be checked diagonal.
         * -Left top to right bottom and right top to left bottom. Also every line then
         * needs to be checked forward and backwards.
         * Maybe its possible to save every line as an array char[] temprary and then
         * check this temp array from front to back etc.
         * 
         */

    }

    public static void horizontal(Set<String> wordSet, char[][] chars) {
        // This part runs through every line of the array and checks from left to right
        // for words. Needs to be turned around
        // and also written that it displays words from top to bottom and bottom to top.
        System.out.println("____horizontal forwards____");
        for (int x = 0; x < chars.length; x++) {
            char[] a = chars[x];
            for (int i = 1; i <= a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    String wordToCheck = "";
                    for (int k = j; k < i; k++) {
                        wordToCheck += a[k];
                    }
                    wordToCheck = wordToCheck.toLowerCase();
                    if (wordToCheck.trim().length() > 0)
                        if (wordSet.contains(wordToCheck))
                            System.out.println(wordToCheck + "[" + x + "]" + "[" + j + "]");

                }
            }
        }
        /*
         * Ability to check the array backwards
         */
        System.out.println("____horizontal backwards____");
        for (int x = 0; x < chars.length; x++) {
            char[] a = chars[x];
            for (int i = 1; i < a.length; i++) {
                for (int j = a.length - 1; j >= 0; j--) {
                    String wordToCheck = "";
                    if (j - i < 0)
                        // Falls j - i kleiner als 0 ist, würde das Programm versuchen zu weit links zu
                        // schauen. Das geht natürlich nicht.
                        break;
                    for (int k = j; k >= j - i && k >= 0; k--) {
                        wordToCheck += a[k];
                    }

                    wordToCheck = wordToCheck.toLowerCase();
                    if (wordToCheck.trim().length() > 0)
                        if (wordSet.contains(wordToCheck))
                            System.out.println(wordToCheck + "[" + x + "]" + "[" + j + "]");

                }
            }
        }
    }

    public static void vertical(Set<String> wordSet, char[][] chars) {
        String wordToCheck = "";
        System.out.println("____vertical from top to bottom____");
        for (int i = 1; i <= chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                for (int l = 0; l < chars.length - i; l++) {
                    for (int k = l; k < l + i; k++) {
                        wordToCheck += chars[k][j];
                    }
                    wordToCheck = wordToCheck.toLowerCase();

                    if (wordToCheck.trim().length() > 0)
                        if (wordSet.contains(wordToCheck))
                            System.out.println(wordToCheck + "[" + l + "]" + "[" + j + "]");
                    wordToCheck = "";
                }

            }
        }
        System.out.println("____vertical from bottom to top____");
        for (int i = 1; i <= chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                for (int l = chars.length - 1; l >= 0 + i; l--) {
                    if (l - 1 < 0) {
                        break;
                    }
                    for (int k = l; k > l - i; k--) {
                        wordToCheck += chars[k][j];
                    }
                    wordToCheck = wordToCheck.toLowerCase();

                    if (wordToCheck.trim().length() > 0)
                        if (wordSet.contains(wordToCheck))
                            System.out.println(wordToCheck + "[" + l + "]" + "[" + j + "]");
                    wordToCheck = "";
                }

            }
        }

    }

    /**
     * This method searches the array diagonally, from left top to right bottom etc.
     * All the lines have to be searched through forwards and backwards.
     * 
     * @param wordSet given wordset the function searches through
     * @param chars   the array of chars that represent the riddle
     */
    public static void diagonal(Set<String> wordSet, char[][] chars) {
        
    }

    /**
     * This function needs a String thats passed which should be searched through.
     * It then goes through it back and fourth and compares possible words with the
     * wordSet.
     * 
     * @param wordSet Dictonary
     * @param line String that should be searched through
     */
    public static void analyzeStringForWords(Set<String> wordSet, String line) {
        line = line.toLowerCase();
        char[] letters = line.toCharArray();
        String wordForSearch = "";
        for (int i = 1; i < letters.length; i++) {
            for (int j = 0; j < letters.length; j++) {
                if (j + i > letters.length) {
                    break;
                }
                for (int k = j; k < j + i; k++) {
                    wordForSearch += letters[k];
                }
                if (wordForSearch.trim().length() > 0) {
                    if (wordSet.contains(wordForSearch)) {
                        System.out.println(wordForSearch);
                    }
                }
                wordForSearch = "";
            }
        }

        for (int i = 1; i < letters.length; i++) {
            for (int j = letters.length - 1; j >= 0; j--) {
                if (j + i > letters.length || j - i < 0) {
                    break;
                }
                for (int k = j; k > j - i; k--) {
                    wordForSearch += letters[k];
                }
                if (wordForSearch.trim().length() > 0) {
                    if (wordSet.contains(wordForSearch)) {
                        System.out.println(wordForSearch);
                    }
                }
                wordForSearch = "";
            }
        }

    }

}
