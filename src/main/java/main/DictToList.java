package main;
import java.io.*;
import java.util.*;

public class DictToList {
    public static void main(String[] args) {
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
                al.add(a);
                System.out.println(a);
                
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
