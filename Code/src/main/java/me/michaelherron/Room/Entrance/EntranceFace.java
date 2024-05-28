package me.michaelherron.Room.Entrance;

public enum EntranceFace {
    TOP, BOTTOM, RIGHT, LEFT, FRONT, BACK;
    
    public Boolean isOpposite(EntranceFace otherFace) {
        if ((otherFace == BACK && this == FRONT) || (otherFace == FRONT && this == BACK)) return true;
        if ((otherFace == TOP && this == BOTTOM) || (otherFace == BOTTOM && this == TOP)) return true;
        if ((otherFace == LEFT && this == RIGHT) || (otherFace == RIGHT && this == LEFT)) return true;
        return false;
    }
}