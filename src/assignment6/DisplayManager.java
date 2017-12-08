/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment6;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author vandl4973
 */
public class DisplayManager {
    
    public boolean left, right, forward, dwn;
    private final int width = 900;
    private final int height = 800;
    private ImagePanel img;
    JLabel down;
    private Graphics g;
    private JFrame frame;

    public DisplayManager() {
        frame = new JFrame();
        frame.setSize(new Dimension(900, 800));
        frame.setBounds(10, 10, width, height);
        frame.setTitle("Adventure Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        JLabel left = new JLabel("Left");
        left.setBounds(1, frame.getHeight() / 2 - 100, 100, 100);
        left.setVisible(true);

        left.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                left();
            }
        });
        frame.add(left, BorderLayout.WEST);

        JLabel forward = new JLabel("                                                          "
                + "                                                                            "
                + "          Forward");
        forward.setBounds(frame.getWidth() / 2 - 25, -40, 100, 100);
        forward.setVisible(true);

        forward.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                forward();
            }
        });
        frame.add(forward, BorderLayout.NORTH);

        JLabel right = new JLabel("Right");
        right.setBounds(frame.getWidth() - 40, frame.getHeight() / 2 - 100, 100, 100);
        right.setVisible(true);

        right.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                right();
            }
        });
        frame.add(right, BorderLayout.EAST);
        
        down = new JLabel("                                                          "
                + "                                                                            "
                + "          Look Down");
        down.setBounds(frame.getWidth() - 40, frame.getHeight() - 5, 100, 100);
        down.setVisible(false);
        down.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                down();
                System.out.println("down");
            }
        });
        frame.add(down, BorderLayout.SOUTH);
        frame.setVisible(true);
        
        img = new ImagePanel();
        img.setPreferredSize(new Dimension(width, height));
        img.setMinimumSize(new Dimension(width, height));
        img.setMaximumSize(new Dimension(width, height));
        frame.add(img, BorderLayout.CENTER);    
        frame.pack(); 
    }
    
    public void addImage(BufferedImage img) {
       this.img.setImage(img);
       frame.repaint();
    }
    
    private void right(){
        right = true;
    }
    
    private void left(){
        left = true;
    }
    
    private void forward(){
        forward = true;
    }
    
    private void down(){
        System.out.println("true");
        dwn = true;
    }
    
    public void robby(){
        down.setVisible(true);
    }
    
    public void byerobby(){
        down.setVisible(false);
    }
}
