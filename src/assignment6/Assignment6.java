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
        //initialize the objects
        TextReader reader = new TextReader();
        //calls the text file reader
        Image image = reader.readFile("images/pics.txt");        
        System.out.println("TESTING:  ");
//        System.out.println(image.getLocation().getLocation());
//        System.out.println(image.getDir());
//        System.out.println(image.getLocation().getLeft(image).getDir());
        String loc = image.getLocation().getLeft(image).getNextImage().getNextImage().getLocation().getLocation();
        System.out.println(loc);
        //call the image loader
        //stores the returned image as a varieable
//        BufferedImage loadedImage;
        
        //calls liams image loader class to return a buffered image when passed a fileName
        //stores that buffered image as the active screen
        
        //while loop
//        while(true){
            //checks for button clicks
            //if a button is clicked checks if player can move in that location
            //if player can move, loads the next image            
 //       }            
        //while loop ends        
    }
}
