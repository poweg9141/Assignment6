/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment6;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import javax.imageio.ImageIO;



/**
 *
 * @author poweg9141
 */
public class Assignment6 {

    /**
     * @param args the command line arguments
     */
      
    public static void main(String[] args) {
        // TODO code application logic here
        DisplayManager test = new DisplayManager();
        BufferedImage img = null;
        FileReader file = null;
        try{
            // fix this proper loading later
            URL url = Assignment6.class.getResource("images//IMG_0052.JPG");
            System.out.println(url);
            //creating a file reader
            file = new FileReader(url.getFile());
        }catch(Exception e){
            //handle any errors
            //print out the lovely red errors
            e.printStackTrace();
            //exit the program
            System.exit(0);
        }
        
        //use scanner to do that
        
        
        test.addImage(null);
        
        
    }
}
