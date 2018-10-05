/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.Scanner;

public class OpenFile {
   

        String text;
        String str = "";
        OpenFile(){
            try{
                try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("Liv.txt"), "latin1"))) {
                    
                    
                    while ((str = in.readLine()) != null) {
                        //System.out.println(str);
                        if (str == null){
                        
                        }else{
                        text += " " + str;
                        
                        }
                    }
                }
            }catch(IOException ex){
            System.out.println("Kappa not found");
            }
        text = text.replaceFirst("null ", "");
        }

        public String getText(){
            return text;

        }

        public static void main(String[] args){
            OpenFile file = new OpenFile();

            }
 



}
