package me.michaelherron.Room;

import me.michaelherron.Room.Entrance.Entrance;
import org.bukkit.Location;

import java.util.ArrayList;

public class Generator {
    private DungeonRoom currentRoom;
    private ArrayList<DungeonRoom> allRooms;
    private ArrayList<RoomInstance> usedRooms;
    private ArrayList<DungeonRoom> unfinishedRooms;
    private Location startLoc;

    public Generator(DungeonRoom startingRoom, Location startLoc) {
        this.currentRoom = startingRoom;
        this.startLoc = startLoc;
        this.allRooms = new ArrayList<>();
        this.usedRooms = new ArrayList<>();
        this.unfinishedRooms = new ArrayList<>();
    }
    public Generator(Location startLoc) {
        this.startLoc = startLoc;
        this.allRooms = new ArrayList<>();
        this.usedRooms = new ArrayList<>();
        this.unfinishedRooms = new ArrayList<>();
    }
    public Generator() {
        this.startLoc.set(0, 0, 0);
        this.allRooms = new ArrayList<>();
        this.usedRooms = new ArrayList<>();
        this.unfinishedRooms = new ArrayList<>();
    }

    public Boolean generate() {
        if (currentRoom == null) {
            DungeonRoom type = allRooms.get((int)Math.random() * (allRooms.size()));
            RoomInstance instance = new RoomInstance(type);
            usedRooms.add(instance);
            return true;
        }

        return false;
    }
    private ArrayList<DungeonRoom> useRooms(RoomInstance fromRoom) {
        ArrayList<DungeonRoom> rooms = new ArrayList<>();
        for (Entrance exit : fromRoom.getAvailableEntrances()) {
            for (DungeonRoom room : unfinishedRooms) {
                for (Entrance entrance : room.getEntrances()) {
                    if (entrance.canEnter(exit)) {
                        rooms.add(room);
                    }
                }
            }
        }
        return rooms;
    }
}
