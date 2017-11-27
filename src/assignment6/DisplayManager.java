/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment6;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author vandl4973
 */
public class DisplayManager {

    public DisplayManager() {
        JFrame frame = new JFrame();
        frame.setBounds(10, 10, 900, 800);
        frame.setTitle("Adventure Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        
        JLabel left = new JLabel("Left");
        left.setBounds(1, frame.getHeight() / 2 - 100, 100, 100);
        left.setVisible(true);

        left.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Clicked");
                
            }
        });
        frame.add(left);

        JLabel forward = new JLabel("Forward");
        forward.setBounds(frame.getWidth() / 2 - 25, -40, 100, 100);
        forward.setVisible(true);

        forward.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Clicked");
            }
        });
        frame.add(forward);

        JLabel right = new JLabel("Right");
        right.setBounds(frame.getWidth() - 40, frame.getHeight() / 2 - 100, 100, 100);
        right.setVisible(true);

        right.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Clicked");
                
            }
        });
        frame.add(right);
        
        

        frame.setVisible(true);
        
    }
    
    
    
}
