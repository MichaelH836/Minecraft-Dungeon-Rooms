package me.michaelherron;

import org.apache.commons.lang3.Range;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

public class DungeonRoom {
    private static int nextID = 0;
    private int roomID;
    private String roomName;
    private Location coord1;
    private Location coord2;
    private Block[][][] blocks;
    private World world;
    private int xdistance, ydistance, zdistance;

    public DungeonRoom(String name, Location coord1, Location coord2) {
        this.roomID = nextID;
        nextID++;
        this.roomName = name;
        this.coord1 = coord1;
        this.coord2 = coord2;
        this.world = coord1.getWorld();
        save();
    }

    public void save() {
        if ((int)coord1.x() > (int)coord1.y()) xdistance = (int)coord1.x() - (int)coord2.x();
        else xdistance = (int)coord2.x() - (int)coord1.x();
        if ((int)coord1.y() > (int)coord1.y()) ydistance = (int)coord1.y() - (int)coord2.y();
        else ydistance = (int)coord2.y() - (int)coord1.y();
        if ((int)coord1.z() > (int)coord1.y()) zdistance = (int)coord1.z() - (int)coord2.z();
        else zdistance = (int)coord2.z() - (int)coord1.z();

        blocks = new Block[xdistance + 1][ydistance + 1][zdistance + 1];
        for (int z = 0; z < zdistance + 1; z++) {
            for (int y = 0; y < ydistance + 1; y++) {
                for (int x = 0; x < xdistance + 1; x++) {
                    blocks[x][y][z] = new Location(this.world, x, y, z).getBlock();
                }
            }
        }
    }
    public void load(Location fromBlock) {
        Location nextLocation;
        for (int z = 0; z < zdistance + 1; z++) {
            for (int y = 0; y < ydistance + 1; y++) {
                for (int x = 0; x < xdistance + 1; x++) {
                    nextLocation = fromBlock.add(fromBlock, x, y, z);
                    Block block = nextLocation.getBlock();
                    block.setType(blocks[x][y][z].getType());
                }
            }
        }
    }
}