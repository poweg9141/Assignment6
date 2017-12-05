/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment6;

/**
 *
 * @author poweg9141
 */
public class Image {
    
    //the name of the image file to be loaded
    private String name;
    //the direction the image is facing
    private char dir;
    //the location the image is in
    private Location location;    
    //whether the front is blocked of not
    private boolean isBlocked;
    //if the front is not blocked, stores the next image
    private Image nextImage;
    
    /**
     * Constructor to create the object with all variables
     * @param fileName the name of the image file this object will represent
     * @param dir the direction the image is facing
     * @param location the location the image is in
     * @param isBlocked whether the front is blocked or not
     */
    public Image(String fileName, char dir, Location location, boolean isBlocked){
        //sets all passed variables to classes variables
        this.name = fileName;
        this.dir = dir;
        this.location = location;
        this.nextImage = nextImage;
        this.isBlocked = isBlocked;
    }
    
    /**
     * 
     * @param image the next image
     */
    public void setNextImage(Image image){
        this.nextImage = image;
    }

    public String getName() {
        return name;
    }

    public char getDir() {
        return dir;
    }

    public Location getLocation() {
        return location;
    }
    
    public Image getNextImage(){
        return nextImage;
    }

    public boolean isBlocked() {
        return isBlocked;
    }        
}
