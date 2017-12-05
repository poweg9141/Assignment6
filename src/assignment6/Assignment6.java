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
        DisplayManager display = new DisplayManager();
        //calls the text file reader
        Image image = reader.readFile("images/pics.txt");
        //calls liams image loader class to return a buffered image when passed a fileName
        //stores that buffered image as the active screen
        BufferedImage frame = ImageLoader.loadImage(image.getName());
        System.out.println(frame);
        //boolean to store whether the image needs to be updated
        boolean update = true;
        //while loop
        while (true) {
            //updates the screen with an image
            if(update){
                display.addImage(frame);
                update = false;
            }
            //checks for button clicks
            //if a button is clicked checks if player can move in that location
            //if player can move, loads the next image
            if (display.forward && image.isBlocked()) {
                image = image.getNextImage();
                frame = ImageLoader.loadImage(image.getName());
                //resets all movement variables to false
                display.forward = false;
                display.left = false;
                display.right = false;
                update = true;
            } else if (display.left) {
                image = image.getLocation().getLeft(image);
                frame = ImageLoader.loadImage(image.getName());
                display.left = false;
                display.forward = false;
                display.right = false;
                update = true;
            } else if (display.right) {
                image = image.getLocation().getRight(image);
                frame = ImageLoader.loadImage(image.getName());
                display.right = false;
                display.forward = false;
                display.left = false;
                update = true;
            }
        }
        //while loop ends        
    }
}
