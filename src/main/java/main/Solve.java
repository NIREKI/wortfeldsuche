package main;
import java.util.*;
import java.io.*;
/*
 * In this class, the values are put into an Array and all the values are scanned for english words.
 */
public class Solve {
    private static ArrayList<String> words;
    public static void main(String[] args){
        words =  new ArrayList<String>();
        words.add("sEXbJJeNZbVDLUvFBppvh");
        words.add("mZsGyHvSsWTFABMlScFye");
        words.add("wovxtvWRqUddahluDbcfS");
        words.add("lZJCneJgdLmTVnmiSSFSY");
        words.add("vWiDJwNDfnAkUmnlHJDNd");
        words.add("hrXAHZRyGMEHeKuCwpeMA");
        words.add("xFxWrecgXFNrlKbwPRCjs");
        words.add("KERpOanIXdCWoGphykuFl");
        words.add("YQDNQgAPmZuJdyFoyKNfu");
        words.add("NSOpoPxiIwmyNis0qHlcr");
        words.add("CcKqeRnEsgppHQJkwSrtK");
        words.add("HdZoLgXwWVrKBbHKdhiPU");
        words.add("CsrPWGbjvLxRAHfdKYSPR");
        words.add("TyuwwIgVLCaNRGclCqUix");
        words.add("PQDNsxynvUfxYybhRvaKI");

        char[][] chars = new char[words.get(0).length()][words.size()];

        for(int i = 0; i < words.size(); i++){
            String a = words.get(i);
            chars[i] = a.toCharArray();
        }
        //This part goes through the dictionary txt and saves it in a ArrayList
        File f = new File("en_US.txt");
        ArrayList<String> al = new ArrayList<String>();
        Scanner sc;
        try {
            sc = new Scanner(f);
            while(sc.hasNext()){
                String a = sc.next();
                if(a.contains("/")){
                    a = a.substring(0, a.indexOf("/", 0)).toLowerCase();
                    
                }
                if(a.length() > 2)
                    al.add(a);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //This part runs through every line of the array and checks from left to right for words. Needs to be turned around
        //and also written that it displays words from top to bottom and bottom to top.
        for(char[] a : chars){
            for(int i = 1; i <= a.length; i++){
                for(int j = 0; j < a.length; j++){
                    String wordToCheck = "";
                    for(int k = j; k < i; k++){
                        wordToCheck += a[k];
                    }
                    wordToCheck = wordToCheck.toLowerCase();
                    if(wordToCheck.trim().length() > 0)
                        if(al.contains(wordToCheck))
                            System.out.println(wordToCheck);
                        
                }
            }
        }
        
        
    }
            

}
