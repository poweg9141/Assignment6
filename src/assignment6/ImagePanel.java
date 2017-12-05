/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment6;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 *
 * @author mr.lamont
 */
public class ImagePanel extends JComponent{
    
    //creates a buffered image
    private BufferedImage img = null;
    
    /**
     * method to paint the image to the screen
     * @param g the graphics component
     */
    @Override
    public void paintComponent(Graphics g){
        //draws the image to the screen if it is not null
        if(img != null){
            g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), null);
        }
    }
    
    /**
     * draws an image to the screen when passed a buffered image
     * @param img the buffered image to draw to the screen
     */
    public void setImage(BufferedImage img){
        //sets the image to this classes image
        this.img = img;
        //calls the repaint method     
        repaint();
    }    
}
