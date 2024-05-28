package me.michaelherron.Room.Entrance;

import org.bukkit.Location;

public class Entrance {
    private EntranceFace direction;
    private Location midpoint;

    public Entrance(EntranceFace direction, Location midpoint) {
        this.direction = direction;
        this.midpoint = midpoint;
    }
    public Location getMidpoint() {
        return this.midpoint;
    }
    public EntranceFace getDirection() {
        return this.direction;
    }
    public Boolean canEnter(Entrance exit) {
        if (this.getDirection().isOpposite(exit.getDirection())) return true;
        return false;
    }
}