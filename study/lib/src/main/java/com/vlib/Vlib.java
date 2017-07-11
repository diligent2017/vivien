package com.vlib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Vlib {
    public static void main(String[] args){
        String pathr = "D:\\AndroidStudio\\text\\1.txt";
        String pathw = "D:\\AndroidStudio\\text\\1_1.txt";
        String pathwn = "D:\\AndroidStudio\\text\\1_2.txt";
//        dealtxt(pathr,pathw);
        removeDuplicate(pathw,pathwn);
    }
    //每行首尾添加字符串
    private static void dealtxt(String pathr, String pathw) {
        try{
            File f1 = new File(pathr);
            File f2 = new File(pathw);
            InputStreamReader fr = new InputStreamReader(new FileInputStream(f1), "GBK");
            OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(f2), "GBK");
            BufferedReader r = new BufferedReader(fr);
            BufferedWriter w = new BufferedWriter(fw);
            String strLine = "";
            String tmp = "";
            String strNewLine = "";
            while((strLine = r.readLine()) != null){
                int len = strLine.length();
                tmp = "";
                strNewLine = "";
                for (int i = 0; i < len; i++) {
                    tmp += "X";
                }
                strNewLine = "<keyword replacement=\""+tmp+"\">"+strLine+"</keyword>";
                w.write(strNewLine);
                w.newLine();
                w.flush();
                System.out.println("=========" + strNewLine);
            }
            w.close();
            r.close();
        }catch(Exception io){
            io.printStackTrace();
        }
    }
    //删除重复的字符串
    //LinkedHashMap取键值对时，是按照你放入的顺序来取的
    //还可以用Excel去重复
    private static void removeDuplicate(String pathr, String pathw){
        try{
            File f1 = new File(pathr);
            InputStreamReader fr = new InputStreamReader(new FileInputStream(f1), "GBK");
            BufferedReader r = new BufferedReader(fr);
            String strLine = "";
            String tmp = "";
            LinkedHashMap<String, Integer> all = new LinkedHashMap<String, Integer>();
            int i = 0;
            while((strLine = r.readLine()) != null){
                all.put(strLine,i);
                System.out.println("=========" + strLine+"===="+i);
                i++;
            }
            r.close();
            File f2 = new File(pathw);
            OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(f2), "GBK");
            BufferedWriter w = new BufferedWriter(fw);
            for(String str:all.keySet()){
                w.write(str);
                w.newLine();
                w.flush();
            }
            w.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
