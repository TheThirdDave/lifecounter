package edu.washington.phida11.lifecounter;

/**
 * Created by David on 4/22/2015.
 * A player in the game of Magic the Gathering.
 */
public class Player {
    public static final int STARTING_LIFE = 20;

    private int ID;
    private String name;
    private int life;

    public Player(int id) {
        this(id, STARTING_LIFE);
    }

    public Player(int id, int life) {
        this(id, "", life);
    }

    public Player(int id, String name) {
        this(id, name, STARTING_LIFE);
    }

    public Player(int id, String name, int life) {
        this.ID = id;
        this.life = life;
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setLife(int newLife) {
        this.life = newLife;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void changeLife(int change) {
        life += change;
    }

    public boolean isDead() {
        return (life <= 0);
    }


}
