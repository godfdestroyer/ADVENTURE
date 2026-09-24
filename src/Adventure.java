public class Adventure {
    private Map map;
    private Player player;

    public Adventure() {
        this.map = new Map();
        this.player = new Player(map.getStartRoom());
    }

    public boolean movePlayer(String direction) {
        return player.move(direction);
    }

    public String getCurrentRoomDescription() {
        return player.getCurrentRoom().toString();
    }

    public String getCurrentRoomName() {
        return player.getCurrentRoom().getName();
    }
}