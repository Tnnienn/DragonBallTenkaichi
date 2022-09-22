package it.develhope.dragonball.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    public static void write(String s) {
        File log = new File("results.txt");
        try{
            if(!log.exists()){
                System.out.println("We had to make a new file.");
                log.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileWriter(log, true));
            out.append(s);
            out.close();
        }catch(IOException e){
            System.out.println("COULD NOT LOG!!");
        }
    }
}
