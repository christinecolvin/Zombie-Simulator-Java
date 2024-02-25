/*
 * CSCI121 - Computer Science II - Spring 2019
 * Instructors: Thyago Mota & Jeffrey Bush
 * Description: Lab 04 - ParticlesSim
 * Your name(s): Christine Colvin
 */

 import javax.swing.*;
 import java.util.Random;
 
 public class PeopleSim extends JFrame {
 
     private static final int    WIDTH                   = 700;
     private static final int    HEIGHT                  = 700;
     private static final int    TITLE_HEIGHT            = 15;
     private static final String TITLE                   = "Zombies";
     private static final int    NUMBER_PEOPLE           = 100;
     private static final int    SLEEP_TIME_PER_PERSON = 1; // ms
     private static Random rnd = new Random();
 
     private World world;
     private int   numberOfPeople;
 
     PeopleSim(int numberOfPeople) {
         if (numberOfPeople > 0)
             this.numberOfPeople = numberOfPeople;
         else
             this.numberOfPeople = NUMBER_PEOPLE;
         setTitle(TITLE);
         setSize(WIDTH, HEIGHT + TITLE_HEIGHT);
         world = new World(0, 0, WIDTH - 1, HEIGHT - 1);
         setContentPane(world);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
     }
 
     static int randomInt(int min, int max) {
         return rnd.nextInt(max - min + 1) + min;
     }
 
     /***
      * Adds a random number of people with 1 undead person to the world simulation
      */
     void createPeople() {
         Random rand = new Random();
         for (int i = 0 ; i < numberOfPeople; i++) {
 
             Alive person = new Alive(new Location(rand.nextInt(0, 700), rand.nextInt(0, 700)),
                     new Location(rand.nextInt(0, 700), rand.nextInt(0, 700)));
 
             world.add(person);
 
         }
 
         Undead undead = new Undead(new Location(314, 313));
         world.add(undead);
 
     }
 
     void run() {
         int i = 0;
         while (world.hasUndeadPeople()) {
             world.update();
             world.repaint();
             try {
                 Thread.sleep(numberOfPeople * SLEEP_TIME_PER_PERSON);
             }
             catch (InterruptedException ex) {
 
             }
         }
         JOptionPane.showMessageDialog(null, "No more people alive; simulation ends now!");
         System.exit(0);
     }
 
 
 }
 