package com.iolearn;

import org.testng.annotations.Test;

import java.io.*;

/**
 * Created by dengyayun on 17/11/16.
 */
public class FileLearn {

    @Test
    public void testBuffer(){

        Writer fw = null;
        Reader fr = null;
        BufferedWriter bf = null;
        BufferedReader bufferedReader=null;

        try {
//            fw = new FileWriter("ceshi.txt");
            fr = new FileReader("ceshi.txt");
            bufferedReader = new BufferedReader(fr);

            while(true) {
                String a = bufferedReader.readLine();
                System.out.println(a);
                if(a == null) {
                    break;
                }
            }

//            bf.write("1324234");
//            bf.newLine();
//            bf.write("oiuytr");
//            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fw !=null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(bf !=null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fr !=null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter wf = null;
        try {
//            File file = new File("b1.txt");
//            System.out.println(file.createNewFile());
//            System.out.println(file.getAbsolutePath());
            wf = new FileWriter("ceshi.txt");
//            char[] c = new char[2048];
//            fr.read(c);
//            System.out.println(c);
            wf.write("Sdsafasfkjj");
            wf.append("134242");
//            wf.flush();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(wf != null) {
                try {
                    wf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
