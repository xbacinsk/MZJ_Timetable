package timetabler.entities;

import java.math.BigInteger;

/**
 * Holds information about room.
 * 
 * Holds room name and id.
 * 
 * @author Michal Kimle
 * @version 2012-05-04
 */
public class Room {
    
    private String name;
    private BigInteger roomId;

    public Room(String name, BigInteger roomId) {
        this.name = name;
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getRoomId() {
        return roomId;
    }

    public void setRoomId(BigInteger roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "Room{" + "name=" + name + ", roomId=" + roomId + '}';
    }
}
