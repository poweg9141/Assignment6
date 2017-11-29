/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
        
package assignment6;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JComponent;



/**
 *
 * @author vandl4973
 */
public class ImageLoader extends JComponent  {
     BufferedImage img = null;
    
  public void loadImage(String location){
        try{
            img = ImageIO.read(new File(location));
        } catch(IOException e) {
            e.printStackTrace();
        }
        
       repaint();
        
       
    }
   
    
}