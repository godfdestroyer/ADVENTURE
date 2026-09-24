public class Map {
    private Room startRoom;

    public Map() {
        buildMap();
    }

    private void buildMap() {
        // 1. Opret alle 9 rum
        Room room1 = new Room("Room 1", "A bare stone chamber with two heavy archways. one east the other south.");
        Room room2 = new Room("Room 2", "A dark corridor. Water drips rhythmically from the ceiling. you can hed back west or go on east.");
        Room room3 = new Room("Room 3", "A bright hall illuminated by glowing crystals in the walls.  go back west or  go on south.");
        Room room4 = new Room("Room 4", "An overgrown indoor garden full of strange, luminescent plants. go back north or move on south.");
        Room room5 = new Room("Room 5", "A mysterious inner sanctum with a glowing pedestal at the center. go back south");
        Room room6 = new Room("Room 6", "A dusty old library filled with ancient, decaying books. go back north go on south.");
        Room room7 = new Room("Room 7", "A damp cellar smelling strongly of ozone and old wood.  go back noth or go on east");
        Room room8 = new Room("Room 8", "A grand entryway with cobwebs stretching across high rafters. you can head east west and north");
        Room room9 = new Room("Room 9", "A quiet armory stocked with rusted weapons and empty racks.  you can go west or north");

        // 2. Forbind rummene (3x3 grid)
        // Rum 1
        room1.setEast(room2);
        room1.setSouth(room4);

        // Rum 2
        room2.setWest(room1);
        room2.setEast(room3);

        // Rum 3
        room3.setWest(room2);
        room3.setSouth(room6);

        // Rum 4
        room4.setNorth(room1);
        room4.setSouth(room7);

        // Rum 5 (Kun tilgængelig fra Rum 8)
        room5.setSouth(room8);

        // Rum 6
        room6.setNorth(room3);
        room6.setSouth(room9);

        // Rum 7
        room7.setNorth(room4);
        room7.setEast(room8);

        // Rum 8
        room8.setWest(room7);
        room8.setNorth(room5);
        room8.setEast(room9);

        // Rum 9
        room9.setWest(room8);
        room9.setNorth(room6);

        // Gem startrummet (Rum 1)
        this.startRoom = room1;
    }

    public Room getStartRoom() {
        return startRoom;
    }
}