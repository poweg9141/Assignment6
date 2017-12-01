/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment6;

/**
 *
 * @author poweg9141
 */
public class Location {
    
    //four images, in the four directions at this location
    private Image NImage, EImage, SImage, WImage;
    //the name of this location
    private String location;
    
    /**
     * Constructor to create this object with all variables determined
     * @param location the name of the location
     * @param NImage the image in the north direction at this location
     * @param EImage the image in the east direction at this location
     * @param SImage the image in the south direction at this location
     * @param WImage the image in the west direction at this location
     */
    public Location(String location, Image NImage, Image EImage, Image SImage, Image WImage){
        this.location = location;
        this.NImage = NImage;
        this.EImage = EImage;
        this.SImage = SImage;
        this.WImage = WImage;
    }
    
    /**
     * Constructor to create this object with only the locations name determined
     * @param location the name of the location
     */
    public Location(String location){
        this.location = location;
    }

    /**
     * sets the image in the north direction at this location
     * @param NImage the image to be set
     */
    public void setNImage(Image NImage) {
        this.NImage = NImage;
    }

    /**
     * sets the image in the east direction at this location
     * @param EImage the image to be set
     */
    public void setEImage(Image EImage) {
        this.EImage = EImage;
    }

    /**
     * sets the image in the south direction at this location
     * @param SImage the image to be set
     */
    public void setSImage(Image SImage) {
        this.SImage = SImage;
    }

    /**
     * sets the image in the west direction at this location
     * @param WImage the image to be set
     */
    public void setWImage(Image WImage) {
        this.WImage = WImage;
    }

    public Image getNImage() {
        return NImage;
    }

    public Image getEImage() {
        return EImage;
    }

    public Image getSImage() {
        return SImage;
    }

    public Image getWImage() {
        return WImage;
    }

    public String getLocation() {
        return location;
    }
    
    /**
     * gets the image in the direction of the character passed
     * @param dir the direction of the image to be returned N-north, S-south, E-east, W-west
     * @return the image in the specified direction
     */
    public Image getImage(char dir){
        if(dir == 'N'){
            return NImage;
        }else if(dir == 'E'){
            return EImage;
        }else if(dir == 'S'){
            return SImage;
        }else{
            return WImage;
        }
    }
    
    /**
     * gets the image to the left of the specified images direction
     * @param image the image that is to the right of the wanted image
     * @return the image to the left of the passed in image
     */
    public Image getLeft(Image image){
        if(image.getDir() == 'N'){
            return WImage;
        }else if(image.getDir() == 'E'){
            return NImage;
        }else if(image.getDir() == 'S'){
            return EImage;
        }else{
            return SImage;
        }
    }
    
    /**
     * gets the image to the right of the specified images direction
     * @param image the image that is to the left of the wanted image
     * @return the image to the right of the passed in image
     */
    public Image getRight(Image image){
        if(image.getDir() == 'N'){
            return EImage;
        }else if(image.getDir() == 'E'){
            return SImage;
        }else if(image.getDir() == 'S'){
            return WImage;
        }else {
            return NImage;
        }
    }
}
