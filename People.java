/*
 * CSCI121 - Computer Science II - Spring 2020
 * Instructors: Greg Schaper, Thyago Mota & Jeffrey Bush
 * Description: Lab 04 - Particle
 * Your name(s): Christine Colvin
 */

 import java.awt.*;
 import java.util.Random;
 
 public abstract class People {
 
     protected Location location;
     protected Location destination;
 
 
     protected static final int MAX_LIFESPAN = 100;
 
     protected static final int RADIUS       = 2;
 
     People(Location location, Location destination) {
         this.location = location;
         this.destination = destination;
 
     }
 
     People(Location location)
     {
         this(location, new Location());
     }
 
 
     boolean isAlive() {
         return true;
     }
 
     public Location getDestination() {
         return destination;
     }
 
     public Location getLocation() {
         return location;
     }
 
     public abstract void update();
 
 
     // Note: do not change this method as it will be used to draw your particles on the screen
     public abstract void paint(Graphics g);
 }
 
