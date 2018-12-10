package test1;

import java.io.*;

public class Test2 {
    public static void main(String[] args) {
        File file=new File("F:/123");

    }

    private static void test1(File file){
        try {
            Reader input=new FileReader(file);
            Writer output=new FileWriter("E:/123");

            File[] arr = file.listFiles();
            for (File f : arr) {

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
