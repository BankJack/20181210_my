package test1;

import java.io.*;

public class Test1 {

    public static void main(String[] args) {
        File file=new File("E:/ab.txt");
        try {
            InputStream input=new FileInputStream(file);
            OutputStream output=new FileOutputStream("F:/hah.txt");
            byte[] chars=new byte[1024];
            int length;
            while((length=input.read(chars))!=-1){
                output.write(chars,0,length);
            }

            output.flush();
            output.close();
            input.close();
            file.delete();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
