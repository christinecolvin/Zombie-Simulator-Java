/*
 * CSCI121 - Computer Science II - Spring 2019
 * Instructors: Thyago Mota & Jeffrey Bush
 * Description: Lab 04 - World
 * Your name(s): Christine Colvin
 */

 import javax.swing.*;
 import java.awt.*;
 import java.util.*;
 import java.util.List;
 import java.util.concurrent.*;
 
 public class World extends JPanel {
 
     private int xMin, xMax, yMin, yMax;
     private List<People> population;
 
     World(int xMin, int yMin, int xMax, int yMax) {
         this.xMin = xMin;
         this.yMin = yMin;
         this.xMax = xMax;
         this.yMax = yMax;
         population = new CopyOnWriteArrayList<>();
     }
 
     void add(People person) {
         population.add(person);
 
     }
 
     public boolean hasUndeadPeople() {
 
         for (People person : population) {
 
             if (person instanceof Undead && ((Undead) person).getLifespan() > 0) {
                 return true;
             }
 
         }
         return false;
 
     }
 
     /***
      * Adds person to the population and simulation
      */
     public void update() {
         for (Iterator<People> iterator = population.iterator(); iterator.hasNext(); ) {
             People dot = iterator.next();
             dot.update();
         }
         for (int i = 0; i < population.size(); i++) {
             People local = population.get(i);
             if (local instanceof Alive) {
                 for (int u = 0; u < population.size(); u++) {
                     People localA = population.get(u);
                     if (localA instanceof Undead && ((Undead) localA).isUnDead()) {
                         Infected newInfected = null;
                         if (Location.distance(local.location, localA.location) <= 16) {
                             newInfected = new Infected(local.getLocation());
                             population.set(i, newInfected);
                         }
                     }
 
                 }
             }
         }
     }
 
     void clean() {
         for (Iterator<People> iterator = population.iterator(); iterator.hasNext(); ) {
             People person = iterator.next();
             if (!person.isAlive())
                 population.remove(person);
         }
     }
 
     @Override
     public void paint(Graphics g) {
         for (Iterator<People> iterator = population.iterator(); iterator.hasNext(); ) {
             People person = iterator.next();
             person.paint(g);
         }
     }
 }
 
