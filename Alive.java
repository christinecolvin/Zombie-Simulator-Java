/*
 * CSCI121 - Computer Science II - Spring 2019
 * Instructors: Thyago Mota & Jeffrey Bush
 * Description: Lab 04 - World
 * Your name(s): Christine Colvin
 */


 import java.awt.*;
 import java.util.Random;
 
 public class Alive extends People {
 
     public Alive(Location location, Location destination) {
         super(location, destination);
 
     }
 
 
     /***
      * Updates the location of the alive person to move , calls location and destination
      */
     @Override
     public void update() {
 
         if (location.getX() == destination.getX() && location.getY() == destination.getY()) {
             Random rand = new Random();
             destination = new Location(rand.nextInt(0, 700), rand.nextInt(0, 700));
         }
 
         if (location.getX() > destination.getX()) {
             location.add(new Location(-1, 0));
         }
 
         if (location.getX() < destination.getX()) {
             location.add(new Location(1, 0));
         }
 
         if (location.getY() < destination.getY()) {
             location.add(new Location(0, 1));
         }
 
         if (location.getY() > destination.getY()) {
             location.add(new Location(0, -1));
         }
     }
 
 
     @Override
     public void paint(Graphics g) {
         Color color = g.getColor();
         g.drawOval(location.getX() - RADIUS, location.getY() - RADIUS, RADIUS * 2, RADIUS * 2);
         g.setColor(Color.BLACK);
         if (isAlive())
             g.setColor(Color.BLUE);
         else
             g.setColor(Color.GREEN);
         g.fillOval(location.getX() - RADIUS + 1, location.getY() - RADIUS + 1, RADIUS * 2 - 1, RADIUS * 2 - 1);
         g.setColor(color);
     }
 
 
 
 }
 