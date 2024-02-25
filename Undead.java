/*
 * CSCI121 - Computer Science II - Spring 2019
 * Instructors: Thyago Mota & Jeffrey Bush
 * Description: Lab 04 - World
 * Your name(s): Christine Colvin
 */
import java.awt.*;
import java.util.Random;

public class Undead extends People{

    protected static final int MAX_LIFESPAN = 100;
    int lifespan;

    /***
     * Calls location from the super class and sets the lifespan to the max
     * @param location super class
     */
    public Undead(Location location) {
        super(location);
        lifespan = MAX_LIFESPAN;
    }

    public boolean isUnDead()
    {
        if (lifespan > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public int getLifespan() { return this.lifespan;}

    /***
     * Allows the 'undead' person to move and subtracts life from their lifespan with every movement
     */
    @Override
    public void update() {
        Random rand = new Random();
        int direction = rand.nextInt(0, 4);

        if (lifespan == 0) {
            return;
        }
        else {
            if (direction == 0) { // Right
                location.add(new Location(10, 0));
            }
            else if (direction == 1) { // Left
                location.add(new Location(-10, 0));
            }
            else if (direction == 2) { // Up
                location.add(new Location(0, 10));
            }
            else if (direction == 3) { // Down
                location.add(new Location(0, -10));
            }
        }
        lifespan--;



    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.drawOval(location.getX() - RADIUS, location.getY() - RADIUS, RADIUS * 2, RADIUS * 2);
        g.setColor(Color.BLACK);
        if (isUnDead())
            g.setColor(Color.RED);
        else
            g.setColor(Color.DARK_GRAY);
        g.fillOval(location.getX() - RADIUS + 1, location.getY() - RADIUS + 1, RADIUS * 2 - 1, RADIUS * 2 - 1);
        g.setColor(color);
    }


}
