/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author poweg9141
 */
public class TextReader {

    /**
     * reads the file specified and returns the image to start with
     * @param fileName the text file to read from
     * @return the Image the game should start at
     */
    public Image readFile(String fileName) {

        //file readed initialized
        FileReader file = null;

        //trys to create a new file reader with the name of the passed file
        try {
            file = new FileReader(fileName);
        //throws an exception if it cant read the file specified
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        //creates a scanner of the file
        Scanner in = new Scanner(file);

        //strings to store the location and direction of the image to start at
        String location = in.nextLine();
        String direction = in.nextLine();
        //array lists to store all the created images, loactions, 
        //as well as corresponding next locations ans directios
        List<Image> images = new ArrayList<Image>();
        List<Location> locations = new ArrayList<Location>();
        List<String> nextImagesLoc = new ArrayList<String>();
        List<String> nextImagesDir = new ArrayList<String>();        

        //while loop to run the while there is still another token in the text file
        while (in.hasNext()) {
            //stores the name of the location
            String locationName = in.nextLine();
            //creates a new location with the name above
            Location loc = new Location(locationName);

            //runs 4 times, once for every image in the location
            for (int i = 0; i < 4; i++) {
                //stores the direction and name of the image file
                String Dir = in.next().trim();
                String Loc = in.next().trim();
                //creates a boolean to store whether you can advance from this image
                boolean adv = false;
                //creates two strings to store if, they exist, the next image location and direction
                String nextImageLoc = "";
                String nextImageDir = "";
                //if the front is not blocked stores the next image direction and location
                if (in.next().trim().equals("false")) {
                    adv = true;
                    nextImageLoc += in.next().trim();
                    nextImageDir += in.next().trim();
                //if the front is blocked adds an empty space to the strings
                } else {
                    nextImageLoc += " ";
                    nextImageDir += " ";
                }
                //creates a new image with all the parameters
                Image image = new Image(Loc, Dir.charAt(0), loc, adv);
                //sets the image to the correct image in the location (i.e. North, South, etc.)
                if (i == 0) {
                    loc.setNImage(image);
                } else if (i == 1) {
                    loc.setEImage(image);
                } else if (i == 2) {
                    loc.setSImage(image);
                } else {
                    loc.setWImage(image);
                }
                //adds the image to the list of images
                images.add(image);
                //adds the next image location and direction to their corresponding lists
                nextImagesLoc.add(nextImageLoc);
                nextImagesDir.add(nextImageDir);
                //goes to the next line to ensure no remaining junk on the line gets read
                in.nextLine();
            }
            //adds the location to the list of locations
            locations.add(loc);
        }

        //prints out the next images location and direction (test code, to be commented out)
//        for (int i = 0; i < nextImagesDir.size(); i++) {
//            System.out.println(nextImagesLoc.get(i));
//            System.out.println(nextImagesDir.get(i));
//        }
        //prints out the size of the lists (test code, to be commented out)
//        System.out.println(nextImagesDir.size() + "\n" + nextImagesLoc.size());

        //calls the method to connect the images to their correct next image
        arrangeNextImages(locations, images, nextImagesLoc, nextImagesDir);

        //loops through the list of locations to find the one the game should start at
        for (Location locationat : locations) {
            //if the locations name is equal to the lacation in the first line of the text file
            if (locationat.getLocation().equals(location)) {
                //returns the image in the correct direction at that location
                if (direction.charAt(0) == 'N') {
                    return locationat.getNImage();
                } else if (direction.charAt(0) == 'E') {
                    return locationat.getEImage();
                } else if (direction.charAt(0) == 'S') {
                    return locationat.getSImage();
                } else {
                    return locationat.getWImage();
                }
            }
        }
        //if not image is found returns the first image in the list        
        return images.get(0);
    }

    /**
     * method to connect the images to their appropriate next images
     * @param locations list of all the possible locations
     * @param images list of all the images
     * @param nextImagesLoc list of all the images next location
     * @param nextImagesDir list of all the images next direction
     */
    private void arrangeNextImages(List<Location> locations, List<Image> images, List<String> nextImagesLoc, List<String> nextImagesDir) {
        //loops through every image to connect it to its appropriate next image
        for (int i = 0; i < images.size(); i++) {
            //stores the name of the next image location as well as direction
            //variables found in the nextImagesLoc and nextImagesDir lists
            String imageLoc = nextImagesLoc.get(i);
            char imageDir = nextImagesDir.get(i).charAt(0);
            //loops trough every location in the location list
            for (Location location : locations) {
                //if the locations name is the same as the imageLoc string
                if (location.getLocation().equals(imageLoc)) {
                    //adds the image in the correct direction to the nextImage
                    //variable in the corresponding image
                    if (imageDir == 'N') {
                        images.get(i).setNextImage(location.getNImage());
                    } else if (imageDir == 'E') {
                        images.get(i).setNextImage(location.getEImage());
                    } else if (imageDir == 'S') {
                        images.get(i).setNextImage(location.getSImage());
                    } else if (imageDir == 'W') {
                        images.get(i).setNextImage(location.getWImage());
                    }
                }
            }
        }
    }
}
