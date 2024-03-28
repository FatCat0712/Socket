/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author maiso
 */
public class test {
    public static void main(String[] args) throws IOException {
         String logPath = "E:\\test\\log\\info.log";
        LocalDateTime ldt = LocalDateTime.now();
        String pattern = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        String format = ldt.format(dtf);
         try {
            FileWriter filewriter = new FileWriter(logPath);
            String event = "init5";
           filewriter.write(format+"\t"+event+"\n");
//            filewriter.write(event);
            filewriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    }
}
