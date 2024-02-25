/*
 * CSCI121 - Computer Science II - Spring 2019
 * Instructors: Thyago Mota & Jeffrey Bush
 * Description: Lab 04 - World
 * Your name(s): Christine Colvin
 */
import java.awt.*;
import java.util.Random;


/****
 * Constructor for the Infected people
 */
public class Infected extends Undead {
    protected static final int MAX_LIFESPAN = 20;
    int deadspan;

    /***
     * Calls from the super class to get the random location of the infected person
     * @param location
     */
    public Infected(Location location) {
        super(location);
        deadspan = MAX_LIFESPAN;
        Random rand = new Random();
        destination = new Location(rand.nextInt(0, 700), rand.nextInt(0, 700));
    }

    /***
     * Determines using boolean if the person is alive
     * @return
     */
    public boolean isAliveUndead() {

        if (deadspan > 0) {
            return true;
        }
        else {
            return false;
        }

    }

    /***
     * Getter for the deadspan
     * @return
     */
    public int getDeadspan() {
        return deadspan;
    }

    /***
     * Update moves the infected person around on the simulation and calls location to get it, subtracts life from its
     * deadspan
     */
    @Override
    public void update() {
        if(getDeadspan() > 0) {


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
            deadspan--;
        }
        else{
            super.update();
        }

    }

    /***
     * Changes the alive person to an infected person...used from alive class
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.drawOval(location.getX() - RADIUS, location.getY() - RADIUS, RADIUS * 2, RADIUS * 2);
        g.setColor(Color.BLACK);
        if (isAliveUndead())
            g.setColor(Color.GREEN);
        if (getDeadspan() <= 0)
        {
            g.setColor(Color.RED);
        }
        if (super.getLifespan() <= 0)
            g.setColor(Color.BLACK);
        g.fillOval(location.getX() - RADIUS + 1, location.getY() - RADIUS + 1, RADIUS * 2 - 1, RADIUS * 2 - 1);
        g.setColor(color);
    }


}

