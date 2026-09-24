public class Player {
    private Room currentRoom;

    public Player(Room startRoom) {
        this.currentRoom = startRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public boolean move(String direction) {
        Room nextRoom = switch (direction.toLowerCase()) {
            case "north" -> currentRoom.getNorth();
            case "east"  -> currentRoom.getEast();
            case "south" -> currentRoom.getSouth();
            case "west"  -> currentRoom.getWest();
            default      -> null;
        };

        if (nextRoom != null) {
            currentRoom = nextRoom;
            return true;
        }
        return false;
    }
}