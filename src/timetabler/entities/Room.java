package timetabler.entities;

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
    private int roomId;

    public Room(String name, int roomId) {
        this.name = name;
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }   
    
}
