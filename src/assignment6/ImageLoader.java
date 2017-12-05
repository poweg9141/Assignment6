/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment6;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author poweg9141
 */
public class ImageLoader{
    
    /**
     * returns a bufferd image when passed its fileName
     * @param file the name of the file
     * @return a buffered image of the image with the passed in file name
     */
    public static BufferedImage loadImage(String file){
        //creates a buffered image
        BufferedImage image;
        try {
            //trys to load the image with teh passed in file name to the buffered image
            //all images must be in the images folder
            image = ImageIO.read(new File("images/" + file));
            //if the image is loaded returns the correct image
            return image;            
        } catch (IOException ex) {
            //if there was a problem prints the stack trace and exits the program
            ex.printStackTrace();
            System.exit(1);
        }
        //returns null to avoid errors
        return null;
    }
}